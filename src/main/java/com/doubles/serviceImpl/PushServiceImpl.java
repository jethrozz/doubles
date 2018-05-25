package com.doubles.serviceImpl;

import com.doubles.dao.PushDataMapper;
import com.doubles.entity.PushData;
import com.doubles.entity.PushDataExample;
import com.doubles.service.PushService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shuang on 2018/5/17.
 */
@Service
public class PushServiceImpl implements PushService {
	@Autowired
	private PushDataMapper pushDataMapper;

	@Override
	public boolean addData(PushData pushData) {
		if(pushDataMapper.insertSelective(pushData) >= 1){
			return true;
		}
		return false;
	}

	@Override
	public Page<PushData> getPageByPushUserId(String userId,int pageNo,int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return pushDataMapper.getPageByPushUser(userId);
	}

	@Override
	public List<PushData> getListByUserId(String userId) {
		PushDataExample example = new PushDataExample();
		example.or().andPushUserEqualTo(userId);
		return pushDataMapper.selectByExample(example);
	}
}
