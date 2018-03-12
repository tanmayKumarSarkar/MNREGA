package com.serv;

import java.io.IOException;

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
 * Servlet implementation class UpdatePasswordServ
 */
@WebServlet("/UpdatePasswordServ.xweb")
public class UpdatePasswordServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doRequest(req,res);
	}
	
	public String doRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ServletContext ctx=getServletContext();
		String dburl=ctx.getInitParameter("dburl");
		String usr=ctx.getInitParameter("usr");
		String pwd=ctx.getInitParameter("pwd");
		String driver=ctx.getInitParameter("driver");
		
		HttpSession session=req.getSession(false);
		Employee lgn_emp=(Employee)session.getAttribute("lgn_emp");
		String emp_userid=lgn_emp.getEmp_userid();
		String emp_password=lgn_emp.getEmp_password();
		
		EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
		
		String nw_pwd=req.getParameter("new_pwd_submit");
		
		try {
			if(empdao.updatePassword(emp_userid, nw_pwd)==true){
				
				session.invalidate();
				Employee emp=empdao.viewProfile(emp_userid);
				session=req.getSession(true);
				session.setAttribute("lgn_emp", emp);
				System.out.println("Successfull new pwd ="+nw_pwd);
				return "Successfull new pwd ="+nw_pwd;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed_catch");
			return "failed_catch";
		}
		System.out.println("failed_prb");
		return "failed_prb";
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
