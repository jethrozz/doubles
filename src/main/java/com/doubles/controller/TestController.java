package com.doubles.controller;

import com.doubles.dao.TopicMapper;
import com.doubles.dao.UsersMapper;
import com.doubles.entity.Topic;
import com.doubles.entity.TopicExample;
import com.doubles.entity.Users;
import com.doubles.entity.UsersExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class TestController {
    @Autowired
    TopicMapper topicMapper;

    @RequestMapping("/welcome")
    public ModelAndView getTheworld( Users users,String pd){
        ModelAndView modelAndView = new ModelAndView("brow");

        return modelAndView;
    }

}
