package com.doubles.controller;


import com.doubles.entity.Comments;
import com.doubles.model.CommonResult;
import com.doubles.service.CommentsService;
import com.doubles.util.SecretUtils;
import com.doubles.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
public class CommentsController {
	@Autowired
	private CommentsService commentsService;

	@RequestMapping("/addComment")
	public String addComment(Comments comment){
		CommonResult<String> commonResult  = new CommonResult<>(0,"success");
		comment.setCommentId(SecretUtils.uuid32());
		if(!commentsService.addComment(comment)){
			commonResult.setMsg("insert comment failed");
			commonResult.setStauts(1);
		}
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

