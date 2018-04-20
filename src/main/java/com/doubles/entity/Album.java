package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 
 * 
 */
public class Album implements Serializable {
    private String album_id;

    /**
    * 所属用户id
    **/
    private String user_id;

    /**
    * 相册名称
    **/
    private String album_name;

    /**
    * 相册描述
    **/
    private String album_describe;

    /**
    * 相册创建时间
    **/
    private Date create_time;

    /**
    * 该条记录的更新时间
    **/
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getAlbum_id() {
        return album_id;
    }

    public Album withAlbum_id(String album_id) {
        this.setAlbum_id(album_id);
        return this;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id == null ? null : album_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public Album withUser_id(String user_id) {
        this.setUser_id(user_id);
        return this;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getAlbum_name() {
        return album_name;
    }

    public Album withAlbum_name(String album_name) {
        this.setAlbum_name(album_name);
        return this;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name == null ? null : album_name.trim();
    }

    public String getAlbum_describe() {
        return album_describe;
    }

    public Album withAlbum_describe(String album_describe) {
        this.setAlbum_describe(album_describe);
        return this;
    }

    public void setAlbum_describe(String album_describe) {
        this.album_describe = album_describe == null ? null : album_describe.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Album withCreate_time(Date create_time) {
        this.setCreate_time(create_time);
        return this;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Album withUpdate_time(Date update_time) {
        this.setUpdate_time(update_time);
        return this;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", album_id=").append(album_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", album_name=").append(album_name);
        sb.append(", album_describe=").append(album_describe);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append("]");
        return sb.toString();
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
        Album other = (Album) that;
        return (this.getAlbum_id() == null ? other.getAlbum_id() == null : this.getAlbum_id().equals(other.getAlbum_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getAlbum_name() == null ? other.getAlbum_name() == null : this.getAlbum_name().equals(other.getAlbum_name()))
            && (this.getAlbum_describe() == null ? other.getAlbum_describe() == null : this.getAlbum_describe().equals(other.getAlbum_describe()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAlbum_id() == null) ? 0 : getAlbum_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getAlbum_name() == null) ? 0 : getAlbum_name().hashCode());
        result = prime * result + ((getAlbum_describe() == null) ? 0 : getAlbum_describe().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }
}