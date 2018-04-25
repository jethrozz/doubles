package com.doubles.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.doubles.dao.RelationshipDao;
import com.doubles.entity.Relationship;
import com.doubles.service.RelationshipService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.doubles.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 好友关系表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class RelationshipServiceImpl extends ServiceImpl<RelationshipDao, Relationship> implements RelationshipService {
    private static final Logger LOGGER = Logger.getLogger(RelationshipServiceImpl.class);
    @Autowired
    RelationshipDao relationshipDao;
    @Override
    public Page<Relationship> findFriends(Page<Relationship> page, String user_id, Integer is_friend) {
        EntityWrapper<Relationship> ew = new EntityWrapper<>();
        ew.where("friend_id = {0}",user_id).and("is_friend = {0}",is_friend);
        return page.setRecords(relationshipDao.selectPage(page,ew));
    }

    @Override
    public List<Relationship> findFriends(String user_id,Integer is_friend) {
        EntityWrapper<Relationship> ew = new EntityWrapper<>();
        ew.where("friend_id = {0}",user_id).and("is_friend = {0}",is_friend);
        return selectList(ew);
    }

    @Override
    public boolean followOrUnfollow(Relationship relationship) {
        EntityWrapper<Relationship> rew = new EntityWrapper<>();
        rew.where("user_id = {0}",relationship.getUserId()).and("friend_id = {0}",relationship.getFriendId());
        Relationship rs = selectOne(rew);
        //先查询这两人之前是否在表中有过关注或者拉黑记录，如果有则改变好友状态即可，如没有，则插入一条记录
        if(rew != null){
            //将这条记录的状态变成新的
            rs.setIsFriend(relationship.getIsFriend());
            updateById(rs);
            //更新之后需要去查询那个好友对自己的状态是什么
            rew = new EntityWrapper<>();
            rew.where("user_id = {0}",relationship.getFriendId()).and("friend_id = {0}",relationship.getUserId());
            Relationship oldrs = selectOne(rew);
            //在check方法中进行检查并修改状态
            cheeckFriendStauts(oldrs,rs);
            return true;
        }else{
            //这是该用户之前没有关注或者拉黑这个用户的情况
            //直接向表中插入一条数据
            insert(relationship);
            //更新之后需要去查询那个好友对自己的状态是什么
            rew = new EntityWrapper<>();
            rew.where("user_id = {0}",relationship.getFriendId()).and("friend_id = {0}",relationship.getUserId());
            Relationship oldrs = selectOne(rew);
            //在check方法中进行检查并修改状态
            cheeckFriendStauts(oldrs,relationship);
            return true;
        }
    }

    private boolean cheeckFriendStauts(Relationship oldStauts,Relationship newStauts){
        if(oldStauts == null){
            //打印日志方便调试
            LOGGER.info("oldrs is empty");
            return false;
        }else{
            if (newStauts.getIsFriend() == 1 && oldStauts.getIsFriend() == 2){
                oldStauts.setIsFriend(0);
                updateById(oldStauts);
                return true;
            }else if(newStauts.getIsFriend() == 0 && oldStauts.getIsFriend() == 0){
                newStauts.setIsFriend(2);
                oldStauts.setIsFriend(2);
                updateById(newStauts);
                updateById(oldStauts);
                return true;
            }
        }
        return false;
    }
}
