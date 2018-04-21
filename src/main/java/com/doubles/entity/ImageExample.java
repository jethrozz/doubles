package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andImg_idIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImg_idIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImg_idEqualTo(String value) {
            addCriterion("img_id =", value, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idNotEqualTo(String value) {
            addCriterion("img_id <>", value, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idGreaterThan(String value) {
            addCriterion("img_id >", value, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idGreaterThanOrEqualTo(String value) {
            addCriterion("img_id >=", value, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idLessThan(String value) {
            addCriterion("img_id <", value, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idLessThanOrEqualTo(String value) {
            addCriterion("img_id <=", value, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idLike(String value) {
            addCriterion("img_id like", value, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idNotLike(String value) {
            addCriterion("img_id not like", value, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idIn(List<String> values) {
            addCriterion("img_id in", values, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idNotIn(List<String> values) {
            addCriterion("img_id not in", values, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idBetween(String value1, String value2) {
            addCriterion("img_id between", value1, value2, "img_id");
            return (Criteria) this;
        }

        public Criteria andImg_idNotBetween(String value1, String value2) {
            addCriterion("img_id not between", value1, value2, "img_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idIsNull() {
            addCriterion("album_id is null");
            return (Criteria) this;
        }

        public Criteria andAlbum_idIsNotNull() {
            addCriterion("album_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlbum_idEqualTo(String value) {
            addCriterion("album_id =", value, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idNotEqualTo(String value) {
            addCriterion("album_id <>", value, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idGreaterThan(String value) {
            addCriterion("album_id >", value, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idGreaterThanOrEqualTo(String value) {
            addCriterion("album_id >=", value, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idLessThan(String value) {
            addCriterion("album_id <", value, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idLessThanOrEqualTo(String value) {
            addCriterion("album_id <=", value, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idLike(String value) {
            addCriterion("album_id like", value, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idNotLike(String value) {
            addCriterion("album_id not like", value, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idIn(List<String> values) {
            addCriterion("album_id in", values, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idNotIn(List<String> values) {
            addCriterion("album_id not in", values, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idBetween(String value1, String value2) {
            addCriterion("album_id between", value1, value2, "album_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_idNotBetween(String value1, String value2) {
            addCriterion("album_id not between", value1, value2, "album_id");
            return (Criteria) this;
        }

        public Criteria andImg_pathIsNull() {
            addCriterion("img_path is null");
            return (Criteria) this;
        }

        public Criteria andImg_pathIsNotNull() {
            addCriterion("img_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg_pathEqualTo(String value) {
            addCriterion("img_path =", value, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathNotEqualTo(String value) {
            addCriterion("img_path <>", value, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathGreaterThan(String value) {
            addCriterion("img_path >", value, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathGreaterThanOrEqualTo(String value) {
            addCriterion("img_path >=", value, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathLessThan(String value) {
            addCriterion("img_path <", value, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathLessThanOrEqualTo(String value) {
            addCriterion("img_path <=", value, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathLike(String value) {
            addCriterion("img_path like", value, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathNotLike(String value) {
            addCriterion("img_path not like", value, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathIn(List<String> values) {
            addCriterion("img_path in", values, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathNotIn(List<String> values) {
            addCriterion("img_path not in", values, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathBetween(String value1, String value2) {
            addCriterion("img_path between", value1, value2, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_pathNotBetween(String value1, String value2) {
            addCriterion("img_path not between", value1, value2, "img_path");
            return (Criteria) this;
        }

        public Criteria andImg_describeIsNull() {
            addCriterion("img_describe is null");
            return (Criteria) this;
        }

        public Criteria andImg_describeIsNotNull() {
            addCriterion("img_describe is not null");
            return (Criteria) this;
        }

        public Criteria andImg_describeEqualTo(String value) {
            addCriterion("img_describe =", value, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeNotEqualTo(String value) {
            addCriterion("img_describe <>", value, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeGreaterThan(String value) {
            addCriterion("img_describe >", value, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeGreaterThanOrEqualTo(String value) {
            addCriterion("img_describe >=", value, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeLessThan(String value) {
            addCriterion("img_describe <", value, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeLessThanOrEqualTo(String value) {
            addCriterion("img_describe <=", value, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeLike(String value) {
            addCriterion("img_describe like", value, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeNotLike(String value) {
            addCriterion("img_describe not like", value, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeIn(List<String> values) {
            addCriterion("img_describe in", values, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeNotIn(List<String> values) {
            addCriterion("img_describe not in", values, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeBetween(String value1, String value2) {
            addCriterion("img_describe between", value1, value2, "img_describe");
            return (Criteria) this;
        }

        public Criteria andImg_describeNotBetween(String value1, String value2) {
            addCriterion("img_describe not between", value1, value2, "img_describe");
            return (Criteria) this;
        }

        public Criteria andLike_numberIsNull() {
            addCriterion("like_number is null");
            return (Criteria) this;
        }

        public Criteria andLike_numberIsNotNull() {
            addCriterion("like_number is not null");
            return (Criteria) this;
        }

        public Criteria andLike_numberEqualTo(Integer value) {
            addCriterion("like_number =", value, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberNotEqualTo(Integer value) {
            addCriterion("like_number <>", value, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberGreaterThan(Integer value) {
            addCriterion("like_number >", value, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_number >=", value, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberLessThan(Integer value) {
            addCriterion("like_number <", value, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberLessThanOrEqualTo(Integer value) {
            addCriterion("like_number <=", value, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberIn(List<Integer> values) {
            addCriterion("like_number in", values, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberNotIn(List<Integer> values) {
            addCriterion("like_number not in", values, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberBetween(Integer value1, Integer value2) {
            addCriterion("like_number between", value1, value2, "like_number");
            return (Criteria) this;
        }

        public Criteria andLike_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("like_number not between", value1, value2, "like_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberIsNull() {
            addCriterion("collect_number is null");
            return (Criteria) this;
        }

        public Criteria andCollect_numberIsNotNull() {
            addCriterion("collect_number is not null");
            return (Criteria) this;
        }

        public Criteria andCollect_numberEqualTo(Integer value) {
            addCriterion("collect_number =", value, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberNotEqualTo(Integer value) {
            addCriterion("collect_number <>", value, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberGreaterThan(Integer value) {
            addCriterion("collect_number >", value, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_number >=", value, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberLessThan(Integer value) {
            addCriterion("collect_number <", value, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberLessThanOrEqualTo(Integer value) {
            addCriterion("collect_number <=", value, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberIn(List<Integer> values) {
            addCriterion("collect_number in", values, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberNotIn(List<Integer> values) {
            addCriterion("collect_number not in", values, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberBetween(Integer value1, Integer value2) {
            addCriterion("collect_number between", value1, value2, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCollect_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_number not between", value1, value2, "collect_number");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }
    }

    /**
     */
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