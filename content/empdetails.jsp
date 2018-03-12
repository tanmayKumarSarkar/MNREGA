<%@page import="com.obj.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList" %>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Employee emp_list_all=(Employee)request.getAttribute("employee_Details"); //type casting
if(emp_list_all!=null){   //else part!
%>

<style type="text/css">
	
	table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black; text-align: center; font-family:tahoma;
}

</style>

<table width="100%">
  
  	<tr><td colspan="2" style=" margin-bottom:5px;background-color:rgba(70,130,180,0.5); text-shadow:0 0 2px #1E90FF; color:white; font-family:tahoma;">Employee Details</td></tr>
	<tr><td>Employee Name</td><td><%= emp_list_all.getEmp_name() %></td></tr>
    <tr><td>Employee Job Card</td><td><%= emp_list_all.getEmp_jobcard_no() %></td></tr>
    <tr><td>Employee's Phone</td> <td><%= emp_list_all.getEmp_phone() %></td></tr>
    <tr><td>Employee's Email</td> <td><%= emp_list_all.getEmp_email() %></td></tr>
    <tr><td>Employee's Village</td><td><%= emp_list_all.getEmp_village() %></td></tr>
    <tr><td>Gram Panchayat</td><td><%= emp_list_all.getEmp_gp() %></td></tr>
    <tr><td>District</td><td><%= emp_list_all.getEmp_district() %></td></tr>
  
  
<%
	}//end of the while block
	%>
</table>
