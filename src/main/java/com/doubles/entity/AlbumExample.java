package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AlbumExample() {
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

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(String value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(String value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(String value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(String value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLike(String value) {
            addCriterion("user_id like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotLike(String value) {
            addCriterion("user_id not like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<String> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<String> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameIsNull() {
            addCriterion("album_name is null");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameIsNotNull() {
            addCriterion("album_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameEqualTo(String value) {
            addCriterion("album_name =", value, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameNotEqualTo(String value) {
            addCriterion("album_name <>", value, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameGreaterThan(String value) {
            addCriterion("album_name >", value, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameGreaterThanOrEqualTo(String value) {
            addCriterion("album_name >=", value, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameLessThan(String value) {
            addCriterion("album_name <", value, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameLessThanOrEqualTo(String value) {
            addCriterion("album_name <=", value, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameLike(String value) {
            addCriterion("album_name like", value, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameNotLike(String value) {
            addCriterion("album_name not like", value, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameIn(List<String> values) {
            addCriterion("album_name in", values, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameNotIn(List<String> values) {
            addCriterion("album_name not in", values, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameBetween(String value1, String value2) {
            addCriterion("album_name between", value1, value2, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_nameNotBetween(String value1, String value2) {
            addCriterion("album_name not between", value1, value2, "album_name");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeIsNull() {
            addCriterion("album_describe is null");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeIsNotNull() {
            addCriterion("album_describe is not null");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeEqualTo(String value) {
            addCriterion("album_describe =", value, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeNotEqualTo(String value) {
            addCriterion("album_describe <>", value, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeGreaterThan(String value) {
            addCriterion("album_describe >", value, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeGreaterThanOrEqualTo(String value) {
            addCriterion("album_describe >=", value, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeLessThan(String value) {
            addCriterion("album_describe <", value, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeLessThanOrEqualTo(String value) {
            addCriterion("album_describe <=", value, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeLike(String value) {
            addCriterion("album_describe like", value, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeNotLike(String value) {
            addCriterion("album_describe not like", value, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeIn(List<String> values) {
            addCriterion("album_describe in", values, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeNotIn(List<String> values) {
            addCriterion("album_describe not in", values, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeBetween(String value1, String value2) {
            addCriterion("album_describe between", value1, value2, "album_describe");
            return (Criteria) this;
        }

        public Criteria andAlbum_describeNotBetween(String value1, String value2) {
            addCriterion("album_describe not between", value1, value2, "album_describe");
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