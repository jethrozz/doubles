package com.doubles.model;

import java.util.List;

/**
 * Created by Shuang on 2018/5/20.
 */
public class ResultAlbum {
	String albumTime;
	List<MyAlbum> albumList;

	public String getAlbumTime() {
		return albumTime;
	}

	public void setAlbumTime(String albumTime) {
		this.albumTime = albumTime;
	}

	public List<MyAlbum> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<MyAlbum> albumList) {
		this.albumList = albumList;
	}
}
