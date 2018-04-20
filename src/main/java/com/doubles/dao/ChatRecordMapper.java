package com.doubles.dao;

import com.doubles.entity.ChatRecord;
import com.doubles.entity.ChatRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChatRecordMapper {
    long countByExample(ChatRecordExample example);

    int deleteByExample(ChatRecordExample example);

    int deleteByPrimaryKey(String cr_id);

    int insert(ChatRecord record);

    int insertSelective(ChatRecord record);

    List<ChatRecord> selectByExample(ChatRecordExample example);

    ChatRecord selectByPrimaryKey(String cr_id);

    int updateByExampleSelective(@Param("record") ChatRecord record, @Param("example") ChatRecordExample example);

    int updateByExample(@Param("record") ChatRecord record, @Param("example") ChatRecordExample example);

    int updateByPrimaryKeySelective(ChatRecord record);

    int updateByPrimaryKey(ChatRecord record);
}