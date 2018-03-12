<%@page import="com.obj.Project"%>
<%@page import="com.obj.Employee"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script src="../js/welcome_employee.js" type="text/javascript"></script>    
<%!

%>
<%
if(session!=null || null!=session.getAttribute("lgn_emp")){
Employee lgn_emp=(Employee)session.getAttribute("lgn_emp");
Project ap_p=(Project)request.getAttribute("ap_p");
if(ap_p!=null){
%>

<table width="520" border="1px solid black" cellspacing="0px" cellpadding="10">
  <tr>
    <th scope="col">Project Name</th>
    <th scope="col">Project Id </th>
    <th scope="col">Description</th>
    <th scope="col">Starting Date</th>
    <th scope="col">Ending Date </th>
  </tr>
  <tr>
    <td><%= ap_p.getPrj_name() %></td>
    <td><%= ap_p.getPrj_id()  %></td>
    <td><%= ap_p.getPrj_description()  %></td>
    <td><%= ap_p.getPrj_starting_date()  %></td>
    <td><%= ap_p.getPrj_ending_date()  %></td>
  </tr>
</table>
<%
}else{
%>
	<h4>No Current Projects</h4>
<%	
}
%>
<%}else{
	%>
		<jsp:forward page="../index.jsp"></jsp:forward>
	<%
}

%>