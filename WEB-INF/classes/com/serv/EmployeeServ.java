package com.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.EmployeeDAO;
import com.obj.Employee;

/**
 * Servlet implementation class Employeeserv
 */
@WebServlet(value="/reg.xweb")
public class EmployeeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServ() {
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

		res.setContentType("text/html");
		PrintWriter pen=res.getWriter();
		
	
		String emp_name=req.getParameter("name").replace("+", " ");
		String emp_userid=req.getParameter("userid").replace("+", " ");
		String emp_jobcard_no=req.getParameter("job_card").replace("+", " ");
		String emp_password=req.getParameter("password").replace("+", " ");
		String emp_district=req.getParameter("district").replace("+", " ");
		String emp_gp=req.getParameter("gp_name").replace("+", " ");
		String emp_village=req.getParameter("village").replace("+", " ");
		String emp_email=req.getParameter("email").replace("%40", "@");
		String emp_phone=req.getParameter("phone").replace("+", " ");
		boolean emp_approve=false;
		
		
		Employee emp=new Employee( emp_userid, emp_name, emp_password,
				 emp_jobcard_no,  emp_village,  emp_district,
				 emp_gp,  emp_phone,  emp_email,  emp_approve);
		
		EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
		
		pen.print(emp_userid+","+ emp_name +","+emp_password+","+
				 emp_jobcard_no+","+  emp_village+","+  emp_district+","+
				 emp_gp+","+ emp_phone+","+ emp_email+","+  emp_approve);
		
		
		try{
			if(empdao.insertEmployee(emp)==true){
				
				HttpSession session= req.getSession(true);
				session.setAttribute("lgn_emp", emp);
				
				//res.sendRedirect("http://localhost:8080/MNREGAwar/content/welcome_employee.jsp");
				
				//pen.print("success");
				
			}else{pen.print("failed");}
			

			//req.setAttribute("data", s);
			//RequestDispatcher rd=req.getRequestDispatcher("p.do");
			//rd.forward(req, res);
			
			

		}catch(Exception e){
			e.printStackTrace();
			pen.print(" catch failed");
		}
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req,res);
				
	}

}
