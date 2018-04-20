package com.doubles.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 
 * 
 */
public class Users implements Serializable {
    private String user_id;

    /**
    * 用户名
    **/
    private String username;

    /**
    * 密码
    **/
    private String password;

    /**
    * 用户昵称
    **/
    private String nickname;

    /**
    * 用户性别
*             0-女
*             1-男
*             默认值为0
*             字段可以为空
    **/
    private String userSex;

    /**
    * 用户生日
*             yyyy-MM-dd
*             
*             可以为空
    **/
    private Date birthday;

    /**
    * 这个字段可以用做个性签名或者个人简介
*             
*             可以为空
    **/
    private String userinfo;

    /**
    * 用户手机号码
    **/
    private String phonenumber;

    /**
    * 用户邮箱
    **/
    private String usermail;

    /**
    * 用户喜好，就是用户注册之后会选择的感兴趣的那几个东西
*             数据库中以字符串形式保存，以 _  做分隔符
*             如用户选择了运动，摄影，男神，女神这几个类别，则传过来的数据应是：运动_摄影_男神_女神    
    **/
    private String userlike;

    /**
    * 该用户的注册时间
    **/
    private Date create_time;

    /**
    * 该用户上一次更新个人信息的时间
    **/
    private Date update_time;

    private static final long serialVersionUID = 1L;

    public String getUser_id() {
        return user_id;
    }

    public Users withUser_id(String user_id) {
        this.setUser_id(user_id);
        return this;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getUsername() {
        return username;
    }

    public Users withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public Users withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public Users withNickname(String nickname) {
        this.setNickname(nickname);
        return this;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public Users withUserSex(String userSex) {
        this.setUserSex(userSex);
        return this;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public Users withBirthday(Date birthday) {
        this.setBirthday(birthday);
        return this;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public Users withUserinfo(String userinfo) {
        this.setUserinfo(userinfo);
        return this;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo == null ? null : userinfo.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public Users withPhonenumber(String phonenumber) {
        this.setPhonenumber(phonenumber);
        return this;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getUsermail() {
        return usermail;
    }

    public Users withUsermail(String usermail) {
        this.setUsermail(usermail);
        return this;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail == null ? null : usermail.trim();
    }

    public String getUserlike() {
        return userlike;
    }

    public Users withUserlike(String userlike) {
        this.setUserlike(userlike);
        return this;
    }

    public void setUserlike(String userlike) {
        this.userlike = userlike == null ? null : userlike.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Users withCreate_time(Date create_time) {
        this.setCreate_time(create_time);
        return this;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Users withUpdate_time(Date update_time) {
        this.setUpdate_time(update_time);
        return this;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user_id=").append(user_id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", userSex=").append(userSex);
        sb.append(", birthday=").append(birthday);
        sb.append(", userinfo=").append(userinfo);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", usermail=").append(usermail);
        sb.append(", userlike=").append(userlike);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Users other = (Users) that;
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getUserinfo() == null ? other.getUserinfo() == null : this.getUserinfo().equals(other.getUserinfo()))
            && (this.getPhonenumber() == null ? other.getPhonenumber() == null : this.getPhonenumber().equals(other.getPhonenumber()))
            && (this.getUsermail() == null ? other.getUsermail() == null : this.getUsermail().equals(other.getUsermail()))
            && (this.getUserlike() == null ? other.getUserlike() == null : this.getUserlike().equals(other.getUserlike()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getUserinfo() == null) ? 0 : getUserinfo().hashCode());
        result = prime * result + ((getPhonenumber() == null) ? 0 : getPhonenumber().hashCode());
        result = prime * result + ((getUsermail() == null) ? 0 : getUsermail().hashCode());
        result = prime * result + ((getUserlike() == null) ? 0 : getUserlike().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }
}