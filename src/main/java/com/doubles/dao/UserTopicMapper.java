package com.doubles.dao;

import com.doubles.entity.UserTopic;
import com.doubles.entity.UserTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTopicMapper {
    int countByExample(UserTopicExample example);

    int deleteByExample(UserTopicExample example);

    int deleteByPrimaryKey(String upId);

    int insert(UserTopic record);

    int insertSelective(UserTopic record);

    List<UserTopic> selectByExample(UserTopicExample example);

    UserTopic selectByPrimaryKey(String upId);

    int updateByExampleSelective(@Param("record") UserTopic record, @Param("example") UserTopicExample example);

    int updateByExample(@Param("record") UserTopic record, @Param("example") UserTopicExample example);

    int updateByPrimaryKeySelective(UserTopic record);

    int updateByPrimaryKey(UserTopic record);
}