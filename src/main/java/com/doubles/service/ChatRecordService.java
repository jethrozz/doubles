package com.doubles.service;

import com.doubles.entity.ChatRecord;
import com.github.pagehelper.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 聊天记录表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface ChatRecordService{
    //查询聊天记录
    List<ChatRecord> findChatRecordList(String fromUser, String toUser);
    boolean insert(ChatRecord chatRecord);
    Page<ChatRecord> getPageChatRecord(String fromUser, String toUser,int pageNo,int pageSize);
    Page<ChatRecord> getChatRecordList(String toUser,int pageNo,int pageSize);
    Integer getNumberOfMeAndFriend(String fromUser, String toUser);

    Page<Map<String,Object>> getChatRecordListCount(String toUser,int pageNo,int pageSize);
    ChatRecord getTheTopOne(String userId,String toUser);
}
