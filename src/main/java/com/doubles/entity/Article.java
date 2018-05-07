package com.doubles.entity;

import java.util.Date;
import java.util.List;

public class Article {
    private String articleId;

    private String userId;

    private Byte isHaveimg;

    private Integer likeNumber;

    private Integer collectNumber;

    private Integer transmitNumber;

    private Byte isReport;

    private Integer reportNumber;

    private String type;

    private Date createTime;

    private Date updateTime;

    private String content;


    List<Image> imgList;

    public List<Image> getImgList() {
        return imgList;
    }

    public void setImgList(List<Image> imgList) {
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
}