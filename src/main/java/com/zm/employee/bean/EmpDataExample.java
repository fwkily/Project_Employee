package com.zm.employee.bean;

import java.util.ArrayList;
import java.util.List;

public class EmpDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmpDataExample() {
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

        public Criteria andEmpidIsNull() {
            addCriterion("empId is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empId is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empId =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empId <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empId >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empId >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empId <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empId <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empId in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empId not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empId between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empId not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthIsNull() {
            addCriterion("birth is null");
            return (Criteria) this;
        }

        public Criteria andBirthIsNotNull() {
            addCriterion("birth is not null");
            return (Criteria) this;
        }

        public Criteria andBirthEqualTo(String value) {
            addCriterion("birth =", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotEqualTo(String value) {
            addCriterion("birth <>", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThan(String value) {
            addCriterion("birth >", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThanOrEqualTo(String value) {
            addCriterion("birth >=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThan(String value) {
            addCriterion("birth <", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThanOrEqualTo(String value) {
            addCriterion("birth <=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLike(String value) {
            addCriterion("birth like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotLike(String value) {
            addCriterion("birth not like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthIn(List<String> values) {
            addCriterion("birth in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotIn(List<String> values) {
            addCriterion("birth not in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthBetween(String value1, String value2) {
            addCriterion("birth between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotBetween(String value1, String value2) {
            addCriterion("birth not between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andHighIsNull() {
            addCriterion("high is null");
            return (Criteria) this;
        }

        public Criteria andHighIsNotNull() {
            addCriterion("high is not null");
            return (Criteria) this;
        }

        public Criteria andHighEqualTo(Integer value) {
            addCriterion("high =", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotEqualTo(Integer value) {
            addCriterion("high <>", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThan(Integer value) {
            addCriterion("high >", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThanOrEqualTo(Integer value) {
            addCriterion("high >=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThan(Integer value) {
            addCriterion("high <", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThanOrEqualTo(Integer value) {
            addCriterion("high <=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighIn(List<Integer> values) {
            addCriterion("high in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotIn(List<Integer> values) {
            addCriterion("high not in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighBetween(Integer value1, Integer value2) {
            addCriterion("high between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotBetween(Integer value1, Integer value2) {
            addCriterion("high not between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andEthnicIsNull() {
            addCriterion("ethnic is null");
            return (Criteria) this;
        }

        public Criteria andEthnicIsNotNull() {
            addCriterion("ethnic is not null");
            return (Criteria) this;
        }

        public Criteria andEthnicEqualTo(String value) {
            addCriterion("ethnic =", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotEqualTo(String value) {
            addCriterion("ethnic <>", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicGreaterThan(String value) {
            addCriterion("ethnic >", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicGreaterThanOrEqualTo(String value) {
            addCriterion("ethnic >=", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLessThan(String value) {
            addCriterion("ethnic <", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLessThanOrEqualTo(String value) {
            addCriterion("ethnic <=", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicLike(String value) {
            addCriterion("ethnic like", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotLike(String value) {
            addCriterion("ethnic not like", value, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicIn(List<String> values) {
            addCriterion("ethnic in", values, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotIn(List<String> values) {
            addCriterion("ethnic not in", values, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicBetween(String value1, String value2) {
            addCriterion("ethnic between", value1, value2, "ethnic");
            return (Criteria) this;
        }

        public Criteria andEthnicNotBetween(String value1, String value2) {
            addCriterion("ethnic not between", value1, value2, "ethnic");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andStudybgIsNull() {
            addCriterion("studyBg is null");
            return (Criteria) this;
        }

        public Criteria andStudybgIsNotNull() {
            addCriterion("studyBg is not null");
            return (Criteria) this;
        }

        public Criteria andStudybgEqualTo(String value) {
            addCriterion("studyBg =", value, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgNotEqualTo(String value) {
            addCriterion("studyBg <>", value, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgGreaterThan(String value) {
            addCriterion("studyBg >", value, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgGreaterThanOrEqualTo(String value) {
            addCriterion("studyBg >=", value, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgLessThan(String value) {
            addCriterion("studyBg <", value, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgLessThanOrEqualTo(String value) {
            addCriterion("studyBg <=", value, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgLike(String value) {
            addCriterion("studyBg like", value, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgNotLike(String value) {
            addCriterion("studyBg not like", value, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgIn(List<String> values) {
            addCriterion("studyBg in", values, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgNotIn(List<String> values) {
            addCriterion("studyBg not in", values, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgBetween(String value1, String value2) {
            addCriterion("studyBg between", value1, value2, "studybg");
            return (Criteria) this;
        }

        public Criteria andStudybgNotBetween(String value1, String value2) {
            addCriterion("studyBg not between", value1, value2, "studybg");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andPsIsNull() {
            addCriterion("ps is null");
            return (Criteria) this;
        }

        public Criteria andPsIsNotNull() {
            addCriterion("ps is not null");
            return (Criteria) this;
        }

        public Criteria andPsEqualTo(String value) {
            addCriterion("ps =", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotEqualTo(String value) {
            addCriterion("ps <>", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsGreaterThan(String value) {
            addCriterion("ps >", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsGreaterThanOrEqualTo(String value) {
            addCriterion("ps >=", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLessThan(String value) {
            addCriterion("ps <", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLessThanOrEqualTo(String value) {
            addCriterion("ps <=", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsLike(String value) {
            addCriterion("ps like", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotLike(String value) {
            addCriterion("ps not like", value, "ps");
            return (Criteria) this;
        }

        public Criteria andPsIn(List<String> values) {
            addCriterion("ps in", values, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotIn(List<String> values) {
            addCriterion("ps not in", values, "ps");
            return (Criteria) this;
        }

        public Criteria andPsBetween(String value1, String value2) {
            addCriterion("ps between", value1, value2, "ps");
            return (Criteria) this;
        }

        public Criteria andPsNotBetween(String value1, String value2) {
            addCriterion("ps not between", value1, value2, "ps");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMyabilityIsNull() {
            addCriterion("myAbility is null");
            return (Criteria) this;
        }

        public Criteria andMyabilityIsNotNull() {
            addCriterion("myAbility is not null");
            return (Criteria) this;
        }

        public Criteria andMyabilityEqualTo(String value) {
            addCriterion("myAbility =", value, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityNotEqualTo(String value) {
            addCriterion("myAbility <>", value, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityGreaterThan(String value) {
            addCriterion("myAbility >", value, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityGreaterThanOrEqualTo(String value) {
            addCriterion("myAbility >=", value, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityLessThan(String value) {
            addCriterion("myAbility <", value, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityLessThanOrEqualTo(String value) {
            addCriterion("myAbility <=", value, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityLike(String value) {
            addCriterion("myAbility like", value, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityNotLike(String value) {
            addCriterion("myAbility not like", value, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityIn(List<String> values) {
            addCriterion("myAbility in", values, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityNotIn(List<String> values) {
            addCriterion("myAbility not in", values, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityBetween(String value1, String value2) {
            addCriterion("myAbility between", value1, value2, "myability");
            return (Criteria) this;
        }

        public Criteria andMyabilityNotBetween(String value1, String value2) {
            addCriterion("myAbility not between", value1, value2, "myability");
            return (Criteria) this;
        }

        public Criteria andMyspecialityIsNull() {
            addCriterion("mySpeciality is null");
            return (Criteria) this;
        }

        public Criteria andMyspecialityIsNotNull() {
            addCriterion("mySpeciality is not null");
            return (Criteria) this;
        }

        public Criteria andMyspecialityEqualTo(String value) {
            addCriterion("mySpeciality =", value, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityNotEqualTo(String value) {
            addCriterion("mySpeciality <>", value, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityGreaterThan(String value) {
            addCriterion("mySpeciality >", value, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityGreaterThanOrEqualTo(String value) {
            addCriterion("mySpeciality >=", value, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityLessThan(String value) {
            addCriterion("mySpeciality <", value, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityLessThanOrEqualTo(String value) {
            addCriterion("mySpeciality <=", value, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityLike(String value) {
            addCriterion("mySpeciality like", value, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityNotLike(String value) {
            addCriterion("mySpeciality not like", value, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityIn(List<String> values) {
            addCriterion("mySpeciality in", values, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityNotIn(List<String> values) {
            addCriterion("mySpeciality not in", values, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityBetween(String value1, String value2) {
            addCriterion("mySpeciality between", value1, value2, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyspecialityNotBetween(String value1, String value2) {
            addCriterion("mySpeciality not between", value1, value2, "myspeciality");
            return (Criteria) this;
        }

        public Criteria andMyteachIsNull() {
            addCriterion("myTeach is null");
            return (Criteria) this;
        }

        public Criteria andMyteachIsNotNull() {
            addCriterion("myTeach is not null");
            return (Criteria) this;
        }

        public Criteria andMyteachEqualTo(String value) {
            addCriterion("myTeach =", value, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachNotEqualTo(String value) {
            addCriterion("myTeach <>", value, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachGreaterThan(String value) {
            addCriterion("myTeach >", value, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachGreaterThanOrEqualTo(String value) {
            addCriterion("myTeach >=", value, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachLessThan(String value) {
            addCriterion("myTeach <", value, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachLessThanOrEqualTo(String value) {
            addCriterion("myTeach <=", value, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachLike(String value) {
            addCriterion("myTeach like", value, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachNotLike(String value) {
            addCriterion("myTeach not like", value, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachIn(List<String> values) {
            addCriterion("myTeach in", values, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachNotIn(List<String> values) {
            addCriterion("myTeach not in", values, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachBetween(String value1, String value2) {
            addCriterion("myTeach between", value1, value2, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyteachNotBetween(String value1, String value2) {
            addCriterion("myTeach not between", value1, value2, "myteach");
            return (Criteria) this;
        }

        public Criteria andMyideaIsNull() {
            addCriterion("myIdea is null");
            return (Criteria) this;
        }

        public Criteria andMyideaIsNotNull() {
            addCriterion("myIdea is not null");
            return (Criteria) this;
        }

        public Criteria andMyideaEqualTo(String value) {
            addCriterion("myIdea =", value, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaNotEqualTo(String value) {
            addCriterion("myIdea <>", value, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaGreaterThan(String value) {
            addCriterion("myIdea >", value, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaGreaterThanOrEqualTo(String value) {
            addCriterion("myIdea >=", value, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaLessThan(String value) {
            addCriterion("myIdea <", value, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaLessThanOrEqualTo(String value) {
            addCriterion("myIdea <=", value, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaLike(String value) {
            addCriterion("myIdea like", value, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaNotLike(String value) {
            addCriterion("myIdea not like", value, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaIn(List<String> values) {
            addCriterion("myIdea in", values, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaNotIn(List<String> values) {
            addCriterion("myIdea not in", values, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaBetween(String value1, String value2) {
            addCriterion("myIdea between", value1, value2, "myidea");
            return (Criteria) this;
        }

        public Criteria andMyideaNotBetween(String value1, String value2) {
            addCriterion("myIdea not between", value1, value2, "myidea");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andEmpdescIsNull() {
            addCriterion("empDesc is null");
            return (Criteria) this;
        }

        public Criteria andEmpdescIsNotNull() {
            addCriterion("empDesc is not null");
            return (Criteria) this;
        }

        public Criteria andEmpdescEqualTo(String value) {
            addCriterion("empDesc =", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescNotEqualTo(String value) {
            addCriterion("empDesc <>", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescGreaterThan(String value) {
            addCriterion("empDesc >", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescGreaterThanOrEqualTo(String value) {
            addCriterion("empDesc >=", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescLessThan(String value) {
            addCriterion("empDesc <", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescLessThanOrEqualTo(String value) {
            addCriterion("empDesc <=", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescLike(String value) {
            addCriterion("empDesc like", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescNotLike(String value) {
            addCriterion("empDesc not like", value, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescIn(List<String> values) {
            addCriterion("empDesc in", values, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescNotIn(List<String> values) {
            addCriterion("empDesc not in", values, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescBetween(String value1, String value2) {
            addCriterion("empDesc between", value1, value2, "empdesc");
            return (Criteria) this;
        }

        public Criteria andEmpdescNotBetween(String value1, String value2) {
            addCriterion("empDesc not between", value1, value2, "empdesc");
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