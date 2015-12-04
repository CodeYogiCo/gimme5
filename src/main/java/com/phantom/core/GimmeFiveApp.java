package com.phantom.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by vishal on 10/28/15.
 */
@SpringBootApplication
@ComponentScan("com.phantom")
public class GimmeFiveApp {

    public static void main(String[] args) {
        SpringApplication.run(GimmeFiveApp.class,args);

    }
}
