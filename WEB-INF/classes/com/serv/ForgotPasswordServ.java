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

import com.DAO.EmployeeDAO;
import com.obj.Employee;

/**
 * Servlet implementation class ForgotPasswordServ
 */
@WebServlet("/ForgotPasswordServ.xweb")
public class ForgotPasswordServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServ() {
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
		
		String frm_user_id=req.getParameter("frm_user_id");
		String frm_user_jobcard=req.getParameter("frm_user_jobcard");
		String frm_user_pwd=req.getParameter("frm_user_pwd");
		String frm_user_repwd=req.getParameter("frm_user_repwd");
		System.out.println(frm_user_id+" "+frm_user_jobcard+" "+frm_user_pwd);
		EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
		
		try {
			if(empdao.checkBeforeForgotPassword(frm_user_id, frm_user_jobcard)==true){
				if(empdao.updatePassword(frm_user_id, frm_user_pwd)){
					pen.print("success");
					/*RequestDispatcher rd=req.getRequestDispatcher("../content/statictics.jsp");
					rd.forward(req, res);*/
					}
			}else{pen.print("failed");}
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
