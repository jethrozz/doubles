package com.doubles.service;


import com.doubles.entity.Image;

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
}
