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
import com.DAO.ApproveProjectDAO;
import com.obj.Employee;
import com.obj.Project;


@WebServlet("/approveemployee.xweb")
public class ApproveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ApproveEmployee() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		
		ServletContext ctx=getServletContext();
		String dburl=ctx.getInitParameter("dburl");
		String usr=ctx.getInitParameter("usr");
		String pwd=ctx.getInitParameter("pwd");
		String driver=ctx.getInitParameter("driver");
		
		String id=request.getParameter("userid");
		int approve=Integer.parseInt(request.getParameter("len"));	//path, random no except 99
		
		response.setContentType("text/html");
		PrintWriter pen=response.getWriter();
		
		AdminDAO app=new AdminDAO(usr, pwd,dburl, driver);
		
		try{
			
			if(approve!=99){
					
				
				
					String id2=id.replace("_", " ");
					Collection<Employee> emp=app.approveList(id2);
					
					
					if(emp!=null){					
						
						Collection<Employee> emp1=new ArrayList<Employee>();
						Iterator<Employee> it =emp.iterator();
						
						while(it.hasNext()){
							
							
							Employee e=it.next();								
							emp1.add(e);
							
						}
						
						request.setAttribute("emp_list", emp1);
						RequestDispatcher rd=request.getRequestDispatcher("content/approveemplist.jsp");
						rd.forward(request, response);
						
					}else{
						
						request.setAttribute("emp_list", null);
						RequestDispatcher rd=request.getRequestDispatcher("content/approveemplist.jsp");
						rd.forward(request, response);
						
					}
				
			}else{
					
					boolean b=app.approvedemployee(id);
					if(b==true){	pen.print("true");
					
				}else{pen.print("false");}
				
			}//end of the else part
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
