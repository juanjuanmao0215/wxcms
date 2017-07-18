package cn.com.lzt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysmenuCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TSysmenuCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andMenunameIsNull() {
            addCriterion("menuname is null");
            return (Criteria) this;
        }

        public Criteria andMenunameIsNotNull() {
            addCriterion("menuname is not null");
            return (Criteria) this;
        }

        public Criteria andMenunameEqualTo(String value) {
            addCriterion("menuname =", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotEqualTo(String value) {
            addCriterion("menuname <>", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThan(String value) {
            addCriterion("menuname >", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThanOrEqualTo(String value) {
            addCriterion("menuname >=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThan(String value) {
            addCriterion("menuname <", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThanOrEqualTo(String value) {
            addCriterion("menuname <=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLike(String value) {
            addCriterion("menuname like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotLike(String value) {
            addCriterion("menuname not like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameIn(List<String> values) {
            addCriterion("menuname in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotIn(List<String> values) {
            addCriterion("menuname not in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameBetween(String value1, String value2) {
            addCriterion("menuname between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotBetween(String value1, String value2) {
            addCriterion("menuname not between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenuurlIsNull() {
            addCriterion("menuurl is null");
            return (Criteria) this;
        }

        public Criteria andMenuurlIsNotNull() {
            addCriterion("menuurl is not null");
            return (Criteria) this;
        }

        public Criteria andMenuurlEqualTo(String value) {
            addCriterion("menuurl =", value, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlNotEqualTo(String value) {
            addCriterion("menuurl <>", value, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlGreaterThan(String value) {
            addCriterion("menuurl >", value, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlGreaterThanOrEqualTo(String value) {
            addCriterion("menuurl >=", value, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlLessThan(String value) {
            addCriterion("menuurl <", value, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlLessThanOrEqualTo(String value) {
            addCriterion("menuurl <=", value, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlLike(String value) {
            addCriterion("menuurl like", value, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlNotLike(String value) {
            addCriterion("menuurl not like", value, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlIn(List<String> values) {
            addCriterion("menuurl in", values, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlNotIn(List<String> values) {
            addCriterion("menuurl not in", values, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlBetween(String value1, String value2) {
            addCriterion("menuurl between", value1, value2, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuurlNotBetween(String value1, String value2) {
            addCriterion("menuurl not between", value1, value2, "menuurl");
            return (Criteria) this;
        }

        public Criteria andMenuimgIsNull() {
            addCriterion("menuimg is null");
            return (Criteria) this;
        }

        public Criteria andMenuimgIsNotNull() {
            addCriterion("menuimg is not null");
            return (Criteria) this;
        }

        public Criteria andMenuimgEqualTo(String value) {
            addCriterion("menuimg =", value, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgNotEqualTo(String value) {
            addCriterion("menuimg <>", value, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgGreaterThan(String value) {
            addCriterion("menuimg >", value, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgGreaterThanOrEqualTo(String value) {
            addCriterion("menuimg >=", value, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgLessThan(String value) {
            addCriterion("menuimg <", value, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgLessThanOrEqualTo(String value) {
            addCriterion("menuimg <=", value, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgLike(String value) {
            addCriterion("menuimg like", value, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgNotLike(String value) {
            addCriterion("menuimg not like", value, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgIn(List<String> values) {
            addCriterion("menuimg in", values, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgNotIn(List<String> values) {
            addCriterion("menuimg not in", values, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgBetween(String value1, String value2) {
            addCriterion("menuimg between", value1, value2, "menuimg");
            return (Criteria) this;
        }

        public Criteria andMenuimgNotBetween(String value1, String value2) {
            addCriterion("menuimg not between", value1, value2, "menuimg");
            return (Criteria) this;
        }

        public Criteria andSortnumIsNull() {
            addCriterion("sortnum is null");
            return (Criteria) this;
        }

        public Criteria andSortnumIsNotNull() {
            addCriterion("sortnum is not null");
            return (Criteria) this;
        }

        public Criteria andSortnumEqualTo(Integer value) {
            addCriterion("sortnum =", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumNotEqualTo(Integer value) {
            addCriterion("sortnum <>", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumGreaterThan(Integer value) {
            addCriterion("sortnum >", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortnum >=", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumLessThan(Integer value) {
            addCriterion("sortnum <", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumLessThanOrEqualTo(Integer value) {
            addCriterion("sortnum <=", value, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumIn(List<Integer> values) {
            addCriterion("sortnum in", values, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumNotIn(List<Integer> values) {
            addCriterion("sortnum not in", values, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumBetween(Integer value1, Integer value2) {
            addCriterion("sortnum between", value1, value2, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortnumNotBetween(Integer value1, Integer value2) {
            addCriterion("sortnum not between", value1, value2, "sortnum");
            return (Criteria) this;
        }

        public Criteria andSortlevelIsNull() {
            addCriterion("sortlevel is null");
            return (Criteria) this;
        }

        public Criteria andSortlevelIsNotNull() {
            addCriterion("sortlevel is not null");
            return (Criteria) this;
        }

        public Criteria andSortlevelEqualTo(String value) {
            addCriterion("sortlevel =", value, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelNotEqualTo(String value) {
            addCriterion("sortlevel <>", value, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelGreaterThan(String value) {
            addCriterion("sortlevel >", value, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelGreaterThanOrEqualTo(String value) {
            addCriterion("sortlevel >=", value, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelLessThan(String value) {
            addCriterion("sortlevel <", value, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelLessThanOrEqualTo(String value) {
            addCriterion("sortlevel <=", value, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelLike(String value) {
            addCriterion("sortlevel like", value, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelNotLike(String value) {
            addCriterion("sortlevel not like", value, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelIn(List<String> values) {
            addCriterion("sortlevel in", values, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelNotIn(List<String> values) {
            addCriterion("sortlevel not in", values, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelBetween(String value1, String value2) {
            addCriterion("sortlevel between", value1, value2, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andSortlevelNotBetween(String value1, String value2) {
            addCriterion("sortlevel not between", value1, value2, "sortlevel");
            return (Criteria) this;
        }

        public Criteria andIsusedIsNull() {
            addCriterion("isused is null");
            return (Criteria) this;
        }

        public Criteria andIsusedIsNotNull() {
            addCriterion("isused is not null");
            return (Criteria) this;
        }

        public Criteria andIsusedEqualTo(Integer value) {
            addCriterion("isused =", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotEqualTo(Integer value) {
            addCriterion("isused <>", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedGreaterThan(Integer value) {
            addCriterion("isused >", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedGreaterThanOrEqualTo(Integer value) {
            addCriterion("isused >=", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedLessThan(Integer value) {
            addCriterion("isused <", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedLessThanOrEqualTo(Integer value) {
            addCriterion("isused <=", value, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedIn(List<Integer> values) {
            addCriterion("isused in", values, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotIn(List<Integer> values) {
            addCriterion("isused not in", values, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedBetween(Integer value1, Integer value2) {
            addCriterion("isused between", value1, value2, "isused");
            return (Criteria) this;
        }

        public Criteria andIsusedNotBetween(Integer value1, Integer value2) {
            addCriterion("isused not between", value1, value2, "isused");
            return (Criteria) this;
        }

        public Criteria andMenulevelIsNull() {
            addCriterion("menulevel is null");
            return (Criteria) this;
        }

        public Criteria andMenulevelIsNotNull() {
            addCriterion("menulevel is not null");
            return (Criteria) this;
        }

        public Criteria andMenulevelEqualTo(String value) {
            addCriterion("menulevel =", value, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelNotEqualTo(String value) {
            addCriterion("menulevel <>", value, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelGreaterThan(String value) {
            addCriterion("menulevel >", value, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelGreaterThanOrEqualTo(String value) {
            addCriterion("menulevel >=", value, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelLessThan(String value) {
            addCriterion("menulevel <", value, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelLessThanOrEqualTo(String value) {
            addCriterion("menulevel <=", value, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelLike(String value) {
            addCriterion("menulevel like", value, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelNotLike(String value) {
            addCriterion("menulevel not like", value, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelIn(List<String> values) {
            addCriterion("menulevel in", values, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelNotIn(List<String> values) {
            addCriterion("menulevel not in", values, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelBetween(String value1, String value2) {
            addCriterion("menulevel between", value1, value2, "menulevel");
            return (Criteria) this;
        }

        public Criteria andMenulevelNotBetween(String value1, String value2) {
            addCriterion("menulevel not between", value1, value2, "menulevel");
            return (Criteria) this;
        }

        public Criteria andParentflagIsNull() {
            addCriterion("parentflag is null");
            return (Criteria) this;
        }

        public Criteria andParentflagIsNotNull() {
            addCriterion("parentflag is not null");
            return (Criteria) this;
        }

        public Criteria andParentflagEqualTo(Integer value) {
            addCriterion("parentflag =", value, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagNotEqualTo(Integer value) {
            addCriterion("parentflag <>", value, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagGreaterThan(Integer value) {
            addCriterion("parentflag >", value, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentflag >=", value, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagLessThan(Integer value) {
            addCriterion("parentflag <", value, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagLessThanOrEqualTo(Integer value) {
            addCriterion("parentflag <=", value, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagIn(List<Integer> values) {
            addCriterion("parentflag in", values, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagNotIn(List<Integer> values) {
            addCriterion("parentflag not in", values, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagBetween(Integer value1, Integer value2) {
            addCriterion("parentflag between", value1, value2, "parentflag");
            return (Criteria) this;
        }

        public Criteria andParentflagNotBetween(Integer value1, Integer value2) {
            addCriterion("parentflag not between", value1, value2, "parentflag");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCustomCriteria(String value) {
            addCriterion( "("+ value +")" );
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