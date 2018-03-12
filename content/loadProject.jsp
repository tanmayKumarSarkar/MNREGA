<%@page import="com.obj.Gp"%>
<%@page import="com.obj.Project"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%@ page errorPage="error.jsp" %>
<style type="text/css">
	
	table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black; text-align: center;
}
</style>

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
            Gp lgn_admn=(Gp)session.getAttribute("lgn_admn");

            	
            String id = lgn_admn.getName();  

            ResultSet rs = 
                statement.executeQuery("select * from projecttable where prj_gp_name = '" + id + "'") ; 
	%>
	 <TABLE style="width:100%;">
<tr><td colspan="6" style=" margin-bottom:5px;background-color:rgba(70,130,180,0.5); text-shadow:0 0 2px #1E90FF; color:white; font-family:tahoma;">All Projects</td></tr>

            <tr>
		<td> Project ID</td><td> Project Name</td><td> Starting Date</td><td> Ending Date</td><td> Employee</td><td> button</td>
			</tr>
	<%
            while(rs.next()) {
                
        %>
           <tr>
           	   <td> <%= rs.getInt(2) %> </td>
               <td> <%= rs.getString(1) %> </td>
               <td> <%= rs.getString(4) %> </td>
               <td> <%= rs.getString(5) %> </td>
               <td> <%= rs.getString(6) %> </td>
               <td> <input type="button" onclick="viewProject('viewproject.jsp?project=<%=rs.getInt(2)%>');" value="view"/></td>
           </tr> 
       <% 
           } 
       %> </TABLE>