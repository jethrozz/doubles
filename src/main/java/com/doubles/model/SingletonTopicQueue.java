package com.doubles.model;

import com.doubles.entity.ArtilceTopic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Shuang on 2018/5/17.
 */
public class SingletonTopicQueue {
	private BlockingQueue<ArtilceTopic> artilceTopicPushQueue;

	private SingletonTopicQueue(){
		artilceTopicPushQueue = new LinkedBlockingDeque<>();
	}
	private static SingletonTopicQueue instance = null;

	public static synchronized SingletonTopicQueue getInstance(){
		if(instance == null){
			instance = new SingletonTopicQueue();
		}
		return instance;
	}

	public BlockingQueue<ArtilceTopic> getArtilceTopicPushQueue() {
		return artilceTopicPushQueue;
	}
	public void addUserIntoPushQueue(ArtilceTopic artilceTopic){
		artilceTopicPushQueue.offer(artilceTopic);
	}
}
