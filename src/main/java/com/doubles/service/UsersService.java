package com.doubles.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.entity.Relationship;
import com.doubles.entity.Users;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface UsersService extends IService<Users> {
    //登录
    Users userLogin(Users user);
    //用户注册
    boolean registUser(Users user);
    //修改个人相关信息
    boolean updateUserInfo(Users user);
    //修改密码
    boolean updateUserPassword(Users user);
    //修改头像
    boolean updateUserImg(Users user);
    //查看所有用户
    Page<Users> findAll(Page<Users> page);

}
