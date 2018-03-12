package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.obj.Gp;
import com.obj.LoginAdmin;


public class GpDAO {
	
	private String usr,pwd,dburl,driver;

	public GpDAO(String usr, String pwd, String dburl, String driver) {
		
		this.usr = usr;
		this.pwd = pwd;
		this.dburl = dburl;
		this.driver = driver;
	}
	
	
	
	public boolean checkLogin(LoginAdmin admn) throws Exception{
		
				String qry="SELECT * FROM gpTable WHERE gpTable.user_gp = ? AND gpTable.pass_gp = ?;";
				
				Class.forName(driver);
				Connection conn=DriverManager.getConnection(dburl,usr,pwd);
				PreparedStatement pst=conn.prepareStatement(qry);
				pst.setString(1,admn.getUser_gp());
				pst.setString(2,admn.getPass_gp());
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()){
					return true;
				}else{return false;}
	}
	
/*-----------------------------------------------------------------------------------------------------------------------------*/	
	public int totalprojects(String gp_name) throws Exception{
		
		String qry="SELECT * FROM projectTable WHERE prj_gp_name ='"+gp_name+"';";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);	
		ResultSet rs = pst.executeQuery();
		int i=0;
		while(rs.next()){
			i++;			
		}
		return i;
}
	
/*-----------------------------------------------------------------------------------------------------------------------------*/		
	public int totalEmployee(String gp_name) throws Exception{
		
		String qry="SELECT * FROM emptable WHERE emp_gp  ='"+gp_name+"';";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);	
		ResultSet rs = pst.executeQuery();
		int i=0;
		while(rs.next()){
			i++;			
		}
		return i;
}
	
/*-----------------------------------------------------------------------------------------------------------------------------*/		
	public int totalProjectApproval(String gp_name) throws Exception{
		
		String qry="SELECT * FROM applyProject WHERE gp_name  ='"+gp_name+"' and CURDATE() <= prj_starting_date and app_prj_approval = false ;";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);	
		ResultSet rs = pst.executeQuery();
		int i=0;
		while(rs.next()){
			i++;			
		}
		return i;
}
/*-----------------------------------------------------------------------------------------------------------------------------*/		
	public int totalEmployeeApproval(String gp_name) throws Exception{
		
		String qry="SELECT * FROM emptable WHERE emp_gp ='"+gp_name+"' and emp_approve=false;";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);	
		ResultSet rs = pst.executeQuery();
		int i=0;
		while(rs.next()){
			i++;			
		}
		return i;
}	
	
/*-----------------------------------------------------------------------------------------------------------------------------*/		
public int totalOngoingProjects(String gp_name) throws Exception{
		
		String qry="SELECT * FROM projecttable WHERE prj_gp_name ='"+gp_name+"' AND CURDATE() BETWEEN prj_starting_date AND prj_ending_date ;";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);	
		ResultSet rs = pst.executeQuery();
		int i=0;
		while(rs.next()){
			i++;			
		}
		return i;
}	

/*-----------------------------------------------------------------------------------------------------------------------------*/	
	public boolean updatePassword(String userid,String nw_pwd) throws Exception{
		
		String qry="UPDATE `mnrega_db`.`gpTable` SET pass_gp` = ? WHERE gpTable.user_gp = ?;";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		pst.setString(1, nw_pwd);
		pst.setString(2,userid );
		
		int rs = pst.executeUpdate();
		
		if(rs==1){
			return true;
		}else{return false;}
	}
/*-----------------------------------------------------------------------------------------------------------------------------*/		
	public Gp viewProfile(String userid) throws Exception{
		
		Gp admin =new Gp();
		
		String qry="SELECT * FROM `mnrega_db`.`gpTable` WHERE user_gp = '"+userid+"';";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			admin.setUser_gp(rs.getString(1));
			admin.setPass_gp(rs.getString(2));
			admin.setName(rs.getString(3));
			admin.setAddress(rs.getString(4));
			admin.setPhone(rs.getString(5));
			admin.setEmail(rs.getString(6));
			admin.setDistrict(rs.getString(7));
			admin.setVillage(rs.getString(8));
			
			
			return admin;
		}else{return null;}
		
	}
	/*-----------------------------------------------------------------------------------------------------------------------------*/	
}
