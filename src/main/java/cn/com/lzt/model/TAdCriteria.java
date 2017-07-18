package cn.com.lzt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAdCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TAdCriteria() {
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

        public Criteria andImgurlIsNull() {
            addCriterion("imgurl is null");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNotNull() {
            addCriterion("imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andImgurlEqualTo(String value) {
            addCriterion("imgurl =", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotEqualTo(String value) {
            addCriterion("imgurl <>", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThan(String value) {
            addCriterion("imgurl >", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgurl >=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThan(String value) {
            addCriterion("imgurl <", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThanOrEqualTo(String value) {
            addCriterion("imgurl <=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLike(String value) {
            addCriterion("imgurl like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotLike(String value) {
            addCriterion("imgurl not like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlIn(List<String> values) {
            addCriterion("imgurl in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotIn(List<String> values) {
            addCriterion("imgurl not in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlBetween(String value1, String value2) {
            addCriterion("imgurl between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotBetween(String value1, String value2) {
            addCriterion("imgurl not between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andShowurlIsNull() {
            addCriterion("showurl is null");
            return (Criteria) this;
        }

        public Criteria andShowurlIsNotNull() {
            addCriterion("showurl is not null");
            return (Criteria) this;
        }

        public Criteria andShowurlEqualTo(String value) {
            addCriterion("showurl =", value, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlNotEqualTo(String value) {
            addCriterion("showurl <>", value, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlGreaterThan(String value) {
            addCriterion("showurl >", value, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlGreaterThanOrEqualTo(String value) {
            addCriterion("showurl >=", value, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlLessThan(String value) {
            addCriterion("showurl <", value, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlLessThanOrEqualTo(String value) {
            addCriterion("showurl <=", value, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlLike(String value) {
            addCriterion("showurl like", value, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlNotLike(String value) {
            addCriterion("showurl not like", value, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlIn(List<String> values) {
            addCriterion("showurl in", values, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlNotIn(List<String> values) {
            addCriterion("showurl not in", values, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlBetween(String value1, String value2) {
            addCriterion("showurl between", value1, value2, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowurlNotBetween(String value1, String value2) {
            addCriterion("showurl not between", value1, value2, "showurl");
            return (Criteria) this;
        }

        public Criteria andShowtitleIsNull() {
            addCriterion("showtitle is null");
            return (Criteria) this;
        }

        public Criteria andShowtitleIsNotNull() {
            addCriterion("showtitle is not null");
            return (Criteria) this;
        }

        public Criteria andShowtitleEqualTo(String value) {
            addCriterion("showtitle =", value, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleNotEqualTo(String value) {
            addCriterion("showtitle <>", value, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleGreaterThan(String value) {
            addCriterion("showtitle >", value, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleGreaterThanOrEqualTo(String value) {
            addCriterion("showtitle >=", value, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleLessThan(String value) {
            addCriterion("showtitle <", value, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleLessThanOrEqualTo(String value) {
            addCriterion("showtitle <=", value, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleLike(String value) {
            addCriterion("showtitle like", value, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleNotLike(String value) {
            addCriterion("showtitle not like", value, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleIn(List<String> values) {
            addCriterion("showtitle in", values, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleNotIn(List<String> values) {
            addCriterion("showtitle not in", values, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleBetween(String value1, String value2) {
            addCriterion("showtitle between", value1, value2, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowtitleNotBetween(String value1, String value2) {
            addCriterion("showtitle not between", value1, value2, "showtitle");
            return (Criteria) this;
        }

        public Criteria andShowcontentIsNull() {
            addCriterion("showcontent is null");
            return (Criteria) this;
        }

        public Criteria andShowcontentIsNotNull() {
            addCriterion("showcontent is not null");
            return (Criteria) this;
        }

        public Criteria andShowcontentEqualTo(String value) {
            addCriterion("showcontent =", value, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentNotEqualTo(String value) {
            addCriterion("showcontent <>", value, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentGreaterThan(String value) {
            addCriterion("showcontent >", value, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentGreaterThanOrEqualTo(String value) {
            addCriterion("showcontent >=", value, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentLessThan(String value) {
            addCriterion("showcontent <", value, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentLessThanOrEqualTo(String value) {
            addCriterion("showcontent <=", value, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentLike(String value) {
            addCriterion("showcontent like", value, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentNotLike(String value) {
            addCriterion("showcontent not like", value, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentIn(List<String> values) {
            addCriterion("showcontent in", values, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentNotIn(List<String> values) {
            addCriterion("showcontent not in", values, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentBetween(String value1, String value2) {
            addCriterion("showcontent between", value1, value2, "showcontent");
            return (Criteria) this;
        }

        public Criteria andShowcontentNotBetween(String value1, String value2) {
            addCriterion("showcontent not between", value1, value2, "showcontent");
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

        public Criteria andIntimeIsNull() {
            addCriterion("intime is null");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNotNull() {
            addCriterion("intime is not null");
            return (Criteria) this;
        }

        public Criteria andIntimeEqualTo(Date value) {
            addCriterion("intime =", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotEqualTo(Date value) {
            addCriterion("intime <>", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThan(Date value) {
            addCriterion("intime >", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("intime >=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThan(Date value) {
            addCriterion("intime <", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThanOrEqualTo(Date value) {
            addCriterion("intime <=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeIn(List<Date> values) {
            addCriterion("intime in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotIn(List<Date> values) {
            addCriterion("intime not in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeBetween(Date value1, Date value2) {
            addCriterion("intime between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotBetween(Date value1, Date value2) {
            addCriterion("intime not between", value1, value2, "intime");
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