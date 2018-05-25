package com.doubles.service;


import com.doubles.entity.Article;
import com.doubles.entity.ArtilceTopic;
import com.doubles.entity.Topic;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 动态话题表,表示参与了该话题的动态
当用户 发表带有话题的动态时，即向该表中插入一条数据 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface ArtilceTopicService {
	boolean insertOne(ArtilceTopic articleTopic);
	List<Article> getArticleByTopic(String topicId);
	Page<ArtilceTopic> getArticlePageByTopicId(String topicId,int pageNo,int pageSize);
	Map<Topic,List<Article>> getListByArticleNumber();
	Map<Topic,List<Article>> getListByCreateTime();
}
