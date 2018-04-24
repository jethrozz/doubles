package com.doubles.serviceImpl;

import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @时间: 2018/4/23
 * @描述：UserService的实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UsersMapper userDao;
    @Autowired
    RelationshipMapper relationshipDao;

    @Override
    public Users userLogin(Users user) {
        UsersExample usersExample = new UsersExample();
        usersExample.or().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<Users> listUser = userDao.selectByExample(usersExample);
        if(listUser.size() == 1){
            return listUser.get(0);
        }else {
           return null;
        }
    }

    @Override
    public boolean registUser(Users user) {
        if(userDao.insertSelective(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserInfo(Users user) {
        if(userDao.updateByPrimaryKeySelective(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserPassword(Users user) {
        if(userDao.updateByPrimaryKeySelective(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserImg(Users user) {
        if(userDao.updateByPrimaryKeySelective(user) == 1){
            return true;
        }
        return false;
    }

    @Override
    public Page<Users> findAll(Page<Users> page) {
        UsersExample example = new UsersExample();
        return page.setRecords(userDao.selectByExample(example));
    }

    @Override
    public Page<Relationship> findFriends(Page<Relationship> page, String user_id, Integer is_friend) {
        RelationshipExample example = new RelationshipExample();
        example.or().andUser_idEqualTo(user_id).andIs_friendEqualTo(is_friend.byteValue());
        return page.setRecords(relationshipDao.selectByExample(example));
    }

    @Override
    public boolean followOrUnfollow(Relationship relationship) {
        RelationshipExample example = new RelationshipExample();
        example.or().andUser_idEqualTo(relationship.getUser_id()).andFriend_idEqualTo(relationship.getFriend_id());
        List<Relationship> list = relationshipDao.selectByExample(example);
        //先查询这两人之前是否在表中有过关注或者拉黑记录，如果有则改变好友状态即可，如没有，则插入一条记录
        if(list.size() == 1){
            //size==1,表示之前有过记录
            Relationship rs = list.get(0);
            rs.setIs_friend(relationship.getIs_friend());
            relationshipDao.updateByPrimaryKeySelective(rs);
        }else{
            //这个用户之前未关注或者拉黑过这个用户
            example.clear();
            example.or().andUser_idEqualTo(relationship.getFriend_id()).andFriend_idEqualTo(relationship.getUser_id());
            list = relationshipDao.selectByExample(example);
            //如果这个朋友对他也有关注记录
            if(list.size() == 1 ){
                Relationship temp = list.get(0);
                //拉黑且只有互相关注的情况才修改成单方面关注
                if(relationship.getIs_friend().intValue() == 1 && list.get(0).getIs_friend().intValue() == 2){
                    temp.setIs_friend((byte)0);
                    relationshipDao.updateByPrimaryKeySelective(temp);
                }else if(relationship.getIs_friend().intValue() == 0 && list.get(0).getIs_friend().intValue() == 0){
                    //如果是关注，且这个朋友对他也关注了则修改为相互关注
                    temp.setIs_friend((byte)2);
                    relationshipDao.updateByPrimaryKeySelective(temp);
                }
            }
            relationshipDao.insert(relationship);
        }
        return false;
    }

}
