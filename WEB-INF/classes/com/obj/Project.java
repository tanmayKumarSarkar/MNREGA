package com.obj;

public class Project {

	
	private String prj_name ;
	private int prj_id ;
	private String prj_description ;
	private String prj_starting_date;
	private String prj_ending_date ;
	private int prj_total_seat ;
	private int prj_left_seat ;
	private String prj_gp_name;
	
	
	public Project(String prj_name, int prj_id, String prj_description,
			String prj_starting_date, String prj_ending_date,
			int prj_total_seat, int prj_left_seat, String prj_gp_name) {
		super();
		this.prj_name = prj_name;
		this.prj_id = prj_id;
		this.prj_description = prj_description;
		this.prj_starting_date = prj_starting_date;
		this.prj_ending_date = prj_ending_date;
		this.prj_total_seat = prj_total_seat;
		this.prj_left_seat = prj_left_seat;
		this.prj_gp_name = prj_gp_name;
	}


	public Project() {
		super();
	}


	public String getPrj_name() {
		return prj_name;
	}


	public void setPrj_name(String prj_name) {
		this.prj_name = prj_name;
	}


	public int getPrj_id() {
		return prj_id;
	}


	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}


	public String getPrj_description() {
		return prj_description;
	}


	public void setPrj_description(String prj_description) {
		this.prj_description = prj_description;
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


	public int getPrj_total_seat() {
		return prj_total_seat;
	}


	public void setPrj_total_seat(int prj_total_seat) {
		this.prj_total_seat = prj_total_seat;
	}


	public int getPrj_left_seat() {
		return prj_left_seat;
	}


	public void setPrj_left_seat(int prj_left_seat) {
		this.prj_left_seat = prj_left_seat;
	}


	public String getPrj_gp_name() {
		return prj_gp_name;
	}


	public void setPrj_gp_name(String prj_gp_name) {
		this.prj_gp_name = prj_gp_name;
	}
	
	
	
}
