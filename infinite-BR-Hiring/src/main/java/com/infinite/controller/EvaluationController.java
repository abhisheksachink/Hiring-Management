package com.infinite.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.infinite.model.Evaluation;
import com.infinite.repository.EvaluationRepository;
import com.infinite.service.BussinessRequirementService;
import com.infinite.service.EvaluationService;

@Controller
public class EvaluationController {
	
	@Autowired
	EvaluationService evService;
	
	@Autowired
	BussinessRequirementService brservice;
	
	@Autowired
	EvaluationRepository evRepo;
	
	@RequestMapping(value = "/evaluation/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.GET)
	public ModelAndView displayHome(ModelMap map,HttpServletRequest request,@PathVariable("admin_id") Integer admin_id,@PathVariable("admin_name") String admin_name,@PathVariable("admin_role") String admin_role,HttpSession session,BussinessRequirement BR ,Admin admin, Evaluation evaluation) {
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);
//		ModelAndView mav1 = new ModelAndView("evaluation");
		if(admin_role.equalsIgnoreCase("HR")) {
			ModelAndView mav1 = new ModelAndView("evaluationHr");
			List<Evaluation> evaluations= evService.getEvaluation();

			mav1.addObject("evaluationsdata", evaluations);
			
			return mav1;
		}
		else if(admin_role.equalsIgnoreCase("Manager")) {
			ModelAndView mav1 = new ModelAndView("evaluation");
			List<Evaluation> evaluations= evService.getEvaluation();

			mav1.addObject("evaluationsdata", evaluations);
			
			return mav1;
		}
		else if(admin_role.equalsIgnoreCase("Client")) {
			ModelAndView mav1 = new ModelAndView("EvaluationClient");
			List<Evaluation> evaluations= evService.getEvaluation();

			mav1.addObject("evaluationsdata", evaluations);
			
			return mav1;
		}
		else {
			
		
		ModelAndView mav2 = new ModelAndView("home");
		return mav2;
		}
	}
		

		

	
	@RequestMapping(value="/addCandidate/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.POST)
	public ModelAndView addToAdmin(ModelMap map,HttpServletRequest request,@PathVariable("admin_id") Integer admin_id,@PathVariable("admin_name") String admin_name,@PathVariable("admin_role") String admin_role,HttpSession session,BussinessRequirement BR ,Admin admin,Evaluation ev) throws ParseException {
		
		
		String candName=request.getParameter("cand_name") ;
		String through=request.getParameter("through") ;
		String grade=request.getParameter("grade") ;
		String location=request.getParameter("location") ;
		String source=request.getParameter("source") ;
		String skill=request.getParameter("skill") ;
		String brNo = request.getParameter("brNo");
		int brId=brservice.getBrId(brNo);


		admin.setAdmin_id(admin_id);
		BR.setBr_id(brId);
//		BR.setBr_num(brNo);
		ev.setBr(BR);
		ev.setBr_number(brNo);
		ev.setCand_name(candName);
		ev.setEsource(source);
		ev.setGrade(grade);
		ev.setLocation(location);
		ev.setThrough(through);
		ev.setSkill(skill);
	

		
		evService.addEvaluation(ev);
		
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);
		map.addAttribute("br_number", brNo);
		map.addAttribute("addStatus","Evaluation Detail added Successfully");
		ModelAndView mav1 = new ModelAndView("evaluationHr");
		List<Evaluation> evaluations= evService.getEvaluation();

		mav1.addObject("evaluationsdata", evaluations);
		
		return mav1;
		
			
	
	}

	
	@RequestMapping(value = "/hravaluate/{evaluation_id}/{Cand_name}/{Through}/{Grade}/{Location}/{Esource}/{Skill}/{Br_number}/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.GET)
	public ModelAndView hrEvaluate(ModelMap map,HttpServletRequest request,@PathVariable("admin_id") Integer admin_id,@PathVariable("evaluation_id") Integer evaluation_id,@PathVariable("admin_name") String admin_name,@PathVariable("Cand_name") String Cand_name,@PathVariable("Through") String Through,@PathVariable("Grade") String Grade,@PathVariable("Esource") String Esource,@PathVariable("Location") String Location,@PathVariable("Skill") String Skill,@PathVariable("Br_number") String Br_number,@PathVariable("admin_role") String admin_role,HttpSession session,BussinessRequirement BR ,Admin admin, Evaluation ev) {
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);
		map.addAttribute("evaluation_id", evaluation_id);
		map.addAttribute("Cand_name", Cand_name);
		map.addAttribute("Through", Through);
		map.addAttribute("Grade", Grade);
		map.addAttribute("Location", Location);
		map.addAttribute("Esource", Esource);
		map.addAttribute("Skill", Skill);
		map.addAttribute("Br_number", Br_number);

		String evaln_comment=evService.getEvaluationComment(evaluation_id);
		String screenResult=evService.getScreenResult(evaluation_id);
		Date screenDate=evService.getScreenDate(evaluation_id);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String screen_Date = dateFormat.format(screenDate);
		map.addAttribute("evln_comment", evaln_comment);
		map.addAttribute("screen_result", screenResult);
		map.addAttribute("screen_date", screen_Date);

			ModelAndView mav1 = new ModelAndView("evaluationHrUpdate");

			
			return mav1;
		
		

	}
	
