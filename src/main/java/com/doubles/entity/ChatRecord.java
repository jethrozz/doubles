package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 聊天记录表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class ChatRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String crId;
    /**
     * 这条消息 的发送者id
     */
    private String userId;
    /**
     * 这条消息的接收者id
     */
    private String toUser;
    /**
     * 这条消息的消息内容
     */
    private String content;
    /**
     * 这条记录的创建时间
     */
    private Date createTime;
    /**
     * 这条消息的更新时间
     */
    private Date updateTime;


    public String getCrId() {
        return crId;
    }

    public void setCrId(String crId) {
        this.crId = crId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "ChatRecord{" +
        "crId=" + crId +
        ", userId=" + userId +
        ", toUser=" + toUser +
        ", content=" + content +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
