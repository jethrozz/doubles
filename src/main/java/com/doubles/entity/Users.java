package com.doubles.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.doubles.util.SecretUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Users {
    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userimg='" + userimg + '\'' +
                ", nickname='" + nickname + '\'' +
                ", usersex='" + usersex + '\'' +
                ", birthday=" + birthday +
                ", userinfo='" + userinfo + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", usermail='" + usermail + '\'' +
                ", userlike='" + userlike + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public  Users(){
    }
    public Users(String username,String password){
        this.username = username;
        this.password = password;
    }

    public Users(String userId, String username, String password, String userimg, String nickname, String usersex, Date birthday, String userinfo, String phonenumber, String usermail, String userlike, Date createTime, Date updateTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userimg = userimg;
        this.nickname = nickname;
        this.usersex = usersex;
        this.birthday = birthday;
        this.userinfo = userinfo;
        this.phonenumber = phonenumber;
        this.usermail = usermail;
        this.userlike = userlike;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    private String userId;

    private String username;

    private String password;

    private String userimg;

    private String nickname;

    private String usersex;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;

    private String userinfo;

    private String phonenumber;

    private String usermail;

    private String userlike;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg == null ? null : userimg.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
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
        this.userinfo = userinfo == null ? null : userinfo.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail == null ? null : usermail.trim();
    }

    public String getUserlike() {
        return userlike;
    }

    public void setUserlike(String userlike) {
        this.userlike = userlike == null ? null : userlike.trim();
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
}