package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    private String commentId;
    /**
     * 发出这条评论的用户id
     */
    private String userId;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 被评论的类型
            0-动态
            1-图片
            默认为0
            具体数据由前端判断之后发送给后台
     */
    private Integer objectType;
    /**
     * type为0时，表示为动态id
            type为1时，表示为图片id
     */
    private String objectId;
    /**
     * 这条评论的发送对象
     */
    private String toUser;
    /**
     * 标识回复类型，方便查询操作
            评论则为0
            回复为1
            默认为0
     */
    private Integer type;
    /**
     * 创建这条记录时的id
     */
    private Date createTime;
    /**
     * 更新这条记录时的id
     */
    private Date updateTime;


    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getObjectType() {
        return objectType;
    }

    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Comments{" +
        "commentId=" + commentId +
        ", userId=" + userId +
        ", commentContent=" + commentContent +
        ", objectType=" + objectType +
        ", objectId=" + objectId +
        ", toUser=" + toUser +
        ", type=" + type +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
