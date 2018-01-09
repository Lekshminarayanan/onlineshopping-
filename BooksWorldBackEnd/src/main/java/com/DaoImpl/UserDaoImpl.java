package com.DaoImpl;

import com.Dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao
{

	@Autowired
SessionFactory sessionFactory;
	
	
@Autowired
public UserDaoImpl(SessionFactory sessionFactory)
{
	super();
	
	this.sessionFactory=sessionFactory;
}

	public void insertUser(User user)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}
	public User findUserByEmail(String email)
	{
		Session session=sessionFactory.openSession();
		User u=null;
		try {
		session.beginTransaction();
		u=sesion.get(User.class,email);
				session.getTransaction().commit();
	}
		catch(HibernateException e)
		{
	e.printStackTrace();		
			
		}
	return u;
	}
}
