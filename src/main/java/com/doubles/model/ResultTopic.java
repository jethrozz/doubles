package com.doubles.model;

import com.doubles.entity.Topic;

import java.util.Map;

/**
 * Created by Shuang on 2018/5/22.
 */
public class ResultTopic {
	private Topic topic;
	private Map<String,String> imgList;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Map<String, String> getImgList() {
		return imgList;
	}

	public void setImgList(Map<String, String> imgList) {
		this.imgList = imgList;
	}
}
