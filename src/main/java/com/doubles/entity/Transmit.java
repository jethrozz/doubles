package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * transmit
 * @author 
 */
public class Transmit implements Serializable {
    private String transmit_id;

    /**
     * 转发这条动态的用户id
     */
    private String user_id;

    /**
     * 0-动态
            1-图片
     */
    private Integer type;

    /**
     * type为0时表示动态id
            type为1时表示图片id
     */
    private String content_id;

    /**
     * 转发时发表的评论，可以为空
     */
    private String comment;

    /**
     * 这条转发的点赞数，初始值默认为0
     */
    private Integer like_number;

    /**
     * 这条记录的创建时间
     */
    private Date create_time;

    /**
     * 这条记录的更新时间
     */
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getTransmit_id() {
        return transmit_id;
    }

    public void setTransmit_id(String transmit_id) {
        this.transmit_id = transmit_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLike_number() {
        return like_number;
    }

    public void setLike_number(Integer like_number) {
        this.like_number = like_number;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
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
        Transmit other = (Transmit) that;
        return (this.getTransmit_id() == null ? other.getTransmit_id() == null : this.getTransmit_id().equals(other.getTransmit_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent_id() == null ? other.getContent_id() == null : this.getContent_id().equals(other.getContent_id()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getLike_number() == null ? other.getLike_number() == null : this.getLike_number().equals(other.getLike_number()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTransmit_id() == null) ? 0 : getTransmit_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent_id() == null) ? 0 : getContent_id().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getLike_number() == null) ? 0 : getLike_number().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", transmit_id=").append(transmit_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", type=").append(type);
        sb.append(", content_id=").append(content_id);
        sb.append(", comment=").append(comment);
        sb.append(", like_number=").append(like_number);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}