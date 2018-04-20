package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommentExample() {
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

    public void setPageInfo(Integer currentPage, Integer pageSize) {
        if(pageSize<1) throw new IllegalArgumentException("页大小不能小于1！");
        this.limit=pageSize;
        if(currentPage<1) throw new IllegalArgumentException("页数不能小于1！");
        this.offset=(currentPage-1)*pageSize;
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

        public Criteria andComment_idIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andComment_idIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andComment_idEqualTo(String value) {
            addCriterion("comment_id =", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idNotEqualTo(String value) {
            addCriterion("comment_id <>", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idGreaterThan(String value) {
            addCriterion("comment_id >", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idGreaterThanOrEqualTo(String value) {
            addCriterion("comment_id >=", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idLessThan(String value) {
            addCriterion("comment_id <", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idLessThanOrEqualTo(String value) {
            addCriterion("comment_id <=", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idLike(String value) {
            addCriterion("comment_id like", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idNotLike(String value) {
            addCriterion("comment_id not like", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idIn(List<String> values) {
            addCriterion("comment_id in", values, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idNotIn(List<String> values) {
            addCriterion("comment_id not in", values, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idBetween(String value1, String value2) {
            addCriterion("comment_id between", value1, value2, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idNotBetween(String value1, String value2) {
            addCriterion("comment_id not between", value1, value2, "comment_id");
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

        public Criteria andComment_contentIsNull() {
            addCriterion("comment_content is null");
            return (Criteria) this;
        }

        public Criteria andComment_contentIsNotNull() {
            addCriterion("comment_content is not null");
            return (Criteria) this;
        }

        public Criteria andComment_contentEqualTo(String value) {
            addCriterion("comment_content =", value, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentNotEqualTo(String value) {
            addCriterion("comment_content <>", value, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentGreaterThan(String value) {
            addCriterion("comment_content >", value, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentGreaterThanOrEqualTo(String value) {
            addCriterion("comment_content >=", value, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentLessThan(String value) {
            addCriterion("comment_content <", value, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentLessThanOrEqualTo(String value) {
            addCriterion("comment_content <=", value, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentLike(String value) {
            addCriterion("comment_content like", value, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentNotLike(String value) {
            addCriterion("comment_content not like", value, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentIn(List<String> values) {
            addCriterion("comment_content in", values, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentNotIn(List<String> values) {
            addCriterion("comment_content not in", values, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentBetween(String value1, String value2) {
            addCriterion("comment_content between", value1, value2, "comment_content");
            return (Criteria) this;
        }

        public Criteria andComment_contentNotBetween(String value1, String value2) {
            addCriterion("comment_content not between", value1, value2, "comment_content");
            return (Criteria) this;
        }

        public Criteria andObject_typeIsNull() {
            addCriterion("object_type is null");
            return (Criteria) this;
        }

        public Criteria andObject_typeIsNotNull() {
            addCriterion("object_type is not null");
            return (Criteria) this;
        }

        public Criteria andObject_typeEqualTo(Integer value) {
            addCriterion("object_type =", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeNotEqualTo(Integer value) {
            addCriterion("object_type <>", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeGreaterThan(Integer value) {
            addCriterion("object_type >", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("object_type >=", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeLessThan(Integer value) {
            addCriterion("object_type <", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeLessThanOrEqualTo(Integer value) {
            addCriterion("object_type <=", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeIn(List<Integer> values) {
            addCriterion("object_type in", values, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeNotIn(List<Integer> values) {
            addCriterion("object_type not in", values, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeBetween(Integer value1, Integer value2) {
            addCriterion("object_type between", value1, value2, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("object_type not between", value1, value2, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_idIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObject_idIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObject_idEqualTo(String value) {
            addCriterion("object_id =", value, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idNotEqualTo(String value) {
            addCriterion("object_id <>", value, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idGreaterThan(String value) {
            addCriterion("object_id >", value, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idGreaterThanOrEqualTo(String value) {
            addCriterion("object_id >=", value, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idLessThan(String value) {
            addCriterion("object_id <", value, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idLessThanOrEqualTo(String value) {
            addCriterion("object_id <=", value, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idLike(String value) {
            addCriterion("object_id like", value, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idNotLike(String value) {
            addCriterion("object_id not like", value, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idIn(List<String> values) {
            addCriterion("object_id in", values, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idNotIn(List<String> values) {
            addCriterion("object_id not in", values, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idBetween(String value1, String value2) {
            addCriterion("object_id between", value1, value2, "object_id");
            return (Criteria) this;
        }

        public Criteria andObject_idNotBetween(String value1, String value2) {
            addCriterion("object_id not between", value1, value2, "object_id");
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

        public Criteria andComment_idLikeInsensitive(String value) {
            addCriterion("upper(comment_id) like", value.toUpperCase(), "comment_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLikeInsensitive(String value) {
            addCriterion("upper(user_id) like", value.toUpperCase(), "user_id");
            return (Criteria) this;
        }

        public Criteria andComment_contentLikeInsensitive(String value) {
            addCriterion("upper(comment_content) like", value.toUpperCase(), "comment_content");
            return (Criteria) this;
        }

        public Criteria andObject_idLikeInsensitive(String value) {
            addCriterion("upper(object_id) like", value.toUpperCase(), "object_id");
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