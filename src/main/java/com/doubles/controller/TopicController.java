package com.doubles.controller;


import com.doubles.entity.*;
import com.doubles.model.*;
import com.doubles.service.*;
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
import java.util.*;

/**
 * <p>
 * 话题表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;
	@Autowired
	private UserTopicService userTopicService;
	@Autowired
	private UsersService userService;
	@Autowired
	private RelationshipService relationshipService;
	@Autowired
	private ArtilceTopicService artilceTopicService;
	@Autowired
	private CollectionsService collectionsService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticlImgService articlImgService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private ImageService imageService;

	@RequestMapping("/submitArticle")
	@ResponseBody
	public String submitArticle(HttpServletRequest request, Article article,String image){
		CommonResult<String> result = new CommonResult<>(0,"success");
		if(StringUtils.isEmpty(image)&&article.getIsHaveimg() == 1){
			result.setStauts(1);
			result.setMsg("failed");
			return Utils.toJson(result);
		}

		//发表动态时要先去遍历该动态的type
		Users user = (Users)request.getSession().getAttribute("user");
		article.setUserId(user.getUserId());
		//直接插入表中，如有图片再进行后续处理
		articleService.addArticleNoImg(article);

		if(article.getIsHaveimg() == 1){
			//如果有图片，则先插入动态，再处理图片
			String imgUrl[] = image.split("\\|\\|");
			//先根据用户id 获取到动态相册
			Album album = albumService.getAlbumByuserIdAndName(user.getUserId());
			for(int i=0;i<imgUrl.length;i++){
				//然后遍历每个图片链接进行处理
				//将图片放入动态相册中
				Image img = new Image();
				img.setImgPath(imgUrl[i]);
				img.setAlbumId(album.getAlbumId());
				img.setImgDescribe("");
				imageService.addImage(img);
				//再将图片与该动态对应放入动态表中
				ArticlImg articlImg = new ArticlImg();
				articlImg.setArticleId(article.getArticleId());
				articlImg.setImgId(img.getImgId());
				articlImgService.addImage(articlImg);
			}
		}


		Topic topic = topicService.getOneById(article.getType());
		ArtilceTopic artilceTopic = new ArtilceTopic();
		artilceTopic.setArticleId(article.getArticleId());
		artilceTopic.setTopicId(article.getType());
		artilceTopicService.insertOne(artilceTopic);
		if(topic != null){
			topic.setDiscussionNumber(topic.getDiscussionNumber()+1);
			topicService.updateTopic(topic);
			SingletonTopicQueue.getInstance().addUserIntoPushQueue(artilceTopic);
		}
		//将当前发表动态的用户放入阻塞队列中，在另一个线程中进行推送操作
		SingletonArticleQueue.getInstance().addUserIntoPushQueue(article);
		return Utils.toJson(result);
	}

	@RequestMapping("/addTopic")
	@ResponseBody
	public String addTopic(Topic topic){
		CommonResult<String> result = new CommonResult<>(0,"add topic success");
		if(null == topic){
			result.setStauts(1);
			result.setMsg("the request is empty");
			return Utils.toJson(result);
		}else{
			//topic.setTopicId(SecretUtils.uuid32());
			if (!topicService.addTopic(topic)){
				result.setStauts(1);
				result.setMsg("add topic failed");
			}
			return Utils.toJson(result);
		}
	}

	@RequestMapping("/followOrUnfollowTopic")
	@ResponseBody
	public String followTopic(HttpServletRequest request,UserTopic userTopic,String opt){
		CommonResult<String> result = new CommonResult<>(0,"follow success");
		Users user = (Users) request.getSession().getAttribute("user");
		//Users user = userService.getOne(userTopic.getUserId());
		Topic topic = topicService.getOneById(userTopic.getTopicId());
		userTopic.setUserId(user.getUserId());
/*		if(user == null){
			result.setStauts(1);
			result.setMsg("user is not exist");
			return Utils.toJson(result);
		}*/
		if (topic == null ){
			result.setStauts(1);
			result.setMsg("topic is not exist");
			return Utils.toJson(result);
		}
		if("follow".equals(opt)){
			if(!userTopicService.followTopic(userTopic)){
				result.setStauts(1);
				result.setMsg("follow failed");
				return Utils.toJson(result);
			}

			topic.setFanNumber(topic.getFanNumber()+1);
			topicService.updateTopic(topic);
			return Utils.toJson(result);
		}else{
			if(!userTopicService.unFollowTopic(userTopic)){
				result.setStauts(1);
				result.setMsg("unFollow failed");
				return Utils.toJson(result);
			}
			topic.setFanNumber(topic.getFanNumber()-1);
			topicService.updateTopic(topic);
			result.setMsg("unFollow success");
			return Utils.toJson(result);
		}

	}

	@RequestMapping("/getUserList")
	@ResponseBody
	public String getUserList(String topicId, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		CommonResult<PageInfo<UserTopic>> result = new CommonResult<>(0,"success");
		if(StringUtils.isEmpty(topicId)){
			result.setStauts(1);
			result.setMsg("topicId is empty");
			return Utils.toJson(result);
		}

		Page<UserTopic> userTopicPage = userTopicService.getUserPageByTopicId(topicId,pageNo,pageSize);
		PageInfo<UserTopic> userTopicPageInfo = new PageInfo<>(userTopicPage);

		result.setData(userTopicPageInfo);
		return Utils.toJson(result);
	}

	@RequestMapping("/getTopicList")
	@ResponseBody
	public String getTopicList(String userId, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		CommonResult<PageInfo<UserTopic>> result = new CommonResult<>(0,"success");
		if(StringUtils.isEmpty(userId)){
			result.setStauts(1);
			result.setMsg("userId is empty");
			return Utils.toJson(result);
		}

		Page<UserTopic> userTopicPage = userTopicService.getTopicPageByUserId(userId,pageNo,pageSize);
		PageInfo<UserTopic> userTopicPageInfo = new PageInfo<>(userTopicPage);

		result.setData(userTopicPageInfo);
		return Utils.toJson(result);
	}

	@RequestMapping("/getArticleList")
	@ResponseBody
	public String getArticleList(String topicId, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		CommonResult<PageInfo<ArtilceTopic>> result = new CommonResult<>(0,"success");
		if(StringUtils.isEmpty(topicId)){
			result.setStauts(1);
			result.setMsg("topicId is empty");
			return Utils.toJson(result);
		}
		Page<ArtilceTopic> artilceTopicPage = artilceTopicService.getArticlePageByTopicId(topicId,pageNo,pageSize);
		PageInfo<ArtilceTopic> artilceTopicPageInfo = new PageInfo<>(artilceTopicPage);
		result.setData(artilceTopicPageInfo);
		return Utils.toJson(result);
	}

	@RequestMapping("/getHotTopic")
	@ResponseBody
	public String getHotTopic(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		CommonResult<PageInfo<ResultTopic>> result = new CommonResult<>(0,"success");
		Map<Topic,List<Article>> artilceTopicList = artilceTopicService.getListByArticleNumber();

		List<ResultTopic> resultTopicList = new ArrayList<>();
		getTopic(artilceTopicList,resultTopicList);
		PageInfo<ResultTopic> topicPageInfo = new PageInfo<>(resultTopicList);
		result.setData(topicPageInfo);
		return Utils.toJson(result);
	}

	@RequestMapping("/getNewTopic")
	@ResponseBody
	public String getNewTopic(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		CommonResult<PageInfo<ResultTopic>> result = new CommonResult<>(0,"success");
		Map<Topic,List<Article>> artilceTopicList = artilceTopicService.getListByCreateTime();

		List<ResultTopic> resultTopicList = new ArrayList<>();
		getTopic(artilceTopicList,resultTopicList);

		PageInfo<ResultTopic> topicPageInfo = new PageInfo<>(resultTopicList);
		result.setData(topicPageInfo);
		return Utils.toJson(result);
	}

	@RequestMapping("/gettopic/{topicId}")
	public ModelAndView getTopic(HttpServletRequest request,@PathVariable String topicId){
		ModelAndView modelAndView = new ModelAndView("/innertopic");
		List<TopicArticleResult> articleResults = new ArrayList<>();
		List<TopicUserResult> userResults = new ArrayList<>();
		Topic topic = topicService.getOneById(topicId);

		Users user = (Users)request.getSession().getAttribute("user");
		boolean isFollow = userTopicService.isFollow(topicId,user.getUserId());

		List<UserTopic> userTopicList = userTopicService.getLisyByTopicId(topicId);
		List<Article> articleList = artilceTopicService.getArticleByTopic(topicId);
		List<Users> usersList = new ArrayList<>();

		for(UserTopic userTopic : userTopicList){
			usersList.add(userTopic.getUser());
		}


		for(Article article : articleList){
			TopicArticleResult topicArticleResult = new TopicArticleResult();
			topicArticleResult.setArticle(article);
			topicArticleResult.setLike(collectionsService.isCollection(user.getUserId(),article.getArticleId()));

			if(article.getUserId().equals(user.getUserId())){
				topicArticleResult.setIsFollow(3);
			}else{
				Relationship relationship = relationshipService.isFriend(user.getUserId(),article.getUserId());
				if(relationship == null){
					topicArticleResult.setIsFollow(3);
				}else{
					topicArticleResult.setIsFollow((int)relationship.getIsFriend());
				}
			}
			articleResults.add(topicArticleResult);
		}

		for (Users u : usersList){
			TopicUserResult topicUserResult = new TopicUserResult();
			topicUserResult.setUser(u);
			if(u.getUserId().equals(user.getUserId())){
				topicUserResult.setIsFollow(3);
			}else{
				Relationship relationship = relationshipService.isFriend(user.getUserId(),u.getUserId());
				if(relationship == null){
					topicUserResult.setIsFollow(1);
				}else{
					topicUserResult.setIsFollow((int)relationship.getIsFriend());
				}
			}
			userResults.add(topicUserResult);
		}

		modelAndView.addObject("articleList",articleResults);
		modelAndView.addObject("topic",topic);
		modelAndView.addObject("userList",userResults);
		modelAndView.addObject("subscribe",isFollow);
		return modelAndView;
	}

	private void getTopic(Map<Topic,List<Article>> artilceTopicList,List<ResultTopic> resultTopicList){
		Iterator iterator = artilceTopicList.entrySet().iterator();

		while (iterator.hasNext()){
			Map.Entry<Topic, List<Article>> entry = (Map.Entry<Topic, List<Article>>) iterator.next();
			ResultTopic resultTopic = new ResultTopic();
			resultTopic.setTopic(entry.getKey());
			//获取到该动态的第一张图片
			Map<String,String> imgList = new LinkedHashMap<>();
			for (Article article :entry.getValue()){
				String img = Utils.getOneImgTag(article.getContent());
				//判断是否有图
				String src = Utils.getOneImgSrc(img);
				//将该动态与图片关联起来
				imgList.put(article.getArticleId(),src);
				resultTopic.setImgList(imgList);

				if(imgList.size() >= 6){
					break;
				}
			}
			resultTopicList.add(resultTopic);
		}
	}

}

