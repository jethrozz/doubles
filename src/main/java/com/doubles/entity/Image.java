package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 
 * 
 */
public class Image implements Serializable {
    private String img_id;

    /**
    * 所属相册id
    **/
    private String album_id;

    /**
    * 图片的存储路径，可以存放在七牛上，也可以自己保存其路径
    **/
    private String img_path;

    /**
    * 该图片的描述
    **/
    private String img_describe;

    /**
    * 图片的点赞数，默认为0
    **/
    private Integer like_number;

    /**
    * 图片的收藏数，默认为0
    **/
    private Integer collect_number;

    /**
    * 该条记录的创建时间
    **/
    private Date create_time;

    /**
    * 该条记录的更新时间
    **/
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getImg_id() {
        return img_id;
    }

    public Image withImg_id(String img_id) {
        this.setImg_id(img_id);
        return this;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id == null ? null : img_id.trim();
    }

    public String getAlbum_id() {
        return album_id;
    }

    public Image withAlbum_id(String album_id) {
        this.setAlbum_id(album_id);
        return this;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id == null ? null : album_id.trim();
    }

    public String getImg_path() {
        return img_path;
    }

    public Image withImg_path(String img_path) {
        this.setImg_path(img_path);
        return this;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path == null ? null : img_path.trim();
    }

    public String getImg_describe() {
        return img_describe;
    }

    public Image withImg_describe(String img_describe) {
        this.setImg_describe(img_describe);
        return this;
    }

    public void setImg_describe(String img_describe) {
        this.img_describe = img_describe == null ? null : img_describe.trim();
    }

    public Integer getLike_number() {
        return like_number;
    }

    public Image withLike_number(Integer like_number) {
        this.setLike_number(like_number);
        return this;
    }

    public void setLike_number(Integer like_number) {
        this.like_number = like_number;
    }

    public Integer getCollect_number() {
        return collect_number;
    }

    public Image withCollect_number(Integer collect_number) {
        this.setCollect_number(collect_number);
        return this;
    }

    public void setCollect_number(Integer collect_number) {
        this.collect_number = collect_number;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Image withCreate_time(Date create_time) {
        this.setCreate_time(create_time);
        return this;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Image withUpdate_time(Date update_time) {
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
        sb.append(", img_id=").append(img_id);
        sb.append(", album_id=").append(album_id);
        sb.append(", img_path=").append(img_path);
        sb.append(", img_describe=").append(img_describe);
        sb.append(", like_number=").append(like_number);
        sb.append(", collect_number=").append(collect_number);
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
        Image other = (Image) that;
        return (this.getImg_id() == null ? other.getImg_id() == null : this.getImg_id().equals(other.getImg_id()))
            && (this.getAlbum_id() == null ? other.getAlbum_id() == null : this.getAlbum_id().equals(other.getAlbum_id()))
            && (this.getImg_path() == null ? other.getImg_path() == null : this.getImg_path().equals(other.getImg_path()))
            && (this.getImg_describe() == null ? other.getImg_describe() == null : this.getImg_describe().equals(other.getImg_describe()))
            && (this.getLike_number() == null ? other.getLike_number() == null : this.getLike_number().equals(other.getLike_number()))
            && (this.getCollect_number() == null ? other.getCollect_number() == null : this.getCollect_number().equals(other.getCollect_number()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImg_id() == null) ? 0 : getImg_id().hashCode());
        result = prime * result + ((getAlbum_id() == null) ? 0 : getAlbum_id().hashCode());
        result = prime * result + ((getImg_path() == null) ? 0 : getImg_path().hashCode());
        result = prime * result + ((getImg_describe() == null) ? 0 : getImg_describe().hashCode());
        result = prime * result + ((getLike_number() == null) ? 0 : getLike_number().hashCode());
        result = prime * result + ((getCollect_number() == null) ? 0 : getCollect_number().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }
}