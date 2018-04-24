package com.doubles.dao;

import com.doubles.entity.UserTopic;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户参与话题关联表

表示关注了该话题的动态 Mapper 接口
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface UserTopicDao extends BaseMapper<UserTopic> {

}
