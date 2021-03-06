package com.doubles.controller;


import com.doubles.entity.ChatRecord;
import com.doubles.entity.Users;
import com.doubles.model.ChatResult;
import com.doubles.model.CommonResult;
import com.doubles.model.PageInfo;
import com.doubles.model.SingletonMsgQueue;
import com.doubles.service.ChatRecordService;
import com.doubles.service.UsersService;
import com.doubles.util.Utils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @RequestMapping("/privateletter/{id}")
    public ModelAndView privateletter(HttpServletRequest request,@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/privateletter");
        Users toUser = usersService.getOne(id);
        modelAndView.addObject("toUser",toUser);

        return modelAndView;
    }

    @RequestMapping("/getprivateletter/{id}")
    public ModelAndView getprivateletter(HttpServletRequest request,@PathVariable String id, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
        ModelAndView modelAndView = new ModelAndView("/talk");
        Users toUser = usersService.getOne(id);
        Users fromUser = (Users)request.getSession().getAttribute("user");

        Page<ChatRecord> chatRecordPage = chatRecordService.getPageChatRecord(fromUser.getUserId(),toUser.getUserId(),pageNo,pageSize);
        PageInfo<ChatRecord> chatRecordPageInfo = new PageInfo<>(chatRecordPage);
        modelAndView.addObject("pageinfo",chatRecordPageInfo);
        modelAndView.addObject("toUser",toUser);
        return modelAndView;
    }

    /**
     * 返回数据时记得把数据库写入结果返回了
     * @param chatRecord
     */
    @RequestMapping("/sendMsg")
    @ResponseBody
    public String sendMsg(HttpServletRequest request,ChatRecord chatRecord){
        CommonResult<ChatRecord> result = new CommonResult<>(0,"success");
        Users user = (Users)request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(chatRecord.getToUser())){
            result.setStauts(1);
            result.setMsg("touser id is null");
            return Utils.toJson(result);
        }
        chatRecord.setUserId(user.getUserId());
        chatRecord.setFrom(user);
        chatRecord.setTo(usersService.getOne(chatRecord.getToUser()));

        if(chatRecordService.insert(chatRecord)){
            SingletonMsgQueue.getInstance().addMsgPushQueue(chatRecord);
        }
        result.setData(chatRecord);
        return  Utils.toJson(result);
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


    @RequestMapping("getChatRecordList")
    @ResponseBody
    public String getChatRecordList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
        CommonResult<PageInfo<ChatResult>> result = new CommonResult<>(0,"success");
        Users user = (Users)request.getSession().getAttribute("user");

        Map<String,Integer> chatNumber = new HashMap<>();
        Page<Map<String,Object>> mapPage = chatRecordService.getChatRecordListCount(user.getUserId(),pageNo,pageSize);
        //这里开始统计总共的会话数以及每个对话的条数
        for(Map<String,Object> m :mapPage){
            String from = (String) m.get("fromId");
            String to = (String) m.get("toId");
            long number= (Long) m.get("number");
            int count = (int)number;
            if(from.equals(user.getUserId()) && !to.equals(user.getUserId())){
                if(chatNumber.containsKey(to)){
                    int num = chatNumber.get(to);
                    chatNumber.put(to,num+count);
                }else{
                    chatNumber.put(to,count);
                }
            }else if(!from.equals(user.getUserId()) && to.equals(user.getUserId())){
                if(chatNumber.containsKey(from)){
                    int num = chatNumber.get(from);
                    chatNumber.put(from,num+count);
                }else{
                    chatNumber.put(from,count);
                }
            }
        }

        List<ChatResult> list = new ArrayList<>();
        //此时chatNumber 中以及有了每个对话者的id以及对话条数，此时只需要根据对话者的id取得最新的那一条返回即可
        for (Map.Entry<String, Integer> entry : chatNumber.entrySet()) {
            ChatResult chatResult = new ChatResult();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            ChatRecord chatRecord = chatRecordService.getTheTopOne(user.getUserId(),entry.getKey());
            chatResult.setCount(entry.getValue());
            chatResult.setCreate_time(chatRecord.getCreateTime());
            chatResult.setFromUser(chatRecord.getFrom());
            chatResult.setToUser(chatRecord.getTo());
            chatResult.setContent(chatRecord.getContent());
            list.add(chatResult);
        }

        PageInfo<ChatResult> chatResultPageInfo = new PageInfo<>(list);
        result.setData(chatResultPageInfo);
        return Utils.toJson(result);
    }

    @RequestMapping("getChatDetail")
    @ResponseBody
    public String getChatDetail(HttpServletRequest request,String toUserId, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
        CommonResult<PageInfo<ChatRecord>> result = new CommonResult<>(0,"success");
        Users user = (Users)request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(toUserId)){
            result.setMsg("toUserId is null");
            result.setStauts(1);
            return Utils.toJson(result);
        }

        Page<ChatRecord> chatRecordPage = chatRecordService.getPageChatRecord(user.getUserId(),toUserId,pageNo,pageSize);
        PageInfo<ChatRecord> chatRecordPageInfo = new PageInfo<>(chatRecordPage);

        result.setData(chatRecordPageInfo);

        return Utils.toJson(result);
    }

}

