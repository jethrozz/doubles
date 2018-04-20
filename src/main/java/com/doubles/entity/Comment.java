package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 
 * 
 */
public class Comment implements Serializable {
    private String comment_id;

    /**
    * 发出这条评论的用户id
    **/
    private String user_id;

    /**
    * 评论内容
    **/
    private String comment_content;

    /**
    * 被评论的类型
*             0-动态
*             1-图片
*             默认为0
*             具体数据由前端判断之后发送给后台
    **/
    private Integer object_type;

    /**
    * type为0时，表示为动态id
*             type为1时，表示为图片id
    **/
    private String object_id;

    /**
    * 创建这条记录时的id
    **/
    private Date create_time;

    /**
    * 更新这条记录时的id
    **/
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getComment_id() {
        return comment_id;
    }

    public Comment withComment_id(String comment_id) {
        this.setComment_id(comment_id);
        return this;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id == null ? null : comment_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public Comment withUser_id(String user_id) {
        this.setUser_id(user_id);
        return this;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getComment_content() {
        return comment_content;
    }

    public Comment withComment_content(String comment_content) {
        this.setComment_content(comment_content);
        return this;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content == null ? null : comment_content.trim();
    }

    public Integer getObject_type() {
        return object_type;
    }

    public Comment withObject_type(Integer object_type) {
        this.setObject_type(object_type);
        return this;
    }

    public void setObject_type(Integer object_type) {
        this.object_type = object_type;
    }

    public String getObject_id() {
        return object_id;
    }

    public Comment withObject_id(String object_id) {
        this.setObject_id(object_id);
        return this;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Comment withCreate_time(Date create_time) {
        this.setCreate_time(create_time);
        return this;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Comment withUpdate_time(Date update_time) {
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
        sb.append(", comment_id=").append(comment_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", comment_content=").append(comment_content);
        sb.append(", object_type=").append(object_type);
        sb.append(", object_id=").append(object_id);
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
        Comment other = (Comment) that;
        return (this.getComment_id() == null ? other.getComment_id() == null : this.getComment_id().equals(other.getComment_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getComment_content() == null ? other.getComment_content() == null : this.getComment_content().equals(other.getComment_content()))
            && (this.getObject_type() == null ? other.getObject_type() == null : this.getObject_type().equals(other.getObject_type()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getComment_id() == null) ? 0 : getComment_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getComment_content() == null) ? 0 : getComment_content().hashCode());
        result = prime * result + ((getObject_type() == null) ? 0 : getObject_type().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }
}