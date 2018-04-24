package com.doubles.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String adminId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用数字表示权限
            0-普通
            1-高级
     */
    private Integer power;
    /**
     * 这条记录的创建时间
     */
    private Date createTime;
    /**
     * 这条记录的更新时间
     */
    private Date updateTime;


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
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

    @Override
    public String toString() {
        return "Admin{" +
        "adminId=" + adminId +
        ", username=" + username +
        ", password=" + password +
        ", power=" + power +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
