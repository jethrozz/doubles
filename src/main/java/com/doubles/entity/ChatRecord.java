package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * chat_record
 * @author 
 */
public class ChatRecord implements Serializable {
    private String cr_id;

    /**
     * 这条消息 的发送者id
     */
    private String user_id;

    /**
     * 这条消息的接收者id
     */
    private String to_user;

    /**
     * 这条消息的消息内容
     */
    private String content;

    /**
     * 这条记录的创建时间
     */
    private Date create_time;

    /**
     * 这条消息的更新时间
     */
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getCr_id() {
        return cr_id;
    }

    public void setCr_id(String cr_id) {
        this.cr_id = cr_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTo_user() {
        return to_user;
    }

    public void setTo_user(String to_user) {
        this.to_user = to_user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        ChatRecord other = (ChatRecord) that;
        return (this.getCr_id() == null ? other.getCr_id() == null : this.getCr_id().equals(other.getCr_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getTo_user() == null ? other.getTo_user() == null : this.getTo_user().equals(other.getTo_user()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCr_id() == null) ? 0 : getCr_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getTo_user() == null) ? 0 : getTo_user().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
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
        sb.append(", cr_id=").append(cr_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", to_user=").append(to_user);
        sb.append(", content=").append(content);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}