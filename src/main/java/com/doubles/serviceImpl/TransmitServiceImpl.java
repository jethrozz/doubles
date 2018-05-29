package com.doubles.serviceImpl;

import com.doubles.dao.TransmitMapper;
import com.doubles.entity.Transmit;
import com.doubles.entity.TransmitExample;
import com.doubles.service.TransmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 转发表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class TransmitServiceImpl implements TransmitService {

	@Autowired
	TransmitMapper transmitMapper;

	@Override
	public boolean addTransmit(Transmit transmit) {
		if(transmitMapper.insertSelective(transmit) >= 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteTransmit(String articleId,String userId) {
		TransmitExample example = new TransmitExample();
		example.or().andContentIdEqualTo(articleId).andUserIdEqualTo(userId);

		if(transmitMapper.deleteByExample(example) >= 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isTransmit(String articleId, String userId) {
		TransmitExample example = new TransmitExample();
		example.or().andContentIdEqualTo(articleId).andUserIdEqualTo(userId);
		List<Transmit> list = transmitMapper.selectByExample(example);

		if(list != null && list.size() != 0 ){
			return true;
		}
		return false;
	}

	@Override
	public List<Transmit> getListArticleByUid(String userId) {
		TransmitExample example = new TransmitExample();
		example.or().andUserIdEqualTo(userId).andTypeEqualTo(0);
		return transmitMapper.selectByExample(example);
	}

}
