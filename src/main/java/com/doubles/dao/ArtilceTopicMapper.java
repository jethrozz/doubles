package com.doubles.dao;

import com.doubles.entity.ArtilceTopic;
import com.doubles.entity.ArtilceTopicExample;
import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface ArtilceTopicMapper {
    int countByExample(ArtilceTopicExample example);

    int deleteByExample(ArtilceTopicExample example);

    int deleteByPrimaryKey(String atId);

    int insert(ArtilceTopic record);

    int insertSelective(ArtilceTopic record);

    List<ArtilceTopic> selectByExample(ArtilceTopicExample example);

    ArtilceTopic selectByPrimaryKey(String atId);

    int updateByExampleSelective(@Param("record") ArtilceTopic record, @Param("example") ArtilceTopicExample example);

    int updateByExample(@Param("record") ArtilceTopic record, @Param("example") ArtilceTopicExample example);

    int updateByPrimaryKeySelective(ArtilceTopic record);

    int updateByPrimaryKey(ArtilceTopic record);
    List<ArtilceTopic> getArticleListByArticleId(@Param("articleId") String articleId);
    Page<ArtilceTopic> getArticlePageByTopicId(@Param("topicId") String topicId);

    List<String> getTopicListByArticleNumber();
}