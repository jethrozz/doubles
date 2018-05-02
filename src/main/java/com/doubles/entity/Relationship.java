package com.doubles.entity;

import java.util.Date;

public class Relationship {
    private String relationshipId;

    private String userId;

    private String friendId;

    private Byte isFriend;

    private Date createTime;

    private Date updateTime;

    public String getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(String relationshipId) {
        this.relationshipId = relationshipId == null ? null : relationshipId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    public Byte getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Byte isFriend) {
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
}