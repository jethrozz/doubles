package com.doubles.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuang on 2018/5/16.
 */
public class IndexResult {
	@JsonProperty("status")
	private int status;
	@JsonProperty("list")
	private PageInfo<ResultArticle> list;



	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	public PageInfo<ResultArticle> getList() {
		return list;
	}

	public void setList(PageInfo<ResultArticle>list) {
		this.list = list;
	}


}
