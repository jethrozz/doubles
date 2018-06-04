package com.doubles.util;

import com.doubles.entity.Article;
import com.doubles.entity.PushData;
import com.doubles.entity.Relationship;
import com.doubles.model.CommonResult;
import com.doubles.model.SingletonArticleQueue;
import com.doubles.model.SingletonOnlineUserList;
import com.doubles.service.PushService;
import com.doubles.service.RelationshipService;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @时间: 2018/4/25
 * @描述：动态推送类
 */
@Component
@PropertySource(value = {"classpath:qiniu.properties"})
public class ArticlePush implements Runnable{
    private static final Logger LOGGER = Logger.getLogger(ArticlePush.class);
    volatile boolean stopme = false;

    @Autowired
    private RelationshipService relationshipService;
    @Autowired
    private GoEasy goEasy;
    @Autowired
    private PushService pushService;
    @Value("${goEasy.articlePush}")
    private String articleChannel;
    @Override
    public void run() {
        try {
            while (true){
                if(stopme || Thread.currentThread().isInterrupted()){
                    LOGGER.trace("CurrentThread IS STOP");
                    break;
                }
                //获取到一个当前发表了动态的用户
                CommonResult<PushData> result = new CommonResult<>(0,"success");
                Article article = SingletonArticleQueue.getInstance().getUserFromPushQueue().take();
                addToMyPush(article);
                String userId = article.getUserId();
                //将所有关注了我的用户以及相互关注了的用户放入一个list中
                List<Relationship> relationship1 = relationshipService.findFriends(userId,0,1); //单方面关注了我的用户
                List<Relationship> relationship2 = relationshipService.findFriends(userId,2,1); //相互关注用户
                List<String> followUser = new ArrayList<>();

                addtoList(relationship1,followUser,article);
                addtoList(relationship2,followUser,article);

                for(String userid : followUser){
                    PushData pushData = new PushData();
                    pushData.setBelongUser(userId);
                    pushData.setContentId(article.getArticleId());
                    pushData.setPushUser(userid);
                    pushData.setType(3);
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

    private void addtoList(List<Relationship> list1,List<String> list2,Article article){
        for (Relationship r:list1 ) {
            if(r.getIsFriend() == 2){
                if(r.getUserId().equals(article.getUserId()) && !r.getFriendId().equals(article.getUserId())){
                    list2.add(r.getFriendId());
                }else{
                    list2.add(r.getUserId());
                }
            }else{
                list2.add(r.getUserId());
            }
        }
    }

    private void addToMyPush(Article article){
        PushData pushData = new PushData();
        pushData.setBelongUser(article.getUserId());
        pushData.setPushUser(article.getUserId());
        pushData.setType(0);
        pushData.setContentId(article.getArticleId());
        pushData.setIsPush(0);
        pushService.addData(pushData);
    }
}
