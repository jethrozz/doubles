package com.doubles.dao;

import com.doubles.entity.ArtilceTopic;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 动态话题表,表示参与了该话题的动态
当用户 发表带有话题的动态时，即向该表中插入一条数据 Mapper 接口
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface ArtilceTopicDao extends BaseMapper<ArtilceTopic> {

}
