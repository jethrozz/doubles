package com.doubles.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @时间: 2018/4/25
 * @描述：
 */
public class SingletonBlockQueue {
    private BlockingQueue<String> registQueue;

    private SingletonBlockQueue(){
        registQueue = new LinkedBlockingDeque<>();
    }

    private static SingletonBlockQueue instance = null;

    public static synchronized SingletonBlockQueue getInstance(){
        if(instance == null){
            instance = new SingletonBlockQueue();
        }
        return instance;
    }

    public BlockingQueue<String> getRegistQueue() {
        return registQueue;
    }

    public void addRegistInfo(String registInfo){
        registQueue.offer(registInfo);
    }
}