	@RequestMapping(value = "/testing/{evaluation_id}/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.GET)
	public ModelAndView test(ModelMap map,HttpServletRequest request,HttpSession session,BussinessRequirement BR ,Admin admin, Evaluation ev) {
System.out.println("working");
			ModelAndView mav1 = new ModelAndView("home");

			
			return mav1;
		
		

	}
	@RequestMapping(value ="/screenevaluate/{evaluate_id}/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.POST)
	public ModelAndView hrEvaluateScreening(ModelMap map,HttpServletRequest request,@PathVariable("evaluate_id") Integer evaluate_id,@PathVariable("admin_id") Integer admin_id,@PathVariable("admin_role") String admin_role,@PathVariable("admin_name") String admin_name,HttpSession session,BussinessRequirement BR ,Admin admin, Evaluation ev) throws ParseException {

		String candName=request.getParameter("cand_name");
		String through=request.getParameter("through");
		String loc=request.getParameter("location");
		String sourc=request.getParameter("esource");
		String reqskill=request.getParameter("skill");
		String trBr=request.getParameter("br_number");
		String grad=request.getParameter("grade");
		String screenResult=request.getParameter("screen_result");
		String commnts=request.getParameter("evln_comnts");
		String screenDate = request.getParameter("screen_date");
		Date screendate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("appr_date"));
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);

		int brId=brservice.getBrId(trBr);
		
		admin.setAdmin_id(admin_id);
		BR.setBr_id(brId);
//		BR.setBr_num(brNo);
		ev.setEvaluation_id(evaluate_id);
		ev.setBr(BR);
		ev.setBr_number(trBr);
		ev.setCand_name(candName);
		ev.setEsource(sourc);
		ev.setGrade(grad);
		ev.setLocation(loc);
		ev.setThrough(through);
		ev.setSkill(reqskill);
		ev.setScreen_date(screendate);
		ev.setScreen_result(screenResult);
		ev.setEvln_comnts(commnts);
		evService.addEvaluation(ev);

			ModelAndView mav1 = new ModelAndView("evaluationHr");
			List<Evaluation> evaluations= evService.getEvaluation();

			mav1.addObject("evaluationsdata", evaluations);

			
			return mav1;
		
		

	}
	
	@RequestMapping(value ="/l1evaluate/{evaluate_id}/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.POST)
	public ModelAndView hrEvaluatel1(ModelMap map,HttpServletRequest request,@PathVariable("evaluate_id") Integer evaluate_id,@PathVariable("admin_id") Integer admin_id,@PathVariable("admin_role") String admin_role,@PathVariable("admin_name") String admin_name,HttpSession session,BussinessRequirement BR ,Admin admin, Evaluation ev) throws ParseException {

		System.out.println("okokok");
		String candName=request.getParameter("cand_name");
		String through=request.getParameter("through");
		String loc=request.getParameter("location");
		String sourc=request.getParameter("esource");
		String reqskill=request.getParameter("skill");
		String trBr=request.getParameter("br_number");
		String grad=request.getParameter("grade");
		String screenResult=request.getParameter("screen_result");
		String commnts=request.getParameter("evln_comnts");
		String screenDate = request.getParameter("scrndate");
		Boolean client_evaluation=Boolean.parseBoolean(request.getParameter("clnt_evln"));
		Date screen_date=new SimpleDateFormat("yyyy-MM-dd").parse(screenDate);  
		Date l1EvalDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("appr_date"));
		String l1Result=request.getParameter("l1_result");
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);

		int brId=brservice.getBrId(trBr);
		
		admin.setAdmin_id(admin_id);
		BR.setBr_id(brId);
//		BR.setBr_num(brNo);
		ev.setEvaluation_id(evaluate_id);
		ev.setBr(BR);
		ev.setBr_number(trBr);
		ev.setCand_name(candName);
		ev.setEsource(sourc);
		ev.setGrade(grad);
		ev.setLocation(loc);
		ev.setThrough(through);
		ev.setSkill(reqskill);
		ev.setScreen_date(screen_date);
		ev.setScreen_result(screenResult);
		ev.setEvln_comnts(commnts);
		ev.setL1_evln_date(l1EvalDate);
		ev.setL1_evln_result(l1Result);
		ev.setClnt_evln(client_evaluation);
		evService.addEvaluation(ev);

			ModelAndView mav1 = new ModelAndView("evaluationHr");
			List<Evaluation> evaluations= evService.getEvaluation();

