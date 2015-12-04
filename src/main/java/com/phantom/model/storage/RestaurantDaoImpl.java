package com.phantom.model.storage;

import com.phantom.entity.Restaurants;
import com.phantom.model.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by vishal on 14/11/15.
 */
public class RestaurantDaoImpl implements RestaurantDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    private void setDataSource(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);

    }
    @Override
    public String addRestaurants(Restaurants restaurants) {
        StringBuilder status = new StringBuilder();

        String query = "INSERT INTO rating_schema.restraurants(rest_name,user_email,speciality,value_for_money,food,service,ambience,quality," +
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

        String query = "UPDATE rating_schema.restraurants SET user_review="+restaurant.getUserReview()+
                " WHERE rest_name="+ restaurant.getName() +" AND location="+restaurant.getLocation()+
                " AND user_email="+ restaurant.getUser_email();
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

        String query = "UPDATE rating_schema.restraurants SET value_for_money"+restaurant.getValueForMoney_Rating()+
        " ,food="+restaurant.getFood_Rating()+
        " ,service="+restaurant.getService_Rating()+" ,ambience="+restaurant.getAmbience_Rating()+
        " ,quality="+restaurant.getQuality_Rating()+" , user_exp="+restaurant.getUserExp()+"\n"+
        " WHERE rest_name="+ restaurant.getName() +" AND location="+restaurant.getLocation()+
        " AND user_email="+ restaurant.getUser_email();

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
    public String addNewReviewForRestaurant(Restaurants restaurant) {
        return null;
    }


    @Override
    public List<Restaurants> getAllRestaurants() {
        return null;
    }

    @Override
    public List<Restaurants> getRestaurantsByLocation(String location, Double rating) {
        return null;
    }

    @Override
    public List<Restaurants> getRestaurantsByAttributes(List<String> attributeList) {
        return null;
    }

    @Override
    public List<Restaurants> getRestaurantsByAttriNLoc(String Location, List<String> attributeList) {
        return null;
    }

    @Override
    public Restaurants updateRatingAndReview(Restaurants restaurants) {
        return null;
    }
}
