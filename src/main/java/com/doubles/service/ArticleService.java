package com.doubles.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.entity.*;


/**
 * @时间: 2018/4/23
 * @描述：用户对动态的各种操作
 */
public interface ArticleService {
    //发表没有带图片的动态
    Article addArticleNoImg(Article article);
    //删除动态
    boolean deleteArticle(Article article);
    //更新动态
    boolean updateArticle(Article article);
    //发表评论或者回复
    Comment addComment(Comment comment);
    //删除评论或者回复
    boolean deleteComment(String commentId);
    //修改评论或者回复
    boolean updateComment(Comment comment);
    //点赞
    boolean updateArticleLikeNumber(Article article);
    //收藏
    Collection addCollection(Collection collection);
    //删除收藏记录
    boolean deleteCollection(String collectionId);
    //分页查询，该用户的所有动态
    Page<Article> selectArticleListByUid(Page<Article> page,String user_id);
    //模糊搜索不同用户的动态
    Page<Article> selectArticleListByContent(Page<Article> page,String content);
    //获取单个动态
    Article getOneArticle(String artilce_id);
}
