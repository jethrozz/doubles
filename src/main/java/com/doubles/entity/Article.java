package com.doubles.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article implements Serializable {
    private String articleId;

    private String userId;

    private Byte isHaveimg;

    private Integer likeNumber;

    private Integer collectNumber;

    private Integer transmitNumber;

    private Byte isReport;

    private Integer reportNumber;

    private String type;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

    private String content;

    private Users user;

    private List<ArticlImg> imgList;

    private List<Comments> commentsList;

    private List<ArtilceTopic> artilceTopics;

    public List<ArtilceTopic> getArtilceTopics() {
        return artilceTopics;
    }

    public void setArtilceTopics(List<ArtilceTopic> artilceTopics) {
        this.artilceTopics = artilceTopics;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }


    public List<ArticlImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<ArticlImg> imgList) {
        this.imgList = imgList;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Byte getIsHaveimg() {
        return isHaveimg;
    }

    public void setIsHaveimg(Byte isHaveimg) {
        this.isHaveimg = isHaveimg;
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

    public Integer getTransmitNumber() {
        return transmitNumber;
    }

    public void setTransmitNumber(Integer transmitNumber) {
        this.transmitNumber = transmitNumber;
    }

    public Byte getIsReport() {
        return isReport;
    }

    public void setIsReport(Byte isReport) {
        this.isReport = isReport;
    }

    public Integer getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Integer reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public boolean equals(Object obj) {
       return this.getArticleId().equals(((Article)obj).getArticleId());
    }
}