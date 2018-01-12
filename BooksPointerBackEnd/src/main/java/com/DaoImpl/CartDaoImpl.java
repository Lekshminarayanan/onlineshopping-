package com.DaoImpl;

import com.Dao.CartDao;

@Repository("CartDaoImpl")
public class CartDaoImpl implements CartDao 
{
@Autowired
SessionFactory sessionFactory;


public CartDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
public void insertCart(Cart cart)
{
	
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.persist(cart);
	session.getTransaction().commit();

}
@SuppressWarnings("Unchecked")
public <ListCart> findByCartID(String userId)
{
	Session session=sessionFactory.openSession();
	List<Cart> cr=null;
	try {
		session.beginTransaction();
		cr=(List<Cart>).session.createQuery("from Cart where userMailId=:email").setString("email",userId).list();
		session.getTransaction().commit();
	}
	catch(HibernateException e)
	{
		e.printStackTrace();
		session.getTransaction().rollback();
		
	}
	return cr;
}
public Cart getCartById(int cartId,String userEmail)
{
	
	Sesssion session=sessionFactory=sessionFactory.openSession();
	Cart cr=null;
	session.beginTransaction();
	cr=(Cart)session.createQuery("Where userMailId=: email and cartProductID=:pid").setString("email",userEmail).setInteger("id",cartProductId).UniqueResult();
	session.getTransaction().commit();
	return cr;
	
	
}
public void deleteCart(int cartId)
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	Cart cr=(Cart)session.get(Cart.class,cartId);
	
}

public void updateCart(Cart cr)
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.update(cr);
	session.getTransaction().commit();
	
}


}
