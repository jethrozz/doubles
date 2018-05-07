package com.doubles.serviceImpl;

import com.doubles.dao.ArtilceTopicMapper;
import com.doubles.entity.ArtilceTopic;
import com.doubles.service.ArtilceTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public boolean insertOne(ArtilceTopic articleTopic) {
		if(artilceTopicDao.insertSelective(articleTopic) >= 1){
			return true;
		}
		return false;
	}
}
