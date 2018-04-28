package com.doubles.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.doubles.dao.ChatRecordDao;
import com.doubles.entity.ChatRecord;
import com.doubles.service.ChatRecordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 聊天记录表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class ChatRecordServiceImpl extends ServiceImpl<ChatRecordDao, ChatRecord> implements ChatRecordService {

    @Autowired
    private ChatRecordDao chatRecordDao;

    @Override
    public List<ChatRecord> findChatRecordList(String fromUser, String toUser) {
        List<ChatRecord> chatRecordList = new ArrayList<>();
        EntityWrapper<ChatRecord> ew = new EntityWrapper<>();
        ew.where("user_id = {0}",fromUser).and("to_user = {0}",toUser);
        ew.orderBy("create_time",false);
        chatRecordList = selectList(ew);
        return chatRecordList;
    }

}
