package com.doubles.service;

import com.doubles.entity.ChatRecord;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 聊天记录表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface ChatRecordService extends IService<ChatRecord> {
    //查询聊天记录
    List<ChatRecord> findChatRecordList(String fromUser,String toUser);

}
