package com.doubles.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.entity.Relationship;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 好友关系表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface RelationshipService extends IService<Relationship> {
    //isFollowMe 为0 表示我关注的用户，或者拉黑的，或者相互关注的。为1时，表示关注了这个用户的，或者拉黑了和这个用户的所有人的集合
    Page<Relationship> findFriends(Page<Relationship> page, String user_id, Integer is_friend, int isFollowMe);
    List<Relationship> findFriends(String user_id, Integer is_friend, int isFollowMe);

    boolean followOrUnfollow(Relationship relationship);
}
