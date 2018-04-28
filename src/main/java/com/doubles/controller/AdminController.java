package com.doubles.controller;


import com.doubles.entity.Admin;
import com.doubles.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

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
    public void addAdmin(HttpServletRequest request, Admin admin){
        adminService.insert(admin);
    }
}

