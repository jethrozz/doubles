package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 图片表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    private String imgId;
    /**
     * 所属相册id
     */
    private String albumId;
    /**
     * 图片的存储路径，可以存放在七牛上，也可以自己保存其路径
     */
    private String imgPath;
    /**
     * 该图片的描述
     */
    private String imgDescribe;
    /**
     * 图片的点赞数，默认为0
     */
    private Integer likeNumber;
    /**
     * 图片的收藏数，默认为0
     */
    private Integer collectNumber;
    /**
     * 该条记录的创建时间
     */
    private Date createTime;
    /**
     * 该条记录的更新时间
     */
    private Date updateTime;


    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgDescribe() {
        return imgDescribe;
    }

    public void setImgDescribe(String imgDescribe) {
        this.imgDescribe = imgDescribe;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Integer getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
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
        return "Image{" +
        "imgId=" + imgId +
        ", albumId=" + albumId +
        ", imgPath=" + imgPath +
        ", imgDescribe=" + imgDescribe +
        ", likeNumber=" + likeNumber +
        ", collectNumber=" + collectNumber +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
