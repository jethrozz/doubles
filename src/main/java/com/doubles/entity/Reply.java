package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 
 * 
 */
public class Reply implements Serializable {
    private String reply_id;

    /**
    * 发出这条回复的用户id
    **/
    private String user_id;

    /**
    * 对应的评论id
*             表明这条回复是哪个评论下的
    **/
    private String comment_id;

    /**
    * 回复内容
    **/
    private String reply_content;

    /**
    * 接收这条回复的用户id
    **/
    private String to_user;

    /**
    * 创建这条记录的时间
    **/
    private Date create_time;

    /**
    * 更新这条记录的时间
    **/
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getReply_id() {
        return reply_id;
    }

    public Reply withReply_id(String reply_id) {
        this.setReply_id(reply_id);
        return this;
    }

    public void setReply_id(String reply_id) {
        this.reply_id = reply_id == null ? null : reply_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public Reply withUser_id(String user_id) {
        this.setUser_id(user_id);
        return this;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getComment_id() {
        return comment_id;
    }

    public Reply withComment_id(String comment_id) {
        this.setComment_id(comment_id);
        return this;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id == null ? null : comment_id.trim();
    }

    public String getReply_content() {
        return reply_content;
    }

    public Reply withReply_content(String reply_content) {
        this.setReply_content(reply_content);
        return this;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content == null ? null : reply_content.trim();
    }

    public String getTo_user() {
        return to_user;
    }

    public Reply withTo_user(String to_user) {
        this.setTo_user(to_user);
        return this;
    }

    public void setTo_user(String to_user) {
        this.to_user = to_user == null ? null : to_user.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Reply withCreate_time(Date create_time) {
        this.setCreate_time(create_time);
        return this;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Reply withUpdate_time(Date update_time) {
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
        sb.append(", reply_id=").append(reply_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", comment_id=").append(comment_id);
        sb.append(", reply_content=").append(reply_content);
        sb.append(", to_user=").append(to_user);
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
        Reply other = (Reply) that;
        return (this.getReply_id() == null ? other.getReply_id() == null : this.getReply_id().equals(other.getReply_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getComment_id() == null ? other.getComment_id() == null : this.getComment_id().equals(other.getComment_id()))
            && (this.getReply_content() == null ? other.getReply_content() == null : this.getReply_content().equals(other.getReply_content()))
            && (this.getTo_user() == null ? other.getTo_user() == null : this.getTo_user().equals(other.getTo_user()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReply_id() == null) ? 0 : getReply_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getComment_id() == null) ? 0 : getComment_id().hashCode());
        result = prime * result + ((getReply_content() == null) ? 0 : getReply_content().hashCode());
        result = prime * result + ((getTo_user() == null) ? 0 : getTo_user().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }
}