package com.obj;

public class ApplicationProject {

	private int app_prj_id ;
	private String emp_name ;
	private String emp_jobcard_no ;
	private int prj_id ;
	private String prj_starting_date ;
	private String prj_ending_date ;
	private String gp_name ;
	private boolean app_prj_approval ;
	private String prj_name;
	
	
	public ApplicationProject(int app_prj_id, String emp_name,
			String emp_jobcard_no, int prj_id, String prj_starting_date,
			String prj_ending_date, String gp_name, boolean app_prj_approval,
			String prj_name) {
		super();
		this.app_prj_id = app_prj_id;
		this.emp_name = emp_name;
		this.emp_jobcard_no = emp_jobcard_no;
		this.prj_id = prj_id;
		this.prj_starting_date = prj_starting_date;
		this.prj_ending_date = prj_ending_date;
		this.gp_name = gp_name;
		this.app_prj_approval = app_prj_approval;
		this.prj_name = prj_name;
	}


	public ApplicationProject() {
		super();
	}


	public int getApp_prj_id() {
		return app_prj_id;
	}


	public void setApp_prj_id(int app_prj_id) {
		this.app_prj_id = app_prj_id;
	}


	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public String getEmp_jobcard_no() {
		return emp_jobcard_no;
	}


	public void setEmp_jobcard_no(String emp_jobcard_no) {
		this.emp_jobcard_no = emp_jobcard_no;
	}


	public int getPrj_id() {
		return prj_id;
	}


	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}


	public String getPrj_starting_date() {
		return prj_starting_date;
	}


	public void setPrj_starting_date(String prj_starting_date) {
		this.prj_starting_date = prj_starting_date;
	}


	public String getPrj_ending_date() {
		return prj_ending_date;
	}


	public void setPrj_ending_date(String prj_ending_date) {
		this.prj_ending_date = prj_ending_date;
	}


	public String getGp_name() {
		return gp_name;
	}


	public void setGp_name(String gp_name) {
		this.gp_name = gp_name;
	}


	public boolean isApp_prj_approval() {
		return app_prj_approval;
	}


	public void setApp_prj_approval(boolean app_prj_approval) {
		this.app_prj_approval = app_prj_approval;
	}


	public String getPrj_name() {
		return prj_name;
	}


	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}
	
	
	
	
}
