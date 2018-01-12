package com.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.component;
@component
@Entity
public class User implements Serializable
{
	private static final long serialVersionUID=1L;
@Id
@Email(message="Enter valid Email")
 private int email;
private String name;
@NotNull
private String password;
private boolean enabled;
public static long getSerialversionuid() {
	return serialVersionUID;
}
private String role;
private String address;
@Pattren(regex=[\\d] {10},message="Enter valid digits")
@Size(min=8,max=10,message="Enter valid phone")
private String phone;
private boolean enabled;

 public int getEmail() {
	return email;
}
public void setEmail(int email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
}