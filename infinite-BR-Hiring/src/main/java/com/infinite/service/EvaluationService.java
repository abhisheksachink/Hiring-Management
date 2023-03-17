package com.infinite.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.model.BussinessRequirement;
import com.infinite.model.Evaluation;
import com.infinite.repository.EvaluationRepository;




@Service
public class EvaluationService {
	
	
	@Autowired
	EvaluationRepository evrepo;
	
	public void addEvaluation(Evaluation ev) {
		evrepo.save(ev);
	}
	
public List<Evaluation> getEvaluation(){
	
		List<Evaluation> evaluations = (List<Evaluation>)evrepo.findAll();
		return evaluations;
	}

//public Evaluation getEvaluationDetail(int evaluation_id) {
//	
//}
public String getEvaluationComment(int evaluationId) {
	List<Evaluation> evaluations = (List<Evaluation>)evrepo.findAll();

	String comment=null;
	for(Evaluation evln: evaluations) {
		if(evln.getEvaluation_id()==evaluationId){

			comment=evln.getEvln_comnts();
			
		}

		
}
	return comment;
	
}
public String getScreenResult(int evaluationId) {
	List<Evaluation> evaluations = (List<Evaluation>)evrepo.findAll();

	String screenRes=null;
	for(Evaluation evln: evaluations) {
		if(evln.getEvaluation_id()==evaluationId){

			screenRes=evln.getScreen_result();
			
		}

		
}
	return screenRes;
	
}

public String getL1Result(int evaluationId) {
	List<Evaluation> evaluations = (List<Evaluation>)evrepo.findAll();

	String l1Res=null;
	for(Evaluation evln: evaluations) {
		if(evln.getEvaluation_id()==evaluationId){

			l1Res=evln.getL1_evln_result();
			
		}

		
}
	return l1Res;
	
}


//public Boolean getClientStatus(int evaluationId) {
//	List<Evaluation> evaluations = (List<Evaluation>)evrepo.findAll();
//
//	String ClientStat=null;
//	for(Evaluation evln: evaluations) {
//		if(evln.getEvaluation_id()==evaluationId){
//
//			ClientStat=evln.get
//			
//		}
//
//		
//}
//	return ClientStat;
//	
//}


public Date getScreenDate(int evaluationId) {
	List<Evaluation> evaluations = (List<Evaluation>)evrepo.findAll();

	Date screenDate=null;
	for(Evaluation evln: evaluations) {
		if(evln.getEvaluation_id()==evaluationId){

			screenDate=evln.getScreen_date();
			
		}

		
}
	return screenDate;
	
}

public Date getL1Date(int evaluationId) {
	List<Evaluation> evaluations = (List<Evaluation>)evrepo.findAll();

	Date L1Date=null;
	for(Evaluation evln: evaluations) {
		if(evln.getEvaluation_id()==evaluationId){

			L1Date=evln.getL1_evln_date();
			
		}

		
}
	return L1Date;
	
}

}
