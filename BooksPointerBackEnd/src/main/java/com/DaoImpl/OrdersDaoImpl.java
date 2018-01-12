package com.DaoImpl;

import com.Dao.OrderDao;

@Repository
public class OrdersDaoImpl implements OrderDao
{
	@Autowired
	SessionFactory sessionFactory;
	public OrdersDaoImpl()
	{
		
		
		this.sessionFactory=sessionFactory;
	}
@Transactional
public void insertOrder(Orders order)
{
	SessionFactory=sessionFactory.openSession();
	session.persist(order);
	
}
}