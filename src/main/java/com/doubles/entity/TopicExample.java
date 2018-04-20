package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TopicExample() {
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

        public Criteria andTopic_idIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopic_idIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopic_idEqualTo(String value) {
            addCriterion("topic_id =", value, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idNotEqualTo(String value) {
            addCriterion("topic_id <>", value, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idGreaterThan(String value) {
            addCriterion("topic_id >", value, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idGreaterThanOrEqualTo(String value) {
            addCriterion("topic_id >=", value, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idLessThan(String value) {
            addCriterion("topic_id <", value, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idLessThanOrEqualTo(String value) {
            addCriterion("topic_id <=", value, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idLike(String value) {
            addCriterion("topic_id like", value, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idNotLike(String value) {
            addCriterion("topic_id not like", value, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idIn(List<String> values) {
            addCriterion("topic_id in", values, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idNotIn(List<String> values) {
            addCriterion("topic_id not in", values, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idBetween(String value1, String value2) {
            addCriterion("topic_id between", value1, value2, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idNotBetween(String value1, String value2) {
            addCriterion("topic_id not between", value1, value2, "topic_id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDescirbeIsNull() {
            addCriterion("descirbe is null");
            return (Criteria) this;
        }

        public Criteria andDescirbeIsNotNull() {
            addCriterion("descirbe is not null");
            return (Criteria) this;
        }

        public Criteria andDescirbeEqualTo(String value) {
            addCriterion("descirbe =", value, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeNotEqualTo(String value) {
            addCriterion("descirbe <>", value, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeGreaterThan(String value) {
            addCriterion("descirbe >", value, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeGreaterThanOrEqualTo(String value) {
            addCriterion("descirbe >=", value, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeLessThan(String value) {
            addCriterion("descirbe <", value, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeLessThanOrEqualTo(String value) {
            addCriterion("descirbe <=", value, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeLike(String value) {
            addCriterion("descirbe like", value, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeNotLike(String value) {
            addCriterion("descirbe not like", value, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeIn(List<String> values) {
            addCriterion("descirbe in", values, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeNotIn(List<String> values) {
            addCriterion("descirbe not in", values, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeBetween(String value1, String value2) {
            addCriterion("descirbe between", value1, value2, "descirbe");
            return (Criteria) this;
        }

        public Criteria andDescirbeNotBetween(String value1, String value2) {
            addCriterion("descirbe not between", value1, value2, "descirbe");
            return (Criteria) this;
        }

        public Criteria andFan_numberIsNull() {
            addCriterion("fan_number is null");
            return (Criteria) this;
        }

        public Criteria andFan_numberIsNotNull() {
            addCriterion("fan_number is not null");
            return (Criteria) this;
        }

        public Criteria andFan_numberEqualTo(Integer value) {
            addCriterion("fan_number =", value, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberNotEqualTo(Integer value) {
            addCriterion("fan_number <>", value, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberGreaterThan(Integer value) {
            addCriterion("fan_number >", value, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("fan_number >=", value, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberLessThan(Integer value) {
            addCriterion("fan_number <", value, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberLessThanOrEqualTo(Integer value) {
            addCriterion("fan_number <=", value, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberIn(List<Integer> values) {
            addCriterion("fan_number in", values, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberNotIn(List<Integer> values) {
            addCriterion("fan_number not in", values, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberBetween(Integer value1, Integer value2) {
            addCriterion("fan_number between", value1, value2, "fan_number");
            return (Criteria) this;
        }

        public Criteria andFan_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("fan_number not between", value1, value2, "fan_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberIsNull() {
            addCriterion("discussion_number is null");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberIsNotNull() {
            addCriterion("discussion_number is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberEqualTo(Integer value) {
            addCriterion("discussion_number =", value, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberNotEqualTo(Integer value) {
            addCriterion("discussion_number <>", value, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberGreaterThan(Integer value) {
            addCriterion("discussion_number >", value, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("discussion_number >=", value, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberLessThan(Integer value) {
            addCriterion("discussion_number <", value, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberLessThanOrEqualTo(Integer value) {
            addCriterion("discussion_number <=", value, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberIn(List<Integer> values) {
            addCriterion("discussion_number in", values, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberNotIn(List<Integer> values) {
            addCriterion("discussion_number not in", values, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberBetween(Integer value1, Integer value2) {
            addCriterion("discussion_number between", value1, value2, "discussion_number");
            return (Criteria) this;
        }

        public Criteria andDiscussion_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("discussion_number not between", value1, value2, "discussion_number");
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

        public Criteria andTopic_idLikeInsensitive(String value) {
            addCriterion("upper(topic_id) like", value.toUpperCase(), "topic_id");
            return (Criteria) this;
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }

        public Criteria andDescirbeLikeInsensitive(String value) {
            addCriterion("upper(descirbe) like", value.toUpperCase(), "descirbe");
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