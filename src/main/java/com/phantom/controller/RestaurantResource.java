    package com.phantom.controller;

    import com.phantom.entity.Restaurants;
    import com.phantom.model.RestaurantDao;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import javax.ws.rs.DefaultValue;
    import javax.ws.rs.QueryParam;
    import javax.ws.rs.core.Response;
    import java.util.ArrayList;
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

        @RequestMapping(value="/restraurants",method=RequestMethod.GET ,produces = "application/json")
        public List<Restaurants> getAllRestaurants(@RequestParam(value="location",required= false) String location)
        {
            List<Restaurants> listofRestaurants= new ArrayList<Restaurants>();
            if(null==location)
                listofRestaurants= restaurantDao.getAllRestaurants();
            else
               listofRestaurants=restaurantDao.getRestaurantsByLocation(location);
            return listofRestaurants;

        }

        @RequestMapping(value="/restraurants/{retraurant}{location}",method=RequestMethod.GET ,produces = "application/json")
        public List<Restaurants> getRestaurantDetails(@PathVariable("retraurant")String restraurant_name,
                                                      @DefaultValue("")  @QueryParam("location")String location){
            return restaurantDao.getRestraurantDetails(restraurant_name, location);
        }



        @RequestMapping(value="/restaurants{location}{valueformoney},{food},{service},{ambience},{quality}" ,method= RequestMethod.GET)
        public List<Restaurants> getRestraurantsByAttributes(@DefaultValue("") @QueryParam(value="location") String location,
                                                             @DefaultValue("0") @QueryParam(value="valueformoney") String valueForMoney,
                                                             @DefaultValue("0") @QueryParam("food") String food,
                                                             @DefaultValue("0") @QueryParam("service")String service,
                                                             @DefaultValue("0") @QueryParam("ambience")String ambience,
                                                             @DefaultValue("0") @QueryParam("quality")String quality){
            Map<String,Float>  gimmeFiveRating = new HashMap<>();
            gimmeFiveRating.put("valueformoney", Float.parseFloat(valueForMoney));
            gimmeFiveRating.put("food", Float.parseFloat(food));
            gimmeFiveRating.put("service", Float.parseFloat(service));
            gimmeFiveRating.put("ambience", Float.parseFloat(ambience));
            gimmeFiveRating.put("quality", Float.parseFloat(quality));
            return restaurantDao.getRestaurantsByAttriNLoc(location,gimmeFiveRating);
        }

        @RequestMapping(value="/restaurants/restraurant/{restraurant_name},{user},{location},{valueformoney},{food},{service},{ambience},{quality},{rating}" , method = RequestMethod.PUT)
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
            restaurant.setValue_for_money(Float.parseFloat(valueformoney));
            restaurant.setFood(Float.parseFloat(food));
            restaurant.setService(Float.parseFloat(service));
            restaurant.setAmbience(Float.parseFloat(ambience));
            restaurant.setQuality(Float.parseFloat(quality));
            restaurant.setUser_exp(Float.parseFloat(rating));

            return restaurantDao.updateRestaurantRatings(restaurant);
        }








    }
