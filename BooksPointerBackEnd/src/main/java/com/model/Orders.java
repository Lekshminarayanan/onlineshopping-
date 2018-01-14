
package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Orders implements Serializable
{
@Id
@GeneratedValue
private int orderId;
private double total;



public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public double getCartPrice() {
	return cartPrice;
}
public void setCartPrice(double cartPrice) {
	this.cartPrice = cartPrice;
}
public int getCartStock() {
	return cartStock;
}
public void setCartStock(int cartStock) {
	this.cartStock = cartStock;
}
public String getCartImage() {
	return cartImage;
}
public void setCartImage(String cartImage) {
	this.cartImage = cartImage;
}
public String getCartProductName() {
	return cartProductName;
}
public void setCartProductName(String cartProductName) {
	this.cartProductName = cartProductName;
}
private String payment;
@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="userMailId")
private User user;

private double cartPrice;
private int cartStock;
private String cartImage;
private String cartProductName;

}