package com.zm.employee.bean;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdminnameIsNull() {
            addCriterion("adminName is null");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNotNull() {
            addCriterion("adminName is not null");
            return (Criteria) this;
        }

        public Criteria andAdminnameEqualTo(String value) {
            addCriterion("adminName =", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotEqualTo(String value) {
            addCriterion("adminName <>", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThan(String value) {
            addCriterion("adminName >", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThanOrEqualTo(String value) {
            addCriterion("adminName >=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThan(String value) {
            addCriterion("adminName <", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThanOrEqualTo(String value) {
            addCriterion("adminName <=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLike(String value) {
            addCriterion("adminName like", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotLike(String value) {
            addCriterion("adminName not like", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameIn(List<String> values) {
            addCriterion("adminName in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotIn(List<String> values) {
            addCriterion("adminName not in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameBetween(String value1, String value2) {
            addCriterion("adminName between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotBetween(String value1, String value2) {
            addCriterion("adminName not between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminpwdIsNull() {
            addCriterion("adminPwd is null");
            return (Criteria) this;
        }

        public Criteria andAdminpwdIsNotNull() {
            addCriterion("adminPwd is not null");
            return (Criteria) this;
        }

        public Criteria andAdminpwdEqualTo(String value) {
            addCriterion("adminPwd =", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdNotEqualTo(String value) {
            addCriterion("adminPwd <>", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdGreaterThan(String value) {
            addCriterion("adminPwd >", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdGreaterThanOrEqualTo(String value) {
            addCriterion("adminPwd >=", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdLessThan(String value) {
            addCriterion("adminPwd <", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdLessThanOrEqualTo(String value) {
            addCriterion("adminPwd <=", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdLike(String value) {
            addCriterion("adminPwd like", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdNotLike(String value) {
            addCriterion("adminPwd not like", value, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdIn(List<String> values) {
            addCriterion("adminPwd in", values, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdNotIn(List<String> values) {
            addCriterion("adminPwd not in", values, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdBetween(String value1, String value2) {
            addCriterion("adminPwd between", value1, value2, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpwdNotBetween(String value1, String value2) {
            addCriterion("adminPwd not between", value1, value2, "adminpwd");
            return (Criteria) this;
        }

        public Criteria andAdminpowerIsNull() {
            addCriterion("adminPower is null");
            return (Criteria) this;
        }

        public Criteria andAdminpowerIsNotNull() {
            addCriterion("adminPower is not null");
            return (Criteria) this;
        }

        public Criteria andAdminpowerEqualTo(String value) {
            addCriterion("adminPower =", value, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerNotEqualTo(String value) {
            addCriterion("adminPower <>", value, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerGreaterThan(String value) {
            addCriterion("adminPower >", value, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerGreaterThanOrEqualTo(String value) {
            addCriterion("adminPower >=", value, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerLessThan(String value) {
            addCriterion("adminPower <", value, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerLessThanOrEqualTo(String value) {
            addCriterion("adminPower <=", value, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerLike(String value) {
            addCriterion("adminPower like", value, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerNotLike(String value) {
            addCriterion("adminPower not like", value, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerIn(List<String> values) {
            addCriterion("adminPower in", values, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerNotIn(List<String> values) {
            addCriterion("adminPower not in", values, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerBetween(String value1, String value2) {
            addCriterion("adminPower between", value1, value2, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdminpowerNotBetween(String value1, String value2) {
            addCriterion("adminPower not between", value1, value2, "adminpower");
            return (Criteria) this;
        }

        public Criteria andAdmindescIsNull() {
            addCriterion("adminDesc is null");
            return (Criteria) this;
        }

        public Criteria andAdmindescIsNotNull() {
            addCriterion("adminDesc is not null");
            return (Criteria) this;
        }

        public Criteria andAdmindescEqualTo(String value) {
            addCriterion("adminDesc =", value, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescNotEqualTo(String value) {
            addCriterion("adminDesc <>", value, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescGreaterThan(String value) {
            addCriterion("adminDesc >", value, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescGreaterThanOrEqualTo(String value) {
            addCriterion("adminDesc >=", value, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescLessThan(String value) {
            addCriterion("adminDesc <", value, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescLessThanOrEqualTo(String value) {
            addCriterion("adminDesc <=", value, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescLike(String value) {
            addCriterion("adminDesc like", value, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescNotLike(String value) {
            addCriterion("adminDesc not like", value, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescIn(List<String> values) {
            addCriterion("adminDesc in", values, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescNotIn(List<String> values) {
            addCriterion("adminDesc not in", values, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescBetween(String value1, String value2) {
            addCriterion("adminDesc between", value1, value2, "admindesc");
            return (Criteria) this;
        }

        public Criteria andAdmindescNotBetween(String value1, String value2) {
            addCriterion("adminDesc not between", value1, value2, "admindesc");
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