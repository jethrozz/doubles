package com.doubles.model;

import java.util.List;
import java.util.Map;

public class RecommendResult {
    Map<String,Object> art;
    List<Map<String,Object>> tag;
    boolean isLike;

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public Map<String, Object> getArt() {
        return art;
    }

    public void setArt(Map<String, Object> art) {
        this.art = art;
    }

    public List<Map<String, Object>> getTag() {
        return tag;
    }

    public void setTag(List<Map<String, Object>> tag) {
        this.tag = tag;
    }
}
