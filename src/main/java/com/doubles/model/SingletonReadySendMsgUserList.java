package com.doubles.model;

import com.doubles.entity.ChatRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @时间: 2018/4/28
 * @描述：用一个队列来保存这些未登录用户的离线消息
 * 在用户登录时，进行按顺序进行推送
 */
public class SingletonReadySendMsgUserList {
    private Map<String,ArrayList<ChatRecord>> offlineMsg;
    private static SingletonReadySendMsgUserList instance = null;


    private SingletonReadySendMsgUserList(){
        offlineMsg = new HashMap<>();
    }
    public static synchronized SingletonReadySendMsgUserList getInstance(){
        if(instance == null){
            instance = new SingletonReadySendMsgUserList();
        }
        return instance;
    }

    public ArrayList<ChatRecord> getReadySendList(String toUser) {
        if(offlineMsg.containsKey(toUser)){
            return offlineMsg.get(toUser);
        }else{
            return null;
        }

    }
    public boolean isContainUser(String toUser){
        if(offlineMsg.containsKey(toUser)){
            return true;
        }else{
            return false;
        }
    }
    public void addChatRecord(String toUser,ChatRecord chatRecord){
        if(offlineMsg.containsKey(toUser)){
            ArrayList<ChatRecord> list = offlineMsg.get(toUser);
            list.add(chatRecord);
            offlineMsg.replace(toUser,list);
        }else{
            ArrayList<ChatRecord> list = new ArrayList<>();
            list.add(chatRecord);
            offlineMsg.put(toUser,list);
        }
    }
    public void removedChatRecord(String toUser){
        offlineMsg.remove(toUser);
    }
}
