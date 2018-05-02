package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(String value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(String value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(String value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(String value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(String value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(String value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLike(String value) {
            addCriterion("img_id like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotLike(String value) {
            addCriterion("img_id not like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<String> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<String> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(String value1, String value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(String value1, String value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIsNull() {
            addCriterion("album_id is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIsNotNull() {
            addCriterion("album_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdEqualTo(String value) {
            addCriterion("album_id =", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotEqualTo(String value) {
            addCriterion("album_id <>", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThan(String value) {
            addCriterion("album_id >", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThanOrEqualTo(String value) {
            addCriterion("album_id >=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThan(String value) {
            addCriterion("album_id <", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThanOrEqualTo(String value) {
            addCriterion("album_id <=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLike(String value) {
            addCriterion("album_id like", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotLike(String value) {
            addCriterion("album_id not like", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIn(List<String> values) {
            addCriterion("album_id in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotIn(List<String> values) {
            addCriterion("album_id not in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdBetween(String value1, String value2) {
            addCriterion("album_id between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotBetween(String value1, String value2) {
            addCriterion("album_id not between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andImgPathIsNull() {
            addCriterion("img_path is null");
            return (Criteria) this;
        }

        public Criteria andImgPathIsNotNull() {
            addCriterion("img_path is not null");
            return (Criteria) this;
        }

        public Criteria andImgPathEqualTo(String value) {
            addCriterion("img_path =", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotEqualTo(String value) {
            addCriterion("img_path <>", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathGreaterThan(String value) {
            addCriterion("img_path >", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("img_path >=", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLessThan(String value) {
            addCriterion("img_path <", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLessThanOrEqualTo(String value) {
            addCriterion("img_path <=", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLike(String value) {
            addCriterion("img_path like", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotLike(String value) {
            addCriterion("img_path not like", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathIn(List<String> values) {
            addCriterion("img_path in", values, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotIn(List<String> values) {
            addCriterion("img_path not in", values, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathBetween(String value1, String value2) {
            addCriterion("img_path between", value1, value2, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotBetween(String value1, String value2) {
            addCriterion("img_path not between", value1, value2, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgDescribeIsNull() {
            addCriterion("img_describe is null");
            return (Criteria) this;
        }

        public Criteria andImgDescribeIsNotNull() {
            addCriterion("img_describe is not null");
            return (Criteria) this;
        }

        public Criteria andImgDescribeEqualTo(String value) {
            addCriterion("img_describe =", value, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeNotEqualTo(String value) {
            addCriterion("img_describe <>", value, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeGreaterThan(String value) {
            addCriterion("img_describe >", value, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("img_describe >=", value, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeLessThan(String value) {
            addCriterion("img_describe <", value, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeLessThanOrEqualTo(String value) {
            addCriterion("img_describe <=", value, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeLike(String value) {
            addCriterion("img_describe like", value, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeNotLike(String value) {
            addCriterion("img_describe not like", value, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeIn(List<String> values) {
            addCriterion("img_describe in", values, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeNotIn(List<String> values) {
            addCriterion("img_describe not in", values, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeBetween(String value1, String value2) {
            addCriterion("img_describe between", value1, value2, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andImgDescribeNotBetween(String value1, String value2) {
            addCriterion("img_describe not between", value1, value2, "imgDescribe");
            return (Criteria) this;
        }

        public Criteria andLikeNumberIsNull() {
            addCriterion("like_number is null");
            return (Criteria) this;
        }

        public Criteria andLikeNumberIsNotNull() {
            addCriterion("like_number is not null");
            return (Criteria) this;
        }

        public Criteria andLikeNumberEqualTo(Integer value) {
            addCriterion("like_number =", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberNotEqualTo(Integer value) {
            addCriterion("like_number <>", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberGreaterThan(Integer value) {
            addCriterion("like_number >", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_number >=", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberLessThan(Integer value) {
            addCriterion("like_number <", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("like_number <=", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberIn(List<Integer> values) {
            addCriterion("like_number in", values, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberNotIn(List<Integer> values) {
            addCriterion("like_number not in", values, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberBetween(Integer value1, Integer value2) {
            addCriterion("like_number between", value1, value2, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("like_number not between", value1, value2, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberIsNull() {
            addCriterion("collect_number is null");
            return (Criteria) this;
        }

        public Criteria andCollectNumberIsNotNull() {
            addCriterion("collect_number is not null");
            return (Criteria) this;
        }

        public Criteria andCollectNumberEqualTo(Integer value) {
            addCriterion("collect_number =", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberNotEqualTo(Integer value) {
            addCriterion("collect_number <>", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberGreaterThan(Integer value) {
            addCriterion("collect_number >", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_number >=", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberLessThan(Integer value) {
            addCriterion("collect_number <", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberLessThanOrEqualTo(Integer value) {
            addCriterion("collect_number <=", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberIn(List<Integer> values) {
            addCriterion("collect_number in", values, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberNotIn(List<Integer> values) {
            addCriterion("collect_number not in", values, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberBetween(Integer value1, Integer value2) {
            addCriterion("collect_number between", value1, value2, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_number not between", value1, value2, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}