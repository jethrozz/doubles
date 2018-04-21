package com.doubles.entity;

import java.io.Serializable;

/**
 * articl_img
 * @author 
 */
public class ArticlImg implements Serializable {
    private String ai_id;

    /**
     * 动态的id
     */
    private String article_id;

    /**
     * 该动态下的图片id
     */
    private String img_id;

    private static final long serialVersionUID = 1L;

    public String getAi_id() {
        return ai_id;
    }

    public void setAi_id(String ai_id) {
        this.ai_id = ai_id;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
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
        ArticlImg other = (ArticlImg) that;
        return (this.getAi_id() == null ? other.getAi_id() == null : this.getAi_id().equals(other.getAi_id()))
            && (this.getArticle_id() == null ? other.getArticle_id() == null : this.getArticle_id().equals(other.getArticle_id()))
            && (this.getImg_id() == null ? other.getImg_id() == null : this.getImg_id().equals(other.getImg_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAi_id() == null) ? 0 : getAi_id().hashCode());
        result = prime * result + ((getArticle_id() == null) ? 0 : getArticle_id().hashCode());
        result = prime * result + ((getImg_id() == null) ? 0 : getImg_id().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ai_id=").append(ai_id);
        sb.append(", article_id=").append(article_id);
        sb.append(", img_id=").append(img_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}