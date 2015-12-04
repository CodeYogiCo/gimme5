package com.phantom.controller;

import com.phantom.entity.AppUser;
import com.phantom.entity.AuthenticateResponse;
import com.phantom.model.AppUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vishal on 20/11/15.
 */
public class AppUserResource {


    @Autowired
    private AppUserDao appUserDao;

    @RequestMapping(value="/user/signup" ,method= RequestMethod.POST,headers = "content-type=application/x-www-form-urlencoded;charset=UTF-8" ,
            produces={"application/json"}
    )
    public @ResponseBody
    String doUserRegistration(@ModelAttribute AppUser user)
            throws Exception{
        String userRegistrationRepose=appUserDao.doUserRegistration(user);
        return userRegistrationRepose;

    }


    @RequestMapping(value="/user/{userEmail}/forgotPassword", method=RequestMethod.GET)
    public String forgortPassword(@PathVariable String userEmail){
        return appUserDao.forgotPassword(userEmail);

    }

    @Cacheable(value="userLoginAuthentication")
    @RequestMapping (value="/user/login",method=RequestMethod.POST)
    public AuthenticateResponse loginAuthenticate(@RequestBody AppUser user){
        return appUserDao.doUserAuthentication(user);
    }
}
