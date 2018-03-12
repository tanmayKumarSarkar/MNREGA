<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="com.obj.Project"%>
<%@page import="com.obj.Employee"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script src="../js/welcome_employee.js" type="text/javascript"></script>
<%
if(session!=null || null!=session.getAttribute("lgn_emp")){
Employee lgn_emp=(Employee)session.getAttribute("lgn_emp");
Collection<Project> coll_prj=(Collection<Project>)request.getAttribute("coll_prj");
%>
<table width="520" border="1px solid black" cellspacing="0px" cellpadding="5" align="center">
  <tr>
    <th scope="col">Project Id</th>
    <th scope="col">Project Name</th>
    <th scope="col">Starting Date</th>
    <th scope="col">Ending Date</th>
    <th scope="col">Employee Posts</th>
    <th scope="col">View</th>
  </tr>
<%
Iterator<Project> it=coll_prj.iterator();
while(it.hasNext()){
	Project p_prj=it.next();
%>  
  
  <tr>
    <td><%= p_prj.getPrj_id()  %></td>
    <td><%= p_prj.getPrj_name()  %></td>
    <td><%= p_prj.getPrj_starting_date()  %></td>
    <td><%= p_prj.getPrj_ending_date()  %></td>
    <td><%= p_prj.getPrj_left_seat()  %></td>
    <td>
<input type="button" value="View" onclick="viewForApplicationProject('<%= p_prj.getPrj_id()%>','ViewProjectAppDetails.xweb')" />
	</td>
  </tr>
  
<%
	}
%>  
</table>
<%}else{
	%>
		<jsp:forward page="../index.jsp"></jsp:forward>
	<%
}

%>