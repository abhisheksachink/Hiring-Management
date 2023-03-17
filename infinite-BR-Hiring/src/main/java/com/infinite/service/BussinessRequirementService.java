package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.model.Admin;
import com.infinite.model.BussinessRequirement;
import com.infinite.repository.BussinessRequirementRepository;

@Service
public class BussinessRequirementService {
	
	@Autowired
	BussinessRequirementRepository brrepo;
	
	public void addBR(BussinessRequirement br) {
		brrepo.save(br);
	}
	
public List<BussinessRequirement> getBR(){
		
		List<BussinessRequirement> bussinessreq = (List<BussinessRequirement>)brrepo.findAll();
		return bussinessreq;
	}


public int getBrId(String brNo) {
	List<BussinessRequirement> bussinessreq = (List<BussinessRequirement>)brrepo.findAll();

	int brId=0;
	for(BussinessRequirement brs: bussinessreq) {
		if(brs.getBr_num().equalsIgnoreCase(brNo)) {
			brId=brs.getBr_id();
			
		}

		
}
	return brId;
	
}

}
