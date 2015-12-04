package com.phantom.model;

import com.phantom.entity.Restaurants;

import java.util.List;

/**
 * Created by vishal on 14/11/15.
 */
public interface RestaurantDao {

    String addRestaurants(Restaurants restaurants);

    String updateRestaurantReview(Restaurants restaurant);

    String updateRestaurantRatings(Restaurants restaurant);

    String addNewReviewForRestaurant(Restaurants restaurant);

    List<Restaurants> getAllRestaurants();

    List<Restaurants> getRestaurantsByLocation(String location,Double rating);

    List<Restaurants> getRestaurantsByAttributes(List<String> attributeList);

    List<Restaurants> getRestaurantsByAttriNLoc(String Location ,List<String> attributeList);

    Restaurants updateRatingAndReview(Restaurants restaurants);




}
