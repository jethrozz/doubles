package com.doubles.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @时间: 2018/4/25
 * @描述：依据单例设计模式，设计的一个全局唯一的阻塞队列用于动态的推送工作
 * 因为动态推送不可能是同步的操作，这样如果用户的粉丝数量过多会一直卡在发表动态界面，所以改成异步的方式，由程序后台进行推送
 */
public class SingletonBlockQueue {
    private BlockingQueue<String> articlePushQueue;

    private SingletonBlockQueue(){
        articlePushQueue = new LinkedBlockingDeque<>();
    }

    private static SingletonBlockQueue instance = null;

    public static synchronized SingletonBlockQueue getInstance(){
        if(instance == null){
            instance = new SingletonBlockQueue();
        }
        return instance;
    }

    public BlockingQueue<String> getUserFromPushQueue() {
        return articlePushQueue;
    }

    public void addUserIntoPushQueue(String registInfo){
        articlePushQueue.offer(registInfo);
    }
}
