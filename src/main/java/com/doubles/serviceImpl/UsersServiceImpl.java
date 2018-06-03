package com.doubles.serviceImpl;

import com.doubles.dao.UsersMapper;
import com.doubles.entity.Users;
import com.doubles.entity.UsersExample;
import com.doubles.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
/*        UsersExample example = new UsersExample();
        example.setOrderByClause("username desc");
        example.or().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<Users> list=userDao.selectByExample(example);
        if (list==null&&list.size()==0)
        {
            return null;
        }else {
            return list.get(0);
        }*/
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
    public List<Users> getHotPerson() {
        return userDao.getHotPerson();
    }

    @Override
    public Users getOne(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public Users getAdmin() {
        UsersExample example = new UsersExample();
        example.setOrderByClause("create_time desc");
        example.or().andUsernameEqualTo("admin").andPasswordEqualTo("admin").andNicknameEqualTo("admin");
        List<Users> list = userDao.selectByExample(example);
        if(null == list || list.size() == 0)
            return null;
        return list.get(0);
    }

    @Override
    public List<Users> getHotPersonByTopic(String topicId) {
        return userDao.getHotPersonByTopic(topicId);
    }


}
