package com.obj;

public class Gp {
	
	
	
	private String user_gp ;
	private String pass_gp ;
	private String name ;
	private String Address ;
	private String phone ;
	private String email ;
	private String district ;
	private String village ;
	
	
	public Gp(String user_gp, String pass_gp, String name, String address,
			String phone, String email, String district, String village) {
		super();
		this.user_gp = user_gp;
		this.pass_gp = pass_gp;
		this.name = name;
		Address = address;
		this.phone = phone;
		this.email = email;
		this.district = district;
		this.village = village;
	}


	public Gp() {
		super();
	}


	public String getUser_gp() {
		return user_gp;
	}


	public void setUser_gp(String user_gp) {
		this.user_gp = user_gp;
	}


	public String getPass_gp() {
		return pass_gp;
	}


	public void setPass_gp(String pass_gp) {
		this.pass_gp = pass_gp;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getVillage() {
		return village;
	}


	public void setVillage(String village) {
		this.village = village;
	}
	
	

}
