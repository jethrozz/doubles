package com.doubles.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.doubles.entity.Users;

import java.util.Date;

/**
 * Created by Shuang on 2018/5/26.
 */
public class ChatResult {
	private Integer count;
	private Users fromUser;
	private Users toUser;
	private String content;
	@JSONField(format="yyyy-MM-dd hh:mm:ss")
	private Date create_time;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Users getFromUser() {
		return fromUser;
	}

	public void setFromUser(Users fromUser) {
		this.fromUser = fromUser;
	}

	public Users getToUser() {
		return toUser;
	}

	public void setToUser(Users toUser) {
		this.toUser = toUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
}
