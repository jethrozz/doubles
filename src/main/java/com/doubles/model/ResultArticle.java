package com.doubles.model;

import com.doubles.entity.Article;
import com.doubles.entity.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Shuang on 2018/5/16.
 */
public class ResultArticle {
	//(类型。0——个人动态
	//1——关注的话题的动态
	//2——个人转发的动态
	//3——关注的人的动态)
	@JsonProperty("type")
	private int isTransmit;


	@JsonProperty("oldUser")
	private Users oldUser;

	@JsonProperty("nowUser")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Users nowUser;

	@JsonProperty("article")
	private Article article;

	public int getIsTransmit() {
		return isTransmit;
	}

	public void setIsTransmit(int isTransmit) {
		this.isTransmit = isTransmit;
	}

	public Users getOldUser() {
		return oldUser;
	}

	public void setOldUser(Users oldUser) {
		this.oldUser = oldUser;
	}

	public Users getNowUser() {
		return nowUser;
	}

	public void setNowUser(Users nowUser) {
		this.nowUser = nowUser;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}
