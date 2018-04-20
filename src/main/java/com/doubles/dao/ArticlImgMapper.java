package com.doubles.dao;

import com.doubles.entity.ArticlImg;
import com.doubles.entity.ArticlImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticlImgMapper {
    long countByExample(ArticlImgExample example);

    int deleteByExample(ArticlImgExample example);

    int deleteByPrimaryKey(String ai_id);

    int insert(ArticlImg record);

    int insertSelective(ArticlImg record);

    List<ArticlImg> selectByExample(ArticlImgExample example);

    ArticlImg selectByPrimaryKey(String ai_id);

    int updateByExampleSelective(@Param("record") ArticlImg record, @Param("example") ArticlImgExample example);

    int updateByExample(@Param("record") ArticlImg record, @Param("example") ArticlImgExample example);

    int updateByPrimaryKeySelective(ArticlImg record);

    int updateByPrimaryKey(ArticlImg record);
}