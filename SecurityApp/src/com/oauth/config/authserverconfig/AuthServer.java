package com.oauth.config.authserverconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer

public class AuthServer extends AuthorizationServerConfigurerAdapter{
	public AuthServer() {
		System.out.println("In AuthServer");
	}
}
