package com.oxy.model;

public class Score {
    private String name;

    private Integer paperid;

    private String subject;

    private String selectanswer;

    private String saqanswer;

    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getSelectanswer() {
        return selectanswer;
    }

    public void setSelectanswer(String selectanswer) {
        this.selectanswer = selectanswer == null ? null : selectanswer.trim();
    }

    public String getSaqanswer() {
        return saqanswer;
    }

    public void setSaqanswer(String saqanswer) {
        this.saqanswer = saqanswer == null ? null : saqanswer.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}