package com.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
public class Supplier implements Serializable
{

	@Id
	private int sid;
	
	private String supplierName;
	
	

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	@OneToMany(targetEntity=Product.class.fetch=FetchType.EAGER,mappedBy="supplier")
	private Set<Product> product=new HashSet<Product>(0);



	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}
