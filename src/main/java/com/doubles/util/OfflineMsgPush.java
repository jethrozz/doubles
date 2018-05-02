package com.doubles.util;

import com.doubles.entity.ChatRecord;
import com.doubles.model.SingletonReadySendMsgUserList;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @时间: 2018/4/28
 * @描述：
 */
@Component
@PropertySource(value = {"classpath:qiniu.properties"})
public class OfflineMsgPush implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(OfflineMsgPush.class);
    private String toUser;
    @Autowired
    private GoEasy goEasy;
    @Value("${goEasy.messagePush}")
    private String msgChannel;
    @Override
    public void run() {
        try{
            Thread.sleep(1000); //暂停一秒，防止前端接收消息的js未初始化而导致接收不到消息

            ArrayList<ChatRecord> list = SingletonReadySendMsgUserList.getInstance().getReadySendList(toUser);
            if(list != null || list.size() != 0){
               for (ChatRecord chatRecord : list) {
                    goEasy.publish("msgChannel",Utils.toJson(chatRecord));
               }
                   //移除该用户的离线消息
               SingletonReadySendMsgUserList.getInstance().removedChatRecord(toUser);
            }

               Thread.currentThread().yield();
        }catch (Exception e){
            LOGGER.error("推送聊天消息时出现了异常");
        }
    }
    public OfflineMsgPush(){
        super();
    }
    public OfflineMsgPush(String toUser){
        super();
        this.toUser = toUser;
    }
}
