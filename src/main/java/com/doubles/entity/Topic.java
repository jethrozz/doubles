package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * topic
 * @author 
 */
public class Topic implements Serializable {
    private String topic_id;

    /**
     * 话题标题
     */
    private String title;

    /**
     * 话题的相关描述，数据库中可以为空
     */
    private String descirbe;

    /**
     * 该话题的被关注数量，初始值为0
     */
    private Integer fan_number;

    /**
     * 该话题下的动态数量，初始值为0
     */
    private Integer discussion_number;

    /**
     * 该条记录的创建时间
     */
    private Date create_time;

    /**
     * 该条记录的更新时间
     */
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescirbe() {
        return descirbe;
    }

    public void setDescirbe(String descirbe) {
        this.descirbe = descirbe;
    }

    public Integer getFan_number() {
        return fan_number;
    }

    public void setFan_number(Integer fan_number) {
        this.fan_number = fan_number;
    }

    public Integer getDiscussion_number() {
        return discussion_number;
    }

    public void setDiscussion_number(Integer discussion_number) {
        this.discussion_number = discussion_number;
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
        Topic other = (Topic) that;
        return (this.getTopic_id() == null ? other.getTopic_id() == null : this.getTopic_id().equals(other.getTopic_id()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescirbe() == null ? other.getDescirbe() == null : this.getDescirbe().equals(other.getDescirbe()))
            && (this.getFan_number() == null ? other.getFan_number() == null : this.getFan_number().equals(other.getFan_number()))
            && (this.getDiscussion_number() == null ? other.getDiscussion_number() == null : this.getDiscussion_number().equals(other.getDiscussion_number()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTopic_id() == null) ? 0 : getTopic_id().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescirbe() == null) ? 0 : getDescirbe().hashCode());
        result = prime * result + ((getFan_number() == null) ? 0 : getFan_number().hashCode());
        result = prime * result + ((getDiscussion_number() == null) ? 0 : getDiscussion_number().hashCode());
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
        sb.append(", topic_id=").append(topic_id);
        sb.append(", title=").append(title);
        sb.append(", descirbe=").append(descirbe);
        sb.append(", fan_number=").append(fan_number);
        sb.append(", discussion_number=").append(discussion_number);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}