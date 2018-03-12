<%@page import="com.obj.Gp"%>
<%@page import="com.obj.Project"%>
<%@page import="com.obj.ApplicationProject"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page errorPage="error.jsp" %>

<style type="text/css">
	table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black; text-align: center;
}
</style>
<script type="text/javascript">
var today = new Date();
</script>
<% 			

ServletContext ctx=getServletContext();
String dburl=ctx.getInitParameter("dburl");
String usr=ctx.getInitParameter("usr");
String pwd=ctx.getInitParameter("pwd");
String driver=ctx.getInitParameter("driver");

Class.forName(driver);
Connection conn=DriverManager.getConnection(dburl,usr,pwd);

            Statement statement = conn.createStatement();
          	HttpSession sessoion=request.getSession(false);
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            int prj_id=Integer.parseInt(request.getParameter("project"));
            

            ResultSet rs = 
                statement.executeQuery("select * from projectTable where prj_id   = '" +prj_id+ "' ;") ; 
	%>
	 <TABLE style="width:100%;" class="projects">
            
	<%
            if(rs.next()) {
                
        %>
        
        
        
       
           	  <tr><td colspan="2" style=" margin-bottom:5px;background-color:rgba(70,130,180,0.5); text-shadow:0 0 2px #1E90FF; color:white; font-family:tahoma;">Project Details</td></tr>
           	  <tr><td> Project ID</td><td> <%= rs.getInt(2) %> </td></tr>
              <tr><td> Project Name</td> <td> <%= rs.getString(1) %> </td></tr>
              <tr rowspan="2"><td> Project Description</td> <td> <%= rs.getString(3) %> </td></tr>
              <tr><td> Starting Date</td> <td> <%= rs.getString(4) %> </td></tr>
              <tr><td> Ending Date</td><td> <%= rs.getString(5) %> </td></tr>
              <tr><td> Employee Needed</td><td><%= rs.getInt(6) %> </td></tr>
              <tr><td> Employee Occupied</td><td><%= rs.getInt(7) %> </td></tr>
              <tr><td> Project Under</td> <td> <%= rs.getString(8) %> </td></tr>
           
      
       
       <% 
           } else{ %><tr><td><script type="text/javascript">alert("Sorry No Data Found")</script> </td></tr><% }
       %> </TABLE>