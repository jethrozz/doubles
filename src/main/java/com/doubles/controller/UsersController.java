package com.doubles.controller;


import com.doubles.entity.Users;
import com.doubles.model.CommonResult;
import com.doubles.model.ResLogin;
import com.doubles.model.SingletonOnlineUserList;
import com.doubles.model.SingletonReadySendMsgUserList;
import com.doubles.service.UsersService;
import com.doubles.util.OfflineMsgPush;
import com.doubles.util.SecretUtils;
import com.doubles.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/regist")
	public String regist(HttpServletRequest request) {
		return "register";
	}

	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

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


	@RequestMapping("/userregist")
	@ResponseBody
	public String userRegist(HttpServletRequest request,Users users) {

		ResLogin res = new ResLogin(1, "default failed");
		Users user = new Users();
		user.setUserId(SecretUtils.uuid32());
		user.setUserimg("/static/img/default.jpg");
		if (usersService.registUser(user)) {
			res.setStauts(0);
			res.setMsg(user.getUserId());
		}
		return Utils.toJson(res);
	}

	@RequestMapping("/addLike")
	@ResponseBody
	public String userLike(HttpSession session,HttpServletResponse response, Users user) {
		usersService.updateUserInfo(user);
		user = usersService.getOne(user.getUserId());
		session.setAttribute("user", user);
		CommonResult<Users> res = new CommonResult();
		res.setData(user);
		res.setStauts(0);
		res.setMsg("登录成功");
		addCooike(session,response);
		return Utils.toJson(res);
	}


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

	@RequestMapping("/updateInfo")
	public void userUpdate(HttpServletRequest request, Users user) {
		usersService.updateUserInfo(user);
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
}

