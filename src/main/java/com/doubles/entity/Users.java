package com.doubles.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@TableName("users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    @TableField("userImg")
    private String userImg;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户性别
            0-女
            1-男
            默认值为0
            字段可以为空
     */
    @TableField("userSex")
    private String userSex;
    /**
     * 用户生日
            yyyy-MM-dd
            
            可以为空
     */
    private Date birthday;
    /**
     * 这个字段可以用做个性签名或者个人简介
            
            可以为空
     */
    private String userinfo;
    /**
     * 用户手机号码
     */
    private String phonenumber;
    /**
     * 用户邮箱
     */
    private String usermail;
    /**
     * 用户喜好，就是用户注册之后会选择的感兴趣的那几个东西
            数据库中以字符串形式保存，以 _  做分隔符
            如用户选择了运动，摄影，男神，女神这几个类别，则传过来的数据应是：运动_摄影_男神_女神    
     */
    private String userlike;
    /**
     * 该用户的注册时间
     */
    private Date createTime;
    /**
     * 该用户上一次更新个人信息的时间
     */
    private Date updateTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getUserlike() {
        return userlike;
    }

    public void setUserlike(String userlike) {
        this.userlike = userlike;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Users(String username,String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Users{" +
        "userId=" + userId +
        ", username=" + username +
        ", password=" + password +
        ", userImg=" + userImg +
        ", nickname=" + nickname +
        ", userSex=" + userSex +
        ", birthday=" + birthday +
        ", userinfo=" + userinfo +
        ", phonenumber=" + phonenumber +
        ", usermail=" + usermail +
        ", userlike=" + userlike +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
