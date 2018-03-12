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
import com.obj.Project;

/**
 * Servlet implementation class ViewProjectAppDetails
 */
@WebServlet("/ViewProjectAppDetails.xweb")
public class ViewProjectAppDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProjectAppDetails() {
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
		int getPrj_id=Integer.parseInt(req.getParameter("getPrj_id"));
		EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
		
		try {
			Project prj_det=empdao.getDetailsOfTheProjectByProjectId(getPrj_id);
			
			req.setAttribute("prj_det", prj_det);
			RequestDispatcher rd=req.getRequestDispatcher("content/NewProjectApplicationPage.jsp");
			rd.forward(req, res);
			
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
