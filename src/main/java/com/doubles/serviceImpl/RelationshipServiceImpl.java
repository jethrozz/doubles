package com.doubles.serviceImpl;

import com.doubles.dao.RelationshipMapper;
import com.doubles.entity.Relationship;
import com.doubles.entity.RelationshipExample;
import com.doubles.service.RelationshipService;
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
public class RelationshipServiceImpl implements RelationshipService {
    private static final Logger LOGGER = Logger.getLogger(RelationshipServiceImpl.class);
    @Autowired
    RelationshipMapper relationshipDao;
/*    @Override
    public Page<Relationship> findFriends(Page<Relationship> page, String user_id, Integer is_friend, int isFollowMe) {
        RelationshipExample example = new RelationshipExample();
        if(isFollowMe == 0){
            example.or().andUserIdEqualTo(user_id).andIsFriendEqualTo(is_friend.byteValue());
        }else{
            example.or().andFriendIdEqualTo(user_id).andIsFriendEqualTo(is_friend.byteValue());
         }
        return page.setRecords(relationshipDao.selectByExample(example));
    }*/

    @Override
    public List<Relationship> findFriends(String user_id,Integer is_friend, int isFollowMe) {
        RelationshipExample example = new RelationshipExample();
        if(isFollowMe == 0){
            example.or().andUserIdEqualTo(user_id).andIsFriendEqualTo(is_friend.byteValue());
        }else{
            example.or().andFriendIdEqualTo(user_id).andIsFriendEqualTo(is_friend.byteValue());
        }
        return relationshipDao.selectByExample(example);
    }

    @Override
    public boolean followOrUnfollow(Relationship relationship) {
        RelationshipExample example = new RelationshipExample();

        example.or().andUserIdEqualTo(relationship.getUserId()).andFriendIdEqualTo(relationship.getFriendId());
        //先查询这两人之前是否在表中有过关注或者拉黑记录，如果有则改变好友状态即可，如没有，则插入一条记录
        List<Relationship> rslist = relationshipDao.selectByExample(example);
        if(rslist.size() != 0 || null != rslist){
            Relationship rs = rslist.get(0);
            //将这条记录的状态变成新的
            rs.setIsFriend(relationship.getIsFriend());
            relationshipDao.updateByPrimaryKeySelective(rs);
            //更新之后需要去查询那个好友对自己的状态是什么
            example.clear();
            example.or().andUserIdEqualTo(relationship.getFriendId()).andFriendIdEqualTo(relationship.getUserId());
            List<Relationship> rslist1 = relationshipDao.selectByExample(example);
            if(rslist1.size() != 0 || null != rslist1){
                Relationship oldrs = rslist1.get(0);
                cheeckFriendStauts(oldrs,rs);
            }
            return true;
        }else{
            //这是该用户之前没有关注或者拉黑这个用户的情况
            //直接向表中插入一条数据
            relationshipDao.insertSelective(relationship);
            //更新之后需要去查询那个好友对自己的状态是什么
            example.clear();
            example.or().andUserIdEqualTo(relationship.getFriendId()).andFriendIdEqualTo(relationship.getUserId());
            List<Relationship> rslist1 = relationshipDao.selectByExample(example);
            if(rslist1.size() != 0 || null != rslist1){
                Relationship oldrs = rslist1.get(0);
                cheeckFriendStauts(oldrs,relationship);
            }
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
                oldStauts.setIsFriend((byte)0);
                relationshipDao.updateByPrimaryKeySelective(oldStauts);
                return true;
            }else if(newStauts.getIsFriend() == 0 && oldStauts.getIsFriend() == 0){
                newStauts.setIsFriend((byte)2);
                oldStauts.setIsFriend((byte)2);
                relationshipDao.updateByPrimaryKeySelective(newStauts);
                relationshipDao.updateByPrimaryKeySelective(oldStauts);
                return true;
            }
        }
        return false;
    }
}
