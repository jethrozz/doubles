package com.doubles.service;

import com.doubles.entity.Article;
import com.github.pagehelper.Page;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户动态表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface ArticleService{
    //发表没有带图片的动态
    Article addArticleNoImg(Article article);
    //删除动态
    boolean deleteArticle(Article article);
    //更新动态
    boolean updateArticle(Article article);
    List<Article> selectArticleListByUid(String user_id);
    //分页查询，该用户的所有动态
    Page<Article> selectArticlePageByUid(int pageNo, int pageSize, String user_id);

   // Page<Article> selectArticleListByUid(Page<Article> page, String user_id);
    //模糊搜索不同用户的动态
    Page<Article> selectArticlePageByContent(int pageNo, int pageSize, String content);
    //获取单个动态
    Article getOneArticle(String artilce_id);
    List<Date> getTimeGroup(String userId);
    List<Article> getArticleByTime(String date,String userId);
}
