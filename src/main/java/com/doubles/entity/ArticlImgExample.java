package com.doubles.entity;

import java.util.ArrayList;
import java.util.List;

public class ArticlImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ArticlImgExample() {
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

        public Criteria andAi_idIsNull() {
            addCriterion("ai_id is null");
            return (Criteria) this;
        }

        public Criteria andAi_idIsNotNull() {
            addCriterion("ai_id is not null");
            return (Criteria) this;
        }

        public Criteria andAi_idEqualTo(String value) {
            addCriterion("ai_id =", value, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idNotEqualTo(String value) {
            addCriterion("ai_id <>", value, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idGreaterThan(String value) {
            addCriterion("ai_id >", value, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idGreaterThanOrEqualTo(String value) {
            addCriterion("ai_id >=", value, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idLessThan(String value) {
            addCriterion("ai_id <", value, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idLessThanOrEqualTo(String value) {
            addCriterion("ai_id <=", value, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idLike(String value) {
            addCriterion("ai_id like", value, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idNotLike(String value) {
            addCriterion("ai_id not like", value, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idIn(List<String> values) {
            addCriterion("ai_id in", values, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idNotIn(List<String> values) {
            addCriterion("ai_id not in", values, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idBetween(String value1, String value2) {
            addCriterion("ai_id between", value1, value2, "ai_id");
            return (Criteria) this;
        }

        public Criteria andAi_idNotBetween(String value1, String value2) {
            addCriterion("ai_id not between", value1, value2, "ai_id");
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

        public Criteria andAi_idLikeInsensitive(String value) {
            addCriterion("upper(ai_id) like", value.toUpperCase(), "ai_id");
            return (Criteria) this;
        }

        public Criteria andArticle_idLikeInsensitive(String value) {
            addCriterion("upper(article_id) like", value.toUpperCase(), "article_id");
            return (Criteria) this;
        }

        public Criteria andImg_idLikeInsensitive(String value) {
            addCriterion("upper(img_id) like", value.toUpperCase(), "img_id");
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