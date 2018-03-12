package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.obj.Employee;
import com.obj.Gp;
import com.obj.LoginAdmin;
import com.obj.Project;


public class AdminDAO {
	
	private String usr,pwd,dburl,driver;

	public AdminDAO(String usr, String pwd, String dburl, String driver) {
		
		this.usr = usr;
		this.pwd = pwd;
		this.dburl = dburl;
		this.driver = driver;
	}
	

public Collection<Employee> approveList(String user_gp)throws Exception{
		

		
		Collection<Employee> ap_emp_list=new ArrayList<Employee>();
		
		String qry="SELECT * FROM emptable WHERE emp_gp ='"+user_gp+"' and emp_approve=false ;";
		
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);		
		ResultSet rs = pst.executeQuery();
		int i=0;
		
		while(rs.next()){
			String emp_userid   =rs.getString(1);
			String emp_name   =rs.getString(2);
			String emp_jobcard_no   =rs.getString(4);
			String emp_village   =rs.getString(5);
			String emp_district   =rs.getString(6);
			String emp_phone   =rs.getString(8);
			String emp_email   =rs.getString(9);
			i++;
			
			
			
			Employee emp=new Employee( emp_userid, emp_name, null,
					 emp_jobcard_no, emp_village,emp_district,
					 null, emp_phone, emp_email, false);
			ap_emp_list.add(emp);
		}
		
		if(i>0){
			return ap_emp_list;
		}else{ return null;}
	}
	
	public boolean approvedemployee(String userid) throws Exception{
		
		String qry="update emptable set emp_approve = true where emp_userid = '"+userid+"' ;";
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		int up = pst.executeUpdate();
		if(up==1){
		return true;}else{return false;}
	}
	
	//end of the DAO
}