			mav1.addObject("evaluationsdata", evaluations);

			
			return mav1;
		
		

	}
	
	
	@RequestMapping(value = "/clientavaluate/{evaluation_id}/{Cand_name}/{Through}/{Grade}/{Location}/{Esource}/{Skill}/{Br_number}/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.GET)
	public ModelAndView clientEvaluate(ModelMap map,HttpServletRequest request,@PathVariable("admin_id") Integer admin_id,@PathVariable("evaluation_id") Integer evaluation_id,@PathVariable("admin_name") String admin_name,@PathVariable("Cand_name") String Cand_name,@PathVariable("Through") String Through,@PathVariable("Grade") String Grade,@PathVariable("Esource") String Esource,@PathVariable("Location") String Location,@PathVariable("Skill") String Skill,@PathVariable("Br_number") String Br_number,@PathVariable("admin_role") String admin_role,HttpSession session,BussinessRequirement BR ,Admin admin, Evaluation ev) {
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);
		map.addAttribute("evaluation_id", evaluation_id);
		map.addAttribute("Cand_name", Cand_name);
		map.addAttribute("Through", Through);
		map.addAttribute("Grade", Grade);
		map.addAttribute("Location", Location);
		map.addAttribute("Esource", Esource);
		map.addAttribute("Skill", Skill);
		map.addAttribute("Br_number", Br_number);

		String evaln_comment=evService.getEvaluationComment(evaluation_id);
		String screenResult=evService.getScreenResult(evaluation_id);
		String l1Result=evService.getL1Result(evaluation_id);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Date screenDate=evService.getScreenDate(evaluation_id);
		String screen_Date = dateFormat.format(screenDate);
		Date L1Date=evService.getL1Date(evaluation_id);
		String l1_Date = dateFormat.format(L1Date);
		map.addAttribute("evln_comment", evaln_comment);
		map.addAttribute("screen_result", screenResult);
		map.addAttribute("screen_date", screen_Date);

		map.addAttribute("l1_result", l1Result);
		map.addAttribute("l1_date", l1_Date);
			ModelAndView mav1 = new ModelAndView("evaluationClientUpdate");

			
			return mav1;
		
		

	}
	
	@RequestMapping(value ="/clientevaluateupdate/{evaluate_id}/{admin_id}/{admin_name}/{admin_role}", method = RequestMethod.POST)
	public ModelAndView clientEvaluateUpdate(ModelMap map,HttpServletRequest request,@PathVariable("evaluate_id") Integer evaluate_id,@PathVariable("admin_id") Integer admin_id,@PathVariable("admin_role") String admin_role,@PathVariable("admin_name") String admin_name,HttpSession session,BussinessRequirement BR ,Admin admin, Evaluation ev) throws ParseException {

		System.out.println("okokok");
		String candName=request.getParameter("cand_name");
		String through=request.getParameter("through");
		String loc=request.getParameter("location");
		String sourc=request.getParameter("esource");
		String reqskill=request.getParameter("skill");
		String trBr=request.getParameter("br_number");
		String grad=request.getParameter("grade");
		String screenResult=request.getParameter("screen_result");
		String commnts=request.getParameter("evln_comnts");
		String screenDate = request.getParameter("scrndate");
		String l1Date = request.getParameter("l1_Date");
		Boolean client_evaluation=Boolean.parseBoolean("True");
		Date screen_date=new SimpleDateFormat("yyyy-MM-dd").parse(screenDate);  
		Date l1EvalDate=new SimpleDateFormat("yyyy-MM-dd").parse(l1Date);
		Date clientEvalDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("appr_date"));
		String l1Result=request.getParameter("l1_result");
		String clientResult=request.getParameter("client_result");
		map.addAttribute("admin_name",admin_name);
		map.addAttribute("admin_role",admin_role);
		map.addAttribute("admin_id", admin_id);

		int brId=brservice.getBrId(trBr);
		
		admin.setAdmin_id(admin_id);
		BR.setBr_id(brId);
//		BR.setBr_num(brNo);
		ev.setEvaluation_id(evaluate_id);
		ev.setBr(BR);
		ev.setBr_number(trBr);
		ev.setCand_name(candName);
		ev.setEsource(sourc);
		ev.setGrade(grad);
		ev.setLocation(loc);
		ev.setThrough(through);
		ev.setSkill(reqskill);
		ev.setScreen_date(screen_date);
		ev.setScreen_result(screenResult);
		ev.setEvln_comnts(commnts);
		ev.setL1_evln_date(l1EvalDate);
		ev.setL1_evln_result(l1Result);
		ev.setClnt_evln(client_evaluation);
		ev.setClnt_evln_date(clientEvalDate);
		ev.setClnt_evln_result(clientResult);
		evService.addEvaluation(ev);

			ModelAndView mav1 = new ModelAndView("EvaluationClient");
			List<Evaluation> evaluations= evService.getEvaluation();

			mav1.addObject("evaluationsdata", evaluations);

			
			return mav1;
		
		

	}

}
