package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.infinite.model.Admin;
import com.infinite.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public List<Admin> getAdmins(){
		
		List<Admin> admins = (List<Admin>)adminRepository.findAll();
		return admins;
	}
	
	
	
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}

}
