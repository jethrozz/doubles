package com.doubles.service;


import com.doubles.entity.UserTopic;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户参与话题关联表

表示关注了该话题的动态 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface UserTopicService {
	boolean followTopic(UserTopic userTopic);
	boolean unFollowTopic(UserTopic userTopic);
	boolean isFollow(String topicId,String userId);

	List<UserTopic> getListByUserId(String userId);
	List<UserTopic> getLisyByTopicId(String topicId);

	Page<UserTopic> getUserPageByTopicId(String topicId,int pageNo,int pageSize);
	Page<UserTopic> getTopicPageByUserId(String userId,int pageNo,int pageSize);
}
