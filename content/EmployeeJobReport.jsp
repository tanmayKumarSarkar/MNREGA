<%@page import="com.obj.Employee"%>
<%@page import="com.obj.EmpAttendence"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.obj.Project"%>
<%@page import="java.util.Collection"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!
%>
<%
if(session!=null || null!=session.getAttribute("lgn_emp")){
Employee lgn_emp=(Employee)session.getAttribute("lgn_emp");

ServletContext ctx=getServletContext();
String dburl=ctx.getInitParameter("dburl");
String usr=ctx.getInitParameter("usr");
String pwd=ctx.getInitParameter("pwd");
String driver=ctx.getInitParameter("driver");

EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);

Collection<EmpAttendence> col_of_proj=empdao.getAttendenceReport(lgn_emp.getEmp_jobcard_no());
%>
<%
Iterator<EmpAttendence> it=col_of_proj.iterator();
%>
<style type="text/css">
table{}
</style>
<table width="520px" border="1px solid black" cellspacing="0px" cellpadding="10px">
 <tr>
    <th scope="col">Project Id </th>
    <th scope="col">Project Name </th>
    <th scope="col">Date </th>
    <th scope="col">Income </th>
  </tr>
<%
int rs_counter=0;
while(it.hasNext()){
	EmpAttendence emp_at=it.next();
%>

  <tr>
    <td><%=emp_at.getPrj_id() %></td>
    <td><%=empdao.getDetailsOfTheProjectByProjectId(emp_at.getPrj_id()).getPrj_name() %></td>
    <td><%=emp_at.getCurr_date() %></td>
    <td><%="100 Rs/-" %><% rs_counter++; %></td>
  </tr>
 
<%	
}
%>
<tr><td colspan="4" align="center">Total &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(rs_counter*100)%> Rs/-</td></tr>
</table>
<%}else{
	%>
		<jsp:forward page="../index.jsp"></jsp:forward>
	<%
}

%>