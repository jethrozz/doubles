package com.doubles.entity;

public class ArticlImg {
    private String aiId;

    private String articleId;

    private String imgId;

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getAiId() {
        return aiId;
    }

    public void setAiId(String aiId) {
        this.aiId = aiId == null ? null : aiId.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }
}