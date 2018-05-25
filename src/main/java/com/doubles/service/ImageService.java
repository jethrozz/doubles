package com.doubles.service;


import com.doubles.entity.Image;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * <p>
 * 图片表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface ImageService{
	Image getOneImg(String imgId);
	boolean updateImg(Image image);
	boolean addImage(Image image);

	List<Image> getImageListByAlbum(String id);
	Page<Image> getImagePageByAlbum(String id,int pageNo,int pageSize);
}
