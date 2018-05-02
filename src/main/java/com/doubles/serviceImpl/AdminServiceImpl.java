package com.doubles.serviceImpl;

import com.doubles.dao.AdminMapper;
import com.doubles.entity.Admin;
import com.doubles.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminDao;
	@Override
	public boolean insert(Admin admin) {
		if(adminDao.insertSelective(admin) >= 1){
			return  true;
		}
		return false;
	}
}
