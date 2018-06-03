package com.doubles.serviceImpl;

import com.doubles.dao.TopicMapper;
import com.doubles.entity.Topic;
import com.doubles.entity.TopicExample;
import com.doubles.service.TopicService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 话题表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicMapper topicMapper;

	@Override
	public Topic getOneById(String topicId) {

		return topicMapper.selectByPrimaryKey(topicId);
}

	@Override
	public Topic getOneByTitle(String title) {
		TopicExample example = new TopicExample();
		example.or().andTitleEqualTo(title);
		List<Topic> topicList = topicMapper.selectByExample(example);
		if (topicList.size() == 0)
			return null;
		else
			return topicList.get(0);
	}

	@Override
	public boolean addTopic(Topic topic) {
		if(topicMapper.insertSelective(topic) >= 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateTopic(Topic topic) {
		if(topicMapper.updateByPrimaryKeySelective(topic) >= 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Topic> findTopicOrderByfansNum() {
		TopicExample example = new TopicExample();
		example.setOrderByClause("fan_number desc");
		List<Topic> topicList = topicMapper.selectByExample(example);
		return topicList;
	}

	@Override
	public List<Topic> findTopicOrderByDisNum() {
		TopicExample example = new TopicExample();
		example.setOrderByClause("discussion_number desc");
		List<Topic> topicList = topicMapper.selectByExample(example);
		return topicList;
	}

	@Override
	public Page<Topic> findPageOrderByfansNum(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);

		return topicMapper.findPageByfansNum();
	}

	@Override
	public Page<Topic> findPageOrderByDisNum(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return topicMapper.findPageByDisNum();
	}

	@Override
	public Page<Topic> findTopicOrderByTime(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return topicMapper.findPageOrderByTime();
	}
}
