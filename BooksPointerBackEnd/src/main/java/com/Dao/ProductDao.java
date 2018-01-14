package com.Dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {

	public void insertProduct(Product product);
	public List<Product> retrieve();
	public Product findByPID();
}
