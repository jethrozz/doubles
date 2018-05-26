package com.doubles.model;

/**
 * Created by Shuang on 2018/5/17.
 */
public class NoticeResult {
	private int status;
	private String msg;
	private String fromUser;
	private String toUser;
	
	public NoticeResult(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public NoticeResult(){}

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


}
