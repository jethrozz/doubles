package com.doubles.model;

import com.doubles.entity.Users;

/**
 * Created by Shuang on 2018/5/28.
 */
public class TopicUserResult {
	private int isFollow;
	private Users user;

	public int getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(int isFollow) {
		this.isFollow = isFollow;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
