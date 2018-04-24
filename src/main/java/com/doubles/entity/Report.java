package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 举报表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    private String reportId;
    /**
     * 举报用户的id
     */
    private String userId;
    /**
     * 举报内容的类型，表示图片还是动态
            0-动态
            1-图片
            默认为0
            具体数据由前端判断之后发送到后台
     */
    private Integer type;
    /**
     * 被举报内容的id
            type为0，表示为动态id
            type为1，表示为图片id
     */
    private String contentId;
    /**
     * 举报内容
     */
    private String reportDescribe;
    /**
     * 该条记录的创建时间
     */
    private Date createTime;
    /**
     * 该条记录的更新时间
     */
    private Date updateTime;


    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getReportDescribe() {
        return reportDescribe;
    }

    public void setReportDescribe(String reportDescribe) {
        this.reportDescribe = reportDescribe;
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
        return "Report{" +
        "reportId=" + reportId +
        ", userId=" + userId +
        ", type=" + type +
        ", contentId=" + contentId +
        ", reportDescribe=" + reportDescribe +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
