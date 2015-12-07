    package com.phantom.controller;

    import com.phantom.entity.Restaurants;
    import com.phantom.model.RestaurantDao;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    /**
     * Created by vishal on 21/11/15.
     */

    @RequestMapping(value="/gimme5")
    @RestController
    public class RestaurantResource {

        @Autowired
        private RestaurantDao restaurantDao;


        @RequestMapping(value="/restaurant",method=RequestMethod.POST,headers="content-type=application/vnd.v0+json"
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

        @RequestMapping(value="/restaurant",method=RequestMethod.GET,headers="content-type=application/vnd.v0+json"
                ,produces = "application/json")
        public List<Restaurants> getAllRestaurants(@RequestBody Restaurants restaurants){
            
                return restaurantDao.getAllRestaurants();

        }




    }
