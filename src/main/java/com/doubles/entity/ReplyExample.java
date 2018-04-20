package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ReplyExample() {
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

        public Criteria andReply_idIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReply_idIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReply_idEqualTo(String value) {
            addCriterion("reply_id =", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idNotEqualTo(String value) {
            addCriterion("reply_id <>", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idGreaterThan(String value) {
            addCriterion("reply_id >", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idGreaterThanOrEqualTo(String value) {
            addCriterion("reply_id >=", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idLessThan(String value) {
            addCriterion("reply_id <", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idLessThanOrEqualTo(String value) {
            addCriterion("reply_id <=", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idLike(String value) {
            addCriterion("reply_id like", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idNotLike(String value) {
            addCriterion("reply_id not like", value, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idIn(List<String> values) {
            addCriterion("reply_id in", values, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idNotIn(List<String> values) {
            addCriterion("reply_id not in", values, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idBetween(String value1, String value2) {
            addCriterion("reply_id between", value1, value2, "reply_id");
            return (Criteria) this;
        }

        public Criteria andReply_idNotBetween(String value1, String value2) {
            addCriterion("reply_id not between", value1, value2, "reply_id");
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

        public Criteria andReply_contentIsNull() {
            addCriterion("reply_content is null");
            return (Criteria) this;
        }

        public Criteria andReply_contentIsNotNull() {
            addCriterion("reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andReply_contentEqualTo(String value) {
            addCriterion("reply_content =", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentNotEqualTo(String value) {
            addCriterion("reply_content <>", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentGreaterThan(String value) {
            addCriterion("reply_content >", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentGreaterThanOrEqualTo(String value) {
            addCriterion("reply_content >=", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentLessThan(String value) {
            addCriterion("reply_content <", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentLessThanOrEqualTo(String value) {
            addCriterion("reply_content <=", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentLike(String value) {
            addCriterion("reply_content like", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentNotLike(String value) {
            addCriterion("reply_content not like", value, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentIn(List<String> values) {
            addCriterion("reply_content in", values, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentNotIn(List<String> values) {
            addCriterion("reply_content not in", values, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentBetween(String value1, String value2) {
            addCriterion("reply_content between", value1, value2, "reply_content");
            return (Criteria) this;
        }

        public Criteria andReply_contentNotBetween(String value1, String value2) {
            addCriterion("reply_content not between", value1, value2, "reply_content");
            return (Criteria) this;
        }

        public Criteria andTo_userIsNull() {
            addCriterion("to_user is null");
            return (Criteria) this;
        }

        public Criteria andTo_userIsNotNull() {
            addCriterion("to_user is not null");
            return (Criteria) this;
        }

        public Criteria andTo_userEqualTo(String value) {
            addCriterion("to_user =", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userNotEqualTo(String value) {
            addCriterion("to_user <>", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userGreaterThan(String value) {
            addCriterion("to_user >", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userGreaterThanOrEqualTo(String value) {
            addCriterion("to_user >=", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userLessThan(String value) {
            addCriterion("to_user <", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userLessThanOrEqualTo(String value) {
            addCriterion("to_user <=", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userLike(String value) {
            addCriterion("to_user like", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userNotLike(String value) {
            addCriterion("to_user not like", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userIn(List<String> values) {
            addCriterion("to_user in", values, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userNotIn(List<String> values) {
            addCriterion("to_user not in", values, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userBetween(String value1, String value2) {
            addCriterion("to_user between", value1, value2, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userNotBetween(String value1, String value2) {
            addCriterion("to_user not between", value1, value2, "to_user");
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

        public Criteria andReply_idLikeInsensitive(String value) {
            addCriterion("upper(reply_id) like", value.toUpperCase(), "reply_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLikeInsensitive(String value) {
            addCriterion("upper(user_id) like", value.toUpperCase(), "user_id");
            return (Criteria) this;
        }

        public Criteria andComment_idLikeInsensitive(String value) {
            addCriterion("upper(comment_id) like", value.toUpperCase(), "comment_id");
            return (Criteria) this;
        }

        public Criteria andReply_contentLikeInsensitive(String value) {
            addCriterion("upper(reply_content) like", value.toUpperCase(), "reply_content");
            return (Criteria) this;
        }

        public Criteria andTo_userLikeInsensitive(String value) {
            addCriterion("upper(to_user) like", value.toUpperCase(), "to_user");
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