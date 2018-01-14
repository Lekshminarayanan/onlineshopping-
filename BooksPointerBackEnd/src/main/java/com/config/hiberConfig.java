package com.config;

import java.util.Locale.Category;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;

import com.model.Product;
import com.model.Supplier;
import com.model.User;

@Configuration
@Component("com")
@EnableTransactionManagement
public class hiberConfig {
	


		@Autowired
		@Bean(name="datasource")
	public DataSource getH2Data() 
	{
		
			DriverManagerDataSource dsource=new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/BooksWorld");
		dsource.setUsername("sa");
		dsource.setPassword("");
		System.out.println("H2 Connected");
		
		return dsource;
	}


	private Properties getHiber()
	{
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2dialect");
		p.put("hibernate.hbm2ddl.auto","update");
		p.put("hibernate.show_sql","true");
		
	System.out.println("Data table  Created in H2");
	return p;
	}

	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getHiberSession(Datasource datasource)
	{
		LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(datasource);
		lsfb.addProperties(getHiber());
		lsfb.addAnnotatedClass(User.class);
		lsfb.addAnnotatedClass(Supplier.class);
		lsfb.addAnnotatedClass(Category.class);
		lsfb.addAnnotatedClass(Product.class);
		lsfb.addAnnotatedClass(Cart.class);
		return lsfb.buildSessionFactory();
	}
	@Autowired
	@Bean(name="UserDaoImpl")
	public UserDaoImpl saveUserData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
		
	}


	@Autowired
	@Bean(name="SupplierDaoImpl")
	public SupplierDaoImpl saveSuppData(SessionFactory sf)
	{
		return new SupplierDaoImpl(sf);
		
	}

	@Autowired
	@Bean(name="CategoryDaoImpl")
	public CategoryDaoImpl saveCatData(SessionFactory sf)
	{
		return new CategoryDaoImpl(sf);
		
	}

	@Autowired
	@Bean(name="ProductDaoImpl")
	public ProductDaoImpl saveProdData(SessionFactory sf)
	{
		return new ProductDaoImpl(sf);
		
	}
	@Autowired
	@Bean(name="CartDaoImpl")
	public CartDaoImpl saveCartData(SessionFactory sf)
	{
		return new CartDaoImpl(sf);
		
	}
	@Autowired
	@Bean(name="OrdersDaoImpl")
	public OrdersDaoImpl saveOrdersData(SessionFactory sf)
	{
		return new OrdersDaoImpl(sf);
		
	}







	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager gettrans(SessionFactory sf)
	{
		HibernateTransactionManager tm=new HibernateTransactionManager(sf);
	    return tm;

	}


	}

