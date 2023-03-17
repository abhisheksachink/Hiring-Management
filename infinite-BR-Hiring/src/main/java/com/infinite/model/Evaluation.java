package com.infinite.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "INFINITE_BR_EVALUATION")
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int evaluation_id;
	private String cand_name;
	private String through;
	private String grade;
	private String location;
	private String esource;
	private String skill;
	@ManyToOne
	@JoinColumn(name="br_num", nullable=false)
	private BussinessRequirement br;
	private String br_number;
	private Date screen_date;
	private String screen_result;
	private Date l1_evln_date;
	private String l1_evln_result;
	private boolean clnt_evln;
	private Date clnt_evln_date;
	private String clnt_evln_result;
	private Date manager_evln_date;
	private String manager_evln_result;
	private String status;
	private String evln_comnts;
	private Date doj;
	
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evaluation(int evaluation_id, String cand_name, String through, String grade, String location,
			String esource, String skill, BussinessRequirement br, String br_number, Date screen_date,
			String screen_result, Date l1_evln_date, String l1_evln_result, boolean clnt_evln, Date clnt_evln_date,
			String clnt_evln_result, Date manager_evln_date, String manager_evln_result, String status,
			String evln_comnts, Date doj) {
		super();
		this.evaluation_id = evaluation_id;
		this.cand_name = cand_name;
		this.through = through;
		this.grade = grade;
		this.location = location;
		this.esource = esource;
		this.skill = skill;
		this.br = br;
		this.br_number = br_number;
		this.screen_date = screen_date;
		this.screen_result = screen_result;
		this.l1_evln_date = l1_evln_date;
		this.l1_evln_result = l1_evln_result;
		this.clnt_evln = clnt_evln;
		this.clnt_evln_date = clnt_evln_date;
		this.clnt_evln_result = clnt_evln_result;
		this.manager_evln_date = manager_evln_date;
		this.manager_evln_result = manager_evln_result;
		this.status = status;
		this.evln_comnts = evln_comnts;
		this.doj = doj;
	}
	
	

}
