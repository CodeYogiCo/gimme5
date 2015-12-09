package com.phantom.config;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by vishal on 12/6/15.
 */

@Configuration
public class AppConfig {



 //   @Bean
//    public MemcachedClient getMemcachedClient(){
//        MemcachedClient mc= null;
//        try{
 //   1094574019927-lo0d0aphr5fqssnt7qk5i8845ils7pn2.apps.googleusercontent.com
//            mc= new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        return mc;
//    }

}
