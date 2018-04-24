package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Collections implements Serializable {

    private static final long serialVersionUID = 1L;

    private String collectionId;
    /**
     * 收藏者id
     */
    private String userId;
    /**
     * 收藏内容的类型
            0-动态
            1-图片
            默认值为 0
            具体数据由前端判断之后发送到后台
     */
    private Integer type;
    /**
     * type为0时，表示动态id
            type为1时，表示图片id
     */
    private String contentId;
    /**
     * 该条记录的创建时间
     */
    private Date createTime;
    /**
     * 该条记录的更新时间
     */
    private Date updateTime;


    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
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
        return "Collections{" +
        "collectionId=" + collectionId +
        ", userId=" + userId +
        ", type=" + type +
        ", contentId=" + contentId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
