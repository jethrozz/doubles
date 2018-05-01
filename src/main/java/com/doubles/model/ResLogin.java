package com.doubles.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResLogin {
    @JsonProperty("stauts")
    private int stauts;
    @JsonProperty("msg")
    private String msg;

    public ResLogin(int stauts,String msg){
        this.msg = msg;
        this.stauts = stauts;
    }

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
