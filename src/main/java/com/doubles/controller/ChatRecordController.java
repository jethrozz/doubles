package com.doubles.controller;


import com.doubles.entity.ChatRecord;
import com.doubles.entity.Image;
import com.doubles.entity.Users;
import com.doubles.model.CommonResult;
import com.doubles.model.PageInfo;
import com.doubles.model.SingletonMsgQueue;
import com.doubles.service.ChatRecordService;
import com.doubles.service.UsersService;
import com.doubles.util.Utils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    private UsersService usersService;

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

    @RequestMapping("/getNotice")
    @ResponseBody
    public String getNotice(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
        CommonResult<PageInfo<ChatRecord>> result = new CommonResult<>(0,"success");
        Users toUser = (Users)request.getSession().getAttribute("user");
        Users fromUser = usersService.getAdmin();

        Page<ChatRecord> chatRecordPage = chatRecordService.getPageChatRecord(fromUser.getUserId(),toUser.getUserId(),pageNo,pageSize);
        PageInfo<ChatRecord> chatRecordPageInfo = new PageInfo<>(chatRecordPage);
        result.setData(chatRecordPageInfo);
        return Utils.toJson(result);
    }
    @RequestMapping("/getMsgRecord")
    @ResponseBody
    public String getMsgRecord(String toUser,HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
        CommonResult<PageInfo<ChatRecord>> result = new CommonResult<>(0,"success");
        Users fromUser = (Users)request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(toUser)){
            result.setStauts(1);
            result.setMsg("to user id is empty");
            return Utils.toJson(result);
        }
        Page<ChatRecord> chatRecordPage = chatRecordService.getPageChatRecord(fromUser.getUserId(),toUser,pageNo,pageSize);
        PageInfo<ChatRecord> chatRecordPageInfo = new PageInfo<>(chatRecordPage);
        result.setData(chatRecordPageInfo);
        return Utils.toJson(result);
    }
}

