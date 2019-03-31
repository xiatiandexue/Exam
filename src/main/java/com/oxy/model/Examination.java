package com.oxy.model;

import java.util.Date;

public class Examination {
    private Integer examinationid;

    private Integer paperid;

    private String subject;

    private Date begintime;

    private Integer duration;

    private String name;

    private String createuser;

    public Integer getExaminationid() {
        return examinationid;
    }

    public void setExaminationid(Integer examinationid) {
        this.examinationid = examinationid;
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

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }
}