package com.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProjectApp
 */
@WebServlet("/x.do")
public class ProjectApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter pen= res.getWriter();
		//Random r=new Random();
		//int i=r.nextInt(1001);
		int i1=Integer.parseInt(req.getParameter("num1"));
		int i2=Integer.parseInt(req.getParameter("num2"));
		String s="style='color:green; text-align:center;'";
		String s1="style='color:red;'";
		pen.println(" <h1 "+s+"> Sum of "+i1+" and "+i2+" is :<div "+s1+">"+(i1+i2)+"</div></h1>");
		pen.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
