package com.doubles.controller;


import com.doubles.entity.*;
import com.doubles.model.CommonResult;
import com.doubles.model.PageInfo;
import com.doubles.model.SingletonArticleQueue;
import com.doubles.model.SingletonTopicQueue;
import com.doubles.service.*;
import com.doubles.util.Utils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private ArticlImgService articlImgService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private ArtilceTopicService artilceTopicService;
    @Autowired
    private CollectionsService collectionsService;
    @Autowired
    private UsersService userService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ImageService imageService;


    @RequestMapping("/submitArticle")
    @ResponseBody
    public String submitArticle(HttpServletRequest request, Article article,String image){
        CommonResult<String> result = new CommonResult<>(0,"success");
        if(StringUtils.isEmpty(image)){
            result.setStauts(1);
            result.setMsg("failed");
            return Utils.toJson(result);
        }

        //发表动态时要先去遍历该动态的type
        Users user = (Users)request.getSession().getAttribute("user");
        article.setUserId(user.getUserId());
        //直接插入表中，如有图片再进行后续处理
        articleService.addArticleNoImg(article);

        if(article.getIsHaveimg() == 1){
            //如果有图片，则先插入动态，再处理图片
            String imgUrl[] = image.split("\\|\\|");
            //先根据用户id 获取到动态相册
            Album album = albumService.getAlbumByuserIdAndName(user.getUserId());
            for(int i=0;i<imgUrl.length;i++){
                //然后遍历每个图片链接进行处理
                //将图片放入动态相册中
                Image img = new Image();
                img.setImgPath(imgUrl[i]);
                img.setAlbumId(album.getAlbumId());
                img.setImgDescribe("");
                imageService.addImage(img);
                //再将图片与该动态对应放入动态表中
                ArticlImg articlImg = new ArticlImg();
                articlImg.setArticleId(article.getArticleId());
                articlImg.setImgId(img.getImgId());
                articlImgService.addImage(articlImg);
            }
        }
        //再遍历该动态所参与的话题
        if(!StringUtils.isEmpty(article.getType())){
            String tag[] = article.getType().split("\\|\\|");
            for (String t:tag) {
                Topic topic = topicService.getOneById(t);
                ArtilceTopic artilceTopic = new ArtilceTopic();
                artilceTopic.setArticleId(article.getArticleId());
                artilceTopic.setTopicId(t);
                artilceTopicService.insertOne(artilceTopic);
                if(topic != null){
                    topic.setDiscussionNumber(topic.getDiscussionNumber()+1);
                    topicService.updateTopic(topic);
                    SingletonTopicQueue.getInstance().addUserIntoPushQueue(artilceTopic);
                }
            }
        }

        //将当前发表动态的用户放入阻塞队列中，在另一个线程中进行推送操作
        SingletonArticleQueue.getInstance().addUserIntoPushQueue(article);
        return Utils.toJson(result);
    }

    //根据文章id，点赞
    @RequestMapping("/addArtLike")
    @ResponseBody
    public String addLike(HttpServletRequest request,String articleId,Integer type){
        CommonResult<String> result = new CommonResult<>(0,"collect success");
        Users user = (Users)request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(articleId)){
            result.setStauts(1);
            result.setMsg("the articleId is empty");
            return Utils.toJson(result);
        }else{
            Article article = articleService.getOneArticle(articleId);
            if(article ==  null){
                result.setStauts(1);
                result.setMsg("not found the article by articleId");
                return Utils.toJson(result);
            }
            if (user == null){
                result.setStauts(1);
                result.setMsg("not found the user by userId");
                return Utils.toJson(result);
            }

            if(type == 0){
                //点赞
                Collections collection = new Collections();
                collection.setContentId(article.getArticleId());
                collection.setUserId(user.getUserId());

                article.setLikeNumber(article.getLikeNumber()+1);
                if(!(articleService.updateArticle(article) && collectionsService.addCollection(collection))){
                    result.setStauts(1);
                    result.setMsg("collect failed");
                }
                return Utils.toJson(result);
            }else{
                //取消点赞
                article.setLikeNumber(article.getLikeNumber()-1);
                if(!(articleService.updateArticle(article) && collectionsService.deleteCollection(user.getUserId(),article.getArticleId()))){
                    result.setStauts(1);
                    result.setMsg("uncollect failed");
                }
                return Utils.toJson(result);
            }
        }
    }


    //获取用户id该用户的所有动态，并跳转到用户个人主页
    @RequestMapping("/getMyArticle")
    public ModelAndView getMyArticle(HttpServletRequest request,String userId, @RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "20") int pageSize){
        ModelAndView modelAndView = new ModelAndView("/homepage");
        //Page<Article> articlePage = articleService.selectArticlePageByUid(pageNo,pageSize,userId);
        List<Article> articleList = articleService.selectArticleListByUid(userId);

        //PageInfo<Article> articlePageInfo = new PageInfo<>(articlePage);
        Users u = (Users)request.getSession().getAttribute("user");
        Users user = userService.getOne(userId);


        Relationship relationship = relationshipService.isFriend(u.getUserId(),userId);

        modelAndView.addObject("articleList",articleList);
        modelAndView.addObject("object",user);
        if(u.getUserId().equals(userId) && relationship == null){
            modelAndView.addObject("relationship",3);
        }else if(relationship == null){
            modelAndView.addObject("relationship",1);
        }else{
            modelAndView.addObject("relationship",(int)relationship.getIsFriend());
        }

        return modelAndView;
    }

    //获取单个动态详情
    @RequestMapping("/getArticle")
    public ModelAndView getArticle(String articleId){
        ModelAndView modelAndView = new ModelAndView("/hpdynamic");
        Article article = articleService.getOneArticle(articleId);
        List<Article> articleList = articleService.selectArticleListByUid(article.getUserId());

        List<Collections>  list = collectionsService.getListCollectionByArtcile(articleId);
        Article pre = null;
        Article next = null;
        int index = articleList.indexOf(article);
        if(index != -1){
            if(index == 0 && index != articleList.size()-1 ){
                next = articleList.get(index+1);
            }else if(index != 0 && index == articleList.size()-1){
                pre = articleList.get(index-1);
            }else if(index != articleList.size()-1 && index != 0){
                pre = articleList.get(index-1);
                next = articleList.get(index+1);
            }
        }

        modelAndView.addObject("article",article);
        modelAndView.addObject("collectionsList",list);
        modelAndView.addObject("pre",pre);
        modelAndView.addObject("next",next);
        return modelAndView;
    }

    //根据用户id查询用户的收藏，也就是喜欢
    @RequestMapping("/getCollectionList")
    @ResponseBody
    public String getCollectionList(HttpServletRequest request,String userId,@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "20") int pageSize){
        CommonResult<PageInfo<Collections>> result = new CommonResult<>(0,"success");
        if(StringUtils.isEmpty(userId)){
            result.setStauts(1);
            result.setMsg("userId is empty");
            return Utils.toJson(result);
        }
        Page<Collections> page = collectionsService.getPageCollection(userId,pageNo,pageSize);

        for(Collections collection : page){
            if(collection.getType() == 0){
                Article article = articleService.getOneArticle(collection.getContentId());
                collection.setArticle(article);
            }else if(collection.getType() == 1){
                Image image = imageService.getOneImg(collection.getContentId());
                collection.setImage(image);
            }
        }
        PageInfo<Collections> collectionsPageInfo = new PageInfo<>(page);

        result.setData(collectionsPageInfo);
        return Utils.toJson(result);
    }

    //根据动态id删除动态
    @RequestMapping("/deleteArticle")
    @ResponseBody
    public String deleteArticle(Article article){
        CommonResult<PageInfo<Collections>> result = new CommonResult<>(0,"success");
        if(StringUtils.isEmpty(article.getArticleId())){
            result.setStauts(1);
            result.setMsg("articleId is empty");
            return Utils.toJson(result);
        }
        articleService.deleteArticle(article);
        return Utils.toJson(result);
    }
    //获取用户id该用户的所有动态
    @RequestMapping("/getArticleList")
    @ResponseBody
    public String getArticleList(HttpServletRequest request,String userId,@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "20") int pageSize){
        CommonResult<PageInfo<Article>> result = new CommonResult<>(0,"success");
        //Users user = (Users)request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(userId)){
            result.setStauts(1);
            result.setMsg("userId is empty");
            return Utils.toJson(result);
        }
        Page<Article> articlePage = articleService.selectArticlePageByUid(pageNo,pageSize,userId);
        PageInfo<Article> articlePageInfo = new PageInfo<>(articlePage);
        result.setData(articlePageInfo);

        return Utils.toJson(result);
    }

    //    //获取单个动态
//    @RequestMapping("/getOneArticle")
//    @ResponseBody
//    public String getOneArticle(HttpServletRequest request,String articleId){
//        CommonResult<Article> result = new CommonResult<>(0,"success");
//        if(StringUtils.isEmpty(articleId)){
//            result.setStauts(1);
//            result.setMsg("articleId is empty");
//            return Utils.toJson(result);
//        }
//        Article article = articleService.getOneArticle(articleId);
//        result.setData(article);
//        return Utils.toJson(result);
//    }
}

