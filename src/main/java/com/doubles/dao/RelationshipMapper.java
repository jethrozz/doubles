package com.doubles.dao;

import com.doubles.entity.Relationship;
import com.doubles.entity.RelationshipExample;
import java.util.List;

import com.doubles.model.PageInfo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface RelationshipMapper {
    int countByExample(RelationshipExample example);

    int deleteByExample(RelationshipExample example);

    int deleteByPrimaryKey(String relationshipId);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    List<Relationship> selectByExample(RelationshipExample example);

    Relationship selectByPrimaryKey(String relationshipId);

    int updateByExampleSelective(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByExample(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);

    Page<Relationship> getPageFriend(@Param("userId") String userId,@Param("isFriend") int is_friend,@Param("isFollowMe") int isFollowMe);
}