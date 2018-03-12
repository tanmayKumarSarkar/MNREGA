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
import com.obj.Employee;
import com.obj.Project;

/**
 * Servlet implementation class MyProjectDetails
 */
@WebServlet("/MyProjectDetails.xweb")
public class MyProjectDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProjectDetails() {
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
		
		HttpSession session=req.getSession(false);
		Employee lgn_emp=(Employee)session.getAttribute("lgn_emp");
		String emp_userid=lgn_emp.getEmp_userid();
		String jobcard_no=lgn_emp.getEmp_jobcard_no();
		EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
		
		pen.print(jobcard_no);
		
		try {
			ApplicationProject ap_pr=empdao.viewCurrentRunningProject(jobcard_no);
			
			if(ap_pr!=null){
			Project ap_p=empdao.getDetailsOfTheProjectByProjectId(ap_pr.getPrj_id());
			pen.print(ap_p.getPrj_name());
			req.setAttribute("ap_p", ap_p);
			RequestDispatcher rd=req.getRequestDispatcher("content/MyProjectDetails.jsp");
			rd.forward(req, res);
			}else{
			req.setAttribute("ap_p", null);
			RequestDispatcher rd=req.getRequestDispatcher("content/MyProjectDetails.jsp");
			rd.forward(req, res);}
			
		} catch (Exception e) {
			e.printStackTrace();	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
