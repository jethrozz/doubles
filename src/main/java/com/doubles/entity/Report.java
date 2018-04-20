package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 
 * 
 */
public class Report implements Serializable {
    private String report_id;

    /**
    * 举报用户的id
    **/
    private String user_id;

    /**
    * 举报内容的类型，表示图片还是动态
*             0-动态
*             1-图片
*             默认为0
*             具体数据由前端判断之后发送到后台
    **/
    private Integer type;

    /**
    * 被举报内容的id
*             type为0，表示为动态id
*             type为1，表示为图片id
    **/
    private String content_id;

    /**
    * 举报内容
    **/
    private String report_describe;

    /**
    * 该条记录的创建时间
    **/
    private Date create_time;

    /**
    * 该条记录的更新时间
    **/
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getReport_id() {
        return report_id;
    }

    public Report withReport_id(String report_id) {
        this.setReport_id(report_id);
        return this;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id == null ? null : report_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public Report withUser_id(String user_id) {
        this.setUser_id(user_id);
        return this;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public Integer getType() {
        return type;
    }

    public Report withType(Integer type) {
        this.setType(type);
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent_id() {
        return content_id;
    }

    public Report withContent_id(String content_id) {
        this.setContent_id(content_id);
        return this;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id == null ? null : content_id.trim();
    }

    public String getReport_describe() {
        return report_describe;
    }

    public Report withReport_describe(String report_describe) {
        this.setReport_describe(report_describe);
        return this;
    }

    public void setReport_describe(String report_describe) {
        this.report_describe = report_describe == null ? null : report_describe.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Report withCreate_time(Date create_time) {
        this.setCreate_time(create_time);
        return this;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Report withUpdate_time(Date update_time) {
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
        sb.append(", report_id=").append(report_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", type=").append(type);
        sb.append(", content_id=").append(content_id);
        sb.append(", report_describe=").append(report_describe);
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
        Report other = (Report) that;
        return (this.getReport_id() == null ? other.getReport_id() == null : this.getReport_id().equals(other.getReport_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent_id() == null ? other.getContent_id() == null : this.getContent_id().equals(other.getContent_id()))
            && (this.getReport_describe() == null ? other.getReport_describe() == null : this.getReport_describe().equals(other.getReport_describe()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReport_id() == null) ? 0 : getReport_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent_id() == null) ? 0 : getContent_id().hashCode());
        result = prime * result + ((getReport_describe() == null) ? 0 : getReport_describe().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }
}