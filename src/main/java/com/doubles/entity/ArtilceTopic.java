package com.doubles.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class ArtilceTopic implements Serializable {
    private String atId;

    private String articleId;

    private String topicId;

    private Topic topic;
    @JSONField(serialize=false)
    private Article article;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getAtId() {
        return atId;
    }

    public void setAtId(String atId) {
        this.atId = atId == null ? null : atId.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }
}