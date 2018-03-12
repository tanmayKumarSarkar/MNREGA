<%@page import="com.obj.Project"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script src="../js/welcome_employee.js" type="text/javascript"></script>
<script src="../js/index.js" type="text/javascript"></script>  
<script src="../jquery/jquery.min.js"></script>
<script src="../jquery/jquery.min.2.0.2.js" type="text/javascript"></script> 
<%!
%>
<script type="text/javascript">
//window.onload=scrollDiv_init();

</script>
<%
ServletContext ctx=getServletContext();
String dburl=ctx.getInitParameter("dburl");
String usr=ctx.getInitParameter("usr");
String pwd=ctx.getInitParameter("pwd");
String driver=ctx.getInitParameter("driver");

EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);

Collection<Project> col_of_proj=empdao.viewUpcomingProjects();
%>
<%
Iterator<Project> it=col_of_proj.iterator();
%>
<style>
#upcomingRowDv{max-height:200px;overflow:hidden;width:250px; }
</style>
<script type='text/javascript'>


</script> 
<div id="upcomingRowDv" >
<table width="240px" border="0" cellpadding="2px">
<%
while(it.hasNext()){
	Project prj=it.next();
%>
 <tr id="upcomingRow" style="cursor:pointer" onclick="refOfUpcomingPrjs('<%=prj.getPrj_id()%>','UpcomingProjectsDetails.jsp')">
   
    <td scope="col"><a><%=prj.getPrj_name() %></a></td>
    <td scope="col"><%=prj.getPrj_starting_date() %></td>
  </tr>
   
  
<%	
}
%>
</table>
</div>