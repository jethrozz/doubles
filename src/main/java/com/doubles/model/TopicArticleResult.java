package com.doubles.model;

import com.doubles.entity.Article;

/**
 * Created by Shuang on 2018/5/28.
 */
public class TopicArticleResult {
	private boolean isLike;
	private int isFollow;
	private Article article;

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean like) {
		isLike = like;
	}

	public int getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(int isFollow) {
		this.isFollow = isFollow;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}
