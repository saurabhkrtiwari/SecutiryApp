package com.oauth.config.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.oauth.config.*")
public class WebAppMVC implements WebMvcConfigurer{
public WebAppMVC() {
System.out.println("WebMVC Confifuration");
}

@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	InternalResourceViewResolver view = new InternalResourceViewResolver();
	view.setPrefix("/WEB-INF/jsps/");
	view.setSuffix(".jsp");
	view.setExposeContextBeansAsAttributes(true);
	registry.viewResolver(view);


	}
}
