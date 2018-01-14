package com.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class adminController {

	@RequestMapping("/admin")
	public String admin()
	{
		return "admin";
		
	}
	
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	ProductDaoImpl 	productDaoImpl;
	
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public String saveProd(HttpServletRequest request,@RequestParam("file")MultipartFile file)
	{
		Product prod=new Product();
		prod.setPname(request.getParameter("pName"));
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
		prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(request.getParameter("pCategory"))));
		prod.setCategory(supplierDaoImpl.findBySuppId(Integer.parseInt(request.getParameter("pSupplier"))));
		
		String filepath=request.Session().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImgName(filename);
		productDaoImpl.insertProduct(prod);
		System.out.println("File path"+filepath);
		try {
			byte imagebyte[]=file.getBytes();
		    BufferedOutputStream fos=new BufferedOutputStream (new FileOutputStream(filePath+"/resources/"));
		    BufferedOutputStream fos=new BufferedOutputStream (new FileOutputStream(filePath+"/resources/"));
		    fos.write(imagebyte);
		    fos.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		return "adding";
	}
	@ModelAttribute
	public void loadingDataImage(Model m)
	{
		m.addAttribute("satList",supplierDaoImpl.retrieve());
		m.addAttribute("catList",categoryDaoImpl.retrieve());
		m.addAttribute("prodList",productDaoImpl.retrieve());
	
	}
	@RequestMapping("/prodList")
	public ModelAndView prodList()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("prodList",productDaoImpl.retrieve());
		mv.setViewName("ProductAdminList");
		return mv;
	}
	@RequestMapping("/supplierList")
	public ModelAndView satList()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("satList",supplierDaoImpl.retrieve());
		mv.setViewName("suppAdmin");
		return mv;
	}


	@RequestMapping("/categoryList")
	public ModelAndView catList()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("catList",categoryDaoImpl.retrieve());
		mv.setViewName("categoryAdminList");
		return mv;
	}

	@RequestMapping(value="/deleteProd/{pid}")
	public String deleteProduct(@PathVariable("pid")int pid)
	{
productDaoImpl.deleteProd(pid);
		return "redirect:/productList?del";
	}

	@RequestMapping("/updateProd")
	public ModelAndView updateproduct(@RequestParam("pid")int pid)
	{
		ModelAndView mv=new ModelAndView();
		Product p=productDaoImpl.findByPID(pid);
		mv.addObject("prod",p);
		mv.addObject("cList",categoryDaoImpl.retrieve());
		mv.addObject("sList",supplierDaoImpl.retrieve());
		mv.setViewName("updateProduct");
		return mv;
	}

	@RequestMapping(value="/productUpdate",method=RequestMethod.POST)
	public String updateprod(HttpServletRequest request,@RequestParam("file")MultipartFile file)
	{
		String pid=request.getParameter("pid");
		Product prod=new Product();
		prod.setPid(Integer.parseInt("pid"));
		prod.setPname(request.getParameter("pName"))
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
		String cat=request.getParameter("pCategory");
		String sat=request.getParameter("pSupplier");
		prod.setCategory(categoryDaoImpl.findByCatId(Integer.parseInt(cat)));
		prod.setSupplier(supplierDaoImpl.findBySuppId(Integer.parseInt(sat)));
		
		
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImgName(filename);
productDaoImpl.update(prod);
System.out.println("File path"+filepath);
		return "redirect:/productList?del";
	}











}
