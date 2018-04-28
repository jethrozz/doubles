package com.doubles.controller;


import com.doubles.entity.Users;
import com.doubles.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

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

    //返回数据待商议
    @RequestMapping("/login")
    public void userLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, String username, String password){
        try{  //把sessionId记录在浏览器
            Cookie c = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            c.setPath("/");
            //先设置cookie有效期为2天，不用担心，session不会保存2天
            c.setMaxAge( 48*60 * 60);
            response.addCookie(c);
        }catch (Exception e){
            e.printStackTrace();
        }
        Users user = usersService.userLogin(new Users(username,password));
        if(user != null){
            session.setAttribute("user",user);
            //
        }
    }
    //返回数据待商议
    @RequestMapping("/regist")
    public void userRegist(HttpServletRequest request,Users user){
        usersService.registUser(user);
    }
    //返回数据待商议
    @RequestMapping("/updateInfo")
    public void  userUpdate(HttpServletRequest request,Users user){
        usersService.updateUserInfo(user);
    }
}

