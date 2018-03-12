package com.obj;

public class EmpAttendence {
	
	private int attendence_id ;
	private String curr_date ;
	private int prj_id ;
	private String emp_jobcard_no ;
	private String emp_name;
	
	
	public EmpAttendence(int attendence_id, String curr_date, int prj_id,
			String emp_jobcard_no, String emp_name) {
		super();
		this.attendence_id = attendence_id;
		this.curr_date = curr_date;
		this.prj_id = prj_id;
		this.emp_jobcard_no = emp_jobcard_no;
		this.emp_name = emp_name;
	}


	public EmpAttendence() {
		super();
	}


	public int getAttendence_id() {
		return attendence_id;
	}


	public void setAttendence_id(int attendence_id) {
		this.attendence_id = attendence_id;
	}


	public String getCurr_date() {
		return curr_date;
	}


	public void setCurr_date(String curr_date) {
		this.curr_date = curr_date;
	}


	public int getPrj_id() {
		return prj_id;
	}


	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}


	public String getEmp_jobcard_no() {
		return emp_jobcard_no;
	}


	public void setEmp_jobcard_no(String emp_jobcard_no) {
		this.emp_jobcard_no = emp_jobcard_no;
	}


	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	
	

}
