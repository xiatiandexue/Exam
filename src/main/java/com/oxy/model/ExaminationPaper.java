package com.oxy.model;

public class ExaminationPaper {
    private Integer paperid;

    private String questionids;

    private String name;

    private String saqids;

    private Integer selectnum;

    private Integer saqnum;

    private Integer one;

    private Integer two;

    private Integer three;

    private Integer score;

    private String subject;

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getQuestionids() {
        return questionids;
    }

    public void setQuestionids(String questionids) {
        this.questionids = questionids == null ? null : questionids.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSaqids() {
        return saqids;
    }

    public void setSaqids(String saqids) {
        this.saqids = saqids == null ? null : saqids.trim();
    }

    public Integer getSelectnum() {
        return selectnum;
    }

    public void setSelectnum(Integer selectnum) {
        this.selectnum = selectnum;
    }

    public Integer getSaqnum() {
        return saqnum;
    }

    public void setSaqnum(Integer saqnum) {
        this.saqnum = saqnum;
    }

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }

    public Integer getThree() {
        return three;
    }

    public void setThree(Integer three) {
        this.three = three;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }
}