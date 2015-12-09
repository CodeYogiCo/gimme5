    package com.phantom.controller;

    import com.phantom.entity.Restaurants;
    import com.phantom.model.RestaurantDao;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import javax.ws.rs.DefaultValue;
    import javax.ws.rs.QueryParam;
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

        @RequestMapping(value="/restraurants",method=RequestMethod.GET,headers="content-type=application/vnd.v0+json"
                ,produces = "application/json")
        public List<Restaurants> getAllRestaurants(@RequestParam(value="location",required= false) String location)
//                                                   @DefaultValue("0") @RequestParam(value="valueForMoney") String valueForMoney,
//                                                   @DefaultValue("0") @RequestParam(value="food") String food,
//                                                   @DefaultValue("0") @RequestParam(value="service")String service,
//                                                   @DefaultValue("0") @RequestParam(value="ambience") String ambience,
//                                                   @DefaultValue("0") @RequestParam(value="quality")String quality)
        {
            List<Restaurants> listofRestaurants= new ArrayList<Restaurants>();
            if(null==location)
                listofRestaurants= restaurantDao.getAllRestaurants();
            else
               listofRestaurants=restaurantDao.getRestaurantsByLocation(location);
            return listofRestaurants;

        }

//        @RequestMapping(value="/restaurants{location}" ,method= RequestMethod.GET)
//        public List<Restaurants> getReestraurantsByLocation(@DefaultValue("") @QueryParam(value="location") String location){
//            return restaurantDao.getRestaurantsByLocation(location);
//
//        }

        @RequestMapping(value="/restaurants{valueforMoney},{food},{service},{ambience},{quality}" ,method= RequestMethod.GET)
        public List<Restaurants> getRestraurantsByAttributes(@DefaultValue("0") @QueryParam(value="valueforMoney") String valueForMoney,
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




    }
