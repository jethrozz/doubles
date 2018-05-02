package com.doubles.service;

import com.doubles.entity.Article;

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


    //分页查询，该用户的所有动态
   // Page<Article> selectArticleListByUid(Page<Article> page, String user_id);
    //模糊搜索不同用户的动态
  //  Page<Article> selectArticleListByContent(Page<Article> page,String content);
    //获取单个动态
    Article getOneArticle(String artilce_id);
}
