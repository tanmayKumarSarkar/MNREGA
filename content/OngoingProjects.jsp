<%@page import="com.obj.Project"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
%>
<%
ServletContext ctx=getServletContext();
String dburl=ctx.getInitParameter("dburl");
String usr=ctx.getInitParameter("usr");
String pwd=ctx.getInitParameter("pwd");
String driver=ctx.getInitParameter("driver");

EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);

Collection<Project> col_of_proj=empdao.viewOngoingProjects();
%>
<%
Iterator<Project> it=col_of_proj.iterator();
%>
<table width="240px" border="0" cellpadding="2px">
<%
while(it.hasNext()){
	Project prj=it.next();
%>
  <tr>
    <th scope="col"><%=prj.getPrj_name() %></th>
    <th scope="col"><%=prj.getPrj_starting_date() %></th>
  </tr>
<%	
}
%>
</table>