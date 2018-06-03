package com.doubles.serviceImpl;

import com.doubles.dao.ArtilceTopicMapper;
import com.doubles.dao.TopicMapper;
import com.doubles.entity.*;
import com.doubles.service.ArtilceTopicService;
import com.doubles.service.TopicService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 动态话题表,表示参与了该话题的动态
当用户 发表带有话题的动态时，即向该表中插入一条数据 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class ArtilceTopicServiceImpl implements ArtilceTopicService {

	@Autowired
	private ArtilceTopicMapper artilceTopicDao;
	@Autowired
	private TopicMapper topicMapper;
	@Override
	public boolean insertOne(ArtilceTopic articleTopic) {
		if(artilceTopicDao.insertSelective(articleTopic) >= 1){
			return true;
		}
		return false;
	}

	@Override
	public List<Article> getArticleByTopic(String topicId) {
		ArtilceTopicExample example = new ArtilceTopicExample();
		example.or().andTopicIdEqualTo(topicId);
		List<ArtilceTopic> artilceTopics = artilceTopicDao.selectByExample(example);
		List<Article> articleList = new ArrayList<>();

		for (ArtilceTopic artilceTopic: artilceTopics ) {
			articleList.add(artilceTopic.getArticle());
		}
		return articleList;

	}

	@Override
	public Page<ArtilceTopic> getArticlePageByTopicId(String topicId, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return artilceTopicDao.getArticlePageByTopicId(topicId);
	}

	@Override
	public Map<Topic,List<Article>> getListByArticleNumber() {
		List<String> topicList = artilceTopicDao.getTopicListByArticleNumber();
		Map<Topic,List<Article>> listMap = new LinkedHashMap<>();

		ArtilceTopicExample example = new ArtilceTopicExample();
		for (String topic:topicList ) {
			example.or().andTopicIdEqualTo(topic);
			List<ArtilceTopic> atList = artilceTopicDao.selectByExample(example);
			if(atList != null && atList.size() != 0){
				List<Article> articleList = new ArrayList<>();
				for(ArtilceTopic artilceTopic : atList){
					articleList.add(artilceTopic.getArticle());
				}
				listMap.put(atList.get(0).getTopic(),articleList);
			}
			example.clear();
		}
		return listMap;
	}

	@Override
	public Map<Topic,List<Article>> getListByCreateTime() {
		TopicExample example = new TopicExample();
		example.setOrderByClause("create_time desc");
		List<Topic> list = topicMapper.selectByExample(example);
		Map<Topic,List<Article>> listMap = new LinkedHashMap<>();

		ArtilceTopicExample topicExample = new ArtilceTopicExample();
		for(Topic topic : list){
			topicExample.or().andTopicIdEqualTo(topic.getTopicId());
			List<ArtilceTopic> atList = artilceTopicDao.selectByExample(topicExample);

			if(atList != null && atList.size() != 0){
				List<Article> articleList = new ArrayList<>();
				for(ArtilceTopic artilceTopic : atList){
					articleList.add(artilceTopic.getArticle());
				}
				listMap.put(atList.get(0).getTopic(),articleList);
			}
			topicExample.clear();
		}
		return listMap;
	}
}
