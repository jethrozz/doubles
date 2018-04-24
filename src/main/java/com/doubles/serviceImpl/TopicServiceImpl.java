package com.doubles.serviceImpl;

import com.doubles.dao.TopicDao;
import com.doubles.entity.Topic;
import com.doubles.service.TopicService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 话题表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicDao, Topic> implements TopicService {

}
