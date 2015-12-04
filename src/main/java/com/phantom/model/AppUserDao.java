package com.phantom.model;

import com.phantom.entity.AppUser;
import com.phantom.entity.AuthenticateResponse;

/**
 * Created by vishal on 20/11/15.
 */
public interface AppUserDao {

    public String doUserRegistration(AppUser user);

    public String forgotPassword(String emailId);

    public AuthenticateResponse doUserAuthentication(AppUser user);
}
