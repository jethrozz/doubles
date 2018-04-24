package com.doubles.controller;

import com.doubles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @时间: 2018/4/23
 * @描述：用户相关操作的控制器
 */
@Controller
@RequestMapping("/doubles/user")
public class UserController {

    @Autowired
    UserService userService;



}
