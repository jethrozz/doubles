package com.doubles.service;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * @时间: 2018/4/23
 * @描述：
 */
public interface UserService {
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
    //查看自己关注列表 0-关注的，1-拉黑的，2-互为关注
    Page<Relationship> findFriends(Page<Relationship> page, String user_id, Integer is_friend);
    //关注、拉黑某人
    boolean followOrUnfollow(Relationship relationship);
}
