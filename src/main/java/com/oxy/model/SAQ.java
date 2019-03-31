package com.oxy.model;

public class SAQ {
    private Integer saqid;

    private String saq;

    private Integer score;

    private String subject;

    private String chapter;

    private Integer difficulty;

    private String createuser;

    public Integer getSaqid() {
        return saqid;
    }

    public void setSaqid(Integer saqid) {
        this.saqid = saqid;
    }

    public String getSaq() {
        return saq;
    }

    public void setSaq(String saq) {
        this.saq = saq == null ? null : saq.trim();
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

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter == null ? null : chapter.trim();
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }
}