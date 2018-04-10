package com.zm.employee.bean;

import java.util.ArrayList;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTclassIsNull() {
            addCriterion("tclass is null");
            return (Criteria) this;
        }

        public Criteria andTclassIsNotNull() {
            addCriterion("tclass is not null");
            return (Criteria) this;
        }

        public Criteria andTclassEqualTo(Integer value) {
            addCriterion("tclass =", value, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassNotEqualTo(Integer value) {
            addCriterion("tclass <>", value, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassGreaterThan(Integer value) {
            addCriterion("tclass >", value, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassGreaterThanOrEqualTo(Integer value) {
            addCriterion("tclass >=", value, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassLessThan(Integer value) {
            addCriterion("tclass <", value, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassLessThanOrEqualTo(Integer value) {
            addCriterion("tclass <=", value, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassIn(List<Integer> values) {
            addCriterion("tclass in", values, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassNotIn(List<Integer> values) {
            addCriterion("tclass not in", values, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassBetween(Integer value1, Integer value2) {
            addCriterion("tclass between", value1, value2, "tclass");
            return (Criteria) this;
        }

        public Criteria andTclassNotBetween(Integer value1, Integer value2) {
            addCriterion("tclass not between", value1, value2, "tclass");
            return (Criteria) this;
        }

        public Criteria andTnmaeIsNull() {
            addCriterion("tnmae is null");
            return (Criteria) this;
        }

        public Criteria andTnmaeIsNotNull() {
            addCriterion("tnmae is not null");
            return (Criteria) this;
        }

        public Criteria andTnmaeEqualTo(String value) {
            addCriterion("tnmae =", value, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeNotEqualTo(String value) {
            addCriterion("tnmae <>", value, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeGreaterThan(String value) {
            addCriterion("tnmae >", value, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeGreaterThanOrEqualTo(String value) {
            addCriterion("tnmae >=", value, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeLessThan(String value) {
            addCriterion("tnmae <", value, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeLessThanOrEqualTo(String value) {
            addCriterion("tnmae <=", value, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeLike(String value) {
            addCriterion("tnmae like", value, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeNotLike(String value) {
            addCriterion("tnmae not like", value, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeIn(List<String> values) {
            addCriterion("tnmae in", values, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeNotIn(List<String> values) {
            addCriterion("tnmae not in", values, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeBetween(String value1, String value2) {
            addCriterion("tnmae between", value1, value2, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTnmaeNotBetween(String value1, String value2) {
            addCriterion("tnmae not between", value1, value2, "tnmae");
            return (Criteria) this;
        }

        public Criteria andTcontentIsNull() {
            addCriterion("tcontent is null");
            return (Criteria) this;
        }

        public Criteria andTcontentIsNotNull() {
            addCriterion("tcontent is not null");
            return (Criteria) this;
        }

        public Criteria andTcontentEqualTo(String value) {
            addCriterion("tcontent =", value, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentNotEqualTo(String value) {
            addCriterion("tcontent <>", value, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentGreaterThan(String value) {
            addCriterion("tcontent >", value, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentGreaterThanOrEqualTo(String value) {
            addCriterion("tcontent >=", value, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentLessThan(String value) {
            addCriterion("tcontent <", value, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentLessThanOrEqualTo(String value) {
            addCriterion("tcontent <=", value, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentLike(String value) {
            addCriterion("tcontent like", value, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentNotLike(String value) {
            addCriterion("tcontent not like", value, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentIn(List<String> values) {
            addCriterion("tcontent in", values, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentNotIn(List<String> values) {
            addCriterion("tcontent not in", values, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentBetween(String value1, String value2) {
            addCriterion("tcontent between", value1, value2, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTcontentNotBetween(String value1, String value2) {
            addCriterion("tcontent not between", value1, value2, "tcontent");
            return (Criteria) this;
        }

        public Criteria andTdateIsNull() {
            addCriterion("tdate is null");
            return (Criteria) this;
        }

        public Criteria andTdateIsNotNull() {
            addCriterion("tdate is not null");
            return (Criteria) this;
        }

        public Criteria andTdateEqualTo(String value) {
            addCriterion("tdate =", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateNotEqualTo(String value) {
            addCriterion("tdate <>", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateGreaterThan(String value) {
            addCriterion("tdate >", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateGreaterThanOrEqualTo(String value) {
            addCriterion("tdate >=", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateLessThan(String value) {
            addCriterion("tdate <", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateLessThanOrEqualTo(String value) {
            addCriterion("tdate <=", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateLike(String value) {
            addCriterion("tdate like", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateNotLike(String value) {
            addCriterion("tdate not like", value, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateIn(List<String> values) {
            addCriterion("tdate in", values, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateNotIn(List<String> values) {
            addCriterion("tdate not in", values, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateBetween(String value1, String value2) {
            addCriterion("tdate between", value1, value2, "tdate");
            return (Criteria) this;
        }

        public Criteria andTdateNotBetween(String value1, String value2) {
            addCriterion("tdate not between", value1, value2, "tdate");
            return (Criteria) this;
        }

        public Criteria andTargetIsNull() {
            addCriterion("target is null");
            return (Criteria) this;
        }

        public Criteria andTargetIsNotNull() {
            addCriterion("target is not null");
            return (Criteria) this;
        }

        public Criteria andTargetEqualTo(String value) {
            addCriterion("target =", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotEqualTo(String value) {
            addCriterion("target <>", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThan(String value) {
            addCriterion("target >", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetGreaterThanOrEqualTo(String value) {
            addCriterion("target >=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThan(String value) {
            addCriterion("target <", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLessThanOrEqualTo(String value) {
            addCriterion("target <=", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetLike(String value) {
            addCriterion("target like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotLike(String value) {
            addCriterion("target not like", value, "target");
            return (Criteria) this;
        }

        public Criteria andTargetIn(List<String> values) {
            addCriterion("target in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotIn(List<String> values) {
            addCriterion("target not in", values, "target");
            return (Criteria) this;
        }

        public Criteria andTargetBetween(String value1, String value2) {
            addCriterion("target between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTargetNotBetween(String value1, String value2) {
            addCriterion("target not between", value1, value2, "target");
            return (Criteria) this;
        }

        public Criteria andTadminIsNull() {
            addCriterion("tadmin is null");
            return (Criteria) this;
        }

        public Criteria andTadminIsNotNull() {
            addCriterion("tadmin is not null");
            return (Criteria) this;
        }

        public Criteria andTadminEqualTo(String value) {
            addCriterion("tadmin =", value, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminNotEqualTo(String value) {
            addCriterion("tadmin <>", value, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminGreaterThan(String value) {
            addCriterion("tadmin >", value, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminGreaterThanOrEqualTo(String value) {
            addCriterion("tadmin >=", value, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminLessThan(String value) {
            addCriterion("tadmin <", value, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminLessThanOrEqualTo(String value) {
            addCriterion("tadmin <=", value, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminLike(String value) {
            addCriterion("tadmin like", value, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminNotLike(String value) {
            addCriterion("tadmin not like", value, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminIn(List<String> values) {
            addCriterion("tadmin in", values, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminNotIn(List<String> values) {
            addCriterion("tadmin not in", values, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminBetween(String value1, String value2) {
            addCriterion("tadmin between", value1, value2, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTadminNotBetween(String value1, String value2) {
            addCriterion("tadmin not between", value1, value2, "tadmin");
            return (Criteria) this;
        }

        public Criteria andTdescIsNull() {
            addCriterion("tdesc is null");
            return (Criteria) this;
        }

        public Criteria andTdescIsNotNull() {
            addCriterion("tdesc is not null");
            return (Criteria) this;
        }

        public Criteria andTdescEqualTo(String value) {
            addCriterion("tdesc =", value, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescNotEqualTo(String value) {
            addCriterion("tdesc <>", value, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescGreaterThan(String value) {
            addCriterion("tdesc >", value, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescGreaterThanOrEqualTo(String value) {
            addCriterion("tdesc >=", value, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescLessThan(String value) {
            addCriterion("tdesc <", value, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescLessThanOrEqualTo(String value) {
            addCriterion("tdesc <=", value, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescLike(String value) {
            addCriterion("tdesc like", value, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescNotLike(String value) {
            addCriterion("tdesc not like", value, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescIn(List<String> values) {
            addCriterion("tdesc in", values, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescNotIn(List<String> values) {
            addCriterion("tdesc not in", values, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescBetween(String value1, String value2) {
            addCriterion("tdesc between", value1, value2, "tdesc");
            return (Criteria) this;
        }

        public Criteria andTdescNotBetween(String value1, String value2) {
            addCriterion("tdesc not between", value1, value2, "tdesc");
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