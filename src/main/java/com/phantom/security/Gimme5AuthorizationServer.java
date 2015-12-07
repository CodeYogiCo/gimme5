package com.phantom.security;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

@Configuration
@EnableAuthorizationServer
public class Gimme5AuthorizationServer extends AuthorizationServerConfigurerAdapter{
	final String RESOURCE_ID = "notification_resource";




	@Autowired
	private AuthenticationManager authenticationManager;

	@Override // [2]
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}

	@Override // [3]
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// @formatter:off
		clients.inMemory()
				.withClient("client1")
				.authorizedGrantTypes("authorization_code")
				.authorities("ROLE_CLIENT")
				.scopes("read", "trust")
				.resourceIds(RESOURCE_ID)
				.redirectUris("http://anywhere?key=value")
				.secret("secret1")
				.and()
				.withClient("client2")
				.authorizedGrantTypes("client_credentials", "password")
				.authorities("ROLE_CLIENT")
				.scopes("read")
				.resourceIds(RESOURCE_ID)
				.secret("secret");
		// @formatter:on
	}


//	@Autowired
//	DataSource  dataSource;


//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//    	JdbcTokenStore jdbcTokenStore = new JdbcTokenStore(dataSource);
//    	endpoints.tokenStore(jdbcTokenStore);
//    }
//
 

//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//    	JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
//    	clients.withClientDetails(clientDetailsService);
//    }
}

	
	