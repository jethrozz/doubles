package com.doubles.model;

import com.doubles.entity.Transmit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Shuang on 2018/5/17.
 */
public class SingletonTransmitQueue {
	private BlockingQueue<Transmit> artilceTopicPushQueue;

	private SingletonTransmitQueue(){
		artilceTopicPushQueue = new LinkedBlockingDeque<>();
	}
	private static SingletonTransmitQueue instance = null;

	public static synchronized SingletonTransmitQueue getInstance(){
		if(instance == null){
			instance = new SingletonTransmitQueue();
		}
		return instance;
	}

	public BlockingQueue<Transmit> getTransmitPushQueue() {
		return artilceTopicPushQueue;
	}
	public void addTransmitIntoPushQueue(Transmit transmit){
		artilceTopicPushQueue.offer(transmit);
	}
}
