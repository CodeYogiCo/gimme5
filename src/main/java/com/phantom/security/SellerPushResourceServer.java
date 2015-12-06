package com.phantom.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

@Configuration
@EnableResourceServer
public class SellerPushResourceServer extends ResourceServerConfigurerAdapter{
	final String RESOURCE_ID = "notification_resource";
	
    //BearerNullFilter bearerNullFilter= new BearerNullFilter();
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
			http.
			authorizeRequests().anyRequest().authenticated()
			
			.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.NEVER);
		
		
	}


	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID);
	}
}
