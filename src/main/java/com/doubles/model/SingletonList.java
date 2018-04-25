package com.doubles.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @时间: 2018/4/25
 * @描述：
 */
public class SingletonList {
    private List<String> onlineUser;
    private static SingletonList instance = null;

    private SingletonList(){
        onlineUser = new ArrayList<>();
    }
    public static synchronized SingletonList getInstance(){
        if(instance == null){
            instance = new SingletonList();
        }
        return instance;
    }

    public List<String> getUserList() {
        return onlineUser;
    }

    public void addUser(String userId){
        onlineUser.add(userId);
    }
    public void removedUser(String userId){
        Iterator<String> it = onlineUser.iterator();
        while (it.hasNext()){
            String id = it.next();
            if(id.compareTo(userId) == 0){
                it.remove();
            }
        }
    }
}
