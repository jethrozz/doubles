package com.doubles.dao;

import com.doubles.entity.Article;
import com.doubles.entity.ArticleExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    Page<Article> findPageByUid(@Param("userId")String userId);
    Page<Article> findPageByContent(@Param("content")String content);

    List<Date> getTimeGroup(@Param("userId")String userId);
    List<Article> getArticleByTime(@Param("date")String date,@Param("userId") String userId);

    List<Map<String,Object>> getRecomend();
}