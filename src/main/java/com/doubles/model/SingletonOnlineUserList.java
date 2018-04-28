package com.doubles.model;

import java.util.Set;
import java.util.TreeSet;

/**
 * @时间: 2018/4/25
 * @描述：用set集合存放在线用户，因为set集合不允许重复，且会自动排序
 */
public class SingletonOnlineUserList {
    private Set<String> onlineUser;
    private static SingletonOnlineUserList instance = null;

    private SingletonOnlineUserList(){
        onlineUser = new TreeSet<>();
    }
    public static synchronized SingletonOnlineUserList getInstance(){
        if(instance == null){
            instance = new SingletonOnlineUserList();
        }
        return instance;
    }

    public Set<String> getUserList() {
        return onlineUser;
    }

    public void addUser(String userId){
        onlineUser.add(userId);
    }
    public void removedUser(String userId){
        if(onlineUser.contains(userId)) {
            onlineUser.remove(userId);
        }
    }
}
