package com.doubles.service;

import com.doubles.entity.Collections;
import com.doubles.entity.Users;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * <p>
 * 收藏表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface CollectionsService {
    //添加收藏
    boolean addCollection(Collections collection);
    //删除收藏记录
    boolean deleteCollection(String collectionId);
    boolean deleteCollection(String userId,String articleId);
    Collections getOneCollection(String collectionId);
    List<Collections> getListCollection(String userId);
    List<Collections> getListCollectionByArtcile(String articleId);
    Page<Collections> getPageCollection(String userId,int pageNo,int pageSize);
    boolean isCollection(String userId,String articleId);
}
