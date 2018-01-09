package com.Controller;
import org.springframework.stereotype.Controller;

import com.Dao.UserDao;
@Controller
public class indexController 
{
	UserDaoImpl userDaoImpl;
 @RequestMapping("/")
  public String index()
		{
		
		return "index";
	}
 
 @RequestMapping("/index")
 public String home()
		{
		
		return "index";
	}

 
	 @RequestMapping(value="/goToRegister",method=RequestMethod.GET)
public ModelAndView goToRegister() {
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("user",new User());
		 mv.setViewName("register");
		 return mv;
	 }
	 @RequestMapping(value="/saveRegister",method=RequestMethod.POST)
	 public ModelAndView saveRegister(@Valid @ModelAttribute("user")User user,BindingResult result)
	 {
	 		 ModelAndView mv=new ModelAndView();
	 		 if(result.hasErrors())
	 		 {
	 			 mav.setViewName("register");
	 			 return mav;
	 		 }
	 		 else
	 		 {
	 		 user.setRole("ROLE_USER")
	 		 userDao.insertUser(user);
	 		 mv.setViewName("index");
	 		 return mav;
	 	 }
	 
	 @RequestMapping(value="/productCustList")
	 public ModelAndView getCustTable(@RequestParam("cid")int cid)
	 {
		 ModelAndView mv=new ModelAndVieW();
		 mv.addObject("prodList",productDaoImpl.getProductByCatId());
		 mv.setViewName("productCustList");
		 return mv;
		 
		 
	 }
	 
	 @ModelAttribute
	 public void getData(Model m)
	 {
		 
		 m.addAttribute("catList",categoryDaoImpl.retrieve());
	 }
@RequestMapping("/goToLogin")
public String goToLogin()
{
	return "Login";
	
	
}
@RequestMapping("/userLogged")
public String userlogged()
{
return "redirect:/index";
	

}

@RequestMapping("/error")
public String userError()
{
return "error";
	

}
@RequestMapping("/reLogin")
public String relogin()
{
return "redirect:/goToLogin";
	

}

}
