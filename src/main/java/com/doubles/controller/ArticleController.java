package com.doubles.controller;


import com.doubles.entity.Article;
import com.doubles.entity.Relationship;
import com.doubles.service.ArticleService;
import com.doubles.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    @Autowired
    private RelationshipService relationshipService;

    @RequestMapping("/submitArticle")
    public void submitArticle(HttpServletRequest request, Article article){
        articleService.addArticleNoImg(article);
        String userId = article.getUserId();
        //将所有关注了我的用户以及相互关注了的用户放入一个list中
        List<Relationship> relationship1 = relationshipService.findFriends(userId,0); //单方面关注了我的用户
        List<Relationship> relationship2 = relationshipService.findFriends(userId,2); //相互关注用户
        List<Relationship> relationships = new ArrayList<>();
        for(Relationship relationship : relationship1){
            relationships.add(relationship);
        }
        for(Relationship relationship : relationship2){
            relationships.add(relationship);
        }


    }
}

