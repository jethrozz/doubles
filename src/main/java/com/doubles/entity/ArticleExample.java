package com.doubles.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ArticleExample() {
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

        public Criteria andIs_haveImgIsNull() {
            addCriterion("is_haveImg is null");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgIsNotNull() {
            addCriterion("is_haveImg is not null");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgEqualTo(Byte value) {
            addCriterion("is_haveImg =", value, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgNotEqualTo(Byte value) {
            addCriterion("is_haveImg <>", value, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgGreaterThan(Byte value) {
            addCriterion("is_haveImg >", value, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_haveImg >=", value, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgLessThan(Byte value) {
            addCriterion("is_haveImg <", value, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgLessThanOrEqualTo(Byte value) {
            addCriterion("is_haveImg <=", value, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgIn(List<Byte> values) {
            addCriterion("is_haveImg in", values, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgNotIn(List<Byte> values) {
            addCriterion("is_haveImg not in", values, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgBetween(Byte value1, Byte value2) {
            addCriterion("is_haveImg between", value1, value2, "is_haveImg");
            return (Criteria) this;
        }

        public Criteria andIs_haveImgNotBetween(Byte value1, Byte value2) {
            addCriterion("is_haveImg not between", value1, value2, "is_haveImg");
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

        public Criteria andTransmit_numberIsNull() {
            addCriterion("transmit_number is null");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberIsNotNull() {
            addCriterion("transmit_number is not null");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberEqualTo(Integer value) {
            addCriterion("transmit_number =", value, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberNotEqualTo(Integer value) {
            addCriterion("transmit_number <>", value, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberGreaterThan(Integer value) {
            addCriterion("transmit_number >", value, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("transmit_number >=", value, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberLessThan(Integer value) {
            addCriterion("transmit_number <", value, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberLessThanOrEqualTo(Integer value) {
            addCriterion("transmit_number <=", value, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberIn(List<Integer> values) {
            addCriterion("transmit_number in", values, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberNotIn(List<Integer> values) {
            addCriterion("transmit_number not in", values, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberBetween(Integer value1, Integer value2) {
            addCriterion("transmit_number between", value1, value2, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andTransmit_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("transmit_number not between", value1, value2, "transmit_number");
            return (Criteria) this;
        }

        public Criteria andIs_reportIsNull() {
            addCriterion("is_report is null");
            return (Criteria) this;
        }

        public Criteria andIs_reportIsNotNull() {
            addCriterion("is_report is not null");
            return (Criteria) this;
        }

        public Criteria andIs_reportEqualTo(Byte value) {
            addCriterion("is_report =", value, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportNotEqualTo(Byte value) {
            addCriterion("is_report <>", value, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportGreaterThan(Byte value) {
            addCriterion("is_report >", value, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_report >=", value, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportLessThan(Byte value) {
            addCriterion("is_report <", value, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportLessThanOrEqualTo(Byte value) {
            addCriterion("is_report <=", value, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportIn(List<Byte> values) {
            addCriterion("is_report in", values, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportNotIn(List<Byte> values) {
            addCriterion("is_report not in", values, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportBetween(Byte value1, Byte value2) {
            addCriterion("is_report between", value1, value2, "is_report");
            return (Criteria) this;
        }

        public Criteria andIs_reportNotBetween(Byte value1, Byte value2) {
            addCriterion("is_report not between", value1, value2, "is_report");
            return (Criteria) this;
        }

        public Criteria andReport_numberIsNull() {
            addCriterion("report_number is null");
            return (Criteria) this;
        }

        public Criteria andReport_numberIsNotNull() {
            addCriterion("report_number is not null");
            return (Criteria) this;
        }

        public Criteria andReport_numberEqualTo(Integer value) {
            addCriterion("report_number =", value, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberNotEqualTo(Integer value) {
            addCriterion("report_number <>", value, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberGreaterThan(Integer value) {
            addCriterion("report_number >", value, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_number >=", value, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberLessThan(Integer value) {
            addCriterion("report_number <", value, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberLessThanOrEqualTo(Integer value) {
            addCriterion("report_number <=", value, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberIn(List<Integer> values) {
            addCriterion("report_number in", values, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberNotIn(List<Integer> values) {
            addCriterion("report_number not in", values, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberBetween(Integer value1, Integer value2) {
            addCriterion("report_number between", value1, value2, "report_number");
            return (Criteria) this;
        }

        public Criteria andReport_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("report_number not between", value1, value2, "report_number");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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