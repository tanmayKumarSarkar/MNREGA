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
import com.obj.Employee;

@WebServlet("/employeedetails.xweb")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeDetails() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession(false);
		
		ServletContext ctx=getServletContext();
		String dburl=ctx.getInitParameter("dburl");
		String usr=ctx.getInitParameter("usr");
		String pwd=ctx.getInitParameter("pwd");
		String driver=ctx.getInitParameter("driver");
		
		String userid=request.getParameter("userid");
		
		response.setContentType("text/html");
		PrintWriter pen=response.getWriter();
		
		pen.write("in");
		
		EmployeeDAO app=new EmployeeDAO(usr, pwd,dburl, driver);
		try{
			
			
			Employee emp=app.viewProfile(userid);
			
			if(emp!=null){
				request.setAttribute("employee_Details", emp);
				RequestDispatcher rd=request.getRequestDispatcher("content/empdetails.jsp");
				rd.forward(request, response);
				
			}
			else{
				request.setAttribute("employee_Details", null);
				RequestDispatcher rd=request.getRequestDispatcher("content/empdetails.jsp");
				rd.forward(request, response);
				
				
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request,response);
	}

}
