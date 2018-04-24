package com.doubles.serviceImpl;

import com.doubles.dao.AlbumDao;
import com.doubles.entity.Album;
import com.doubles.service.AlbumService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 相册 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumDao, Album> implements AlbumService {

}
