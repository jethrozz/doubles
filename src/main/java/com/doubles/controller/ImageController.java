package com.doubles.controller;


import com.doubles.entity.Article;
import com.doubles.entity.Image;
import com.doubles.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 图片表 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;
    @RequestMapping("/addImgLike")
    public void addLike(HttpServletRequest request, String articleId){
        Image image = imageService.selectById(articleId);
        if(image !=  null){
            image.setLikeNumber(image.getLikeNumber()+1);
            imageService.updateById(image);
        }
    }
}

