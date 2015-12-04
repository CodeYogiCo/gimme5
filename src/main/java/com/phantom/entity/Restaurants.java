package com.phantom.entity;

import java.util.Date;

/**
 * Created by vishal on 14/11/15.
 */
public class Restaurants {

    private String name;

    private String user_email;

    private String location;

    private String speciality;

    private Float valueForMoney_Rating;

    private Float food_Rating;

    private Float service_Rating;

    private Float ambience_Rating;

    private Float quality_Rating;

    private Float userExp;

    private String userReview;

    private Date postedOn;

    public Restaurants(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Float getValueForMoney_Rating() {
        return valueForMoney_Rating;
    }

    public void setValueForMoney_Rating(Float valueForMoney_Rating) {
        this.valueForMoney_Rating = valueForMoney_Rating;
    }

    public Float getFood_Rating() {
        return food_Rating;
    }

    public void setFood_Rating(Float food_Rating) {
        this.food_Rating = food_Rating;
    }

    public Float getService_Rating() {
        return service_Rating;
    }

    public void setService_Rating(Float service_Rating) {
        this.service_Rating = service_Rating;
    }

    public Float getAmbience_Rating() {
        return ambience_Rating;
    }

    public void setAmbience_Rating(Float ambience_Rating) {
        this.ambience_Rating = ambience_Rating;
    }

    public Float getQuality_Rating() {
        return quality_Rating;
    }

    public void setQuality_Rating(Float quality_Rating) {
        this.quality_Rating = quality_Rating;
    }

    public Float getUserExp() {
        return userExp;
    }

    public void setUserExp(Float userExp) {
        this.userExp = userExp;
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "name='" + name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", location='" + location + '\'' +
                ", speciality='" + speciality + '\'' +
                ", valueForMoney_Rating=" + valueForMoney_Rating +
                ", food_Rating=" + food_Rating +
                ", service_Rating=" + service_Rating +
                ", ambience_Rating=" + ambience_Rating +
                ", quality_Rating=" + quality_Rating +
                ", userExp=" + userExp +
                ", userReview='" + userReview + '\'' +
                ", postedOn=" + postedOn +
                '}';
    }
}
