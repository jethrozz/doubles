package com.doubles.serviceImpl;

import com.doubles.dao.ImageDao;
import com.doubles.entity.Image;
import com.doubles.service.ImageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图片表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageDao, Image> implements ImageService {

}
