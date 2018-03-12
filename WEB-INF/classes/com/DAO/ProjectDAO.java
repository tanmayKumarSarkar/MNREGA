package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import com.obj.Project;



public class ProjectDAO {
	
	private String usr,pwd,dburl,driver;

	public ProjectDAO(String usr, String pwd, String dburl, String driver) {
		
		this.usr = usr;
		this.pwd = pwd;
		this.dburl = dburl;
		this.driver = driver;
	}
	
	public boolean insertProject(Project prj) throws Exception{
		
		String qry="INSERT INTO projecttable (prj_name,prj_id,prj_description,prj_starting_date,prj_ending_date,prj_total_seat,prj_left_seat,prj_gp_name) VALUES (?,?,?,?,?,?,?,?);";
			
			
					
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(dburl,usr,pwd);
			
			PreparedStatement pst=conn.prepareStatement(qry);
	
			pst.setString(1,prj.getPrj_name());
			pst.setInt(2,prj.getPrj_id());
			pst.setString(3,prj.getPrj_description());
			pst.setString(4, prj.getPrj_starting_date());
			pst.setString(5, prj.getPrj_ending_date());
			pst.setInt(6,prj.getPrj_total_seat());
			pst.setInt(7, prj.getPrj_left_seat());
			pst.setString(8,prj.getPrj_gp_name());
			
			
			
			int rs = pst.executeUpdate();
			
			if(rs==1){
				return true;
			}else{return false;}
		}
		
}