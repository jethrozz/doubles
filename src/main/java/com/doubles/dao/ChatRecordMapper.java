package com.doubles.dao;

import com.doubles.entity.ChatRecord;
import com.doubles.entity.ChatRecordExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface ChatRecordMapper {
    int countByExample(ChatRecordExample example);

    int deleteByExample(ChatRecordExample example);

    int deleteByPrimaryKey(String crId);

    int insert(ChatRecord record);

    int insertSelective(ChatRecord record);

    List<ChatRecord> selectByExample(ChatRecordExample example);

    ChatRecord selectByPrimaryKey(String crId);

    int updateByExampleSelective(@Param("record") ChatRecord record, @Param("example") ChatRecordExample example);

    int updateByExample(@Param("record") ChatRecord record, @Param("example") ChatRecordExample example);

    int updateByPrimaryKeySelective(ChatRecord record);

    int updateByPrimaryKey(ChatRecord record);

    //聊天记录分页
    Page<ChatRecord> getChatRecordPage(@Param("toUser") String toUser,@Param("userId")String userId);

    Page<ChatRecord> getChatRecordList(@Param("toUser")String userId);
    Integer getNumberOfMeAndFriend(@Param("userId")String fromUser, @Param("toUser")String toUser);

    Page<Map<String,Object>> getChatRecordListCount(@Param("userId")String userId);
    ChatRecord getTheTopOne(@Param("userId")String userId,@Param("toUser")String toUser);
}