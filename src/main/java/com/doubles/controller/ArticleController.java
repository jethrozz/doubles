package com.doubles.controller;


import com.doubles.entity.Article;
import com.doubles.model.SingletonArticleQueue;
import com.doubles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户动态表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;


    @RequestMapping("/submitArticle")
    public void submitArticle(HttpServletRequest request, Article article){
        articleService.addArticleNoImg(article);
        String userId = article.getUserId();
        //将当前发表动态的用户放入阻塞队列中，在另一个线程中进行推送操作
        SingletonArticleQueue.getInstance().addUserIntoPushQueue(userId);


    }
}

