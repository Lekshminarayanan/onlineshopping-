package com.DaoImpl;


	import com.Dao.*;
	import com.model.Supplier;
	@Repository
	@Service
	public class CategoryDaoImpl implements CategoryDao {
	{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public  CategoryDaoImpl (SupplierFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


	public void insertCategory(Category category)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(supplier);
		session.getTransaction().commit();

	}

	public List<Category> retrieve()
	
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Category> li=session.createQuery("form Category").List();
		session.getTransaction().commit();
 return li;
	}
		
		public Category findByCatId(int cid)
		{
			
			Session session=sessionFactory.openSession();
			Category c=null;
			try
			{
				session.beginTransaction();
				c=session.get(Category.class,cid);
				session.getTransaction.commit();
				
			}
		catch(HibernateException e)
			{
			
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			}
			
			
			return c;
			
		}
		
	
	
	
	
	

}