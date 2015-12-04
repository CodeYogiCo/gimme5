package com.phantom.model.storage;

import com.phantom.entity.AppUser;
import com.phantom.entity.AuthenticateResponse;
import com.phantom.model.AppUserDao;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;


/**
 * Created by vishal on 20/11/15.
 */
public class AppUserDaoImpl implements AppUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public String doUserRegistration(AppUser user) {
        String status;
        try{
            jdbcTemplate.update("insert into users VALUES(?,?,?,?) ",
                    user.getFname(),user.getEmail(),user.getPassword(), user.getLname()
            );
            status="USER REGISTERED SUCCESSFULLY";
        }
        catch(Exception exception){
            System.out.println(exception);
            status="FAILED IN USER REGISTRATION";
        }
        return status;
    }

    @Override
    public String forgotPassword(String emailId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("emailId",emailId );
        String response = namedJdbcTemplate.query("select password from hack_user where hack_email=:emailId",namedParameters,
                new ResultSetExtractor<String>() {

                    @Override
                    public String extractData(ResultSet resultset)
                            throws SQLException, DataAccessException {
                        List<String> password= new ArrayList<String>();
                        while(resultset.next()){
                            password.add(resultset.getString("password"));
                        }
                        return password.get(0);
                    }
                });
        return response;
    }

    @Override
    public AuthenticateResponse doUserAuthentication(AppUser user) {
        AuthenticateResponse authenticateResponse=new AuthenticateResponse();
        SqlParameterSource namedParameters = new MapSqlParameterSource("emailId",user.getEmail() );
        String response = namedJdbcTemplate.query("select password from hack_user where hack_email=:emailId",namedParameters,
                new ResultSetExtractor<String>() {

                    @Override
                    public String extractData(ResultSet resultset)
                            throws SQLException, DataAccessException {
                        List<String> password= new ArrayList<String>();
                        while(resultset.next()){
                            password.add(resultset.getString("password"));
                        }
                        return password.get(0);
                    }
                });
        if(response.equals(user.getPassword())){
            authenticateResponse.setEmailId(user.getEmail());
            authenticateResponse.setName(user.getFname());
            authenticateResponse.setIsAuthenticated(Boolean.TRUE);;
        }else{
            authenticateResponse.setEmailId(user.getEmail());
            authenticateResponse.setName(user.getFname());
            authenticateResponse.setIsAuthenticated(Boolean.FALSE);;
        }
        return authenticateResponse;
    }
}
