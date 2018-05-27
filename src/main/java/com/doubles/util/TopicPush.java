package com.doubles.util;

import com.doubles.entity.Article;
import com.doubles.entity.ArtilceTopic;
import com.doubles.entity.PushData;
import com.doubles.entity.UserTopic;
import com.doubles.model.CommonResult;
import com.doubles.model.SingletonOnlineUserList;
import com.doubles.model.SingletonTopicQueue;
import com.doubles.service.ArticleService;
import com.doubles.service.PushService;
import com.doubles.service.RelationshipService;
import com.doubles.service.UserTopicService;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Shuang on 2018/5/17.
 */
@Component
@PropertySource(value = {"classpath:qiniu.properties"})
public class TopicPush implements Runnable{
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
	@Value("${goEasy.topicPush}")
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

				ArtilceTopic artilceTopic = SingletonTopicQueue.getInstance().getArtilceTopicPushQueue().take();
				String topicId = artilceTopic.getTopicId();
				String articleId = artilceTopic.getArticleId();
				List<UserTopic> userTopicList = userTopicService.getLisyByTopicId(topicId);
				Article article = articleService.getOneArticle(articleId);
				for (UserTopic userTopic : userTopicList) {
					PushData pushData = new PushData();
					pushData.setPushUser(userTopic.getUserId());
					pushData.setContentId(articleId);
					pushData.setType(1);
					pushData.setBelongUser(article.getUserId());

					if(SingletonOnlineUserList.getInstance().getUserList().contains(userTopic.getUserId())){
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
}
