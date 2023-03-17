package com.infinite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "INFINITE_USER")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int admin_id;
	private int empl_id;
	private String admin_name;
	private String admin_password;
	private String role;
	
	
	@OneToMany(mappedBy="br_creator", cascade=CascadeType.ALL)
	private List<BussinessRequirement> bussinessrequirements;





	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Admin(int admin_id, int empl_id, String admin_name, String admin_password, String role,
			List<BussinessRequirement> bussinessrequirements) {
		super();
		this.admin_id = admin_id;
		this.empl_id = empl_id;
		this.admin_name = admin_name;
		this.admin_password = admin_password;
		this.role = role;
		this.bussinessrequirements = bussinessrequirements;
	}

	
	
}
