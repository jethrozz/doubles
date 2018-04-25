package com.doubles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @时间: 2018/4/25
 * @描述：
 */
@Controller()
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        request.setAttribute("name","jethro");
        return "index";
    }
}
