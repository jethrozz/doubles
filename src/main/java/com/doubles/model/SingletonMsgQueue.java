package com.doubles.model;

import com.doubles.entity.ChatRecord;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @时间: 2018/4/27
 * @描述：单例的消息推送队列
 */
public class SingletonMsgQueue {
    private BlockingQueue<ChatRecord> msgPushQueue;

    private SingletonMsgQueue(){
        msgPushQueue = new LinkedBlockingDeque<>();
    }

    private static SingletonMsgQueue instance = null;

    public static synchronized SingletonMsgQueue getInstance(){
        if(instance == null){
            instance = new SingletonMsgQueue();
        }
        return instance;
    }

    public BlockingQueue<ChatRecord> getMsgFromPushQueue() {
        return msgPushQueue;
    }

    public void addMsgPushQueue(ChatRecord chatRecord){
        msgPushQueue.offer(chatRecord);
    }
}
