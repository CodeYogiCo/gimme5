package com.phantom.model.storage;

import com.phantom.entity.Restaurants;
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


    @Override
    public String addRestaurants(Restaurants restaurants) {
        StringBuilder status = new StringBuilder();

        String query = "INSERT INTO restraurants(restraurant_name,user_email,speciality,value_for_money,food,service,ambience,quality," +
                "user_exp,user_review) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(query, new Object[]{restaurants.getName(), restaurants.getUser_email() ,restaurants.getSpeciality(), restaurants.getValueForMoney_Rating(), restaurants.getFood_Rating(),
                    restaurants.getService_Rating(), restaurants.getAmbience_Rating(), restaurants.getQuality_Rating(),
                    restaurants.getUserExp(), restaurants.getUserReview()});
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

        String query = "UPDATE restraurant SET user_review="+restaurant.getUserReview()+
                " WHERE restraurant_name="+ restaurant.getName() +AND_CHAR+"location="+restaurant.getLocation()+
                  AND_CHAR+"user_email="+ restaurant.getUser_email();
        try {
            jdbcTemplate.update(query, new Object[]{restaurant.getUserReview()});
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
         if(restaurant.getValueForMoney_Rating() >0) {
           query.append("value_for_money " + restaurant.getValueForMoney_Rating() + SPACE_CHAR );
         }
        if(restaurant.getFood_Rating() >0) {
            query.append(",food=" + restaurant.getFood_Rating() + SPACE_CHAR);
        }
        if(restaurant.getService_Rating()>0) {
            query.append( ",service=" + restaurant.getService_Rating() +SPACE_CHAR);

        }
        if(restaurant.getAmbience_Rating()>0){
            query.append(",ambience=" + restaurant.getAmbience_Rating() + SPACE_CHAR );
        }
        if(restaurant.getQuality_Rating()>0) {
            query.append(",quality=" + restaurant.getQuality_Rating() + SPACE_CHAR);
        }
        if(restaurant.getUserExp() > 0) {
            query.append(",user_exp=" + restaurant.getUserExp() + SPACE_CHAR);
        }
        query.append("WHERE restraurant_name="+ restaurant.getName());
        query.append(AND_CHAR+ "restraurant_location="+restaurant.getLocation());
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
        String query = "UPDATE restraurant SET user_review="+restaurant.getUserReview() +SPACE_CHAR+
                " WHERE restraurant_name="+ restaurant.getName() +AND_CHAR+"restraurant_location="+restaurant.getLocation()+AND_CHAR+
                 "user_email="+ restaurant.getUser_email();

        try {
            jdbcTemplate.update(query, new Object[]{restaurant.getUserReview()});
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
    public List<Restaurants> getRestaurantsByAttributes(Map attributeMap) {
        String query = "SELECT restraurant_name,restraurant_location , SUM(VALUE_FOR_MONEY)/COUNT(restraurant_name) as cost ," +
                "SUM(FOOD)/COUNT(restraurant_name) as taste" + SPACE_CHAR +
                "SUM(SERVICE)/COUNT(restraurant_name) as courtesy"+ SPACE_CHAR +
                "SUM(AMBIENCE)/COUNT(restraurant_name) as environment"+ SPACE_CHAR +
                "SUM(QUALITY)/COUNT(restraurant_name) as hygiene"+ SPACE_CHAR +
                " from gimmeFive.restraurant "+ SPACE_CHAR +
                "WHERE cost >= "+attributeMap.get("valueforMoney")+AND_CHAR+
                "taste >=" + attributeMap.get("food")  + AND_CHAR +
                "courtesy >="+attributeMap.get("service") + AND_CHAR +
                "environment >="+attributeMap.get("ambience") + AND_CHAR +
                "hygiene >= "+ attributeMap.get("quality") ;
        List<Restaurants> restaurantsList = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<Restaurants>(Restaurants.class));
        return restaurantsList;
    }

    @Override
    public List<Restaurants> getRestaurantsByAttriNLoc(String location, Map attributeMap) {
        String query = "SELECT restraurant_name,restraurant_location , SUM(VALUE_FOR_MONEY)/COUNT(restraurant_name) as cost ," +
                "SUM(FOOD)/COUNT(restraurant_name) as taste" +
                "SUM(SERVICE)/COUNT(restraurant_name) as courtesy"+
                "SUM(AMBIENCE)/COUNT(restraurant_name) as environment"+
                "SUM(QUALITY)/COUNT(restraurant_name) as hygiene"+
                " from gimmeFive.restraurant "+
                "WHERE cost >= "+attributeMap.get("valueforMoney")+AND_CHAR+
                "taste >=" + attributeMap.get("food")  + AND_CHAR +
                "courtesy >="+attributeMap.get("service") + AND_CHAR +
                "environment >="+attributeMap.get("ambience") + AND_CHAR +
                "hygiene >= "+ attributeMap.get("quality")+ AND_CHAR +
                "restraurant_location="+location.toLowerCase();
                ;
        List<Restaurants> restaurantsList = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<Restaurants>(Restaurants.class));
        return restaurantsList;
    }

    @Override
    public String updateRatingAndReview(Restaurants restaurant) {
        StringBuilder status = new StringBuilder();

        String query = "UPDATE gimmeFive.restraurant SET value_for_money="+restaurant.getValueForMoney_Rating() +SPACE_CHAR+
                "food="+restaurant.getFood_Rating()+SPACE_CHAR+
                "service="+restaurant.getService_Rating()+SPACE_CHAR+
                "ambience="+restaurant.getAmbience_Rating()+SPACE_CHAR+
                "quality="+restaurant.getQuality_Rating()+SPACE_CHAR+
                " WHERE restraurant_name="+ restaurant.getName() +AND_CHAR+"restraurant_location="+restaurant.getLocation()+AND_CHAR+
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
    public Restaurants getRestraurantDetails(String restruarant_name, String location) {
        Restaurants restaurant  = new Restaurants(restruarant_name,location);
        String query = "Select restraurant_name,restraurant_location,restraunrant_speciality," +
                        "SUM(VALUE_FOR_MONEY)/COUNT(restraurant_name) as cost ," +
                        "SUM(FOOD)/COUNT(restraurant_name) as taste" +
                        "SUM(SERVICE)/COUNT(restraurant_name) as courtesy"+
                        "SUM(AMBIENCE)/COUNT(restraurant_name) as environment"+
                        "SUM(QUALITY)/COUNT(restraurant_name) as hygiene"+
                        "SUM(USER_EXP)/COUNT(restraurant_name) as userex"+ SPACE_CHAR +
                        "FROM gimmeFive.restraurant" + SPACE_CHAR+
                        "WHERE restraurant_name="+restruarant_name ;
        if(!location.isEmpty()) {
            query = query + AND_CHAR + "restraurant_location=" + location;
        }
        return restaurant;
    }
}
