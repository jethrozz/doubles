package com.doubles.entity;

import java.util.ArrayList;
import java.util.List;

public class ArtilceTopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ArtilceTopicExample() {
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

        public Criteria andAt_idIsNull() {
            addCriterion("at_id is null");
            return (Criteria) this;
        }

        public Criteria andAt_idIsNotNull() {
            addCriterion("at_id is not null");
            return (Criteria) this;
        }

        public Criteria andAt_idEqualTo(String value) {
            addCriterion("at_id =", value, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idNotEqualTo(String value) {
            addCriterion("at_id <>", value, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idGreaterThan(String value) {
            addCriterion("at_id >", value, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idGreaterThanOrEqualTo(String value) {
            addCriterion("at_id >=", value, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idLessThan(String value) {
            addCriterion("at_id <", value, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idLessThanOrEqualTo(String value) {
            addCriterion("at_id <=", value, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idLike(String value) {
            addCriterion("at_id like", value, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idNotLike(String value) {
            addCriterion("at_id not like", value, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idIn(List<String> values) {
            addCriterion("at_id in", values, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idNotIn(List<String> values) {
            addCriterion("at_id not in", values, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idBetween(String value1, String value2) {
            addCriterion("at_id between", value1, value2, "at_id");
            return (Criteria) this;
        }

        public Criteria andAt_idNotBetween(String value1, String value2) {
            addCriterion("at_id not between", value1, value2, "at_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticle_idIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_idEqualTo(String value) {
            addCriterion("article_id =", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idNotEqualTo(String value) {
            addCriterion("article_id <>", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idGreaterThan(String value) {
            addCriterion("article_id >", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idGreaterThanOrEqualTo(String value) {
            addCriterion("article_id >=", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idLessThan(String value) {
            addCriterion("article_id <", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idLessThanOrEqualTo(String value) {
            addCriterion("article_id <=", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idLike(String value) {
            addCriterion("article_id like", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idNotLike(String value) {
            addCriterion("article_id not like", value, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idIn(List<String> values) {
            addCriterion("article_id in", values, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idNotIn(List<String> values) {
            addCriterion("article_id not in", values, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idBetween(String value1, String value2) {
            addCriterion("article_id between", value1, value2, "article_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idNotBetween(String value1, String value2) {
            addCriterion("article_id not between", value1, value2, "article_id");
            return (Criteria) this;
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

        public Criteria andAt_idLikeInsensitive(String value) {
            addCriterion("upper(at_id) like", value.toUpperCase(), "at_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idLikeInsensitive(String value) {
            addCriterion("upper(article_id) like", value.toUpperCase(), "article_id");
            return (Criteria) this;
        }

        public Criteria andTopic_idLikeInsensitive(String value) {
            addCriterion("upper(topic_id) like", value.toUpperCase(), "topic_id");
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