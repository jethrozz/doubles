package com.doubles.dao;

import com.doubles.entity.Album;
import com.doubles.entity.AlbumExample;
import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface AlbumMapper {
    int countByExample(AlbumExample example);

    int deleteByExample(AlbumExample example);

    int deleteByPrimaryKey(String albumId);

    int insert(Album record);

    int insertSelective(Album record);

    List<Album> selectByExample(AlbumExample example);

    Album selectByPrimaryKey(String albumId);

    int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    Page<Album> getAlbumPageByUser(@Param("userId") String userId);
}