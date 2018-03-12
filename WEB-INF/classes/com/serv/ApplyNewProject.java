package com.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
 * Servlet implementation class ApplyNewProject
 */
@WebServlet("/ApplyNewProject.xweb")
public class ApplyNewProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyNewProject() {
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
		
			
		
		try {
			ApplicationProject ap_pr=empdao.viewCurrentRunningProject(jobcard_no);
			
			if(ap_pr!=null){
				
				Collection<Project> cl_prj= empdao.viewAllSortedProjects(lgn_emp.getEmp_gp(), ap_pr.getPrj_id(), ap_pr.getPrj_ending_date());
				
				Collection<Project> coll_prj=new ArrayList<Project>();
				Iterator<Project> it =cl_prj.iterator();
				
				while(it.hasNext()){
					Project prj_it=it.next();
					if(empdao.checkForAppliedProject(jobcard_no,prj_it.getPrj_id())==false){
						
						coll_prj.add(prj_it);
					}
				}
				
				req.setAttribute("coll_prj", coll_prj);
				RequestDispatcher rd=req.getRequestDispatcher("content/ApplyNewProject.jsp");
				rd.forward(req, res);
			}else{
				
				
				Collection<Project> cl_prj= empdao.viewAllProjects(lgn_emp.getEmp_gp());
				
				Collection<Project> coll_prj=new ArrayList<Project>();
				Iterator<Project> it =cl_prj.iterator();
				
				while(it.hasNext()){
					Project prj_it=it.next();
					if(empdao.checkForAppliedProject(jobcard_no,prj_it.getPrj_id())==false){
						
						coll_prj.add(prj_it);
					}
				}
				
				req.setAttribute("coll_prj", coll_prj);
				RequestDispatcher rd=req.getRequestDispatcher("content/ApplyNewProject.jsp");
				rd.forward(req, res);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
