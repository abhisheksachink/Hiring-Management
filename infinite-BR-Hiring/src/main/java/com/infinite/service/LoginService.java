package com.infinite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.model.Admin;
import com.infinite.repository.AdminRepository;

@Service
public class LoginService {

	@Autowired
	AdminRepository adminRepository;
	
	
	public String getAdminRole(int empId, String password) {
		List<Admin> admins = (List<Admin>)adminRepository.findAll();
	
		String adminRole = null;
		for(Admin usr: admins) {
			if(usr.getEmpl_id()==empId && usr.getAdmin_password().equals(password)) {
				adminRole=usr.getRole();
				
			}
			
	}
		return adminRole;
		
	}
	
	public String getAdminName(int empId, String password) {
		List<Admin> admins = (List<Admin>)adminRepository.findAll();
	
		String adminName=null;
		for(Admin usr: admins) {
			if(usr.getEmpl_id()==empId && usr.getAdmin_password().equals(password)) {
				adminName=usr.getAdmin_name();
				
			}
			
	}
		return adminName;
		
	}
	
	public int getAdminId(int empId, String password) {
		List<Admin> admins = (List<Admin>)adminRepository.findAll();
	
		int adminId=0;
		for(Admin usr: admins) {
			if(usr.getEmpl_id()==empId && usr.getAdmin_password().equals(password)) {
				adminId=usr.getAdmin_id();
				
			}
			
	}
		return adminId;
		
	}
	
	
public boolean validateAdmin(int empId, String password) {
		
		List<Admin> admins = (List<Admin>)adminRepository.findAll();
		boolean isValid = false;
		for(Admin usr: admins) {
			if(usr.getEmpl_id()==empId && usr.getAdmin_password().equals(password)) {
				
				
				isValid = true;
			}
			
		}
		return isValid;
		
		/*
		 * if(userName.equals("john") && password.equals("1234")) { return true; } else
		 * { return false; }
		 */
	}
}
