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
            Gp lgn_admn=(Gp)session.getAttribute("lgn_admn");
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String id = lgn_admn.getName();  

            ResultSet rs = 
                statement.executeQuery("select * from applyproject where gp_name  = '" + id + "' and app_prj_approval = false and prj_starting_date >= '"+today+"'") ; 
	%>
	 <table style="width:100%;" class="projects">
<tr><td colspan="6" style=" margin-bottom:5px;background-color:rgba(70,130,180,0.5); text-shadow:0 0 2px #1E90FF; color:white; font-family:tahoma;">All Project To Verify</td></tr>

            <tr>
		<td> Project ID</td><td> Project Name</td><td> Starting Date</td><td> Ending Date</td><td> Employee name</td><td> button</td>
			</tr>
	<%
            while(rs.next()) {                
        %>     
           <tr>
           	   <td> <%= rs.getInt(4) %> </td>
               <td> <%= rs.getString(9) %> </td>
               <td> <%= rs.getString(5) %> </td>
               <td> <%= rs.getString(6) %> </td>
               <td> <%= rs.getString(2) %> </td>
               <td><input type="button" onclick="loadAjaxApprove('../ApprovePrj.xweb?prj=<%= rs.getString(1) %>&prjid=<%= rs.getInt(4) %>');"  value="Approve"/></td>
           </tr>
       <% 
           } 
       %> </table>