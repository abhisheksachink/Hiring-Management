package com.infinite.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infinite.model.Admin;
import com.infinite.model.BussinessRequirement;
import com.infinite.model.Evaluation;
import com.infinite.service.AdminService;
import com.infinite.service.BussinessRequirementService;
import com.infinite.service.LoginService;

@Controller
public class HomeController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	BussinessRequirementService brservice;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayHello() {
		ModelAndView mav = new ModelAndView("login");
		//map.addAttribute("message", "LOGIN PAGE!");
		return mav;
	}
	
	@RequestMapping(value = "/home/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.GET)
	public ModelAndView displayHome(ModelMap map,HttpServletRequest request,@PathVariable("admin_id") Integer admin_id,@PathVariable("admin_name") String admin_name,@PathVariable("admin_role") String admin_role,HttpSession session,BussinessRequirement BR ,Admin admin) {
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);
		ModelAndView mav1 = new ModelAndView("home");
		List<BussinessRequirement> bussinessReq= brservice.getBR();

		mav1.addObject("bussinessReqdata", bussinessReq);
		
		return mav1;

	}
	
	@RequestMapping(value="/addAdmin", method = RequestMethod.POST)
	public String addToAdmin(ModelMap map,HttpServletRequest request,HttpSession session ,Admin admin) {
		
		int empId=Integer.parseInt(request.getParameter("emp_id"));
		String adminName=request.getParameter("admin_name") ;
		String password=request.getParameter("pswd") ;
		String adminType=request.getParameter("role") ;
		
		admin.setEmpl_id(empId);
		admin.setAdmin_name(adminName);
		admin.setAdmin_password(password);
		admin.setRole(adminType);
		
		adminService.saveAdmin(admin);
		
		
		map.addAttribute("status","Admin Registered Successfully");
		return "login";
			
	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginToAdmin(ModelMap map, HttpServletRequest request,@ModelAttribute("admin") Admin admin,BussinessRequirement bussinessRequirement) {
		int empId =Integer.parseInt(request.getParameter("emp_id")) ;
		String password = request.getParameter("pswd");
		String role =loginService.getAdminRole(empId, password);
		String adminName=loginService.getAdminName(empId, password);
		int adminId=loginService.getAdminId(empId, password);

	
		if(loginService.validateAdmin(empId, password) && role.equalsIgnoreCase("Manager")) {
			map.addAttribute("admin_name",adminName);
			map.addAttribute("admin_role",role);
			map.addAttribute("admin_id", adminId);
			ModelAndView mav1 = new ModelAndView("home");
			List<BussinessRequirement> bussinessReq= brservice.getBR();
	
			mav1.addObject("bussinessReqdata", bussinessReq);
			
			return mav1;
			
		}
		else if(loginService.validateAdmin(empId, password) && role.equalsIgnoreCase("Client")){
			map.addAttribute("admin_name",adminName);
			map.addAttribute("admin_role",role);
			map.addAttribute("admin_id", adminId);
			ModelAndView mav2 = new ModelAndView("home");
			List<BussinessRequirement> bussinessReq= brservice.getBR();
			
			mav2.addObject("bussinessReqdata", bussinessReq);
			return mav2;
			
		}
		else if(loginService.validateAdmin(empId, password) && role.equalsIgnoreCase("HR")){
			map.addAttribute("admin_name",adminName);
			map.addAttribute("admin_role",role);
			map.addAttribute("admin_id", adminId);
			ModelAndView mav1 = new ModelAndView("home");
			List<BussinessRequirement> bussinessReq= brservice.getBR();
	
			mav1.addObject("bussinessReqdata", bussinessReq);
			
			return mav1;
			
		}
		else {
			map.addAttribute("status","Wrong Credentials of login user Try Again");
			ModelAndView mav2 = new ModelAndView("loginStatus");
			return mav2;
			
		
			
		}
		
	}

	

}
