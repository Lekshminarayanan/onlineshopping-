package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {
public DBConfiguration() {
	System.out.println("DBConfiguration class is instantiated");
}
@Bean
 public SessionFactory sessionFactory() {
	LocalSessionFactoryBuilder lsf= new LocalSessionFactoryBuilder(getDataSource());
	Properties hibernateProperties=new Properties();
	hibernateProperties.setProperty("hibernate.dialect", "org.hibernatedialect.Oracle10gDialect");
	hibernateProperties.setProperty("hibernate.hbm2dd1.auto", "update");
	hibernateProperties.setProperty("hibernate.show_sql", "true");
	lsf.addProperties(hibernateProperties);
	Class classes[]=new Class[] {};
	return lsf.addAnnotatedClasses(classes).buildSessionFactory();
}
@Bean
public DataSource getDataSource() {
	BasicDataSource  dataSource=new BasicDataSource();
	dataSource.setDriverClassName("");
	dataSource.setUrl("");
	dataSource.setUsername("");
	dataSource.setPassword("");
	return dataSource;
}
@Bean
public HibernateTransactionManager hibTransManagement() {
	return new HibernateTransactionManager(sessionFactory());
}
}
