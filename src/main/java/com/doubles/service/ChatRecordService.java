package com.doubles.service;

import com.doubles.entity.ChatRecord;
import com.github.pagehelper.Page;

import java.util.Date;
import java.util.List;

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

}
