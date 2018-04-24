package com.doubles.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户动态表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private String articleId;
    /**
     * 表示这条动态所属用户的id
     */
    private String userId;
    /**
     * 动态内容的文字部分
     */
    private String content;
    /**
     * 是否带图，0-带图，1-不带
            默认为0
     */
    @TableField("is_haveImg")
    private Integer isHaveimg;
    /**
     * 点赞数量，初始值为0
     */
    private Integer likeNumber;
    /**
     * 收藏数量，初始值为0，
     */
    private Integer collectNumber;
    /**
     * 转发数量，初始值 默认为0
     */
    private Integer transmitNumber;
    /**
     * 是否被举报
            0-被举报
            1-没有被举报
            默认为1
     */
    private Integer isReport;
    /**
     * 被举报的数量，初始值默认为0
     */
    private Integer reportNumber;
    /**
     * 动态话题分类，表示该条动态参与的话题标签，以字符串形式保存在数据库中，中间以  _  做分隔符
            如：人像_黑白_摄影
     */
    private String type;
    /**
     * 这条动态的创建时间
     */
    private Date createTime;
    /**
     * 这条记录的修改时间
     */
    private Date updateTime;


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsHaveimg() {
        return isHaveimg;
    }

    public void setIsHaveimg(Integer isHaveimg) {
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

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
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
        this.type = type;
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
        return "Article{" +
        "articleId=" + articleId +
        ", userId=" + userId +
        ", content=" + content +
        ", isHaveimg=" + isHaveimg +
        ", likeNumber=" + likeNumber +
        ", collectNumber=" + collectNumber +
        ", transmitNumber=" + transmitNumber +
        ", isReport=" + isReport +
        ", reportNumber=" + reportNumber +
        ", type=" + type +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
