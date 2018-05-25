package com.doubles.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Topic {
    private String topicId;

    private String title;

    private String descirbe;

    private Integer fanNumber;

    private Integer discussionNumber;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescirbe() {
        return descirbe;
    }

    public void setDescirbe(String descirbe) {
        this.descirbe = descirbe == null ? null : descirbe.trim();
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
}