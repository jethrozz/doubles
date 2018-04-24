package com.doubles.service;

import com.doubles.entity.Collections;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 收藏表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface CollectionsService extends IService<Collections> {
    //添加收藏
    Collections addCollection(Collections collection);
    //删除收藏记录
    boolean deleteCollection(String collectionId);
}
