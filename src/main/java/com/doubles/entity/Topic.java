package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 话题表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    private String topicId;
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
    private Integer fanNumber;
    /**
     * 该话题下的动态数量，初始值为0
     */
    private Integer discussionNumber;
    /**
     * 该条记录的创建时间
     */
    private Date createTime;
    /**
     * 该条记录的更新时间
     */
    private Date updateTime;


    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
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

    public Integer getFanNumber() {
        return fanNumber;
    }

    public void setFanNumber(Integer fanNumber) {
        this.fanNumber = fanNumber;
    }

    public Integer getDiscussionNumber() {
        return discussionNumber;
    }

    public void setDiscussionNumber(Integer discussionNumber) {
        this.discussionNumber = discussionNumber;
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
        return "Topic{" +
        "topicId=" + topicId +
        ", title=" + title +
        ", descirbe=" + descirbe +
        ", fanNumber=" + fanNumber +
        ", discussionNumber=" + discussionNumber +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
