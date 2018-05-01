package com.doubles.model;

/**
 * @时间: 2018/4/20
 * @描述：用户注册时的选择喜欢的类型
 */
public enum UserLike {
    PHOTOGRAPHY(1,"摄影"),
    SPORT(2,"运动"),
    PET(3,"萌宠"),
    GOD(4,"男神"),
    GODDESS(5,"女神"),
    DRAW(6,"绘画"),
    FILM(7,"电影"),
    MUSIC(8,"音乐"),
    FOOD(9,"美食"),
    MAKE_UP(10,"美妆"),
    WEAR(11,"穿搭"),
    TRAVEL(12,"旅行");


    private final int value;
    private final String reasonPhrase;

    UserLike(int i, String s) {
        this.value = i;
        this.reasonPhrase = s;
    }

}
