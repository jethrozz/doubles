package com.doubles.model;

import com.doubles.entity.Users;

import java.util.List;
import java.util.Map;

/**
 * Created by Shuang on 2018/5/22.
 */
public class HotPerson {
	private Users user;
	private int isFriend;  //0-关注，2-相互关注，3-自己
	private Map<String,String> imgList;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getIsFriend() {
		return isFriend;
	}

	public void setIsFriend(int isFriend) {
		this.isFriend = isFriend;
	}

	public Map<String, String> getImgList() {
		return imgList;
	}

	public void setImgList(Map<String, String> imgList) {
		this.imgList = imgList;
	}
}
