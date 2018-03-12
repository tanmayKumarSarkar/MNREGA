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

import com.DAO.AdminDAO;
import com.DAO.EmployeeDAO;
import com.obj.Employee;
import com.obj.Gp;

@WebServlet("/viewallemployee.xweb")
public class ViewAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewAllEmployee() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession(false);
		
		ServletContext ctx=getServletContext();
		String dburl=ctx.getInitParameter("dburl");
		String usr=ctx.getInitParameter("usr");
		String pwd=ctx.getInitParameter("pwd");
		String driver=ctx.getInitParameter("driver");
		
		 Gp lgn_admn=(Gp)session.getAttribute("lgn_admn");   	
         String id = lgn_admn.getName(); 
		
		response.setContentType("text/html");
		PrintWriter pen=response.getWriter();
		
		EmployeeDAO app=new EmployeeDAO(usr, pwd,dburl, driver);
		
		try{
			
					
					Collection<Employee> emp=app.viewAllEmployeeUnderGp(id);
					
					
					if(emp!=null){					
						
						Collection<Employee> emp1=new ArrayList<Employee>();
						Iterator<Employee> it =emp.iterator();
						
						while(it.hasNext()){
							
							
							Employee e=it.next();								
							emp1.add(e);
							
						}
						
						request.setAttribute("emp_list_all", emp1);
						RequestDispatcher rd=request.getRequestDispatcher("content/allemplist.jsp");
						rd.forward(request, response);
						
					}else{
						
						request.setAttribute("emp_list_all", null);
						RequestDispatcher rd=request.getRequestDispatcher("content/allemplist.jsp");
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
