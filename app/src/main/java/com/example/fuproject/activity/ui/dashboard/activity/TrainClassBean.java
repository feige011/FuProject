package com.example.fuproject.activity.ui.dashboard.activity;

public class TrainClassBean {
    private String name;
    private String mechanism;
    private int peopleNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public TrainClassBean(String name, String mechanism, int peopleNumber) {
        this.name = name;
        this.mechanism = mechanism;
        this.peopleNumber = peopleNumber;
    }
}
