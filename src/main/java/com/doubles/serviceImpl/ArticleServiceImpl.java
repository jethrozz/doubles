package com.doubles.serviceImpl;

import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @时间: 2018/4/23
 * @描述：
 */
@Service("article")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleDao;
    @Autowired
    CommentMapper commentDao;
    @Autowired
    CollectionMapper collectionDao;
    @Autowired
    ImageMapper imageDao;

    @Override
    public Article addArticleNoImg(Article article) {
        articleDao.insertSelective(article);
        return article;
    }

    @Override
    public boolean deleteArticle(Article article) {
        if(articleDao.deleteByPrimaryKey(article.getArticle_id()) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateArticle(Article article) {
        if(articleDao.updateByPrimaryKeySelective(article) == 1){
            return true;
        }
        return false;
    }

    @Override
    public Comment addComment(Comment comment) {
        commentDao.insertSelective(comment);
        return comment;
    }

    @Override
    public boolean deleteComment(String commentId) {
        if(commentDao.deleteByPrimaryKey(commentId) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateComment(Comment comment) {
        if(commentDao.updateByPrimaryKeySelective(comment) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateArticleLikeNumber(Article article) {
        return false;
    }

    @Override
    public Collection addCollection(Collection collection) {
        collectionDao.insertSelective(collection);
        if(collection.getType() == 0){
            //如果是动态，则动态的收藏数+1
            Article article = articleDao.selectByPrimaryKey(collection.getContent_id());
            article.setCollect_number(article.getCollect_number()+1);
            articleDao.updateByPrimaryKeySelective(article);
        }else if(collection.getType() == 1){
            //则图片的收藏数加1
            Image image = imageDao.selectByPrimaryKey(collection.getContent_id());
            image.setCollect_number(image.getCollect_number()+1);
            imageDao.updateByPrimaryKeySelective(image);
        }
        return collection ;
    }

    @Override
    public boolean deleteCollection(String collectionId) {
        if(collectionDao.deleteByPrimaryKey(collectionId) == 1){
            return true;
        }
        return false;
    }


    @Override
    public Page<Article> selectArticleListByUid(Page<Article> page, String user_id) {
        return page.setRecords(articleDao.selectArticleListByUid(page,user_id));
    }

    @Override
    public Page<Article> selectArticleListByContent(Page<Article> page, String content) {
        return page.setRecords(articleDao.selectArticleListByContent(page,content));
    }

    @Override
    public Article getOneArticle(String artilce_id) {
        return articleDao.selectByPrimaryKey(artilce_id);
    }
}
