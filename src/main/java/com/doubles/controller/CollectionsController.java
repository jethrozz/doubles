package com.doubles.controller;


import com.doubles.entity.Collections;
import com.doubles.entity.Users;
import com.doubles.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 收藏表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/collections")
public class CollectionsController {
    @Autowired
    private CollectionsService collectionService;

    @RequestMapping("/addCollectionImg")
    public void addCollectionImg(HttpSession session, String contentId){
        Users user = (Users) session.getAttribute("user");
        Collections collection = new Collections();
        collection.setContentId(contentId);
        collection.setUserId(user.getUserId());
        collection.setType(1);
        collectionService.insert(collection);
    }

    @RequestMapping("/addCollectionArticle")
    public void addCollectionArticle(HttpSession session, String contentId){
        Users user = (Users) session.getAttribute("user");
        Collections collection = new Collections();
        collection.setContentId(contentId);
        collection.setUserId(user.getUserId());
        collection.setType(0);
        collectionService.insert(collection);
    }


}

