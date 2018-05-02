package com.doubles.serviceImpl;

import com.doubles.dao.CollectionsMapper;
import com.doubles.entity.Collections;
import com.doubles.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CollectionsServiceImpl implements CollectionsService {

    @Autowired
    CollectionsMapper collectionsDao;

    @Override
    public Collections addCollection(Collections collection) {
        collectionsDao.insertSelective(collection);
        return collection;
    }

    @Override
    public boolean deleteCollection(String collectionId) {
        if(collectionsDao.deleteByPrimaryKey(collectionId) >= 1){
            return true;
        }
        return false;
    }
}
