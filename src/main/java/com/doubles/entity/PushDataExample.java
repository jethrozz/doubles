package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PushDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PushDataExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsPushIsNull() {
            addCriterion("is_push is null");
            return (Criteria) this;
        }

        public Criteria andIsPushIsNotNull() {
            addCriterion("is_push is not null");
            return (Criteria) this;
        }

        public Criteria andIsPushEqualTo(Integer value) {
            addCriterion("is_push =", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushNotEqualTo(Integer value) {
            addCriterion("is_push <>", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushGreaterThan(Integer value) {
            addCriterion("is_push >", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_push >=", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushLessThan(Integer value) {
            addCriterion("is_push <", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushLessThanOrEqualTo(Integer value) {
            addCriterion("is_push <=", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushIn(List<Integer> values) {
            addCriterion("is_push in", values, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushNotIn(List<Integer> values) {
            addCriterion("is_push not in", values, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushBetween(Integer value1, Integer value2) {
            addCriterion("is_push between", value1, value2, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushNotBetween(Integer value1, Integer value2) {
            addCriterion("is_push not between", value1, value2, "isPush");
            return (Criteria) this;
        }

        public Criteria andContentIdIsNull() {
            addCriterion("content_id is null");
            return (Criteria) this;
        }

        public Criteria andContentIdIsNotNull() {
            addCriterion("content_id is not null");
            return (Criteria) this;
        }

        public Criteria andContentIdEqualTo(String value) {
            addCriterion("content_id =", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotEqualTo(String value) {
            addCriterion("content_id <>", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThan(String value) {
            addCriterion("content_id >", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThanOrEqualTo(String value) {
            addCriterion("content_id >=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThan(String value) {
            addCriterion("content_id <", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThanOrEqualTo(String value) {
            addCriterion("content_id <=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLike(String value) {
            addCriterion("content_id like", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotLike(String value) {
            addCriterion("content_id not like", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdIn(List<String> values) {
            addCriterion("content_id in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotIn(List<String> values) {
            addCriterion("content_id not in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdBetween(String value1, String value2) {
            addCriterion("content_id between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotBetween(String value1, String value2) {
            addCriterion("content_id not between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andBelongUserIsNull() {
            addCriterion("belong_user is null");
            return (Criteria) this;
        }

        public Criteria andBelongUserIsNotNull() {
            addCriterion("belong_user is not null");
            return (Criteria) this;
        }

        public Criteria andBelongUserEqualTo(String value) {
            addCriterion("belong_user =", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserNotEqualTo(String value) {
            addCriterion("belong_user <>", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserGreaterThan(String value) {
            addCriterion("belong_user >", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserGreaterThanOrEqualTo(String value) {
            addCriterion("belong_user >=", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserLessThan(String value) {
            addCriterion("belong_user <", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserLessThanOrEqualTo(String value) {
            addCriterion("belong_user <=", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserLike(String value) {
            addCriterion("belong_user like", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserNotLike(String value) {
            addCriterion("belong_user not like", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserIn(List<String> values) {
            addCriterion("belong_user in", values, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserNotIn(List<String> values) {
            addCriterion("belong_user not in", values, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserBetween(String value1, String value2) {
            addCriterion("belong_user between", value1, value2, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserNotBetween(String value1, String value2) {
            addCriterion("belong_user not between", value1, value2, "belongUser");
            return (Criteria) this;
        }

        public Criteria andNowUserIsNull() {
            addCriterion("now_user is null");
            return (Criteria) this;
        }

        public Criteria andNowUserIsNotNull() {
            addCriterion("now_user is not null");
            return (Criteria) this;
        }

        public Criteria andNowUserEqualTo(String value) {
            addCriterion("now_user =", value, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserNotEqualTo(String value) {
            addCriterion("now_user <>", value, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserGreaterThan(String value) {
            addCriterion("now_user >", value, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserGreaterThanOrEqualTo(String value) {
            addCriterion("now_user >=", value, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserLessThan(String value) {
            addCriterion("now_user <", value, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserLessThanOrEqualTo(String value) {
            addCriterion("now_user <=", value, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserLike(String value) {
            addCriterion("now_user like", value, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserNotLike(String value) {
            addCriterion("now_user not like", value, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserIn(List<String> values) {
            addCriterion("now_user in", values, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserNotIn(List<String> values) {
            addCriterion("now_user not in", values, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserBetween(String value1, String value2) {
            addCriterion("now_user between", value1, value2, "nowUser");
            return (Criteria) this;
        }

        public Criteria andNowUserNotBetween(String value1, String value2) {
            addCriterion("now_user not between", value1, value2, "nowUser");
            return (Criteria) this;
        }

        public Criteria andPushUserIsNull() {
            addCriterion("push_user is null");
            return (Criteria) this;
        }

        public Criteria andPushUserIsNotNull() {
            addCriterion("push_user is not null");
            return (Criteria) this;
        }

        public Criteria andPushUserEqualTo(String value) {
            addCriterion("push_user =", value, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserNotEqualTo(String value) {
            addCriterion("push_user <>", value, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserGreaterThan(String value) {
            addCriterion("push_user >", value, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserGreaterThanOrEqualTo(String value) {
            addCriterion("push_user >=", value, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserLessThan(String value) {
            addCriterion("push_user <", value, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserLessThanOrEqualTo(String value) {
            addCriterion("push_user <=", value, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserLike(String value) {
            addCriterion("push_user like", value, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserNotLike(String value) {
            addCriterion("push_user not like", value, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserIn(List<String> values) {
            addCriterion("push_user in", values, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserNotIn(List<String> values) {
            addCriterion("push_user not in", values, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserBetween(String value1, String value2) {
            addCriterion("push_user between", value1, value2, "pushUser");
            return (Criteria) this;
        }

        public Criteria andPushUserNotBetween(String value1, String value2) {
            addCriterion("push_user not between", value1, value2, "pushUser");
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