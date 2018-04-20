package com.doubles.model;

/**
 * @时间: 2018/4/20
 * @描述：用户注册时的选择喜欢的类型
 */
public enum UserLike {
    SPORT(1,"运动");

    private final int value;
    private final String reasonPhrase;

    UserLike(int i, String s) {
        this.value = i;
        this.reasonPhrase = s;
    }

}
