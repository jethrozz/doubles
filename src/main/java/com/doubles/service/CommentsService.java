package com.doubles.service;

import com.doubles.entity.Comments;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface CommentsService extends IService<Comments> {
    //发表评论或者回复
    Comments addComment(Comments comment);
    //删除评论或者回复
    boolean deleteComment(String commentId);
    //修改评论或者回复
    boolean updateComment(Comments comment);
}