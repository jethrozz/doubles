package com.doubles.controller;


import com.doubles.entity.Article;
import com.doubles.entity.Image;
import com.doubles.entity.Transmit;
import com.doubles.entity.Users;
import com.doubles.model.CommonResult;
import com.doubles.model.SingletonTransmitQueue;
import com.doubles.service.ArticleService;
import com.doubles.service.ImageService;
import com.doubles.service.TransmitService;
import com.doubles.service.UsersService;
import com.doubles.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 转发表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/article")
public class TransmitController {

	@Autowired
	private TransmitService transmitService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/transmit")
	@ResponseBody
	public String transmitArticle(HttpServletRequest request,Transmit transmit){
		CommonResult<String> result = new CommonResult<>(0,"transmit success");
		Users user = (Users) request.getSession().getAttribute("user");
		transmit.setUserId(user.getUserId());
		if(null == transmit){
			result.setStauts(1);
			result.setMsg("the request is null");
			return Utils.toJson(result);
		}
		if(StringUtils.isEmpty(transmit.getUserId())){
			result.setStauts(1);
			result.setMsg("the userId is null");
			return Utils.toJson(result);
		}
		if(StringUtils.isEmpty(transmit.getContentId())){
			result.setStauts(1);
			result.setMsg("the contentId is null");
			return Utils.toJson(result);
		}
		if(transmit.getType() == 0){
			//动态
			Article article = articleService.getOneArticle(transmit.getContentId());
			article.setTransmitNumber(article.getTransmitNumber()+1);
			articleService.updateArticle(article);
			if(null == article){
				result.setStauts(1);
				result.setMsg("the article is not exist");
				return Utils.toJson(result);
			}
		}else if(transmit.getType() == 1){
			//图片
			Image image = imageService.getOneImg(transmit.getContentId());
			if(null == image){
				result.setStauts(1);
				result.setMsg("the Image is not exist");
				return Utils.toJson(result);
			}
		}

		if(!transmitService.addTransmit(transmit)){
			if(transmit.getType() != 1){
				SingletonTransmitQueue.getInstance().addTransmitIntoPushQueue(transmit);
			}
			result.setStauts(1);
			result.setMsg("the transmit failed");
		}

		return Utils.toJson(result);
	}

	@RequestMapping("/deleteTransmit")
	@ResponseBody
	public String delete(HttpServletRequest request,String articleId){
		CommonResult<String> result = new CommonResult<>(0,"transmit success");
		Users user = (Users) request.getSession().getAttribute("user");
		Article article = articleService.getOneArticle(articleId);
		article.setTransmitNumber(article.getTransmitNumber()-1);
		if(StringUtils.isEmpty(articleId)){
			result.setStauts(1);
			result.setMsg("the articleId is empty");
			return Utils.toJson(result);
		}
		if(!transmitService.deleteTransmit(articleId,user.getUserId())){
			result.setStauts(1);
			result.setMsg("delete failed");
			return Utils.toJson(result);
		}
		articleService.updateArticle(article);
		return Utils.toJson(result);
	}
}

