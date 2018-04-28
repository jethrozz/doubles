package com.doubles.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.dao.RelationshipDao;
import com.doubles.dao.UsersDao;
import com.doubles.entity.Relationship;
import com.doubles.entity.Users;
import com.doubles.service.UsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class UsersServiceImpl extends ServiceImpl<UsersDao, Users> implements UsersService {
    @Autowired
    UsersDao userDao;


    @Override
    public Users userLogin(Users user) {
        EntityWrapper ew=new EntityWrapper();
        ew.setEntity(user);
        ew.where("username = {0}",user.getUsername()).and("password = {0}",user.getPassword());
        Users u = selectOne(ew);
        if(u != null){
            return u;
        }else {
            return null;
        }
    }

    @Override
    public boolean registUser(Users user) {
        return insert(user);
    }

    @Override
    public boolean updateUserInfo(Users user) {
        return updateById(user);
    }

    @Override
    public boolean updateUserPassword(Users user) {
        return updateById(user);
    }

    @Override
    public boolean updateUserImg(Users user) {
        return updateById(user);
    }

    @Override
    public Page<Users> findAll(Page<Users> page) {
        EntityWrapper<Users> ew = new EntityWrapper();
        return page.setRecords(userDao.selectPage(page,ew));
    }




}
