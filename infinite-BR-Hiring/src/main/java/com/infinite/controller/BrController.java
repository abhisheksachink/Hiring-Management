package com.infinite.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infinite.model.Admin;
import com.infinite.model.BussinessRequirement;
import com.infinite.service.BussinessRequirementService;

@Controller
public class BrController {
	
	@Autowired
	BussinessRequirementService brservice;
	
	@RequestMapping(value="/addRecord/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.POST)
	public ModelAndView addToAdmin(ModelMap map,HttpServletRequest request,@PathVariable("admin_id") Integer admin_id,@PathVariable("admin_name") String admin_name,@PathVariable("admin_role") String admin_role,HttpSession session,BussinessRequirement BR ,Admin admin) throws ParseException {
		
		
		String brNo=request.getParameter("br_num") ;
		String project=request.getParameter("project") ;
		Date appr_date=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("appr_date"));

		String approveDate = request.getParameter("appr_date");
		String status = request.getParameter("status");
		LocalDate curDate = LocalDate.now(); 

//		int admin_id =admin.getAdmin_id();
		String br_creator=admin.getAdmin_name();
		
		LocalDate apprlocalDate = LocalDate.parse(approveDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		Period period = Period.between(apprlocalDate, curDate);  
		int age=((period.getYears()*365)+(period.getMonths()*30)+(period.getDays()));
		
		admin.setAdmin_id(admin_id);
		BR.setBr_num(brNo);
		BR.setProject(project);
		BR.setApprove_date(appr_date);
		BR.setStatus(status);
		BR.setAge(age);
		BR.setBr_creator(admin);

		
		brservice.addBR(BR);
		int brId=brservice.getBrId(brNo);
		
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);
		map.addAttribute("br_id", brId);
		map.addAttribute("addStatus","BR added Successfully");
		ModelAndView mav1 = new ModelAndView("home");
		List<BussinessRequirement> bussinessReq= brservice.getBR();

		mav1.addObject("bussinessReqdata", bussinessReq);
		
		return mav1;
		
			
	
	}

}
