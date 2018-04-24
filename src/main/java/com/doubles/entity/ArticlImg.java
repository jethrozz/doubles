package com.doubles.entity;

import java.io.Serializable;

/**
 * <p>
 * 动态图片表

动态相册，如果是动态中的图片，则要存入该表中，表示这张图片是哪个动态的
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class ArticlImg implements Serializable {

    private static final long serialVersionUID = 1L;

    private String aiId;
    /**
     * 动态的id
     */
    private String articleId;
    /**
     * 该动态下的图片id
     */
    private String imgId;


    public String getAiId() {
        return aiId;
    }

    public void setAiId(String aiId) {
        this.aiId = aiId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return "ArticlImg{" +
        "aiId=" + aiId +
        ", articleId=" + articleId +
        ", imgId=" + imgId +
        "}";
    }
}
