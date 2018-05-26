package com.doubles.model;

import com.doubles.entity.ChatRecord;
import com.doubles.entity.Users;

import java.util.List;

/**
 * Created by Shuang on 2018/5/26.
 * 封装的私信详情页的聊天记录
 */
public class ResultChatRecoed {
	private Users fromUser;
	private Users toUser;
	private PageInfo<ChatRecord> chatRecordList;

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

	public PageInfo<ChatRecord> getChatRecordList() {
		return chatRecordList;
	}

	public void setChatRecordList(PageInfo<ChatRecord> chatRecordList) {
		this.chatRecordList = chatRecordList;
	}
}
