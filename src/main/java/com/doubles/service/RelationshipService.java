package com.doubles.service;

import com.doubles.entity.Relationship;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * <p>
 * 好友关系表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface RelationshipService {
    //isFollowMe 为0 以我为中心，表示我关注的用户，或者拉黑的，或者相互关注的。
    //isFollowMe 为1时，以userid为中心，表示关注了这个用户的，或者拉黑了和这个用户的所有人的集合
    // isFriend 为0 表示我关注的，为1我拉黑的，为2 相互关注
    Page<Relationship> findPageFriends(int pageNo,int pageSize,String user_id, int is_friend, int isFollowMe);
    List<Relationship> findFriends(String user_id, Integer is_friend, int isFollowMe);
    boolean followOrUnfollow(Relationship relationship);
    Relationship isFriend(String userId,String friend);
}
