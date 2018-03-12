package com.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.EmployeeDAO;
import com.obj.ApplicationProject;
import com.obj.EmpAttendence;
import com.obj.Employee;
import com.obj.LoginEmployee;

/**
 * Servlet implementation class EmpLoginServ
 */
@WebServlet("/EmpLoginServ.xweb")
public class EmpLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		ServletContext ctx=getServletContext();
		String dburl=ctx.getInitParameter("dburl");
		String usr=ctx.getInitParameter("usr");
		String pwd=ctx.getInitParameter("pwd");
		String driver=ctx.getInitParameter("driver");

		
		String emp_userid=req.getParameter("userid");
		String emp_password=req.getParameter("password");
		
		res.setContentType("text/html");
		PrintWriter pen=res.getWriter();
		pen.print(emp_userid+","+emp_password);
		
		LoginEmployee lgn_emp= new LoginEmployee(emp_userid,emp_password);
		EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
		
		try {
			if(empdao.checkLogin(lgn_emp)){
				
				Employee emp=empdao.viewProfile(emp_userid);
				HttpSession session= req.getSession(true);
				session.setAttribute("lgn_emp", emp);
				
				
				ApplicationProject ap_pr=empdao.viewCurrentRunningProject(emp.getEmp_jobcard_no());	
				if(ap_pr!=null){session.setAttribute("curr_prj_det",ap_pr);}else{session.setAttribute("curr_prj_det",null);}
				if(ap_pr!=null && empdao.checkForTodaysAttendence(emp.getEmp_jobcard_no())==false){
					EmpAttendence atnd=new EmpAttendence(0,"",ap_pr.getPrj_id(),emp.getEmp_jobcard_no(),emp.getEmp_name());
					empdao.giveAttendence(atnd);}

				
				res.sendRedirect("http://localhost:8080/MNREGAwar/content/welcome_employee.jsp");
				
				/*req.setAttribute("data",lgn_emp );
				RequestDispatcher rd=req.getRequestDispatcher("content/welcome_employee.jsp");
				rd.forward(req, res);*/
			}else{
				res.sendRedirect("http://localhost:8080/MNREGAwar/index.jsp?msg=invalidUserOrPwd");
			}
		} catch (Exception e) {
			res.sendRedirect("http://localhost:8080/MNREGAwar/index.jsp?msg=invalidUserOrPwd");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
