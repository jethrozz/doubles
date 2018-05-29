package com.doubles.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Shuang on 2018/5/15.
 * wangEditor 富文本编辑器的返回结果封装
 */
public class WangResult {
	@JsonProperty("error")
	private int error;
	@JsonProperty("data")
	private List<String> data;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
}
