package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 相册
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    private String albumId;
    /**
     * 所属用户id
     */
    private String userId;
    /**
     * 相册名称
     */
    private String albumName;
    /**
     * 相册描述
     */
    private String albumDescribe;
    /**
     * 相册创建时间
     */
    private Date createTime;
    /**
     * 该条记录的更新时间
     */
    private Date updateTime;


    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDescribe() {
        return albumDescribe;
    }

    public void setAlbumDescribe(String albumDescribe) {
        this.albumDescribe = albumDescribe;
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
        return "Album{" +
        "albumId=" + albumId +
        ", userId=" + userId +
        ", albumName=" + albumName +
        ", albumDescribe=" + albumDescribe +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
