package com.doubles.dao;

import com.doubles.entity.ArticlImg;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 动态图片表

动态相册，如果是动态中的图片，则要存入该表中，表示这张图片是哪个动态的 Mapper 接口
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface ArticlImgDao extends BaseMapper<ArticlImg> {

}
