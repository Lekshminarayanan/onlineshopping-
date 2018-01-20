package com.controller;

import java.security.Principal;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;
import com.model.Orders;
import com.model.Product;

@Controller
public class CartController {
@Autowired
SupplierDaoImpl supplierDaoImpl;

@Autowired
CategoryDaoImpl categoryDaoImpl;

@Autowired
ProductDaoImpl productDaoImpl;

@Autowired
CartDaoImpl cartDaoImpl;

@Autowired
OrdersDaoImpl ordersDaoImpl;


@Autowired
UserDaoImpl userDaoImpl;

@RequestMapping(value="/proddetails/${p.pid}")
public ModelAndView proddet(@PathVariable("pid")int pid) {
	 ModelAndView mv=new ModelAndView();
	 Product prod=productDaoImpl(findByPID(pid));
	 mv.addObject("prod",prod);
	 mv.setViewName("proddetails");
	 return mv;
}
@RequestMapping(value="/addToCart",method=RequestMethod.POST)
public ModelAndView addToCart(HttpServletRequest request) {
	 ModelAndView mv=new ModelAndView();
	 Principal principal=request.getUserPrincipal();
	String userEmail=principal.getName();		 
	try
	{
		int pid=Integer.parseInt(request.getParameter("pid"));
		Double price=Double.parseDouble(request.getParameter("pPrice"));
		int qty=Integer.parseInt(request.getParameter("pQty"));
		String pname=request.getParameter("pname");
		String imgName=request.getParameter("imgName");
		Cart cartExit=cartDaoImpl.getCartById(pid,userEmail);
		if(cartExit==null) {
			
			Cart cm=new Cart();
			cm.setCartPrice(price);
			cm.setCartProductID(pid);
			cm.setCartStock(cartExit.getCartStock()+qty);
			cm.setCartImage(imgName);
			cm.setCartProductName(pname);
			
			cartDaoImpl.insertCart(cm);
		}
		else if(cartExit!=null)
		{
			
			Cart cm=new Cart();
			cm.setCartPrice(price);
			cm.setCartProductID(pid);
			cm.setCartStock(cartExit.getCartStock()+qty);
			cm.setCartImage(imgName);
			cm.setCartProductName(pname);
			User user=userDaoImpl.findUserByEmail(UserEmail);
			cm.setCartUserDetails(u);
			cartDaoImpl.insertCart(cm);	
	}
	
		{
	
		ModelAndView mav=new ModelAndView("ack");
Orders ord=new Orders();
Principal p=request.getUserPrincipal();
String UserEmail=p.getName();
List<Cart> cart=cartDaoImpl.findByCartID(userEmail);
Double total=Double.parseDouble(request.getParameter("total"));
String payment=request.getParameter("payment");
User users=userDaoImpl.findUserByEmail(userEmail);
ord.setUser(users);
ord.setTotal(total);
ord.setPayment(payment);
ordersDaoImpl.insertOrder(ord);
mav.addObject("user",userDaoImpl.findUserByEmail(userEmail));
		mav.addObject("orderDetails",users);
				mav.addObject("Cart",cart);
					return mav;
		}
	@RequestMapping("/ack")
	public String ack()
	{
		return "ack";
	}
	@RequestMapping("/deletePCart/{cartId}")
	public ModelAndView deleteCartItem(@PathVariable("cartId")int cartId,HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		Principal principal=request.getUserPrincipal();
		String UserEmail=principal.getName();
		cartDaoImpl.deleteCart(cartId);
		mv.addObject("cartInfo",userDaoImpl.findByCartId(UserEmail));
		 mv.setViewName("cart");
		 return mv;
	}}