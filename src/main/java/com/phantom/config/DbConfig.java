package com.phantom.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.annotation.Resource;

/**
 * Created by vishal on 10/28/15.
 */

@Configuration
@PropertySource("classpath:gimmeFive.properties")
public class DbConfig {

@Resource
private Environment env;



    @Bean
    public javax.sql.DataSource gimme5dataSource(){
        DataSource dataSource= new DataSource();
        dataSource.setDriverClassName(env.getProperty("mysql.driver", "com.mysql.jdbc.Driver"));
        dataSource.setUrl(env.getProperty("mysql.jdbcurl",
                "jdbc:mysql://127.0.0.1:3306/gimme5?autoReconnect=true"));
        dataSource.setUsername(env.getProperty("mysql.user", "root"));
        dataSource.setPassword(env.getProperty("mysql.password", "admin"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate setJdbcTemplate(){
        JdbcTemplate jdbcTemplate= new JdbcTemplate();
        jdbcTemplate.setDataSource(gimme5dataSource());
        return jdbcTemplate;
    }

//
//    @Bean
//    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
//        return namedParameterJdbcTemplate;
//    }



}
