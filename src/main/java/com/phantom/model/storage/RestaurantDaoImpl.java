package com.phantom.model.storage;

import com.phantom.entity.Restaurants;
import com.phantom.model.RestaurantConstants;
import com.phantom.model.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

/**
 * Created by vishal on 14/11/15.
 */

@Component
public class RestaurantDaoImpl implements RestaurantDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SPACE_CHAR = " ";
    private final String AND_CHAR= SPACE_CHAR+"and"+SPACE_CHAR;
    private final String COMMA_CHAR= ","+SPACE_CHAR;

    @Override
    public String addRestaurants(Restaurants restaurants) {
        StringBuilder status = new StringBuilder();
        String columns = RestaurantConstants.RESTRAURANT_NAME +COMMA_CHAR+
                RestaurantConstants.RESTRAURANT_LOCATION + COMMA_CHAR +
                RestaurantConstants.USER_EMAIL + COMMA_CHAR +
                RestaurantConstants.RESTRAURANT_SPECIALITY + COMMA_CHAR+
                RestaurantConstants.VALUE_FOR_MONEY + COMMA_CHAR +
                RestaurantConstants.FOOD + COMMA_CHAR +
                RestaurantConstants.SERVICE + COMMA_CHAR +
                RestaurantConstants.AMBIENCE + COMMA_CHAR+
                RestaurantConstants.QUALITY + COMMA_CHAR +
                RestaurantConstants.USER_EXP + COMMA_CHAR +
                RestaurantConstants.USER_REVIEW;
        String query = "INSERT INTO restraurants("+ columns+ ") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(query, new Object[]{restaurants.getRestraurant_name(),restaurants.getRestraurant_location(),
                    restaurants.getUser_email() ,
                    restaurants.getRestraurant_speciality(),
                    restaurants.getValue_for_money(), restaurants.getFood(),
                    restaurants.getService(), restaurants.getAmbience(), restaurants.getQuality(),
                    restaurants.getUser_exp(), restaurants.getUser_review()});
            status.append("Success Restaurant added");
        }catch(Exception exception){
            System.out.println(exception);
            status.append("Failed to add restaurant");
        }
        return status.toString();
    }


    @Override
    public String updateRestaurantReview(Restaurants restaurant) {
        StringBuilder status = new StringBuilder();

        String query = "UPDATE restraurant SET user_review="+restaurant.getUser_review()+
                " WHERE "+RestaurantConstants.RESTRAURANT_NAME+"="+ restaurant.getRestraurant_name() +AND_CHAR+RestaurantConstants.RESTRAURANT_LOCATION+"="+restaurant.getRestraurant_location()+
                  AND_CHAR+"user_email="+ restaurant.getUser_email();
        try {
            jdbcTemplate.update(query, new Object[]{restaurant.getUser_review()});
            status.append("Success Restaurant updated");
        }catch(Exception exception){
            System.out.println(exception);
            status.append("Failed to update restaurant");
        }
        return status.toString();

    }

    @Override
    public String updateRestaurantRatings(Restaurants restaurant) {
        StringBuilder status = new StringBuilder();

        StringBuilder query = new StringBuilder("UPDATE gimmeFive.restraurant SET ");
         if(restaurant.getValue_for_money() >0) {
           query.append("value_for_money " + restaurant.getValue_for_money() + SPACE_CHAR );
         }
        if(restaurant.getFood() >0) {
            query.append(",food=" + restaurant.getFood() + SPACE_CHAR);
        }
        if(restaurant.getService()>0) {
            query.append( ",service=" + restaurant.getService() +SPACE_CHAR);

        }
        if(restaurant.getAmbience()>0){
            query.append(",ambience=" + restaurant.getAmbience() + SPACE_CHAR );
        }
        if(restaurant.getQuality()>0) {
            query.append(",quality=" + restaurant.getQuality() + SPACE_CHAR);
        }
        if(restaurant.getUser_exp() > 0) {
            query.append(",user_exp=" + restaurant.getUser_exp() + SPACE_CHAR);
        }
        query.append("WHERE restraurant_name="+ restaurant.getRestraurant_name());
        query.append(AND_CHAR+ "restraurant_location="+restaurant.getRestraurant_location());
        query.append(AND_CHAR+ "user_email="+restaurant.getUser_email());

        try {
            jdbcTemplate.update(query.toString(), new Object[]{restaurant});
            status.append("Success Restaurant updated");
        }catch(Exception exception){
            System.out.println(exception);
            status.append("Failed to update restaurant");
        }
        return status.toString();
    }

    @Override
    public String addNewReviewForRestaurant(Restaurants restaurant) {
        StringBuilder status = new StringBuilder();
        String query = "UPDATE restraurant SET user_review="+restaurant.getUser_review() +SPACE_CHAR+
                " WHERE restraurant_name="+ restaurant.getRestraurant_name() +AND_CHAR+"restraurant_location="+restaurant.getRestraurant_location()+AND_CHAR+
                 "user_email="+ restaurant.getUser_email();

        try {
            jdbcTemplate.update(query, new Object[]{restaurant.getUser_review()});
            status.append("Success Restaurant updated");
        }catch(Exception exception){
            System.out.println(exception);
            status.append("Failed to update restaurant");
        }
        return status.toString();


    }


    @Override
    public List<Restaurants> getAllRestaurants() {
        StringBuilder status = new StringBuilder();

        String query = "SELECT * from restraurant";
        List<Restaurants> restaurantsList = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<Restaurants>(Restaurants.class));
        return restaurantsList;

    }

    @Override
    public List<Restaurants> getRestaurantsByLocation(String location) {
        String query = "SELECT * from restraurant WHERE restraurant_location =?";
        //Pending is the logic for rating
        List<Restaurants> restaurantsList = jdbcTemplate.query(query,new Object[]{location},
                new BeanPropertyRowMapper<Restaurants>(Restaurants.class));
        return restaurantsList;
    }

    @Override
    public List<Restaurants> getRestaurantsByAttriNLoc(String location, Map attributeMap) {
        String query = "SELECT restraurant_name,restraurant_location , SUM(VALUE_FOR_MONEY)/COUNT(restraurant_name) as cost"  + COMMA_CHAR + 
                "SUM(FOOD)/COUNT(restraurant_name) as taste" + COMMA_CHAR+
                "SUM(SERVICE)/COUNT(restraurant_name) as courtesy" + COMMA_CHAR + 
                "SUM(AMBIENCE)/COUNT(restraurant_name) as environment" + COMMA_CHAR + 
                "SUM(QUALITY)/COUNT(restraurant_name) as hygiene"+SPACE_CHAR+
                " from gimmeFive.restraurant "+
                "WHERE cost >= "+attributeMap.get("valueformoney")+AND_CHAR+
                "taste >=" + attributeMap.get("food")  + AND_CHAR +
                "courtesy >="+attributeMap.get("service") + AND_CHAR +
                "environment >="+attributeMap.get("ambience") + AND_CHAR +
                "hygiene >= "+ attributeMap.get("quality");
                if(location!= null) {
                    query = query + AND_CHAR + "restraurant_location=" + location.toLowerCase();
                }
                ;
        List<Restaurants> restaurantsList = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<Restaurants>(Restaurants.class));
        return restaurantsList;
    }

    @Override
    public String updateRatingAndReview(Restaurants restaurant) {
        StringBuilder status = new StringBuilder();

        String query = "UPDATE gimmeFive.restraurant SET value_for_money="+restaurant.getValue_for_money() +SPACE_CHAR+
                "food="+restaurant.getFood()+SPACE_CHAR+
                "service="+restaurant.getService()+SPACE_CHAR+
                "ambience="+restaurant.getAmbience()+SPACE_CHAR+
                "quality="+restaurant.getQuality()+SPACE_CHAR+
                " WHERE restraurant_name="+ restaurant.getRestraurant_name() +AND_CHAR+
                "restraurant_location="+restaurant.getRestraurant_location()+AND_CHAR+
                 "user_email="+ restaurant.getUser_email();

        try {
            jdbcTemplate.update(query, new Object[]{restaurant});
            status.append("Success Restaurant updated");
        }catch(Exception exception){
            System.out.println(exception);
            status.append("Failed to update restaurant");
        }
        return status.toString();
    }

    @Override
    public List<Restaurants> getRestraurantDetails(String restraurant_name, String location) {
        Restaurants restaurant  = new Restaurants(restraurant_name,location);
        String query = "Select restraurant_name,restraurant_location,restraurant_speciality," +
                        "SUM(VALUE_FOR_MONEY)/COUNT(restraurant_name) as VALUE_FOR_MONEY" + COMMA_CHAR +
                        "SUM(FOOD)/COUNT(restraurant_name) as FOOD " + COMMA_CHAR +
                        "SUM(SERVICE)/COUNT(restraurant_name) as SERVICE "+ COMMA_CHAR +
                        "SUM(AMBIENCE)/COUNT(restraurant_name) as AMBIENCE"+ COMMA_CHAR +
                        "SUM(QUALITY)/COUNT(restraurant_name) as QUALITY"+ COMMA_CHAR +
                        "SUM(USER_EXP)/COUNT(restraurant_name) as USER_EXP"+ SPACE_CHAR +
                        "FROM restraurant" + SPACE_CHAR+
                        "WHERE restraurant_name='"+restraurant_name +"'"+ AND_CHAR +" restraurant_location='"+location+"'" ;
        System.out.println("the query is "+query);
        List<Restaurants> restaurantsList = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<Restaurants>(Restaurants.class));
        return restaurantsList;
    }

}
