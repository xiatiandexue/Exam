package com.oxy.model;

import java.util.ArrayList;
import java.util.List;

public class ExaminationPaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExaminationPaperExample() {
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

        public Criteria andPaperidIsNull() {
            addCriterion("PaperID is null");
            return (Criteria) this;
        }

        public Criteria andPaperidIsNotNull() {
            addCriterion("PaperID is not null");
            return (Criteria) this;
        }

        public Criteria andPaperidEqualTo(Integer value) {
            addCriterion("PaperID =", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotEqualTo(Integer value) {
            addCriterion("PaperID <>", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThan(Integer value) {
            addCriterion("PaperID >", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PaperID >=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThan(Integer value) {
            addCriterion("PaperID <", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThanOrEqualTo(Integer value) {
            addCriterion("PaperID <=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidIn(List<Integer> values) {
            addCriterion("PaperID in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotIn(List<Integer> values) {
            addCriterion("PaperID not in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidBetween(Integer value1, Integer value2) {
            addCriterion("PaperID between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotBetween(Integer value1, Integer value2) {
            addCriterion("PaperID not between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andQuestionidsIsNull() {
            addCriterion("QuestionIds is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidsIsNotNull() {
            addCriterion("QuestionIds is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidsEqualTo(String value) {
            addCriterion("QuestionIds =", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsNotEqualTo(String value) {
            addCriterion("QuestionIds <>", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsGreaterThan(String value) {
            addCriterion("QuestionIds >", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsGreaterThanOrEqualTo(String value) {
            addCriterion("QuestionIds >=", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsLessThan(String value) {
            addCriterion("QuestionIds <", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsLessThanOrEqualTo(String value) {
            addCriterion("QuestionIds <=", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsLike(String value) {
            addCriterion("QuestionIds like", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsNotLike(String value) {
            addCriterion("QuestionIds not like", value, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsIn(List<String> values) {
            addCriterion("QuestionIds in", values, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsNotIn(List<String> values) {
            addCriterion("QuestionIds not in", values, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsBetween(String value1, String value2) {
            addCriterion("QuestionIds between", value1, value2, "questionids");
            return (Criteria) this;
        }

        public Criteria andQuestionidsNotBetween(String value1, String value2) {
            addCriterion("QuestionIds not between", value1, value2, "questionids");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSaqidsIsNull() {
            addCriterion("SAQIds is null");
            return (Criteria) this;
        }

        public Criteria andSaqidsIsNotNull() {
            addCriterion("SAQIds is not null");
            return (Criteria) this;
        }

        public Criteria andSaqidsEqualTo(String value) {
            addCriterion("SAQIds =", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsNotEqualTo(String value) {
            addCriterion("SAQIds <>", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsGreaterThan(String value) {
            addCriterion("SAQIds >", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsGreaterThanOrEqualTo(String value) {
            addCriterion("SAQIds >=", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsLessThan(String value) {
            addCriterion("SAQIds <", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsLessThanOrEqualTo(String value) {
            addCriterion("SAQIds <=", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsLike(String value) {
            addCriterion("SAQIds like", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsNotLike(String value) {
            addCriterion("SAQIds not like", value, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsIn(List<String> values) {
            addCriterion("SAQIds in", values, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsNotIn(List<String> values) {
            addCriterion("SAQIds not in", values, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsBetween(String value1, String value2) {
            addCriterion("SAQIds between", value1, value2, "saqids");
            return (Criteria) this;
        }

        public Criteria andSaqidsNotBetween(String value1, String value2) {
            addCriterion("SAQIds not between", value1, value2, "saqids");
            return (Criteria) this;
        }

        public Criteria andSelectnumIsNull() {
            addCriterion("SelectNum is null");
            return (Criteria) this;
        }

        public Criteria andSelectnumIsNotNull() {
            addCriterion("SelectNum is not null");
            return (Criteria) this;
        }

        public Criteria andSelectnumEqualTo(Integer value) {
            addCriterion("SelectNum =", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumNotEqualTo(Integer value) {
            addCriterion("SelectNum <>", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumGreaterThan(Integer value) {
            addCriterion("SelectNum >", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SelectNum >=", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumLessThan(Integer value) {
            addCriterion("SelectNum <", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumLessThanOrEqualTo(Integer value) {
            addCriterion("SelectNum <=", value, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumIn(List<Integer> values) {
            addCriterion("SelectNum in", values, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumNotIn(List<Integer> values) {
            addCriterion("SelectNum not in", values, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumBetween(Integer value1, Integer value2) {
            addCriterion("SelectNum between", value1, value2, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSelectnumNotBetween(Integer value1, Integer value2) {
            addCriterion("SelectNum not between", value1, value2, "selectnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumIsNull() {
            addCriterion("SAQNum is null");
            return (Criteria) this;
        }

        public Criteria andSaqnumIsNotNull() {
            addCriterion("SAQNum is not null");
            return (Criteria) this;
        }

        public Criteria andSaqnumEqualTo(Integer value) {
            addCriterion("SAQNum =", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumNotEqualTo(Integer value) {
            addCriterion("SAQNum <>", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumGreaterThan(Integer value) {
            addCriterion("SAQNum >", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SAQNum >=", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumLessThan(Integer value) {
            addCriterion("SAQNum <", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumLessThanOrEqualTo(Integer value) {
            addCriterion("SAQNum <=", value, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumIn(List<Integer> values) {
            addCriterion("SAQNum in", values, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumNotIn(List<Integer> values) {
            addCriterion("SAQNum not in", values, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumBetween(Integer value1, Integer value2) {
            addCriterion("SAQNum between", value1, value2, "saqnum");
            return (Criteria) this;
        }

        public Criteria andSaqnumNotBetween(Integer value1, Integer value2) {
            addCriterion("SAQNum not between", value1, value2, "saqnum");
            return (Criteria) this;
        }

        public Criteria andOneIsNull() {
            addCriterion("One is null");
            return (Criteria) this;
        }

        public Criteria andOneIsNotNull() {
            addCriterion("One is not null");
            return (Criteria) this;
        }

        public Criteria andOneEqualTo(Integer value) {
            addCriterion("One =", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotEqualTo(Integer value) {
            addCriterion("One <>", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneGreaterThan(Integer value) {
            addCriterion("One >", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneGreaterThanOrEqualTo(Integer value) {
            addCriterion("One >=", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLessThan(Integer value) {
            addCriterion("One <", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLessThanOrEqualTo(Integer value) {
            addCriterion("One <=", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneIn(List<Integer> values) {
            addCriterion("One in", values, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotIn(List<Integer> values) {
            addCriterion("One not in", values, "one");
            return (Criteria) this;
        }

        public Criteria andOneBetween(Integer value1, Integer value2) {
            addCriterion("One between", value1, value2, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotBetween(Integer value1, Integer value2) {
            addCriterion("One not between", value1, value2, "one");
            return (Criteria) this;
        }

        public Criteria andTwoIsNull() {
            addCriterion("Two is null");
            return (Criteria) this;
        }

        public Criteria andTwoIsNotNull() {
            addCriterion("Two is not null");
            return (Criteria) this;
        }

        public Criteria andTwoEqualTo(Integer value) {
            addCriterion("Two =", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotEqualTo(Integer value) {
            addCriterion("Two <>", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoGreaterThan(Integer value) {
            addCriterion("Two >", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Two >=", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLessThan(Integer value) {
            addCriterion("Two <", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLessThanOrEqualTo(Integer value) {
            addCriterion("Two <=", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoIn(List<Integer> values) {
            addCriterion("Two in", values, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotIn(List<Integer> values) {
            addCriterion("Two not in", values, "two");
            return (Criteria) this;
        }

        public Criteria andTwoBetween(Integer value1, Integer value2) {
            addCriterion("Two between", value1, value2, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotBetween(Integer value1, Integer value2) {
            addCriterion("Two not between", value1, value2, "two");
            return (Criteria) this;
        }

        public Criteria andThreeIsNull() {
            addCriterion("Three is null");
            return (Criteria) this;
        }

        public Criteria andThreeIsNotNull() {
            addCriterion("Three is not null");
            return (Criteria) this;
        }

        public Criteria andThreeEqualTo(Integer value) {
            addCriterion("Three =", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotEqualTo(Integer value) {
            addCriterion("Three <>", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeGreaterThan(Integer value) {
            addCriterion("Three >", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Three >=", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLessThan(Integer value) {
            addCriterion("Three <", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLessThanOrEqualTo(Integer value) {
            addCriterion("Three <=", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeIn(List<Integer> values) {
            addCriterion("Three in", values, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotIn(List<Integer> values) {
            addCriterion("Three not in", values, "three");
            return (Criteria) this;
        }

        public Criteria andThreeBetween(Integer value1, Integer value2) {
            addCriterion("Three between", value1, value2, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotBetween(Integer value1, Integer value2) {
            addCriterion("Three not between", value1, value2, "three");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("Score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("Score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("Score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("Score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("Score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("Score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("Score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("Score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("Score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("Score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("Score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("Score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("Subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("Subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("Subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("Subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("Subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("Subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("Subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("Subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("Subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("Subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("Subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("Subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("Subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("Subject not between", value1, value2, "subject");
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