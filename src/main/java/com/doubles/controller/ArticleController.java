package com.doubles.controller;


import com.doubles.entity.*;
import com.doubles.model.CommonResult;
import com.doubles.model.SingletonArticleQueue;
import com.doubles.service.*;
import com.doubles.util.SecretUtils;
import com.doubles.util.Utils;
import net.sf.jsqlparser.statement.select.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
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

    @RequestMapping("/indexArticle")
    @ResponseBody
    public String indexArticle(HttpSession session){
        CommonResult<List<Article>> cr = new CommonResult<List<Article>>(0,"success");
        //用户首页动态显示
        //先获取该用户，查找其关注的用户的动态
        Users user = (Users)session.getAttribute("user");
        List<Relationship> list1 = relationshipService.findFriends(user.getUserId(),0,0);
        List<Relationship> list2 = relationshipService.findFriends(user.getUserId(),2,0);
        List<Article> articleList = new ArrayList<>();
       //将我关注的用户以及相互关注的用户的最新动态获取出来，最多取20条
        for (Relationship re : list1) {
            if (articleList.size() >= 20){
                break;
            }
            articleList.addAll((List<Article>)articleService.selectArticlePageByUid(1,3,re.getFriendId()));
        }
        for (Relationship re : list2) {
            if (articleList.size() >= 20){
                break;
            }
            articleList.addAll((List<Article>)articleService.selectArticlePageByUid(1,3,re.getFriendId()));
        }
        //取出来之后再按时间排一次序
        articleList.sort((a1, a2) -> {
            return a1.getCreateTime().compareTo(a2.getCreateTime());
        });
        //遍历所有动态将
        isHaveImg(articleList);

        cr.setData(articleList);

        return Utils.toJson(cr);
    }

    @RequestMapping("/submitArticle")
    public void submitArticle(HttpServletRequest request, Article article){
        //发表动态时要先去遍历该动态的type
        article.setArticleId(SecretUtils.uuid32());
        articleService.addArticleNoImg(article);
        String userId = article.getUserId();

        if(!StringUtils.isEmpty(article.getType())){
            String tag[] = article.getType().split("_");
            for (String t:tag) {
                Topic topic = topicService.getOneByTitle(t);
                if(topic != null){
                    ArtilceTopic artilceTopic = new ArtilceTopic();
                    artilceTopic.setAtId(SecretUtils.uuid32());
                    artilceTopic.setArticleId(article.getArticleId());
                    artilceTopic.setTopicId(topic.getTopicId());
                    artilceTopicService.insertOne(artilceTopic);
                }
            }
        }

        //将当前发表动态的用户放入阻塞队列中，在另一个线程中进行推送操作
        SingletonArticleQueue.getInstance().addUserIntoPushQueue(userId);
    }

    @RequestMapping("/addArtLike")
    public void addLike(HttpServletRequest request,String articleId){
        Article article = articleService.getOneArticle(articleId);
        if(article !=  null){
            article.setLikeNumber(article.getLikeNumber()+1);
            articleService.updateArticle(article);
        }
    }

    //为带图的动态加上图片
    private void isHaveImg(List<Article> list){
        for (Article article : list) {
            if (article.getIsHaveimg() == 0){
                article.setImgList(articlImgService.findImgByArticleId(article.getArticleId()));
            }
        }
    }

}

