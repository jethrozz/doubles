package com.doubles.model;

import com.doubles.entity.Users;

/**
 * Created by Shuang on 2018/5/29.
 */
public class FollowResult {
	private int isFriend;
	private Users user;

	public int getIsFriend() {
		return isFriend;
	}

	public void setIsFriend(int isFriend) {
		this.isFriend = isFriend;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
