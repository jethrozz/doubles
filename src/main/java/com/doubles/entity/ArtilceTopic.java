package com.doubles.entity;

import java.io.Serializable;

/**
 * artilce_topic
 * @author 
 */
public class ArtilceTopic implements Serializable {
    private String at_id;

    /**
     * 动态id
     */
    private String article_id;

    /**
     * 该条动态参与的话题id
     */
    private String topic_id;

    private static final long serialVersionUID = 1L;

    public String getAt_id() {
        return at_id;
    }

    public void setAt_id(String at_id) {
        this.at_id = at_id;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
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
        ArtilceTopic other = (ArtilceTopic) that;
        return (this.getAt_id() == null ? other.getAt_id() == null : this.getAt_id().equals(other.getAt_id()))
            && (this.getArticle_id() == null ? other.getArticle_id() == null : this.getArticle_id().equals(other.getArticle_id()))
            && (this.getTopic_id() == null ? other.getTopic_id() == null : this.getTopic_id().equals(other.getTopic_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAt_id() == null) ? 0 : getAt_id().hashCode());
        result = prime * result + ((getArticle_id() == null) ? 0 : getArticle_id().hashCode());
        result = prime * result + ((getTopic_id() == null) ? 0 : getTopic_id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", at_id=").append(at_id);
        sb.append(", article_id=").append(article_id);
        sb.append(", topic_id=").append(topic_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}