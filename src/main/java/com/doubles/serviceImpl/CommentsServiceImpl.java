package com.doubles.serviceImpl;

import com.doubles.dao.CommentsDao;
import com.doubles.entity.Comments;
import com.doubles.service.CommentsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, Comments> implements CommentsService {

    @Override
    public Comments addComment(Comments comment) {
        insert(comment);
        return comment;
    }

    @Override
    public boolean deleteComment(String commentId) {
        return deleteById(commentId);
    }

    @Override
    public boolean updateComment(Comments comment) {
        return updateById(comment);
    }
}
