package com.DaoImpl;

import org.hibernate.Session;
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
	public OrdersDaoImpl(SessionFactory sessionFactory)
	{
		
		
		this.sessionFactory=sessionFactory;
	}
@Transactional
public void insertOrder(Orders order)
{
	Session session=sessionFactory.openSession();
	session.persist(order);
	session.beginTransaction();
	session.getTransaction().commit();
	
}
public void insert(Orders order) {
	// TODO Auto-generated method stub
	
}

}