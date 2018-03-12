package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.obj.Project;

public class ApproveProjectDAO {
	
	
	private String usr,pwd,dburl,driver;

	public ApproveProjectDAO(String usr, String pwd, String dburl, String driver) {
		
		this.usr = usr;
		this.pwd = pwd;
		this.dburl = dburl;
		this.driver = driver;
	}
	
	public boolean approved_prj(int prj,int prj_id) throws Exception{
		
		String qry1="update applyproject set app_prj_approval = true where app_prj_id = "+prj+" ;";
		String qry2="update projecttable set prj_left_seat  = prj_left_seat-1  where prj_id  = "+prj_id+" and prj_left_seat >= 0 ;";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst1=conn.prepareStatement(qry1);
		PreparedStatement pst2=conn.prepareStatement(qry2);
		int rs1 = pst1.executeUpdate();
		int rs2 = pst2.executeUpdate();
		
		if(rs1==1 && rs2==1){
			return true;
		}else{return false;}
		
	}

}
