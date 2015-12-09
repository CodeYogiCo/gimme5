    package com.phantom.controller;

    import com.phantom.entity.Restaurants;
    import com.phantom.model.RestaurantDao;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import javax.ws.rs.DefaultValue;
    import javax.ws.rs.QueryParam;
    import javax.ws.rs.core.Response;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    /**
     * Created by vishal on 21/11/15.
     */

    @RequestMapping(value="/gimme5")
    @RestController
    public class RestaurantResource {

        @Autowired
        private RestaurantDao restaurantDao;


        @RequestMapping(value="/restaurants/restraurant",method=RequestMethod.POST,headers="content-type=application/vnd.v0+json"
        ,produces = "application/json")
            public ResponseEntity.BodyBuilder addRestaurants(@RequestBody Restaurants restaurants){
            try{
                restaurantDao.addRestaurants(restaurants);
                return ResponseEntity.ok();
            }
            catch(Exception ex){
                return ResponseEntity.accepted();
            }


            }

        @RequestMapping(value="/restraurants",method=RequestMethod.GET,headers="content-type=application/vnd.v0+json"
                ,produces = "application/json")
        public List<Restaurants> getAllRestaurants(){

                return restaurantDao.getAllRestaurants();

        }

        @RequestMapping(value="/restaurants{location}" ,method= RequestMethod.GET)
        public List<Restaurants> getReestraurantsByLocation(@DefaultValue("") @QueryParam(value="location") String location){
            return restaurantDao.getRestaurantsByLocation(location);

        }

        @RequestMapping(value="/restaurants{valueformoney},{food},{service},{ambience},{quality}" ,method= RequestMethod.GET)
        public List<Restaurants> getRestraurantsByAttributes(@DefaultValue("0") @QueryParam(value="valueformoney") String valueForMoney,
                                                             @DefaultValue("0") @QueryParam("food") String food,
                                                             @DefaultValue("0") @QueryParam("service")String service,
                                                             @DefaultValue("0") @QueryParam("ambience")String ambience,
                                                             @DefaultValue("0") @QueryParam("quality")String quality){
            Map<String,Float>  gimmeFiveRating = new HashMap<>();
            gimmeFiveRating.put("valueForMoney", Float.parseFloat(valueForMoney));
            gimmeFiveRating.put("food", Float.parseFloat(food));
            gimmeFiveRating.put("service", Float.parseFloat(service));
            gimmeFiveRating.put("ambience", Float.parseFloat(ambience));
            gimmeFiveRating.put("quality", Float.parseFloat(quality));
            return restaurantDao.getRestaurantsByAttributes(gimmeFiveRating);
        }

        @RequestMapping(value="/restaurants/restraurant/{restraurant_name},{user},{location},{valueformoney},{food},{service},{ambience},{quality},{rating}" , method = RequestMethod.GET)
        public String updateRestraurantRating(@PathVariable("restraurant_name")String restraurant_name ,
                                                @QueryParam("user")String user_email,
                                                @QueryParam("location")String location,
                                                @DefaultValue("0") @QueryParam(value="valueformoney") String valueformoney,
                                                @DefaultValue("0") @QueryParam("food") String food,
                                                @DefaultValue("0") @QueryParam("service")String service,
                                                @DefaultValue("0") @QueryParam("ambience")String ambience,
                                                @DefaultValue("0") @QueryParam("quality")String quality,
                                                @DefaultValue("0") @QueryParam("rating") String rating
                                               ){
            Restaurants restaurant = new Restaurants(restraurant_name,location);
            restaurant.setUser_email(user_email);
            restaurant.setValueForMoney_Rating(Float.parseFloat(valueformoney));
            restaurant.setFood_Rating(Float.parseFloat(food));
            restaurant.setService_Rating(Float.parseFloat(service));
            restaurant.setAmbience_Rating(Float.parseFloat(ambience));
            restaurant.setQuality_Rating(Float.parseFloat(quality));
            restaurant.setUserExp(Float.parseFloat(rating));

            return restaurantDao.updateRestaurantRatings(restaurant);
        }




    }
