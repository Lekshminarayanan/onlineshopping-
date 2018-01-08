package com.Controller;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.DaoImpl.*;
import com.model.*;
@Controller
@RequestMapping("/admin")
public class adminController
{
@Autowired; 

SupplierDaoImpl supplierDaoImpl;
@Autowired
CategoryDaoImpl categoryDaoImpl; 

@Autowired
ProductDaoImpl productDaoImpl;

@RequestMapping("/adding")
public String adding()	
{
	
	return "Modal";
	
}
	@RequestMapping(value="/saveSupp",method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveSuppData(@RequestParam ("sid")int sid, @RequestParam("sname")String sname)
	{
		ModelAndView mv=new ModelAndView();
Supplier ss=new Supplier();	
ss.setSid(sid);ss.setSupplierName(sname);
supplierDaoImpl.insertSupplier(ss);mv.setViewName("modal");		
		return mv;
		
		
	}
	
	@RequestMapping(value="/saveCat",method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveCatData(@RequestParam ("cid")int sid,@RequestParam("cname")String sname)
	{
		ModelAndView mv=new ModelAndView();
Category cc=new Supplier();	
ss.setCid(Cid);cc.setCategoryName(cname);
categoryDaoImpl.insertCategory(cc);mv.setViewName("Modal");		
		return mv;
		
		
	}
	
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public String saveProd(HttpServletRequest request,@RequestParam("file")MultipartFile file)
	{
		Product prod=new Product();
		prod.setPname=(request.getParameter("pName"));
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
	    prod.setDescription(request.getParameter("pDescription"));	
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
	    prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(request.getParameter("pCategory"))));
	    prod.setCategory(supplierDaoImpl.findByCatId(Integer.parseInt(request.getParameter("pSupplier"))));						
						
	String filepath=request.getSession().getServletContext().getRealPath("/");
	String filename=file.getOriginalFilename();
	prod.setImgName(filename);
	
	productDaoImpl.insertProduct(prod);
	    System.out.println("File path"+filepath);
	    
	    try {
	    	
	    	byte imagebyte[]=file.getBytes();
	    	BufferedOutputStream fos =new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
	    	
	    	fos.write(imagebyte);
	    	fos.close();
	    	
	    	
	    }
	    catch(IOException e)
	    {
	    	e.printStackTrace();
	    	
	    	
	    }
	    return "Modal";
	}
	@ModelAttribute
	public void loadingDataInPage(Model m)
	{
		m.addAttribute("satList",supplierDaoImpl.retrieve());
		m.addAttribute("catList",categoryDaoImpl.retrieve());
		m.addAttribute("prodList",productDaoImpl.retrieve());
		
		
	}
	@RequestMapping("/productAdminList")
	public ModelAndView prodlist()
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("prodList",productDaoImpl.retrieve());
        mv.setViewName("productAdminList");
        return mv;
	}
	
	@RequestMapping("/supplierList")
	public ModelAndView supplist()
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("satList",supplierDaoImpl.retrieve());
        mv.setViewName("suppAdminList");
        return mv;
	}
	
	@RequestMapping("/categoryList")
	public ModelAndView catlist()
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("catList",categoryDaoImpl.retrieve());
        mv.setViewName("categoryAdminList");
        return mv;
	}
	
	@RequestMapping("/deleteProd/{pid}")
	public String deleteProduct(@PathVariable("pid")int pid)
	{
		productDaoImpl.deleteProd(pid);
		return "redirect:/admin/productList?del";
	}
	
	@RequestMapping("/updateProd")
public ModelAndView updateproduct(@RequestParam("pid") int pid)
{
		ModelAndView mv=new ModelAndView();
		Product p=productDaoImpl.findByPID(pid);
		mv.addObject("prod",p);
		mv.addObject("catList",categoryDaoImpl.retrieve());
		mv.addObject("satList",supplierDaoImpl.retrieve());
		mv.setViewName("updateProduct");
		return mv;
		
}
	@RequestMapping(value="/productUpdate",method=RequestMethod.POST)
	public String saveProd(HttpServletRequest request,@RequestParam("file")MultipartFile file)
	{
		int pid=request.getParameter("pid");
		Product prod=new Product();
		prod.setPid(Integer.parseInt(pid));s
		prod.setPname=(request.getParameter("pName"));
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
	    prod.setDescription(request.getParameter("pDescription"));	
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
		String cat=request.getParameter("pCategory");
		String sat=request.getParameter("pSpplier");;
	    prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(cat)));
	    prod.setCategory(supplierDaoImpl.findBySuppId(Integer.parseInt(sat)));						
						
	String filepath=request.getSession().getServletContext().getRealPath("/");
	String filename=file.getOriginalFilename();
	prod.setImgName(filename);
	
	productDaoImpl.update(prod);
	    System.out.println("File path"+filepath);
	    
	    try {
	    	
	    	byte imagebyte[]=file.getBytes();
	    	BufferedOutputStream fos =new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
	    	
	    	fos.write(imagebyte);
	    	fos.close();
	    	
	    	
	    }
	    catch(IOException e)
	    {
	    	e.printStackTrace();
	    	
	    	
	    }
	    return "redirect:/productList?update";
	}
	
}
