package com.example.fuproject.activity.ui.dashboard.activity;

public class TrainClassBean {
    private String name;
    private String doThings;
    private String money;
    private String place;
    private String doTime;
    private String releaseTime;
    private String education;

    public String getRecommendedStar() {
        return recommendedStar;
    }

    public void setRecommendedStar(String recommendedStar) {
        this.recommendedStar = recommendedStar;
    }

    private String recommendedStar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getDoThings() {
        return doThings;
    }

    public void setDoThings(String doThings) {
        this.doThings = doThings;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDoTime() {
        return doTime;
    }

    public void setDoTime(String doTime) {
        this.doTime = doTime;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public TrainClassBean(String name, String education, String doThings, String money, String place, String doTime, String releaseTime, String recommendedStar) {
        this.name = name;
        this.doThings = doThings;
        this.money = money;
        this.place = place;
        this.doTime = doTime;
        this.releaseTime = releaseTime;
        this.education = education;
        this.recommendedStar = recommendedStar;
    }
}
