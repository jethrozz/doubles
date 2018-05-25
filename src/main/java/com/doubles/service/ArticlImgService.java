package com.doubles.service;

import com.doubles.entity.ArticlImg;
import com.doubles.entity.Image;

import java.util.List;

/**
 * <p>
 * 动态图片表

动态相册，如果是动态中的图片，则要存入该表中，表示这张图片是哪个动态的 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface ArticlImgService{
	List<Image> findImgByArticleId(String article_id);
	boolean addImage(ArticlImg articlImg);
}
