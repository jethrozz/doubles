package com.doubles.controller;


import com.doubles.entity.ChatRecord;
import com.doubles.entity.Comments;
import com.doubles.entity.Users;
import com.doubles.model.CommonResult;
import com.doubles.model.NoticeResult;
import com.doubles.service.ArticleService;
import com.doubles.service.ChatRecordService;
import com.doubles.service.CommentsService;
import com.doubles.service.UsersService;
import com.doubles.util.SecretUtils;
import com.doubles.util.Utils;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@Value("${goEasy.articlePush}")
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

		if(admin != null){
			ChatRecord chatRecord = new ChatRecord();
			chatRecord.setUserId(admin.getUserId());
			chatRecord.setToUser(comment.getToUser());
			chatRecord.setContent(comment.getCommentContent()+"||"+comment.getObjectId());
			chatRecordService.insert(chatRecord);
			NoticeResult noticeResult = new NoticeResult(0,"you have a new notice");
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
}

