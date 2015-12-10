package com.phantom.entity;

import java.util.Date;

/**
 * Created by vishal on 14/11/15.
 */
public class Restaurants {

    private String restraurant_name;

    private String user_email;

    private String restraurant_location;

    private String restraurant_speciality;

    private Float value_for_money;

    private Float food;

    private Float service;

    private Float ambience;

    private Float quality;

    private Float user_exp;

    private String user_review;

    private Date postedOn;

    public Restaurants(){}


    public Restaurants(String restraurant_name, String restraurant_location) {
        this.restraurant_name = restraurant_name;
        this.restraurant_location = restraurant_location;
    }

    public String getRestraurant_name() {
        return restraurant_name;
    }

    public void setRestraurant_name(String restraurant_name) {
        this.restraurant_name = restraurant_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getRestraurant_location() {
        return restraurant_location;
    }

    public void setRestraurant_location(String restraurant_location) {
        this.restraurant_location = restraurant_location;
    }

    public String getRestraurant_speciality() {
        return restraurant_speciality;
    }

    public void setRestraurant_speciality(String restraurant_speciality) {
        this.restraurant_speciality = restraurant_speciality;
    }

    public Float getValue_for_money() {
        return value_for_money;
    }

    public void setValue_for_money(Float value_for_money) {
        this.value_for_money = value_for_money;
    }

    public Float getFood() {
        return food;
    }

    public void setFood(Float food) {
        this.food = food;
    }

    public Float getService() {
        return service;
    }

    public void setService(Float service) {
        this.service = service;
    }

    public Float getAmbience() {
        return ambience;
    }

    public void setAmbience(Float ambience) {
        this.ambience = ambience;
    }

    public Float getQuality() {
        return quality;
    }

    public void setQuality(Float quality) {
        this.quality = quality;
    }

    public Float getUser_exp() {
        return user_exp;
    }

    public void setUser_exp(Float user_exp) {
        this.user_exp = user_exp;
    }

    public String getUser_review() {
        return user_review;
    }

    public void setUser_review(String user_review) {
        this.user_review = user_review;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "restraurant_name='" + restraurant_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", restraurant_location='" + restraurant_location + '\'' +
                ", restraurant_speciality='" + restraurant_speciality + '\'' +
                ", value_for_money=" + value_for_money +
                ", food=" + food +
                ", service=" + service +
                ", ambience=" + ambience +
                ", quality=" + quality +
                ", user_exp=" + user_exp +
                ", user_review='" + user_review + '\'' +
                ", postedOn=" + postedOn +
                '}';
    }
}
