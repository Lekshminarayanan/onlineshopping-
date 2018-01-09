package com.config;

import java.util.Properties;


import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.;
import org.springframework.context.annotation.ComponentScan;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Category;
import com.model.Supplier;
import com.model.User;
@Configuration
@Component("com")
@EnableTransactionManagement

public class hiberConfig
	@Autowired
	@Bean(name="datasource")
public DataSource getH2Data() 
{
	
		DriverManagerDataSource dsource=new DriverManagerDataSource();
	dsource.setDriverClassName("org.h2.Driver");
	dsource.setUrl("jdbc:h2:tcp://localhost/~/BooksWorld");
	dsource.setUserName("sa");
	dsource.setpassword("");
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
	lsfb.addAnnotedClass(User.class);
	lsfb.addAnnotedClass(Supplier.class);
	lsfb.addAnnotedClass(Category.class);
	lsfb.addAnnotedClass(Product.class);
	lsfb.addAnnotedClass(Cart.class);
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