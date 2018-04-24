package com.doubles.serviceImpl;

import com.doubles.dao.CollectionsDao;
import com.doubles.entity.Collections;
import com.doubles.service.CollectionsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收藏表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class CollectionsServiceImpl extends ServiceImpl<CollectionsDao, Collections> implements CollectionsService {

    @Override
    public Collections addCollection(Collections collection) {
        insert(collection);
        return collection;
    }

    @Override
    public boolean deleteCollection(String collectionId) {
        return deleteById(collectionId);
    }
}
