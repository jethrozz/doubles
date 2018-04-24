package com.doubles.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.entity.Relationship;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 好友关系表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface RelationshipService extends IService<Relationship> {
    public Page<Relationship> findFriends(Page<Relationship> page, String user_id, Integer is_friend);
    public boolean followOrUnfollow(Relationship relationship);
}
