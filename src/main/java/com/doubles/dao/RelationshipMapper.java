package com.doubles.dao;

import com.doubles.entity.Relationship;
import com.doubles.entity.RelationshipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationshipMapper {
    long countByExample(RelationshipExample example);

    int deleteByExample(RelationshipExample example);

    int deleteByPrimaryKey(String relationship_id);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    List<Relationship> selectByExample(RelationshipExample example);

    Relationship selectByPrimaryKey(String relationship_id);

    int updateByExampleSelective(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByExample(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);
}