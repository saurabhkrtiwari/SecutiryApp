package com.oauth.config.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.oauth.config.security.SecurityConfig;
import com.oauth.config.userdata.HibernateConfigation;

public class WebAppDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
	return new Class[] {SecurityConfig.class,HibernateConfigation.class};	
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppMVC.class};
	}
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
