package com.doubles.dao;

import com.doubles.entity.ArticlImg;
import com.doubles.entity.ArticlImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticlImgMapper {
    int countByExample(ArticlImgExample example);

    int deleteByExample(ArticlImgExample example);

    int deleteByPrimaryKey(String aiId);

    int insert(ArticlImg record);

    int insertSelective(ArticlImg record);

    List<ArticlImg> selectByExample(ArticlImgExample example);

    ArticlImg selectByPrimaryKey(String aiId);

    List<ArticlImg> selectByArticle(@Param("articleId") String aId);

    int updateByExampleSelective(@Param("record") ArticlImg record, @Param("example") ArticlImgExample example);

    int updateByExample(@Param("record") ArticlImg record, @Param("example") ArticlImgExample example);

    int updateByPrimaryKeySelective(ArticlImg record);

    int updateByPrimaryKey(ArticlImg record);
}