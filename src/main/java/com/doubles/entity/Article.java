package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 
 * 
 */
public class Article implements Serializable {
    private String article_id;

    /**
    * 表示这条动态所属用户的id
    **/
    private String user_id;

    /**
    * 是否带图，0-带图，1-不带
*             默认为0
    **/
    private Byte is_haveImg;

    /**
    * 点赞数量，初始值为0
    **/
    private Integer like_number;

    /**
    * 收藏数量，初始值为0，
    **/
    private Integer collect_number;

    /**
    * 转发数量，初始值 默认为0
    **/
    private Integer transmit_number;

    /**
    * 是否被举报
*             0-被举报
*             1-没有被举报
*             默认为1
    **/
    private Byte is_report;

    /**
    * 被举报的数量，初始值默认为0
    **/
    private Integer report_number;

    /**
    * 动态话题分类，表示该条动态参与的话题标签，以字符串形式保存在数据库中，中间以  _  做分隔符
*             如：人像_黑白_摄影
    **/
    private String type;

    /**
    * 这条动态的创建时间
    **/
    private Date create_time;

    /**
    * 这条记录的修改时间
    **/
    private Date update_time;

    /**
    * 动态内容的文字部分
    **/
    private String content;

    private static final long serialVersionUID = 1L;

    public String getArticle_id() {
        return article_id;
    }

    public Article withArticle_id(String article_id) {
        this.setArticle_id(article_id);
        return this;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id == null ? null : article_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public Article withUser_id(String user_id) {
        this.setUser_id(user_id);
        return this;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public Byte getIs_haveImg() {
        return is_haveImg;
    }

    public Article withIs_haveImg(Byte is_haveImg) {
        this.setIs_haveImg(is_haveImg);
        return this;
    }

    public void setIs_haveImg(Byte is_haveImg) {
        this.is_haveImg = is_haveImg;
    }

    public Integer getLike_number() {
        return like_number;
    }

    public Article withLike_number(Integer like_number) {
        this.setLike_number(like_number);
        return this;
    }

    public void setLike_number(Integer like_number) {
        this.like_number = like_number;
    }

    public Integer getCollect_number() {
        return collect_number;
    }

    public Article withCollect_number(Integer collect_number) {
        this.setCollect_number(collect_number);
        return this;
    }

    public void setCollect_number(Integer collect_number) {
        this.collect_number = collect_number;
    }

    public Integer getTransmit_number() {
        return transmit_number;
    }

    public Article withTransmit_number(Integer transmit_number) {
        this.setTransmit_number(transmit_number);
        return this;
    }

    public void setTransmit_number(Integer transmit_number) {
        this.transmit_number = transmit_number;
    }

    public Byte getIs_report() {
        return is_report;
    }

    public Article withIs_report(Byte is_report) {
        this.setIs_report(is_report);
        return this;
    }

    public void setIs_report(Byte is_report) {
        this.is_report = is_report;
    }

    public Integer getReport_number() {
        return report_number;
    }

    public Article withReport_number(Integer report_number) {
        this.setReport_number(report_number);
        return this;
    }

    public void setReport_number(Integer report_number) {
        this.report_number = report_number;
    }

    public String getType() {
        return type;
    }

    public Article withType(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Article withCreate_time(Date create_time) {
        this.setCreate_time(create_time);
        return this;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Article withUpdate_time(Date update_time) {
        this.setUpdate_time(update_time);
        return this;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getContent() {
        return content;
    }

    public Article withContent(String content) {
        this.setContent(content);
        return this;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", article_id=").append(article_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", is_haveImg=").append(is_haveImg);
        sb.append(", like_number=").append(like_number);
        sb.append(", collect_number=").append(collect_number);
        sb.append(", transmit_number=").append(transmit_number);
        sb.append(", is_report=").append(is_report);
        sb.append(", report_number=").append(report_number);
        sb.append(", type=").append(type);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", content=").append(content);
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
        Article other = (Article) that;
        return (this.getArticle_id() == null ? other.getArticle_id() == null : this.getArticle_id().equals(other.getArticle_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getIs_haveImg() == null ? other.getIs_haveImg() == null : this.getIs_haveImg().equals(other.getIs_haveImg()))
            && (this.getLike_number() == null ? other.getLike_number() == null : this.getLike_number().equals(other.getLike_number()))
            && (this.getCollect_number() == null ? other.getCollect_number() == null : this.getCollect_number().equals(other.getCollect_number()))
            && (this.getTransmit_number() == null ? other.getTransmit_number() == null : this.getTransmit_number().equals(other.getTransmit_number()))
            && (this.getIs_report() == null ? other.getIs_report() == null : this.getIs_report().equals(other.getIs_report()))
            && (this.getReport_number() == null ? other.getReport_number() == null : this.getReport_number().equals(other.getReport_number()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArticle_id() == null) ? 0 : getArticle_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getIs_haveImg() == null) ? 0 : getIs_haveImg().hashCode());
        result = prime * result + ((getLike_number() == null) ? 0 : getLike_number().hashCode());
        result = prime * result + ((getCollect_number() == null) ? 0 : getCollect_number().hashCode());
        result = prime * result + ((getTransmit_number() == null) ? 0 : getTransmit_number().hashCode());
        result = prime * result + ((getIs_report() == null) ? 0 : getIs_report().hashCode());
        result = prime * result + ((getReport_number() == null) ? 0 : getReport_number().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}