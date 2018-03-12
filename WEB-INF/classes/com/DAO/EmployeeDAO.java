package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.obj.ApplicationProject;
import com.obj.EmpAttendence;
import com.obj.Employee;
import com.obj.LoginEmployee;
import com.obj.Project;

public class EmployeeDAO {
	
	private String usr,pwd,dburl,driver;

	public EmployeeDAO(String usr, String pwd, String dburl, String driver) {
		
		this.usr = usr;
		this.pwd = pwd;
		this.dburl = dburl;
		this.driver = driver;
	}
	
	public boolean insertEmployee(Employee emp) throws Exception{
		
	String qry="INSERT INTO emptable (emp_userid,emp_name,emp_password,emp_jobcard_no,emp_village,emp_district,emp_gp,emp_phone,emp_email,emp_approve) VALUES (?,?,?,?,?,?,?,?,?,false);";
		
				
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		
		PreparedStatement pst=conn.prepareStatement(qry);
		pst.setString(1,emp.getEmp_userid());
		pst.setString(2,emp.getEmp_name());
		pst.setString(3,emp.getEmp_password());
		pst.setString(4,emp.getEmp_jobcard_no());
		pst.setString(5,emp.getEmp_village());
		pst.setString(6,emp.getEmp_district());
		pst.setString(7,emp.getEmp_gp());
		pst.setString(8,emp.getEmp_phone());
		pst.setString(9,emp.getEmp_email());
		
		
		int rs = pst.executeUpdate();
		
		if(rs==1){
			return true;
		}else{return false;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public boolean checkLogin(LoginEmployee emp) throws Exception{
		
				String qry="SELECT * FROM emptable WHERE emptable.emp_userid = ? AND emptable.emp_password = ?;";
				
				Class.forName(driver);
				Connection conn=DriverManager.getConnection(dburl,usr,pwd);
				PreparedStatement pst=conn.prepareStatement(qry);
				pst.setString(1, emp.getEmp_userid());
				pst.setString(2, emp.getEmp_password());
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()){
					return true;
				}else{return false;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public boolean updatePassword(String userid,String nw_pwd) throws Exception{
		
		String qry="UPDATE `mnrega_db`.`emptable` SET `emp_password` = ? WHERE emptable.emp_userid = ?;";
		
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
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public Employee viewProfile(String userid) throws Exception{
		
		String qry="SELECT * FROM `mnrega_db`.`emptable` WHERE emp_userid = '"+userid+"';";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			String Emp_userid = rs.getString(1);
			String Emp_name = rs.getString(2);
			String Emp_password = rs.getString(3);
			String Emp_jobcard_no = rs.getString(4);
			String Emp_village = rs.getString(5);
			String Emp_district = rs.getString(6);
			String Emp_gp = rs.getString(7);
			String Emp_phone = rs.getString(8);
			String Emp_email = rs.getString(9);
			boolean Emp_approve = rs.getBoolean(10);
			
			Employee emp=new Employee(Emp_userid,Emp_name,Emp_password,Emp_jobcard_no,Emp_village,
						 Emp_district,Emp_gp,Emp_phone,Emp_email,Emp_approve);
			
			return emp;
		}else{return null;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public boolean applyProject(ApplicationProject app) throws Exception{
		
		String qry="INSERT INTO `mnrega_db`.`applyproject`(`emp_name`,`emp_jobcard_no`,`prj_id`,"
		+ "`prj_starting_date`,`prj_ending_date`,`gp_name`,`app_prj_approval`,`prj_name`) VALUES (?,?,?,?,?,?,false,?);";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		pst.setString(1, app.getEmp_name());
		pst.setString(2, app.getEmp_jobcard_no());
		pst.setInt(3, app.getPrj_id());
		pst.setString(4, app.getPrj_starting_date());
		pst.setString(5, app.getPrj_ending_date());
		pst.setString(6, app.getGp_name());
		pst.setString(7, app.getPrj_name());

		int rs = pst.executeUpdate();
		
		if(rs==1){
			return true;
		}else{return false;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public void giveAttendence(EmpAttendence atnd)throws Exception{
		
		String qry="INSERT INTO `mnrega_db`.`empattendence`"
				+ "(`curr_date`,`prj_id`,`emp_jobcard_no`,`emp_name`) VALUES (NOW(),?,?,?);";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		pst.setInt(1,atnd.getPrj_id());
		pst.setString(2,atnd.getEmp_jobcard_no() );
		pst.setString(3,atnd.getEmp_name() );
		
		pst.executeUpdate();
		
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public boolean checkForTodaysAttendence(String emp_jobcard_no) throws Exception{
		
		String qry="SELECT * FROM mnrega_db.empattendence WHERE emp_jobcard_no = '"+emp_jobcard_no+"' and (curr_date > CAST((now() - interval 24 hour) as datetime));";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			return true;	//true means already present
		}else{return false;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public boolean checkBeforeForgotPassword(String userid,String jobcard_no)throws Exception{
		
		String qry="SELECT * FROM mnrega_db.emptable WHERE emp_userid = ? AND emp_jobcard_no = ?;";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		pst.setString(1, userid);
		pst.setString(2, jobcard_no);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			return true;
		}else{return false;}
		
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public Collection<Project> viewAllProjects(String user_gp)throws Exception{
		
		Collection<Project> prj=new ArrayList<Project>();
		
		String qry="SELECT * FROM projecttable WHERE prj_gp_name = '"+user_gp+"' AND prj_left_seat > 0;";
		
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			String prj_name  =rs.getString(1);
			int prj_id =rs.getInt(2);
			String prj_description  =rs.getString(3);
			String prj_starting_date  =rs.getString(4);
			String prj_ending_date  =rs.getString(5);
			int prj_total_seat =rs.getInt(6);
			int prj_left_seat =rs.getInt(7);
			String prj_gp_name  =rs.getString(8);
			
			
	Project p=new Project(prj_name,prj_id,prj_description,prj_starting_date,prj_ending_date,prj_total_seat,prj_left_seat,prj_gp_name);
			prj.add(p);
		}
		
		return prj;
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	
public Collection<Project> viewAllSortedProjects(String user_gp,int curr_prj_id,String curr_prj_end_date)throws Exception{
		
		//current prj end date ,gp name ,userid,current_prj_id
		
		Collection<Project> prj=new ArrayList<Project>();
		
		String qry="SELECT * FROM projecttable WHERE prj_id <> "+curr_prj_id+
				" AND prj_left_seat > 0 AND prj_gp_name = '"+user_gp+"' AND prj_starting_date > '"+curr_prj_end_date+"';";
		
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			String prj_name  =rs.getString(1);
			int prj_id =rs.getInt(2);
			String prj_description  =rs.getString(3);
			String prj_starting_date  =rs.getString(4);
			String prj_ending_date  =rs.getString(5);
			int prj_total_seat =rs.getInt(6);
			int prj_left_seat =rs.getInt(7);
			String prj_gp_name  =rs.getString(8);
			
			
	Project p=new Project(prj_name,prj_id,prj_description,prj_starting_date,prj_ending_date,prj_total_seat,prj_left_seat,prj_gp_name);
			prj.add(p);
		}
		
		return prj;
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public Collection<ApplicationProject> viewCurrentProjects(String jobcard_no)throws Exception{
		
		Collection<ApplicationProject>app_prj=new ArrayList<ApplicationProject>();
	
		String qry="SELECT * FROM applyproject WHERE emp_jobcard_no ='"+jobcard_no+"';";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		ResultSet rs = pst.executeQuery();
		
		
		while(rs.next()){
			
			int app_prj_id =rs.getInt(1);
			String emp_name =rs.getString(2);
			String emp_jobcard_no =rs.getString(3);
			int prj_id =rs.getInt(4);
			String prj_starting_date =rs.getString(5);
			String prj_ending_date =rs.getString(6);
			String gp_name =rs.getString(7);
			boolean app_prj_approval =rs.getBoolean(8);
			String prj_name =rs.getNString(9);
			
			
			ApplicationProject p=new ApplicationProject(app_prj_id,emp_name,emp_jobcard_no,prj_id,prj_starting_date,prj_ending_date,gp_name,app_prj_approval,prj_name);
			app_prj.add(p);
			 
		}	
		return app_prj;
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	
	public ApplicationProject viewCurrentRunningProject(String jobcard_no)throws Exception{
			
		String qry="SELECT * FROM `mnrega_db`.`applyproject` WHERE emp_jobcard_no ='"+jobcard_no+"' AND app_prj_approval =true AND CURDATE() BETWEEN prj_starting_date AND prj_ending_date ;";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		ResultSet rs = pst.executeQuery();
		
		
		while(rs.next()){
			
			int app_prj_id =rs.getInt(1);
			String emp_name =rs.getString(2);
			String emp_jobcard_no =rs.getString(3);
			int prj_id =rs.getInt(4);
			String prj_starting_date =rs.getString(5);
			String prj_ending_date =rs.getString(6);
			String gp_name =rs.getString(7);
			boolean app_prj_approval =rs.getBoolean(8);
			String prj_name =rs.getString(9);
			
			
			ApplicationProject ap=new ApplicationProject(app_prj_id,emp_name,emp_jobcard_no,prj_id,prj_starting_date,prj_ending_date,gp_name,app_prj_approval,prj_name);
			
			return ap;
		}	
		return null;
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public boolean checkForApprovedEmployee(String userid)throws Exception{
		
		String qry="SELECT * FROM emptable WHERE emp_userid = '"+userid+"' AND emp_approve = true;";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			return true;
		}else{return false;}		
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public boolean checkForApprovedProject(String emp_jobcard_no ,int prj_id ) throws Exception{
		
		String qry="SELECT * FROM applyproject WHERE emp_jobcard_no = '"+emp_jobcard_no +
				"' AND app_prj_approval = true AND prj_id = '"+prj_id +"';";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			return true;
		}else{return false;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/

	public boolean checkForAppliedProject(String emp_jobcard_no ,int prj_id) throws Exception{
		
		String qry="SELECT *  FROM `mnrega_db`.`applyproject` WHERE emp_jobcard_no = '"+emp_jobcard_no +
				"' AND prj_id = "+prj_id +";";

		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			return true;
		}else{return false;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public boolean checkApplibleProjectByApprovedProjectDate(String prj_starting_date,String job_card)throws Exception{
		
		String qry="SELECT * FROM mnrega_db.applyproject WHERE emp_jobcard_no = '"+job_card+
				"' AND app_prj_approval =true AND prj_ending_date > '"+prj_starting_date+"';";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			return false;	//Not applible
		}else{return true;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
public boolean checkApplibleProjectByCurrentRunningProjectDate(String prj_starting_date,String curr_pj_end_date)throws Exception{
		
		String qry="SELECT * FROM projectTable WHERE prj_ending_date > '"+prj_starting_date+"';";////Don't Use!!!!!!!!!!!!!
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()){
			return false;	//Not applible
		}else{return true;}
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
public int getTotalNoOfEmployees()throws Exception{
	int i=0;
	String qry="SELECT * FROM mnrega_db.emptable ;";
	
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(dburl,usr,pwd);
	PreparedStatement pst=conn.prepareStatement(qry);
	
	ResultSet rs = pst.executeQuery();
	
	while(rs.next()){
		i++;
	}
	return i;
}

/*--------------------------------------------------------------------------------------------------------*/


	
	public Project getDetailsOfTheProjectByProjectId(int prj_idP )throws Exception{
		
		String qry="SELECT * FROM projecttable WHERE prj_id = "+prj_idP+";";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			String prj_name  =rs.getString(1);
			int prj_id =rs.getInt(2);
			String prj_description  =rs.getString(3);
			String prj_starting_date  =rs.getString(4);
			String prj_ending_date  =rs.getString(5);
			int prj_total_seat =rs.getInt(6);
			int prj_left_seat =rs.getInt(7);
			String prj_gp_name  =rs.getString(8);
			
			
	Project p=new Project(prj_name,prj_id,prj_description,prj_starting_date,prj_ending_date,prj_total_seat,prj_left_seat,prj_gp_name);
			return p;
		}
		return null;
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	
public int getNoOfAvailableSeatsByProjectId(int prj_idP )throws Exception{
		int i=0;
		
		String qry="SELECT * FROM projecttable WHERE prj_id = "+prj_idP+";";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			i++;
		}
		return i;
	}
	
	/*--------------------------------------------------------------------------------------------------------*/
	

public int getTotalNoOfProjects()throws Exception{
	int i=0;
	
	String qry="SELECT * FROM projecttable ;";
	
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(dburl,usr,pwd);
	PreparedStatement pst=conn.prepareStatement(qry);
	
	ResultSet rs = pst.executeQuery();
	
	while(rs.next()){
		i++;
	}
	return i;
}

/*--------------------------------------------------------------------------------------------------------*/

public ApplicationProject getDetailsOfTheApplicationProjectByProjectId(int prj_idAP )throws Exception{
		
		String qry="SELECT * FROM applyproject WHERE prj_id = "+prj_idAP+";";
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(dburl,usr,pwd);
		PreparedStatement pst=conn.prepareStatement(qry);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			int app_prj_id = rs.getInt(1);
			String emp_name   =rs.getString(2);
			String emp_jobcard_no   =rs.getString(3);
			int prj_id =rs.getInt(4);
			String prj_starting_date  =rs.getString(5);
			String prj_ending_date  =rs.getString(6);
			String gp_name =rs.getString(7);
			boolean app_prj_approval =rs.getBoolean(8);
			String prj_name =rs.getString(9);			
			
	ApplicationProject ap=new ApplicationProject(app_prj_id,emp_name,emp_jobcard_no,prj_id,prj_starting_date,prj_ending_date,gp_name,app_prj_approval,prj_name);
			return ap;
		}
		return null;
	}

	/*--------------------------------------------------------------------------------------------------------*/

public Collection<Project> viewUpcomingProjects()throws Exception{
	
	Collection<Project> prj=new ArrayList<Project>();
	
	String qry="SELECT * FROM projecttable WHERE prj_starting_date > CURDATE() AND prj_left_seat > 0 ;";
	
	
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(dburl,usr,pwd);
	PreparedStatement pst=conn.prepareStatement(qry);
	
	ResultSet rs = pst.executeQuery();
	
	while(rs.next()){
		String prj_name  =rs.getString(1);
		int prj_id =rs.getInt(2);
		String prj_description  =rs.getString(3);
		String prj_starting_date  =rs.getString(4);
		String prj_ending_date  =rs.getString(5);
		int prj_total_seat =rs.getInt(6);
		int prj_left_seat =rs.getInt(7);
		String prj_gp_name  =rs.getString(8);
		
		
Project p=new Project(prj_name,prj_id,prj_description,prj_starting_date,prj_ending_date,prj_total_seat,prj_left_seat,prj_gp_name);
		prj.add(p);
	}
	return prj;
}

/*--------------------------------------------------------------------------------------------------------*/

public Collection<Project> viewOngoingProjects()throws Exception{
	
	Collection<Project> prj=new ArrayList<Project>();
	
	String qry="SELECT * FROM projecttable WHERE CURDATE() BETWEEN prj_starting_date AND prj_ending_date ;";
	
	
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(dburl,usr,pwd);
	PreparedStatement pst=conn.prepareStatement(qry);
	
	ResultSet rs = pst.executeQuery();
	
	while(rs.next()){
		String prj_name  =rs.getString(1);
		int prj_id =rs.getInt(2);
		String prj_description  =rs.getString(3);
		String prj_starting_date  =rs.getString(4);
		String prj_ending_date  =rs.getString(5);
		int prj_total_seat =rs.getInt(6);
		int prj_left_seat =rs.getInt(7);
		String prj_gp_name  =rs.getString(8);
		
		
Project p=new Project(prj_name,prj_id,prj_description,prj_starting_date,prj_ending_date,prj_total_seat,prj_left_seat,prj_gp_name);
		prj.add(p);
		
	}
	return prj;
}
	
/*--------------------------------------------------------------------------------------------------------*/

public Collection<EmpAttendence> getAttendenceReport(String emp_job_card)throws Exception{
	
	Collection<EmpAttendence> coll_empAtt=new ArrayList<EmpAttendence>();
	
	String qry="SELECT * FROM mnrega_db.empattendence where emp_jobcard_no = '"+emp_job_card+"';";
	
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(dburl,usr,pwd);
	PreparedStatement pst=conn.prepareStatement(qry);
	
	ResultSet rs = pst.executeQuery();
	
	while(rs.next()){
		int attendence_id =rs.getInt(1);
		String curr_date =rs.getString(2);
		int prj_id =rs.getInt(3);
		String emp_jobcard_no =rs.getString(4);
		String emp_name =rs.getString(5);
		
		EmpAttendence empAtt=new EmpAttendence(attendence_id,curr_date,prj_id,emp_jobcard_no,emp_name);
		coll_empAtt.add(empAtt);
	}
	return coll_empAtt;
}

/*--------------------------------------------------------------------------------------------------------*/

public int getNoOfAppliedProjectsAfterCurDate(String job_card) throws Exception{
	int i=0;
	
	String qry="SELECT * FROM applyproject WHERE emp_jobcard_no ='"+job_card+"' AND prj_starting_date > CURDATE() ;";
	
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(dburl,usr,pwd);
	PreparedStatement pst=conn.prepareStatement(qry);
	ResultSet rs = pst.executeQuery();
	
	while(rs.next()){i++;}
	return i;
	
}


/*--------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------*/

public Collection<Employee> viewAllEmployeeUnderGp(String gp_name)throws Exception {
	
	Collection<Employee> coll_emp=new ArrayList<Employee>();
	
	String qry="SELECT * FROM mnrega_db.emptable where emp_gp = '"+gp_name+"';";
	
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(dburl,usr,pwd);
	PreparedStatement pst=conn.prepareStatement(qry);
	
	ResultSet rs = pst.executeQuery();
	
	while(rs.next()){
		String Emp_userid = rs.getString(1);
		String Emp_name = rs.getString(2);
		String Emp_password = rs.getString(3);
		String Emp_jobcard_no = rs.getString(4);
		String Emp_village = rs.getString(5);
		String Emp_district = rs.getString(6);
		String Emp_gp = rs.getString(7);
		String Emp_phone = rs.getString(8);
		String Emp_email = rs.getString(9);
		boolean Emp_approve = rs.getBoolean(10);
		
		Employee emp=new Employee(Emp_userid,Emp_name,Emp_password,Emp_jobcard_no,Emp_village,
					 Emp_district,Emp_gp,Emp_phone,Emp_email,Emp_approve);
		coll_emp.add(emp);
	}
	return coll_emp;
}

/*--------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------*/
	
}
