package com.doubles.dao;

import com.doubles.entity.Image;
import com.doubles.entity.ImageExample;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface ImageMapper {
    int countByExample(ImageExample example);

    int deleteByExample(ImageExample example);

    int deleteByPrimaryKey(String imgId);

    int insert(Image record);

    int insertSelective(Image record);

    List<Image> selectByExample(ImageExample example);

    Image selectByPrimaryKey(String imgId);

    List<Image> selectByAlbum(@Param("albumId")String albumId);

    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);

    Page<Image> getImagePageByAlbum(@Param("albumId") String albumId);

    List<Map<String,Object>> selectDateGroup(@Param("albumId") String albumId);
}