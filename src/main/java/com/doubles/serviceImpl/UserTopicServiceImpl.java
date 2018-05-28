package com.doubles.serviceImpl;

import com.doubles.dao.UserTopicMapper;
import com.doubles.entity.UserTopic;
import com.doubles.entity.UserTopicExample;
import com.doubles.service.UserTopicService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户参与话题关联表

表示关注了该话题的动态 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class UserTopicServiceImpl implements UserTopicService {

	@Autowired
	private UserTopicMapper userTopicMapper;

	@Override
	public boolean followTopic(UserTopic userTopic) {
		if(userTopicMapper.insertSelective(userTopic) >= 1){
			return true;
		}else{
			return false;
		}

	}

	@Override
	public boolean unFollowTopic(UserTopic userTopic) {
		UserTopicExample example = new UserTopicExample();
		example.or().andTopicIdEqualTo(userTopic.getTopicId()).andUserIdEqualTo(userTopic.getUserId());
		if(userTopicMapper.deleteByExample(example) >= 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFollow(String topicId, String userId) {
		UserTopicExample example = new UserTopicExample();
		example.or().andUserIdEqualTo(userId).andTopicIdEqualTo(topicId);
		List<UserTopic> list = userTopicMapper.selectByExample(example);
		if(list != null && list.size() != 0){
			return true;
		}
		return false;
	}

	@Override
	public List<UserTopic> getListByUserId(String userId) {
		UserTopicExample example = new UserTopicExample();
		example.or().andUserIdEqualTo(userId);
		return userTopicMapper.selectByExample(example);
	}

	@Override
	public List<UserTopic> getLisyByTopicId(String topicId) {
		UserTopicExample example = new UserTopicExample();
		example.or().andTopicIdEqualTo(topicId);
		return userTopicMapper.selectByExample(example);
	}

	@Override
	public Page<UserTopic> getUserPageByTopicId(String topicId, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);

		return userTopicMapper.getUserPageByTopicId(topicId);
	}

	@Override
	public Page<UserTopic> getTopicPageByUserId(String userId, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return userTopicMapper.getTopicPageByUserId(userId);
	}
}
