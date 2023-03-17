package com.infinite.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "INFINITE_BR")
public class BussinessRequirement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int br_id;
	
	@ManyToOne
	@JoinColumn(name="admin_id", nullable=false)
	private Admin br_creator;
	private String br_num;
	
	private String project;
	private Date approve_date;
	private String status;
	private int age;
	
	@OneToMany(mappedBy="br", cascade=CascadeType.ALL)
	private List<Evaluation> evaluations;



	public BussinessRequirement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BussinessRequirement(int br_id, Admin br_creator, String br_num, String project, Date approve_date,
			String status, int age, List<Evaluation> evaluations) {
		super();
		this.br_id = br_id;
		this.br_creator = br_creator;
		this.br_num = br_num;
		this.project = project;
		this.approve_date = approve_date;
		this.status = status;
		this.age = age;
		this.evaluations = evaluations;
	}

	
	
}
