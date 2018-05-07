package com.doubles.controller;


import com.doubles.entity.Admin;
import com.doubles.entity.Users;
import com.doubles.service.AdminService;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(HttpServletRequest request, Users users){
        System.out.println(users.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(users.getBirthday()));
        return "ok";
       // adminService.insert(admin);
    }

}

