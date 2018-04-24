package com.doubles.entity;

import java.io.Serializable;

/**
 * <p>
 * 动态话题表,表示参与了该话题的动态
当用户 发表带有话题的动态时，即向该表中插入一条数据
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class ArtilceTopic implements Serializable {

    private static final long serialVersionUID = 1L;

    private String atId;
    /**
     * 动态id
     */
    private String articleId;
    /**
     * 该条动态参与的话题id
     */
    private String topicId;


    public String getAtId() {
        return atId;
    }

    public void setAtId(String atId) {
        this.atId = atId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "ArtilceTopic{" +
        "atId=" + atId +
        ", articleId=" + articleId +
        ", topicId=" + topicId +
        "}";
    }
}
