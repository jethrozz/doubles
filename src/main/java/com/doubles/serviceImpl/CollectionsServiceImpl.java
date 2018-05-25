package com.doubles.serviceImpl;

import com.doubles.dao.CollectionsMapper;
import com.doubles.entity.Collections;
import com.doubles.entity.CollectionsExample;
import com.doubles.service.CollectionsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean addCollection(Collections collection) {
        if(collectionsDao.insertSelective(collection) >= 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteCollection(String collectionId) {
        if(collectionsDao.deleteByPrimaryKey(collectionId) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public Collections getOneCollection(String collectionId) {
        return collectionsDao.selectByPrimaryKey(collectionId);
    }

    @Override
    public List<Collections> getListCollection(String userId) {
        CollectionsExample example = new CollectionsExample();
        example.or().andUserIdEqualTo(userId);
        example.setOrderByClause("create_time desc");
        return collectionsDao.selectByExample(example);
    }

    @Override
    public List<Collections> getListCollectionByArtcile(String articleId) {
        CollectionsExample example = new CollectionsExample();
        example.or().andContentIdEqualTo(articleId);
        example.setOrderByClause("create_time desc");

        return collectionsDao.selectByExample(example);
    }

    @Override
    public Page<Collections> getPageCollection(String userId, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);

        return collectionsDao.getCollectionPage(userId);
    }
}
