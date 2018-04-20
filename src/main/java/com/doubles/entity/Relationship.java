package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 
 * 
 */
public class Relationship implements Serializable {
    private String relationship_id;

    /**
    * 外键，表示所属用户id
    **/
    private String user_id;

    /**
    * 外键，好友或者被拉黑的人的id
    **/
    private String friend_id;

    /**
    * 是否是好友，用数字表示 0-好友，1-拉黑
*             默认为0
    **/
    private Byte is_friend;

    /**
    * 这条记录的创建时间
    **/
    private Date create_time;

    /**
    * 这条记录的更新时间
    **/
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getRelationship_id() {
        return relationship_id;
    }

    public Relationship withRelationship_id(String relationship_id) {
        this.setRelationship_id(relationship_id);
        return this;
    }

    public void setRelationship_id(String relationship_id) {
        this.relationship_id = relationship_id == null ? null : relationship_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public Relationship withUser_id(String user_id) {
        this.setUser_id(user_id);
        return this;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getFriend_id() {
        return friend_id;
    }

    public Relationship withFriend_id(String friend_id) {
        this.setFriend_id(friend_id);
        return this;
    }

    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id == null ? null : friend_id.trim();
    }

    public Byte getIs_friend() {
        return is_friend;
    }

    public Relationship withIs_friend(Byte is_friend) {
        this.setIs_friend(is_friend);
        return this;
    }

    public void setIs_friend(Byte is_friend) {
        this.is_friend = is_friend;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Relationship withCreate_time(Date create_time) {
        this.setCreate_time(create_time);
        return this;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Relationship withUpdate_time(Date update_time) {
        this.setUpdate_time(update_time);
        return this;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", relationship_id=").append(relationship_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", friend_id=").append(friend_id);
        sb.append(", is_friend=").append(is_friend);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Relationship other = (Relationship) that;
        return (this.getRelationship_id() == null ? other.getRelationship_id() == null : this.getRelationship_id().equals(other.getRelationship_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getFriend_id() == null ? other.getFriend_id() == null : this.getFriend_id().equals(other.getFriend_id()))
            && (this.getIs_friend() == null ? other.getIs_friend() == null : this.getIs_friend().equals(other.getIs_friend()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelationship_id() == null) ? 0 : getRelationship_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getFriend_id() == null) ? 0 : getFriend_id().hashCode());
        result = prime * result + ((getIs_friend() == null) ? 0 : getIs_friend().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }
}