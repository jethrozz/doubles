package com.doubles.model;

/**
 * Created by Shuang on 2018/5/17.
 */
public class NoticeResult {
	private int status;
	private String msg;
	private String content;

	public NoticeResult(int status, String msg, String content) {
		this.status = status;
		this.msg = msg;
		this.content = content;
	}

	public NoticeResult(){}
	public NoticeResult(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
