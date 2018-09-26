package com.oauth.config.userdata;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@Order(1)
public class HibernateConfigation {

	@Bean
	public DataSource getDataSource()
	{
	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
     dataSource.setUrl("jdbc:mysql://localhost:3306/oauth2spring");
     dataSource.setUsername("root");
     dataSource.setPassword("P@ssw0rd");
	System.out.println("DataSource "+dataSource.toString());
	 return dataSource;
	}
	 
	public LocalContainerEntityManagerFactoryBean hibernateProperties() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	     emf.setDataSource(getDataSource());
	     emf.setPersistenceUnitName("spring-jpa-unit");
	     emf.setJpaVendorAdapter(getHibernateAdapter());
	         Properties jpaProperties = new Properties();
	        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
	        jpaProperties.put("hibernate.show_sql", "true");
	        jpaProperties.put("hibernate.format_sql","false");
	      emf.setJpaProperties(jpaProperties);
	   return emf;
	}
	@Bean
	  public JpaVendorAdapter getHibernateAdapter() {
	      return new HibernateJpaVendorAdapter();
	  }

	/*@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		//sessionFactory.setPackagesToScan(new String[] { "com.oauth.config.*" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}*/
	/*@Bean
	/*@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}*/


}
