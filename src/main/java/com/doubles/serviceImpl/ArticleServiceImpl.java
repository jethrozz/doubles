package com.doubles.serviceImpl;

import com.doubles.dao.ArticleMapper;
import com.doubles.entity.Article;
import com.doubles.service.ArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleDao;

    @Override
    public Article addArticleNoImg(Article article) {
        articleDao.insertSelective(article);
        return article;
     }

    @Override
    public boolean deleteArticle(Article article) {
        if(articleDao.deleteByPrimaryKey(article.getArticleId()) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateArticle(Article article) {
        if(articleDao.updateByPrimaryKeySelective(article) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public Page<Article> selectArticlePageByUid(int pageNo, int pageSize, String user_id) {
        PageHelper.startPage(pageNo,pageSize);
        return articleDao.findPageByUid(user_id);
    }

    @Override
    public Page<Article> selectArticlePageByContent(int pageNo, int pageSize, String content) {
        PageHelper.startPage(pageNo,pageSize);
        return articleDao.findPageByContent(content);
    }

    @Override
    public Article getOneArticle(String artilce_id) {
        return articleDao.selectByPrimaryKey(artilce_id);
    }
}
