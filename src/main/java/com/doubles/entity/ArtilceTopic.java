package com.doubles.entity;

public class ArtilceTopic {
    private String atId;

    private String articleId;

    private String topicId;

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