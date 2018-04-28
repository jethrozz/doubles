package com.doubles.util;


import com.doubles.entity.ChatRecord;
import com.doubles.model.SingletonMsgQueue;
import com.doubles.service.RelationshipService;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * @时间: 2018/4/27
 * @描述：
 */
@Component
@PropertySource(value = {"classpath:qiniu.properties"})
public class MessagePush implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(MessagePush.class);
    volatile boolean stopme = false;

    @Autowired
    private GoEasy goEasy;
    @Value("${goEasy.messagePush}")
    private String msgChannel;
    @Override
    public void run() {
        try{
            while (true){
                if (Thread.currentThread().isInterrupted() || stopme){
                    break;
                }
                ChatRecord chatRecord = SingletonMsgQueue.getInstance().getMsgFromPushQueue().take();
                //这里需要把这个chatRecord对象转成json发送过去
                goEasy.publish(msgChannel,Utils.toJson(chatRecord));
                Thread.currentThread().yield();
            }
        }catch (Exception e){
            LOGGER.error("推送聊天消息时出现了异常");
            stopThread();
        }
    }

    private void stopThread(){
        stopme = true;
    }
}
