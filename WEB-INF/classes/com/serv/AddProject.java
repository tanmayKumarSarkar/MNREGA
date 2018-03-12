package com.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ProjectDAO;
import com.obj.Project;

@WebServlet(value="/addproject.xweb")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddProject() {
        super();

    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ServletContext ctx=getServletContext();
		String dburl=ctx.getInitParameter("dburl");
		String usr=ctx.getInitParameter("usr");
		String pwd=ctx.getInitParameter("pwd");
		String driver=ctx.getInitParameter("driver");
		
		
		
		res.setContentType("text/html");
		PrintWriter pen=res.getWriter();
		
		
		 
		
		 String prj_name =req.getParameter("project_name").replace("+", " ");
		 int prj_id =(int)(10 + 1900*Math.random());
		 String prj_description=req.getParameter("project_des").replace("+", " "); 
		 String prj_starting_date=req.getParameter("s_date"); 
		 String prj_ending_date=req.getParameter("e_date");
		 int prj_total_seat =Integer.parseInt(req.getParameter("emp_no"));
		 int prj_left_seat =Integer.parseInt(req.getParameter("emp_no"));
		 String prj_gp_name = req.getParameter("gp_name").replace("+", " ");
		 
		 Project prj=new Project(prj_name,  prj_id,  prj_description,
					 prj_starting_date,  prj_ending_date,
					 prj_total_seat,  prj_left_seat,  prj_gp_name);
		 
		 
		
		ProjectDAO prjdao =new ProjectDAO(usr, pwd, dburl, driver);
		
		
		
		try{
			
		if(prj_name!="" || prj_id>0 || prj_description!="" || prj_starting_date!="" || prj_ending_date!="" || prj_total_seat>0 || prj_left_seat>0 || prj_gp_name!=""){	
			
			if(prjdao.insertProject(prj)==true){
				
				pen.print("success");
				
				}else{
					
					pen.print("failed");
					
					}//end of else block
		}
			
		}catch(Exception e){
			
			e.printStackTrace();
			pen.print("catch block");
		}
				
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
