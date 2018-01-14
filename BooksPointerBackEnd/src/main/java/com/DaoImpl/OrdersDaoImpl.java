package com.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.OrderDao;
import com.model.Orders;

@Repository
public class OrdersDaoImpl implements OrderDao

{@Autowired
	
	SessionFactory sessionFactory;
	public OrdersDaoImpl()
	{
		
		
		this.sessionFactory=sessionFactory;
	}
@Transactional
public void insertOrder(Orders order)
{
	SessionFactory=sessionFactory.openSession();
	Session.persist(order);
	
}
}