package com.obj;

public class LoginEmployee {
	
	private String emp_userid ;
	private String emp_password ;
	
	public LoginEmployee(String emp_userid, String emp_password) {
		super();
		this.emp_userid = emp_userid;
		this.emp_password = emp_password;
	}

	public LoginEmployee() {
		super();
	}

	public String getEmp_userid() {
		return emp_userid;
	}

	public void setEmp_userid(String emp_userid) {
		this.emp_userid = emp_userid;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	
	

}
