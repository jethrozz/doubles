package com.doubles.model;

import com.doubles.entity.Article;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @时间: 2018/4/25
 * @描述：依据单例设计模式，设计的一个全局唯一的阻塞队列用于动态的推送工作
 * 因为动态推送不可能是同步的操作，这样如果用户的粉丝数量过多会一直卡在发表动态界面，所以改成异步的方式，由程序后台进行推送
 */
public class SingletonArticleQueue {
    private BlockingQueue<Article> articlePushQueue;

    private SingletonArticleQueue(){
        articlePushQueue = new LinkedBlockingDeque<>();
    }

    private static SingletonArticleQueue instance = null;

    public static synchronized SingletonArticleQueue getInstance(){
        if(instance == null){
            instance = new SingletonArticleQueue();
        }
        return instance;
    }

    public BlockingQueue<Article> getUserFromPushQueue() {
        return articlePushQueue;
    }

    public void addUserIntoPushQueue(Article registInfo){
        articlePushQueue.offer(registInfo);
    }
}
