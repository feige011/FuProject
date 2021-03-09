package com.example.fuproject.activity.ui.home.activity;

public class PeoplePastWorkEvaluateBean {
    private int startTime;
    private int endTime;
    private String company;
    private String workEvaluate;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkEvaluate() {
        return workEvaluate;
    }

    public void setWorkEvaluate(String workEvaluate) {
        this.workEvaluate = workEvaluate;
    }

    public PeoplePastWorkEvaluateBean(int startTime, int endTime, String company, String workEvaluate) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.company = company;
        this.workEvaluate = workEvaluate;
    }
}
