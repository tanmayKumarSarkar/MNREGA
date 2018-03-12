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

import com.DAO.GpDAO;
import com.obj.Employee;
import com.obj.Gp;
import com.obj.LoginAdmin;

/**
 * Servlet implementation class AdminLoginServ
 */
@WebServlet("/GpLoginServ.xweb")
public class GpLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GpLoginServ() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	ServletContext ctx=getServletContext();
	String dburl=ctx.getInitParameter("dburl");
	String usr=ctx.getInitParameter("usr");
	String pwd=ctx.getInitParameter("pwd");
	String driver=ctx.getInitParameter("driver");

	
	String user_gp= req.getParameter("userid");
	String pass_gp=req.getParameter("password");
	
	res.setContentType("text/html");
	PrintWriter pen=res.getWriter();
	
	
	LoginAdmin lgn_admn= new LoginAdmin(user_gp,pass_gp);
	GpDAO admndao=new GpDAO(usr, pwd,dburl, driver);
	
	try {
		if(admndao.checkLogin(lgn_admn)){
			
			Gp gp=admndao.viewProfile(user_gp);
			HttpSession session= req.getSession(true);
			session.setAttribute("lgn_admn", gp);
			res.sendRedirect("http://localhost:8080/MNREGAwar/content/welcome_admin.jsp");
			
		}else{
			res.sendRedirect("http://localhost:8080/MNREGAwar/index.jsp?msg=invalidUserOrPwd");
		}
	} catch (Exception e) {
		
		e.printStackTrace();
		pen.print(user_gp+","+pass_gp);
		res.sendRedirect("http://localhost:8080/MNREGAwar/index.jsp?msg=invalidUserOrPwd");
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
