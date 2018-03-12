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

import com.DAO.ApproveProjectDAO;





/**
 * Servlet implementation class ApproveProjectServ
 */
@WebServlet(value="/ApprovePrj.xweb")
public class ApproveProjectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveProjectServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		HttpSession session=request.getSession(false);
		
		ServletContext ctx=getServletContext();
		String dburl=ctx.getInitParameter("dburl");
		String usr=ctx.getInitParameter("usr");
		String pwd=ctx.getInitParameter("pwd");
		String driver=ctx.getInitParameter("driver");
		
		int prj=Integer.parseInt(request.getParameter("prj"));
		int prj_id=Integer.parseInt(request.getParameter("prjid"));
		
		response.setContentType("text/html");
		PrintWriter pen=response.getWriter();
		
		ApproveProjectDAO app=new ApproveProjectDAO(usr, pwd,dburl, driver);
		
		
		try {
			
			boolean b=app.approved_prj(prj,prj_id);
			if(b==true){
				
				
				pen.print("true");
				
				
			}else{
				
				pen.print("false1");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			pen.print("false2");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
