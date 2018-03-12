package com.obj;

public class Employee {
	
	
	private String emp_userid ;
	private String emp_name ;
	private String emp_password ;
	private String emp_jobcard_no ;
	private String emp_village ;
	private String emp_district ;
	private String emp_gp ;
	private String emp_phone ;
	private String emp_email ;
	private boolean emp_approve ;
	
	public Employee(String emp_userid, String emp_name, String emp_password,
			String emp_jobcard_no, String emp_village, String emp_district,
			String emp_gp, String emp_phone, String emp_email, boolean emp_approve) {
		super();
		this.emp_userid = emp_userid;
		this.emp_name = emp_name;
		this.emp_password = emp_password;
		this.emp_jobcard_no = emp_jobcard_no;
		this.emp_village = emp_village;
		this.emp_district = emp_district;
		this.emp_gp = emp_gp;
		this.emp_phone = emp_phone;
		this.emp_email = emp_email;
		this.emp_approve = emp_approve;
	}

	public Employee() {
		super();
	}

	public String getEmp_userid() {
		return emp_userid;
	}

	public void setEmp_userid(String emp_userid) {
		this.emp_userid = emp_userid;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

	public String getEmp_jobcard_no() {
		return emp_jobcard_no;
	}

	public void setEmp_jobcard_no(String emp_jobcard_no) {
		this.emp_jobcard_no = emp_jobcard_no;
	}

	public String getEmp_village() {
		return emp_village;
	}

	public void setEmp_village(String emp_village) {
		this.emp_village = emp_village;
	}

	public String getEmp_district() {
		return emp_district;
	}

	public void setEmp_district(String emp_district) {
		this.emp_district = emp_district;
	}

	public String getEmp_gp() {
		return emp_gp;
	}

	public void setEmp_gp(String emp_gp) {
		this.emp_gp = emp_gp;
	}

	public String getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public boolean isEmp_approve() {
		return emp_approve;
	}

	public void setEmp_approve(boolean emp_approve) {
		this.emp_approve = emp_approve;
	}
	
		
	
}
