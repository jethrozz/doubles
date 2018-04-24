package com.doubles.serviceImpl;

import com.doubles.dao.ArticlImgDao;
import com.doubles.entity.ArticlImg;
import com.doubles.service.ArticlImgService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动态图片表

动态相册，如果是动态中的图片，则要存入该表中，表示这张图片是哪个动态的 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class ArticlImgServiceImpl extends ServiceImpl<ArticlImgDao, ArticlImg> implements ArticlImgService {

}
