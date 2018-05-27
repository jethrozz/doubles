package com.doubles.controller;


import com.doubles.entity.ChatRecord;
import com.doubles.entity.Comments;
import com.doubles.entity.Users;
import com.doubles.model.CommonResult;
import com.doubles.model.NoticeResult;
import com.doubles.model.PageInfo;
import com.doubles.service.ArticleService;
import com.doubles.service.ChatRecordService;
import com.doubles.service.CommentsService;
import com.doubles.service.UsersService;
import com.doubles.util.Utils;
import com.github.pagehelper.Page;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/article")
@PropertySource(value = {"classpath:qiniu.properties"})
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ChatRecordService chatRecordService;
	@Autowired
	private GoEasy goEasy;

	@Value("${goEasy.noticePush}")
	private String noticePush;

	@RequestMapping("/addComment")
	@ResponseBody
	public String addComment(HttpServletRequest request, Comments comment){
		CommonResult<Comments> commonResult  = new CommonResult<>(0,"success");
		Users user = (Users)request.getSession().getAttribute("user");
		//comment.setCommentId(SecretUtils.uuid32());
		comment.setUserId(user.getUserId());
		comment.setUser(user);
		if(!commentsService.addComment(comment)){
			commonResult.setMsg("insert comment failed");
			commonResult.setStauts(1);
		}
		Users admin = usersService.getAdmin();

//		if(!StringUtils.isEmpty(comment.getToUser())){
//
//		}
		if(comment.getType() == 1){
			comment.setTo(usersService.getOne(comment.getToUser()));
		}
		if(admin != null){
			ChatRecord chatRecord = new ChatRecord();
			chatRecord.setUserId(admin.getUserId());
			chatRecord.setToUser(comment.getToUser());
			chatRecord.setContent(comment.getCommentContent()+"||"+comment.getObjectId());
			chatRecordService.insert(chatRecord);
			//封装即将推送出去的数据
			NoticeResult noticeResult = new NoticeResult(0,"you have a new notice");
			noticeResult.setFromUser(user.getUserId());
			noticeResult.setToUser(comment.getToUser());
			noticeResult.setMsg(comment.getCommentContent());
			//goEasy推送评论通知
			goEasy.publish(noticePush,Utils.toJson(noticeResult));
		}
		commonResult.setData(comment);
		return Utils.toJson(commonResult);
	}

	@RequestMapping("/deleteComment")
	public String deleteComment(String commentId){
		CommonResult<String> commonResult  = new CommonResult<>(0,"success");
		if(!commentsService.deleteComment(commentId)){
			commonResult.setMsg("delete comment failed");
			commonResult.setStauts(1);
		}

		return Utils.toJson(commonResult);
	}



	@RequestMapping("getCommentList")
	@ResponseBody
	public String getCommentList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		CommonResult<PageInfo<Comments>> result = new CommonResult<>(0,"success");
		Users user = (Users)request.getSession().getAttribute("user");

		Page<Comments> list = commentsService.getCommentsPage(user.getUserId(),pageNo,pageSize);
		PageInfo<Comments> pageInfo = new PageInfo<>(list);

		result.setData(pageInfo);
		//封装返回
		return Utils.toJson(result);
	}
}

