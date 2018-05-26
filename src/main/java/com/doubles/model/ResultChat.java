package com.doubles.model;

import com.doubles.entity.ChatRecord;
import com.doubles.entity.Users;

/**
 * Created by Shuang on 2018/5/26.
 * 封装的私信页私信列表
 */
public class ResultChat {

	private Users fromUser;

	private ChatRecord lastRecord;

	private Integer number;

	public Users getFromUser() {
		return fromUser;
	}

	public void setFromUser(Users fromUser) {
		this.fromUser = fromUser;
	}

	public ChatRecord getLastRecord() {
		return lastRecord;
	}

	public void setLastRecord(ChatRecord lastRecord) {
		this.lastRecord = lastRecord;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
