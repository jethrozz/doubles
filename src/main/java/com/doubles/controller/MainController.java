package com.doubles.controller;

import com.doubles.entity.Article;
import com.doubles.entity.Relationship;
import com.doubles.entity.Users;
import com.doubles.model.CommonResult;
import com.doubles.service.*;
import com.doubles.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuang on 2018/5/8.
 */

@Controller
public class MainController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private RelationshipService relationshipService;
	@Autowired
	private ArticlImgService articlImgService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ArtilceTopicService artilceTopicService;


	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request){

		ModelAndView view = new ModelAndView("/index1");
	/*	//用户首页动态显示
		//先获取该用户，查找其关注的用户的动态
		Users user = (Users)request.getSession().getAttribute("user");
		List<Relationship> list1 = relationshipService.findFriends(user.getUserId(),0,0);
		List<Relationship> list2 = relationshipService.findFriends(user.getUserId(),2,0);
		List<Article> articleList = new ArrayList<>();
		//将我关注的用户以及相互关注的用户的最新动态获取出来，最多取20条
		for (Relationship re : list1) {
			if (articleList.size() >= 20){
				break;
			}
			articleList.addAll((List<Article>)articleService.selectArticlePageByUid(1,3,re.getFriendId()));
		}
		for (Relationship re : list2) {
			if (articleList.size() >= 20){
				break;
			}
			articleList.addAll((List<Article>)articleService.selectArticlePageByUid(1,3,re.getFriendId()));
		}
		//取出来之后再按时间排一次序
		articleList.sort((a1, a2) -> {
			return a1.getCreateTime().compareTo(a2.getCreateTime());
		});
		//遍历所有动态将
		isHaveImg(articleList);

		view.addObject("articleList",articleList);*/
		return view;
	}

	//为带图的动态加上图片
	private void isHaveImg(List<Article> list){
		for (Article article : list) {
			if (article.getIsHaveimg() == 0){
				article.setImgList(articlImgService.findImgByArticleId(article.getArticleId()));
			}
		}
	}

}
