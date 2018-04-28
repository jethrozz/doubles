package com.doubles.util;

import com.doubles.entity.Relationship;
import com.doubles.model.SingletonArticleQueue;
import com.doubles.model.SingletonOnlineUserList;
import com.doubles.service.RelationshipService;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
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
                String userId = SingletonArticleQueue.getInstance().getUserFromPushQueue().take();

                //将所有关注了我的用户以及相互关注了的用户放入一个list中
                List<Relationship> relationship1 = relationshipService.findFriends(userId,0,1); //单方面关注了我的用户
                List<Relationship> relationship2 = relationshipService.findFriends(userId,2,1); //相互关注用户

                //当前所有在线的用户
                for(Relationship relationship : relationship1){
                    if(SingletonOnlineUserList.getInstance().getUserList().contains(relationship.getUserId())){
                        // 只是一个推送的例子，传过去的数据格式有待商议
                        // goEasy.publish(articleChannel, "Hello world!");
                    }
                }
                for(Relationship relationship : relationship2){
                    if(SingletonOnlineUserList.getInstance().getUserList().contains(relationship.getUserId())){
                        // 只是一个推送的例子，传过去的数据格式有待商议
                        // goEasy.publish(articleChannel, "Hello world!");
                    }
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
