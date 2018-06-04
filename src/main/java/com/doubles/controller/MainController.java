package com.doubles.controller;

import com.doubles.entity.*;
import com.doubles.model.CommonResult;
import com.doubles.model.IndexResult;
import com.doubles.model.PageInfo;
import com.doubles.model.ResultArticle;
import com.doubles.service.*;
import com.doubles.util.Utils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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
	@Autowired
	private UserTopicService userTopicService;
	@Autowired
	private TransmitService transmitService;
	@Autowired
	private CollectionsService collectionsService;
	@Autowired
	private PushService pushService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request){
		IndexResult indexResult = new IndexResult();
		ModelAndView view = new ModelAndView("/index");
		indexResult.setList(getIndexData(request,0,20));
		view.addObject("articleList",indexResult);
		return view;
	}

	@RequestMapping("/getIndex")
	@ResponseBody
	public String getIndex(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		CommonResult<IndexResult> result = new CommonResult<IndexResult>(0,"success");
		IndexResult indexResult = new IndexResult();
		indexResult.setList(getIndexData(request,pageNo,pageSize));

		result.setData(indexResult);
		return Utils.toJson(result);
	}


	@RequestMapping("/getCollection")
	@ResponseBody
	public String getCollection(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		CommonResult<IndexResult> result = new CommonResult<IndexResult>(0,"success");
		IndexResult indexResult = new IndexResult();

		indexResult.setList(getCollectionData(request,pageNo,pageSize));

		result.setData(indexResult);
		return Utils.toJson(result);
	}

	private PageInfo<ResultArticle> getCollectionData(HttpServletRequest request,int index,int size){
		List<ResultArticle> resultArticleList = new ArrayList<>();
		Users user = (Users)request.getSession().getAttribute("user");

		List<Collections> list = collectionsService.getListCollection(user.getUserId());
		for(Collections c : list){
			ResultArticle resultArticle = new ResultArticle();
			resultArticle.setLike(true);
			resultArticle.setOldUser(c.getArticle().getUser());
			resultArticle.setIsTransmit(1);
			resultArticle.setArticle(c.getArticle());
			resultArticleList.add(resultArticle);
		}

		PageInfo<ResultArticle> resultArticlePageInfo = new PageInfo<>(resultArticleList);
		return  resultArticlePageInfo;
	}

	private PageInfo<ResultArticle> getIndexData(HttpServletRequest request,int index,int size){
		List<ResultArticle> resultArticleList = new ArrayList<>();

		//用户首页动态显示
		//先获取该用户，查找其关注的用户的动态
		Users user = (Users)request.getSession().getAttribute("user");
		Page<PushData> pushDataPage = pushService.getPageByPushUserId(user.getUserId(),index,size);

		PageInfo<PushData> pageInfo = new PageInfo<PushData>(pushDataPage);
		for(PushData p : pageInfo.getList()){
			ResultArticle resultArticle = new ResultArticle();
			//Article article = articleService.getOneArticle(p.getContentId());

			resultArticle.setArticle(p.getArticle());
			resultArticle.setIsTransmit(p.getType());
			resultArticle.setOldUser(p.getOld());
			resultArticle.setLike(collectionsService.isCollection(user.getUserId(),p.getArticle().getArticleId()));
			if(p.getType() == 2){
				resultArticle.setNowUser(p.getNow());
			}

			resultArticleList.add(resultArticle);
		}
		PageInfo<ResultArticle> resultArticlePageInfo = new PageInfo<>(resultArticleList);
		return resultArticlePageInfo;
	}

}
