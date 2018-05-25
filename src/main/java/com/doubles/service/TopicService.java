package com.doubles.service;


import com.doubles.entity.Topic;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 * 话题表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface TopicService{
	Topic getOneById(String topicId);
	Topic getOneByTitle(String title);
	boolean addTopic(Topic topic);
	boolean updateTopic(Topic topic);
	List<Topic> findTopicOrderByfansNum();
	List<Topic> findTopicOrderByDisNum();
	Page<Topic> findPageOrderByfansNum(int pageNo, int pageSize);
	Page<Topic> findPageOrderByDisNum(int pageNo, int pageSize);
	Page<Topic> findTopicOrderByTime(int pageNo, int pageSize);
}
