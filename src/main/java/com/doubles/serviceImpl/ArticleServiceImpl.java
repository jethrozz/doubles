package com.doubles.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.dao.ArticleDao;
import com.doubles.entity.Article;
import com.doubles.service.ArticleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户动态表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Override
    public Article addArticleNoImg(Article article) {
        insert(article);
        return article;
    }

    @Override
    public boolean deleteArticle(Article article) {
        return deleteById(article.getArticleId());
    }

    @Override
    public boolean updateArticle(Article article) {
        return updateById(article);
    }

    @Override
    public boolean updateArticleLikeNumber(Article article) {
        return updateById(article);
    }

    @Override
    public Page<Article> selectArticleListByUid(Page<Article> page, String user_id) {
        EntityWrapper<Article> ew = new EntityWrapper<>();
        ew.where("user_id = {0}",user_id);
        ew.orderBy("create_time",false);
        return selectPage(page,ew);
    }

    @Override
    public Page<Article> selectArticleListByContent(Page<Article> page, String content) {
        EntityWrapper<Article> ew = new EntityWrapper<>();
        ew.like("content",content);
        ew.orderBy("create_time",true);
        return selectPage(page,ew);
    }

    @Override
    public Article getOneArticle(String artilce_id) {
        return selectById(artilce_id);
    }
}
