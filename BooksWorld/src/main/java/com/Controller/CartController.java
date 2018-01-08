package com.Controller;
import java.io.BufferedOutputStream;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {

	@Autowired
	SupplierDaoImpl supplierDaoImpl;	
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
@Autowired
ProductDaoImpl ProductDaoImpl;

@Autowired
CartDaoImpl cartDaoImpl;

@Autowired
OrdersDaoImpl ordersDaoImpl;

@Autowired
UserDaoImpl userDaoImpl;

@RequestMapping(value="/prodDetails/${p.pid}")
public ModelAndView prodDet(@PathVariable("pid")int pid)
{
	ModelAndView mv=new ModelAndView();
	Product prod=productDaoImpl.findByPID(pid);
    mv.addObject("prod",prod);
    mv.setViewName("prodDetails");
	return mv;
	
}

@RequestMapping(value="/addToCart",method=RequestMethod.POST)
public ModelAndView addtocart(HttpServletRequest request)
{
	
	ModelAndView mv=new ModelAndView();
	Principal principal=request.getUserPrincipal();
	String userEmail=principal.getName();
	
	try
	{
		int pid=Integer.parseInt(request.getParameter("pid"));
		Double price=Integer.parseDouble(request.getParameter(pPrice));
		int qty=Integer.parseInt(request.getParameter("pQty"));
		String pname=request.getParameter("pname");
		String imgName=request.getParameter("imgName");
		Cart cartExist= cartDaoImpl.getCartById(pid,userEmail);
		if(cartExist==null)
		{
			Cart cm=new Cart();
			cm.setCartPrice(price);
			cm.setCartProductID(pid);
			cm.setCartStock(qty);
			cm.setCartImage(imgName);
			cm.setCartProductName(pname);
			
			User u=userDaoImpl.findUserByEmail(userEmail);
			cm.setCartUserDetails(u);
			cartDaoImpl,insertCart(cm);
		}
		else if(cartExist!=null)
		{
			Cart cm=new Cart();
			cm.setCartId(cartExist.getCartId());
			cm.setCartPrice(price);
			cm.setCartProductID(pid);
			cm.setCartStock(cartExist.getCartStock()+qty);
			cm.setCartImage(imgName);
			cm.setCartProductName(pname);
			
			User u=userDaoImpl.findUserByEmail(userEmail);
			cm.setCartUserDetails(u);
			cartDaoImpl.updateCart(cm);
			
			
		}
		mv.addObject("cartInfo",cartDaoImpl.findCartID(Email));
		mv.setViewName("cart");
		return mv;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		mv.addObject("cartInfo",cartDaoImpl.findByCartID(userEmail));
		mv.setViewName("cart");
		return mv;
	}
	
}

@RequestMapping(value="/checkout" method=RequestMethod.GET)
public ModelAndView checkoutProcess(HttpServletRequest req)
{
	ModelAndView mv=new ModelAndView();
	Principal principal=req.getUserPrincipal();
	String userEmail=principal.getName();
	User u=userDaoImpl.findUserByEmail(userEmail);
	List<Cart> cart=cartDaoImpl.findByCartID(userEmail);
	mv.addObject("user",u);
	mv.addObject("cart",cart);
	return mv;
}

RequestMapping(value="/Orderprocess",method=RequestMethod.GET)
public ModelAndView orderProcess(HttpServletRequest req)
{
	ModelAndView mv=new ModelAndView();
	Orders ord=new Orders();
	Principal principal=req.getUserPrincipal();
	String userEmail=principal.getName();
	Double total= Double.parseDouble(req.getParameter("total"));
	String payment=req.getParameter("payment");
	User u=userDaoImpl.findUserByEmail(userEmail);
	ord.setUser(user);
    ord.setTotal(total);
ord.setPayment(payment);
ordersDaoImpl.insertOrder(ord);
mv.addObject("orderDetails",u);
mv.setViewName("ack");
return mv;
}

}
