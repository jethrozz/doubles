package com.doubles.controller;


import com.doubles.entity.*;
import com.doubles.model.CommonResult;
import com.doubles.model.PageInfo;
import com.doubles.model.WangResult;
import com.doubles.service.CollectionsService;
import com.doubles.service.ImageService;
import com.doubles.service.UsersService;
import com.doubles.util.QiniuUtil;
import com.doubles.util.SecretUtils;
import com.doubles.util.Utils;
import com.github.pagehelper.Page;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private UsersService userService;
    @Autowired
    private CollectionsService collectionsService;
    @Autowired
    QiniuUtil qiniuUtil;

    @RequestMapping("/addImgLike")
    public String addLike(HttpServletRequest request, String imgId){
        CommonResult<String> result = new CommonResult<>(0,"collect success");
        Users user = (Users)request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(imgId)){
            result.setStauts(1);
            result.setMsg("the imgId is empty");
            return Utils.toJson(result);
        }/*else if (StringUtils.isEmpty(userId)){
            result.setStauts(1);
            result.setMsg("the userId is empty");
            return Utils.toJson(result);
        }*/else{
            Image image = imageService.getOneImg(imgId);
            //Users user = userService.getOne(userId);
            if(image ==  null){
                result.setStauts(1);
                result.setMsg("not found the image by imgId");
                return Utils.toJson(result);
            }
            if (user == null){
                result.setStauts(1);
                result.setMsg("not found the user by userId");
                return Utils.toJson(result);
            }

            Collections collection = new Collections();
            collection.setType(1);
            collection.setContentId(image.getImgId());
            collection.setUserId(user.getUserId());
            image.setLikeNumber(image.getLikeNumber()+1);
            if(!(imageService.updateImg(image) && collectionsService.addCollection(collection))){
                result.setStauts(1);
                result.setMsg("collect failed");
            }
            return Utils.toJson(result);
        }
    }

    @RequestMapping(value = "/uploadArticleImg",method = RequestMethod.POST)
    @ResponseBody
    public String uploadArticleImg(MultipartHttpServletRequest request, HttpServletResponse response){
        MultipartFile file = request.getFile("file");
        System.err.println(file);
        WangResult result = new WangResult();
        result.setError(0);
        if(!file.isEmpty()){
            String filename = SecretUtils.uuid32() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            String url = qiniuUtil.uploadImg(filename,file);
            List<String> list = new ArrayList<>();
            list.add(url);
            result.setData(list);
            return Utils.toJson(result);
        }else{
            result.setError(1);
            return Utils.toJson(result);
        }
    }

    @RequestMapping(value = "/getToken")
    @ResponseBody
    public String getToken(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uptoken",qiniuUtil.upToken());
        return jsonObject.toString();
    }

    @RequestMapping("/getImageLIst")
    @ResponseBody
    public String getImageLIst(HttpServletRequest request, String albumId, @RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "20") int pageSize){
        CommonResult<PageInfo<Image>> result = new CommonResult<>(0,"success");
        if(StringUtils.isEmpty(albumId)){
            result.setStauts(1);
            result.setMsg("albumId is empty");
            return Utils.toJson(result);
        }

        Page<Image> pageImage = imageService.getImagePageByAlbum(albumId,pageNo,pageSize);
        PageInfo<Image> imagePageInfo = new PageInfo<>(pageImage);

        result.setData(imagePageInfo);
        return Utils.toJson(result);
    }
}

