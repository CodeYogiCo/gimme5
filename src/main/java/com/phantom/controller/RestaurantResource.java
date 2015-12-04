package com.phantom.controller;

import com.phantom.entity.Restaurants;
import com.phantom.model.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vishal on 21/11/15.
 */

@RequestMapping(value="/gimme5")
@RestController
public class RestaurantResource {

    @Autowired
    private RestaurantDao restaurantDao;

    @RequestMapping(value="/user/signup" ,method= RequestMethod.POST,headers = "content-type=application/x-www-form-urlencoded;charset=UTF-8" ,
            produces={"application/json"}
    )
    public ResponseEntity addQuestion(@RequestBody Restaurants restaurants){
        restaurantDao.addRestaurants(restaurants);
        return ResponseEntity.ok("created");
    }



}
