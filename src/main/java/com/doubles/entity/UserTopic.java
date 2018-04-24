package com.doubles.entity;

import java.io.Serializable;

/**
 * <p>
 * 用户参与话题关联表

表示关注了该话题的动态
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class UserTopic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String upId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 话题id
     */
    private String topicId;


    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "UserTopic{" +
        "upId=" + upId +
        ", userId=" + userId +
        ", topicId=" + topicId +
        "}";
    }
}
