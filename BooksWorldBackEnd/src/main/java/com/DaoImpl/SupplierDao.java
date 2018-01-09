package com.DaoImpl;


import com.Dao.*;
import com.model.Supplier;
@Repository
@Service
public class SupplierDao implements SupplierDao
{
@Autowired
SessionFactory sessionFactory;
@Autowired
public  SupplierDaoImpl (SupplierFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}


public void insertSupplier(Supplier supplier)
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.persist(supplier);
	session.getTransaction().commit();

}

public List<Supplier>retrieve()
{
	Session session=sessionFactory.openSession();
    session.beginTransaction();
    List<Supplier> li=session.createQuery("from Supplier").list();
    session.getTransaction().commit();
    return li;
}

public Supplier findBySuppId(int sid)
{
	Seesion session=sessionFactory.oprnSession();
	Supplier s=null;
	try
	{
	session.beginTransaction();
	s=session.get(Supplier.class,sid);
	session.getTransaction().commit();
}
catch(HibernateException e)
{
	System.out.println(e.getMessage());
	session.getTransaction().rollback();s
	
}
}}
