package com.doubles.service;


import com.doubles.entity.Album;
import com.doubles.entity.Image;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * <p>
 * 相册 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface AlbumService {
	boolean addAlbum(Album album);
	Album getAlbumByuserIdAndName(String userId);
	List<Album> getAlbumListByUser(String userId);
	Page<Album> getAlbumPageByUser(String userId,int pageNo,int pageSize);
	Album getAlbumById(String id);
}
