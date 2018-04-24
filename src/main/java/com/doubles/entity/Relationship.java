package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 好友关系表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Relationship implements Serializable {

    private static final long serialVersionUID = 1L;

    private String relationshipId;
    /**
     * 外键，表示所属用户id
     */
    private String userId;
    /**
     * 外键，好友或者被拉黑的人的id
     */
    private String friendId;
    /**
     * 是否是好友，用数字表示 0-好友，1-拉黑，2-相互关注
            默认为0
     */
    private Integer isFriend;
    /**
     * 这条记录的创建时间
     */
    private Date createTime;
    /**
     * 这条记录的更新时间
     */
    private Date updateTime;


    public String getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(String relationshipId) {
        this.relationshipId = relationshipId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public Integer getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend) {
        this.isFriend = isFriend;
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
        return "Relationship{" +
        "relationshipId=" + relationshipId +
        ", userId=" + userId +
        ", friendId=" + friendId +
        ", isFriend=" + isFriend +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
