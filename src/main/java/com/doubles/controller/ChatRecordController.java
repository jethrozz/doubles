package com.doubles.controller;


import com.doubles.entity.ChatRecord;
import com.doubles.model.SingletonMsgQueue;
import com.doubles.service.ChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 聊天记录表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/chatRecord")
public class ChatRecordController {

    @Autowired
    private ChatRecordService chatRecordService;


    /**
     * 返回数据时记得把数据库写入结果返回了
     * @param chatRecord
     */
    @RequestMapping("/sendMsg")
    public void sendMsg(ChatRecord chatRecord){
        if(chatRecordService.insert(chatRecord)){
            SingletonMsgQueue.getInstance().addMsgPushQueue(chatRecord);
        }

    }
}

