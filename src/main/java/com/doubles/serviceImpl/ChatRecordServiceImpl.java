package com.doubles.serviceImpl;

import com.doubles.dao.ChatRecordMapper;
import com.doubles.entity.ChatRecord;
import com.doubles.entity.ChatRecordExample;
import com.doubles.service.ChatRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
public class ChatRecordServiceImpl  implements ChatRecordService {

    @Autowired
    private ChatRecordMapper chatRecordDao;

    @Override
    public List<ChatRecord> findChatRecordList(String fromUser, String toUser) {
        List<ChatRecord> chatRecordList = new ArrayList<>();
        ChatRecordExample example = new ChatRecordExample();
        example.or().andUserIdEqualTo(fromUser).andToUserEqualTo(toUser);
        chatRecordList = chatRecordDao.selectByExample(example);
        return chatRecordList;
    }

    @Override
    public boolean insert(ChatRecord chatRecord) {
        if(chatRecordDao.insertSelective(chatRecord) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public Page<ChatRecord> getPageChatRecord(String fromUser, String toUser, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return chatRecordDao.getChatRecordPage(toUser,fromUser);
    }

}
