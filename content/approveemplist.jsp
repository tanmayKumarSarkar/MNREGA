
<%@page import="com.obj.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList" %>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Collection<Employee> emp_list=(Collection<Employee>)request.getAttribute("emp_list");
if(emp_list!=null){   //else part!
%>

<style type="text/css">
	
	table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black; text-align: center;
}

</style>

<table width="100%">
<tr><td colspan="5" style=" margin-bottom:5px;background-color:rgba(70,130,180,0.5); text-shadow:0 0 2px #1E90FF; color:white; font-family:tahoma;">All Employees To Approve</td></tr>

  <tr>
    <th >Employee</th>
    <th >Job Card</th>
    <th >Village</th>
    <th >Phone</th>
    <th >approve</th>
  </tr>
<%
Iterator<Employee> it=emp_list.iterator();
while(it.hasNext()){
	Employee emp=it.next();
%>  
  
  <tr>
    <td><%= emp.getEmp_name() %></td>
    <td><%= emp.getEmp_jobcard_no() %></td>
    <td><%= emp.getEmp_village() %></td>
    <td><%= emp.getEmp_phone() %></td>
    <td>
<input type="button" value="Approve" onclick="loadAjaxApproveEmp('../approveemployee.xweb?userid=<%=emp.getEmp_userid()%>&len=99')" />
	</td>
  </tr>
  
<%
	}//end of the while block
	%></table><%
}else{
	%>
		<div style="width:300px; height:200px; margin:0 auto; background-color:rgba(30,144,255,0.5);box-shadow:0 0 5px rgba(24,116,205,0.5); position:absolute; left:47.5%; top:67%; margin-left:-150px; margin-top:-100px;" >
			<div style="border:1px solid rgba(24,116,205,0.7);margin: auto;text-align:center; margin-left:25px; margin-top:25px;background-color:rgba(0,0,0,0.5);padding-top:50px;  box-shadow:0 0 5px rgba(24,116,205,0.5); width:250px; height:100px; color:white;" >No Employee For Approval</div>
		</div>
	<%
}//end of the if block
%>  

