package com.doubles.serviceImpl;

import com.doubles.dao.UserTopicDao;
import com.doubles.entity.UserTopic;
import com.doubles.service.UserTopicService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class UserTopicServiceImpl extends ServiceImpl<UserTopicDao, UserTopic> implements UserTopicService {

}
