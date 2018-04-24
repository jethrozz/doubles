package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 转发表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Transmit implements Serializable {

    private static final long serialVersionUID = 1L;

    private String transmitId;
    /**
     * 转发这条动态的用户id
     */
    private String userId;
    /**
     * 0-动态
            1-图片
     */
    private Integer type;
    /**
     * type为0时表示动态id
            type为1时表示图片id
     */
    private String contentId;
    /**
     * 转发时发表的评论，可以为空
     */
    private String comment;
    /**
     * 这条转发的点赞数，初始值默认为0
     */
    private Integer likeNumber;
    /**
     * 这条记录的创建时间
     */
    private Date createTime;
    /**
     * 这条记录的更新时间
     */
    private Date updateTime;


    public String getTransmitId() {
        return transmitId;
    }

    public void setTransmitId(String transmitId) {
        this.transmitId = transmitId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
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
        return "Transmit{" +
        "transmitId=" + transmitId +
        ", userId=" + userId +
        ", type=" + type +
        ", contentId=" + contentId +
        ", comment=" + comment +
        ", likeNumber=" + likeNumber +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
