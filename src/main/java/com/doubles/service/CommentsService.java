package com.doubles.service;

import com.doubles.entity.Comments;
import com.github.pagehelper.Page;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface CommentsService{
    //发表评论或者回复
    boolean addComment(Comments comment);
    //删除评论或者回复
    boolean deleteComment(String commentId);
    //修改评论或者回复
    boolean updateComment(Comments comment);

    Page<Comments> getCommentsPage(String userId,int pageNo,int pageSize);
}
