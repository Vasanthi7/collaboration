package com.blog.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.blog")
@EnableTransactionManagement
public class DbConfig 
{
	
	@Bean
	public DataSource getDataSource()
	{
		System.out.println("at ");
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		System.out.println("3");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		System.out.println("4");
		dataSource.setUsername("Mydatabase");
		System.out.println("5");
		dataSource.setPassword("vasanthi");
		return dataSource;
	}
	
	public Properties getProperties()
	{
		Properties properties=new Properties();
		  properties.setProperty("hibernate.show_sql", "true");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			properties.setProperty("hibernate.hbm2ddl.auto", "");
			properties.setProperty("hibernate.format_sql", "true");
			
			return properties;
		
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(getDataSource());
	    builder.addProperties(getProperties());
	    builder.scanPackages("com.blog.model");
	    System.out.println("in session Factory");
		return builder.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(getSessionFactory());
		System.out.println(htm);
		return htm;
	
	

}
}
