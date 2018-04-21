package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelationshipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RelationshipExample() {
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

        public Criteria andRelationship_idIsNull() {
            addCriterion("relationship_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationship_idIsNotNull() {
            addCriterion("relationship_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationship_idEqualTo(String value) {
            addCriterion("relationship_id =", value, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idNotEqualTo(String value) {
            addCriterion("relationship_id <>", value, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idGreaterThan(String value) {
            addCriterion("relationship_id >", value, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idGreaterThanOrEqualTo(String value) {
            addCriterion("relationship_id >=", value, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idLessThan(String value) {
            addCriterion("relationship_id <", value, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idLessThanOrEqualTo(String value) {
            addCriterion("relationship_id <=", value, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idLike(String value) {
            addCriterion("relationship_id like", value, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idNotLike(String value) {
            addCriterion("relationship_id not like", value, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idIn(List<String> values) {
            addCriterion("relationship_id in", values, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idNotIn(List<String> values) {
            addCriterion("relationship_id not in", values, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idBetween(String value1, String value2) {
            addCriterion("relationship_id between", value1, value2, "relationship_id");
            return (Criteria) this;
        }

        public Criteria andRelationship_idNotBetween(String value1, String value2) {
            addCriterion("relationship_id not between", value1, value2, "relationship_id");
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

        public Criteria andFriend_idIsNull() {
            addCriterion("friend_id is null");
            return (Criteria) this;
        }

        public Criteria andFriend_idIsNotNull() {
            addCriterion("friend_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriend_idEqualTo(String value) {
            addCriterion("friend_id =", value, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idNotEqualTo(String value) {
            addCriterion("friend_id <>", value, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idGreaterThan(String value) {
            addCriterion("friend_id >", value, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idGreaterThanOrEqualTo(String value) {
            addCriterion("friend_id >=", value, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idLessThan(String value) {
            addCriterion("friend_id <", value, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idLessThanOrEqualTo(String value) {
            addCriterion("friend_id <=", value, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idLike(String value) {
            addCriterion("friend_id like", value, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idNotLike(String value) {
            addCriterion("friend_id not like", value, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idIn(List<String> values) {
            addCriterion("friend_id in", values, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idNotIn(List<String> values) {
            addCriterion("friend_id not in", values, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idBetween(String value1, String value2) {
            addCriterion("friend_id between", value1, value2, "friend_id");
            return (Criteria) this;
        }

        public Criteria andFriend_idNotBetween(String value1, String value2) {
            addCriterion("friend_id not between", value1, value2, "friend_id");
            return (Criteria) this;
        }

        public Criteria andIs_friendIsNull() {
            addCriterion("is_friend is null");
            return (Criteria) this;
        }

        public Criteria andIs_friendIsNotNull() {
            addCriterion("is_friend is not null");
            return (Criteria) this;
        }

        public Criteria andIs_friendEqualTo(Byte value) {
            addCriterion("is_friend =", value, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendNotEqualTo(Byte value) {
            addCriterion("is_friend <>", value, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendGreaterThan(Byte value) {
            addCriterion("is_friend >", value, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_friend >=", value, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendLessThan(Byte value) {
            addCriterion("is_friend <", value, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendLessThanOrEqualTo(Byte value) {
            addCriterion("is_friend <=", value, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendIn(List<Byte> values) {
            addCriterion("is_friend in", values, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendNotIn(List<Byte> values) {
            addCriterion("is_friend not in", values, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendBetween(Byte value1, Byte value2) {
            addCriterion("is_friend between", value1, value2, "is_friend");
            return (Criteria) this;
        }

        public Criteria andIs_friendNotBetween(Byte value1, Byte value2) {
            addCriterion("is_friend not between", value1, value2, "is_friend");
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