package com.doubles.controller;


import com.doubles.entity.*;
import com.doubles.model.*;
import com.doubles.service.*;
import com.doubles.util.OfflineMsgPush;
import com.doubles.util.SecretUtils;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private RelationshipService relationshipService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserTopicService userTopicService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/regist")
	public String regist(HttpServletRequest request) {
		return "register";
	}


	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
	@RequestMapping("/myself")
	public ModelAndView myself(HttpServletRequest request){
		Users user = (Users)request.getSession().getAttribute("user");
		ModelAndView modelAndView = new ModelAndView("updateInfo");
		modelAndView.addObject("user",user);

		return modelAndView;
	}
	/**
	 * 用户登录接口
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/userlogin")
	@ResponseBody
	public String userLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) {
		CommonResult<Users> res = new CommonResult();
		Users user = usersService.userLogin(new Users(username, password));
		HttpSession session = request.getSession();
		if (user != null) {
			session.setAttribute("user", user);
			res.setData(user);
			res.setStauts(0);
			res.setMsg("登录成功");
			if(SingletonReadySendMsgUserList.getInstance().isContainUser(user.getUserId())){
				OfflineMsgPush push = new OfflineMsgPush(user.getUserId());
				fixedThreadPool.submit(push);
			}
			SingletonOnlineUserList.getInstance().addUser(user.getUserId());
		}else{
			res.setStauts(1);
			res.setMsg("登录失败");
		}
		addCooike(session,response);

		return Utils.toJson(res);
	}


	/**
	 * 用户注册接口
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/userregist")
	@ResponseBody
	public String userRegist(HttpServletRequest request,Users user) {
		CommonResult<Users> result = new CommonResult<Users>(0,"regist success");
		//user.setUserId(SecretUtils.uuid32());
		user.setUserimg("http://p8jz8nm27.bkt.clouddn.com/kenan.png");
		if (usersService.registUser(user)) {
			//注册成功为其创建一个存放动态的相册
			Album album = new Album();
			album.setAlbumDescribe("动态相册");
			album.setAlbumName("动态相册");
			album.setUserId(user.getUserId());
			albumService.addAlbum(album);
			result.setData(user);
			return Utils.toJson(result);
		}else{
			CommonResult<String> res = new CommonResult<>(1,"register failed");
			return Utils.toJson(res);
		}

	}

	/**
	 * 用户注册后添加标签接口
	 * @param session
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping("/addLike")
	@ResponseBody
	public String userLike(HttpSession session,HttpServletResponse response, Users user) {
		usersService.updateUserInfo(user);
		String like[] = user.getUserlike().split("\\|\\|");
		for(String topic : like){
			Topic t = topicService.getOneById(topic);
			UserTopic userTopic = new UserTopic();
			userTopic.setUserId(user.getUserId());
			userTopic.setTopicId(topic);
			userTopicService.followTopic(userTopic);
			t.setFanNumber(t.getFanNumber()+1);
			topicService.updateTopic(t);
		}
		user = usersService.getOne(user.getUserId());
		session.setAttribute("user", user);
		CommonResult<Users> res = new CommonResult();
		res.setData(user);
		res.setStauts(0);
		res.setMsg("登录成功");
		addCooike(session,response);
		return Utils.toJson(res);
	}


	/**
	 * 检查用户名是否重复接口
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkName")
	@ResponseBody
	public String checkName(String username) {
		ResLogin res = new ResLogin(1, "default failed");
		if (usersService.checkUserName(username)) {
			res.setMsg("success");
			res.setStauts(0);
		}
		return Utils.toJson(res);
	}

	/**
	 * 个人信息更新接口
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateInfo")
	@ResponseBody
	public String userUpdate(HttpServletRequest request, Users user) {
		CommonResult<String> result = new CommonResult<>(0,"update success");
		Users u = (Users) request.getSession().getAttribute("user");
		user.setUserId(u.getUserId());
		if(user == null){
			result.setStauts(1);
			result.setMsg("user is null");
			return Utils.toJson(result);
		}else {
			if (!usersService.updateUserInfo(user)) {
				result.setStauts(1);
				result.setMsg("update failed");
			}
			return Utils.toJson(result);
		}
	}

	/**
	 * 用户关注接口/取消关注
	 * 参数：userid ,friendid,isfriend(isfriend 0-关注，1-取消关注)
	 * @param relationship
	 * @return
	 */
	@RequestMapping("/followOrUnfollowUser")
	@ResponseBody
	public String followUser(Relationship relationship){
		CommonResult<String> result = new CommonResult<>(0,"success");
		if(relationship == null){
			result.setStauts(1);
			result.setMsg("the request is null");
			return Utils.toJson(result);
		}else{
			//relationshipService.followOrUnfollow() 会返回一个数字，该数字表示这两个用户执行了该方法后的关系
			relationshipService.followOrUnfollow(relationship);
			return Utils.toJson(result);
		}
	}

	@RequestMapping("/getFansList")
	@ResponseBody
	public String getFans(HttpServletRequest request, String userId,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		//我的粉丝列表
		CommonResult<PageInfo<FollowResult>> result = new CommonResult<>(0,"success");
		if(StringUtils.isEmpty(userId)){
			result.setStauts(1);
			result.setMsg("userId is empty");
			return Utils.toJson(result);
		}

		Users user = (Users)request.getSession().getAttribute("user");
		Page<Relationship> relationship = relationshipService.findPageFansFriends(pageNo,pageSize,userId);
		List<FollowResult> resultList = new ArrayList<>();

		for (Relationship r : relationship) {
			FollowResult followUser = new FollowResult();
			followUser.setUser(r.getMe());
			Relationship re = relationshipService.isFriend(user.getUserId(),r.getUserId());
			if(re == null){
				followUser.setIsFriend(1);
			}else{
				followUser.setIsFriend(r.getIsFriend());
			}
			resultList.add(followUser);
		}

		PageInfo<FollowResult> usersPageInfo = new PageInfo<>(resultList);
		result.setData(usersPageInfo);

		return Utils.toJson(result);
	}

	@RequestMapping("/getFollowList")
	@ResponseBody
	public String getFollow(HttpServletRequest request, String userId, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		//我的关注列表
		CommonResult<PageInfo<FollowResult>> result = new CommonResult<>(0,"success");
		if(StringUtils.isEmpty(userId)){
			result.setStauts(1);
			result.setMsg("userId is empty");
			return Utils.toJson(result);
		}

		Users user = (Users)request.getSession().getAttribute("user");
		Page<Relationship> relationship = relationshipService.findPageFollowFriends(pageNo,pageSize,userId);
		List<FollowResult> resultList = new ArrayList<>();

		for (Relationship r : relationship) {
			FollowResult followUser = new FollowResult();
			followUser.setUser(r.getFriend());
			Relationship re = relationshipService.isFriend(user.getUserId(),r.getFriendId());
			if(re == null){
				followUser.setIsFriend(1);
			}else{
				followUser.setIsFriend(r.getIsFriend());
			}
			resultList.add(followUser);
		}

		PageInfo<FollowResult> usersPageInfo = new PageInfo<>(resultList);
		result.setData(usersPageInfo);

		return Utils.toJson(result);
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public String getMe(HttpServletRequest request,String userId){
		CommonResult<Users> result = new CommonResult<>(0,"success");
		//Users user = (Users)request.getSession().getAttribute("user");
		if(StringUtils.isEmpty(userId)){
			result.setStauts(1);
			result.setMsg("userId is empty");
			return Utils.toJson(result);
		}
		Users user = usersService.getOne(userId);
		result.setData(user);

		return Utils.toJson(result);
	}

	@RequestMapping("/hotPerson")
	@ResponseBody
	public String hotPerson(HttpServletRequest request){
		CommonResult<List<HotPerson>> result = new CommonResult<>(0,"success");
		List<HotPerson> hotPeople = new ArrayList<>();
		Users user = (Users)request.getSession().getAttribute("user");
		//获取到所有用户
		List<Users> usersList = usersService.getHotPerson();

		setHotPerson(user,usersList,hotPeople);

		result.setData(hotPeople);

		return Utils.toJson(result);
	}



	@RequestMapping("/hotPersonTopic")
	@ResponseBody
	public String hotPersonTopic(HttpServletRequest request,String topicId){
		CommonResult<List<HotPerson>> result = new CommonResult<>(0,"success");
		List<HotPerson> hotPeople = new ArrayList<>();
		Users user = (Users)request.getSession().getAttribute("user");
		if(StringUtils.isEmpty(topicId)){
			result.setStauts(1);
			result.setMsg("failed");
			return Utils.toJson(result);
		}
		//获取到所有用户
		List<Users> usersList = usersService.getHotPersonByTopic(topicId);
		setHotPerson(user,usersList,hotPeople);
		result.setData(hotPeople);
		return Utils.toJson(result);
	}

	private void addCooike(HttpSession session,HttpServletResponse response){
		try {  //把sessionId记录在浏览器
			Cookie c = new Cookie("JSESSIONID", URLEncoder.encode(session.getId(), "utf-8"));
			c.setPath("/");
			//先设置cookie有效期为2天，不用担心，session不会保存2天
			c.setMaxAge(48 * 60 * 60);
			response.addCookie(c);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	private void setHotPerson(Users user,List<Users> usersList,List<HotPerson> hotPeople ){
		for (Users u : usersList){
			HotPerson hotPerson = new HotPerson();
			hotPerson.setUser(u);
			if (!user.getUserId().equals(u.getUserId())){
				Relationship r = relationshipService.isFriend(user.getUserId(),u.getUserId());
				if(r == null){
					hotPerson.setIsFriend(1);
				}else{
					hotPerson.setIsFriend(r.getIsFriend());
				}

			}else{
				hotPerson.setIsFriend(3);
			}

			List<Article> articleList = articleService.selectArticleListByUid(u.getUserId());
			Map<String,String> imgList = new HashMap<>();
			for(Article article : articleList){
				String imgTag = Utils.getOneImgTag(article.getContent());
				if(imgTag != null){
					imgList.put(article.getArticleId(),Utils.getOneImgSrc(imgTag));
				}else{
					continue;
				}
				if(imgList.size() >= 4){
					break;
				}
			}

			hotPerson.setImgList(imgList);
			hotPeople.add(hotPerson);
		}
	}
}

