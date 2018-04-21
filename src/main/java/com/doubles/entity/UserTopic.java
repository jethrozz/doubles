package com.doubles.entity;

import java.io.Serializable;

/**
 * user_topic
 * @author 
 */
public class UserTopic implements Serializable {
    /**
     * 主键
     */
    private String up_id;

    /**
     * 用户id
     */
    private String user_id;

    /**
     * 话题id
     */
    private String topic_id;

    private static final long serialVersionUID = 1L;

    public String getUp_id() {
        return up_id;
    }

    public void setUp_id(String up_id) {
        this.up_id = up_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
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
        UserTopic other = (UserTopic) that;
        return (this.getUp_id() == null ? other.getUp_id() == null : this.getUp_id().equals(other.getUp_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getTopic_id() == null ? other.getTopic_id() == null : this.getTopic_id().equals(other.getTopic_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUp_id() == null) ? 0 : getUp_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getTopic_id() == null) ? 0 : getTopic_id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", up_id=").append(up_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", topic_id=").append(topic_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}