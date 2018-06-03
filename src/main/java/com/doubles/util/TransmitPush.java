package com.doubles.util;

import com.doubles.entity.*;
import com.doubles.model.CommonResult;
import com.doubles.model.SingletonOnlineUserList;
import com.doubles.model.SingletonTopicQueue;
import com.doubles.model.SingletonTransmitQueue;
import com.doubles.service.ArticleService;
import com.doubles.service.PushService;
import com.doubles.service.RelationshipService;
import com.doubles.service.UserTopicService;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuang on 2018/5/17.
 */
@Component
@PropertySource(value = {"classpath:qiniu.properties"})
public class TransmitPush implements Runnable {
	@Autowired
	private RelationshipService relationshipService;
	@Autowired
	private UserTopicService userTopicService;
	@Autowired
	private GoEasy goEasy;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private PushService pushService;
	@Value("${goEasy.articlePush}")
	private String articleChannel;

	private static final Logger LOGGER = Logger.getLogger(TopicPush.class);
	volatile boolean stopme = false;
	@Override
	public void run() {
		try {
			while (true) {
				if (stopme || Thread.currentThread().isInterrupted()) {
					LOGGER.trace("CurrentThread IS STOP");
					break;
				}
				CommonResult<PushData> result = new CommonResult<>(0,"success");
				Transmit transmit = SingletonTransmitQueue.getInstance().getTransmitPushQueue().take();
				String articleId = transmit.getContentId();
				String userId = transmit.getUserId();
				Article article = articleService.getOneArticle(articleId);
				addToMyPush(transmit,article);
				//将所有关注了我的用户以及相互关注了的用户放入一个list中
				List<Relationship> relationship1 = relationshipService.findFriends(userId,0,1); //单方面关注了我的用户
				List<Relationship> relationship2 = relationshipService.findFriends(userId,2,1); //相互关注用户
				List<String> followUser = new ArrayList<>();

				addtoList(relationship1,followUser);
				addtoList(relationship2,followUser);

				for(String userid : followUser){
					PushData pushData = new PushData();
					pushData.setPushUser(userid);
					pushData.setContentId(articleId);
					pushData.setType(2);
					pushData.setBelongUser(article.getUserId());
					pushData.setNowUser(transmit.getUserId());
					if(SingletonOnlineUserList.getInstance().getUserList().contains(userid)){
						pushData.setIsPush(0);
						result.setData(pushData);
						goEasy.publish(articleChannel, Utils.toJson(result));
					}
					pushService.addData(pushData);
				}
			}
		}catch (InterruptedException e) {
			LOGGER.info("推送动态时出现了异常");
			e.printStackTrace();
			stopThread();
		}
	}

	private void stopThread(){
		stopme = true;
	}

	private void addtoList(List<Relationship> list1,List<String> list2){
		for (Relationship r:list1 ) {
			list2.add(r.getUserId());
		}
	}

	//
	private void addToMyPush(Transmit transmit,Article article){
		PushData pushData = new PushData();
		pushData.setBelongUser(article.getUserId());
		pushData.setNowUser(transmit.getUserId());
		pushData.setPushUser(transmit.getUserId());
		pushData.setType(2);
		pushData.setContentId(article.getArticleId());
		pushData.setIsPush(0);
		pushService.addData(pushData);
	}
}
