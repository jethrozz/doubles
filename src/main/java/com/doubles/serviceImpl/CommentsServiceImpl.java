package com.doubles.serviceImpl;

import com.doubles.dao.CommentsMapper;
import com.doubles.entity.Comments;
import com.doubles.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommentsMapper commentsDao;

    @Override
    public boolean addComment(Comments comment) {

        if( commentsDao.insertSelective(comment) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteComment(String commentId) {
        if(commentsDao.deleteByPrimaryKey(commentId) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateComment(Comments comment) {
        if(commentsDao.updateByPrimaryKeySelective(comment) >= 1){
            return true;
        }
        return false;
    }
}
