package com.doubles.dao;

import com.doubles.entity.ArtilceTopic;
import com.doubles.entity.ArtilceTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArtilceTopicMapper {
    long countByExample(ArtilceTopicExample example);

    int deleteByExample(ArtilceTopicExample example);

    int deleteByPrimaryKey(String at_id);

    int insert(ArtilceTopic record);

    int insertSelective(ArtilceTopic record);

    List<ArtilceTopic> selectByExample(ArtilceTopicExample example);

    ArtilceTopic selectByPrimaryKey(String at_id);

    int updateByExampleSelective(@Param("record") ArtilceTopic record, @Param("example") ArtilceTopicExample example);

    int updateByExample(@Param("record") ArtilceTopic record, @Param("example") ArtilceTopicExample example);

    int updateByPrimaryKeySelective(ArtilceTopic record);

    int updateByPrimaryKey(ArtilceTopic record);
}