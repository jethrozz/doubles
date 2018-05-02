package com.doubles.serviceImpl;

import com.doubles.dao.ArticleMapper;
import com.doubles.entity.Article;
import com.doubles.service.ArticleService;
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


//    @Override
//    public Page<Article> selectArticleListByUid(Page<Article> page, String user_id) {
//        page.
//        EntityWrapper<Article> ew = new EntityWrapper<>();
//        ew.where("user_id = {0}",user_id);
//        ew.orderBy("create_time",false);
//        return selectPage(page,ew);
//    }
//
//    @Override
//    public Page<Article> selectArticleListByContent(Page<Article> page, String content) {
//        EntityWrapper<Article> ew = new EntityWrapper<>();
//        ew.like("content",content);
//        ew.orderBy("create_time",true);
//        return selectPage(page,ew);
//    }

    @Override
    public Article getOneArticle(String artilce_id) {
        return articleDao.selectByPrimaryKey(artilce_id);
    }
}
