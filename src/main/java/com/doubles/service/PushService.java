package com.doubles.service;

import com.doubles.entity.PushData;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by shuang on 2018/5/17.
 */
public interface PushService {
	boolean addData(PushData pushData);
	Page<PushData> getPageByPushUserId(String userId,int pageNo,int pageSize);
	List<PushData> getListByUserId(String userId);
}
