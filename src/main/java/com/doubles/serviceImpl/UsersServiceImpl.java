package com.doubles.serviceImpl;

import com.doubles.dao.UsersMapper;
import com.doubles.entity.Users;
import com.doubles.entity.UsersExample;
import com.doubles.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper userDao;

    @Override
    public boolean checkUserName(String username) {
        UsersExample example = new UsersExample();
        example.or().andUsernameEqualTo(username);
        if(userDao.countByExample(example) == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Users userLogin(Users user) {
        Users u = userDao.isUser(user.getUsername(),user.getPassword());
        if(u != null){
            return u;
        }else {
            return null;
        }
    }

    @Override
    public boolean registUser(Users user) {
        if(userDao.insertSelective(user) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserInfo(Users user) {
        if(userDao.updateByPrimaryKeySelective(user) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public Users getOne(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }


}
