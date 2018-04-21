package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * collection
 * @author 
 */
public class Collection implements Serializable {
    private String collection_id;

    /**
     * 收藏者id
     */
    private String user_id;

    /**
     * 收藏内容的类型
            0-动态
            1-图片
            默认值为 0
            具体数据由前端判断之后发送到后台
     */
    private Integer type;

    /**
     * type为0时，表示动态id
            type为1时，表示图片id
     */
    private String content_id;

    /**
     * 该条记录的创建时间
     */
    private Date create_time;

    /**
     * 该条记录的更新时间
     */
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(String collection_id) {
        this.collection_id = collection_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
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
        Collection other = (Collection) that;
        return (this.getCollection_id() == null ? other.getCollection_id() == null : this.getCollection_id().equals(other.getCollection_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent_id() == null ? other.getContent_id() == null : this.getContent_id().equals(other.getContent_id()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCollection_id() == null) ? 0 : getCollection_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent_id() == null) ? 0 : getContent_id().hashCode());
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
        sb.append(", collection_id=").append(collection_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", type=").append(type);
        sb.append(", content_id=").append(content_id);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}