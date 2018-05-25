package com.doubles.dao;

import java.util.List;

import com.doubles.entity.PushData;
import com.doubles.entity.PushDataExample;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface PushDataMapper {
    int countByExample(PushDataExample example);

    int deleteByExample(PushDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(PushData record);

    int insertSelective(PushData record);

    List<PushData> selectByExample(PushDataExample example);

    PushData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PushData record, @Param("example") PushDataExample example);

    int updateByExample(@Param("record") PushData record, @Param("example") PushDataExample example);

    int updateByPrimaryKeySelective(PushData record);

    int updateByPrimaryKey(PushData record);

    Page<PushData> getPageByPushUser(@Param("userId") String userId);
}