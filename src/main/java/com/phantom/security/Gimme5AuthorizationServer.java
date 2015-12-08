package com.phantom.security;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class Gimme5AuthorizationServer extends AuthorizationServerConfigurerAdapter{
	final String RESOURCE_ID = "gimme5_resource";



	@Autowired
	javax.sql.DataSource dataSource;




    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	JdbcTokenStore jdbcTokenStore = new JdbcTokenStore(dataSource);
    	endpoints.tokenStore(jdbcTokenStore);
    }

 


    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
    	clients.withClientDetails(clientDetailsService);
    }
}

	
	