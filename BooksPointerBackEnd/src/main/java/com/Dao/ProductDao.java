package com.Dao;

public interface ProductDao {

	public void insertProduct(Product product);
	public List<Product> retrieve();
	public Product findByPID();
}
