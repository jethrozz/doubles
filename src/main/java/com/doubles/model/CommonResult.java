package com.doubles.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by shuang on 2018/5/3.
 */
public class CommonResult<T> {
	@JsonProperty("stauts")
	private int stauts;
	@JsonProperty("data")
	private T data;
	@JsonProperty("msg")
	private String msg;

	public CommonResult() {
	}

	public CommonResult(int stauts, String msg) {
		this.stauts = stauts;
		this.msg = msg;
	}

	public CommonResult(int stauts, T data, String msg) {
		this.stauts = stauts;
		this.data = data;
		this.msg = msg;
	}

	public int getStauts() {
		return stauts;
	}

	public void setStauts(int stauts) {
		this.stauts = stauts;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}


}
