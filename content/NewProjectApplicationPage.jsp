<%@page import="com.DAO.EmployeeDAO"%>
<%@page import="com.obj.Project"%>
<%@page import="com.obj.Employee"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script src="../js/welcome_employee.js" type="text/javascript"></script> 
<%! %>   

<%
if(session!=null || null!=session.getAttribute("lgn_emp")){
Employee lgn_emp=(Employee)session.getAttribute("lgn_emp");
Project prj_det=(Project)request.getAttribute("prj_det");

ServletContext ctx=getServletContext();
String dburl=ctx.getInitParameter("dburl");
String usr=ctx.getInitParameter("usr");
String pwd=ctx.getInitParameter("pwd");
String driver=ctx.getInitParameter("driver");
EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
%>

<table width="520" border="0" cellpadding="8" cellspacing="0px">
  <tr>
    <th scope="row">Project Name : </th>
    <td><%= prj_det.getPrj_name() %></td>
  </tr>
  <tr>
    <th scope="row">Project Id : </th>
    <td><%= prj_det.getPrj_id() %></td>
  </tr>
  <tr>
    <th scope="row">Project Description</th>
    <td><%= prj_det.getPrj_description() %></td>
  </tr>
  <tr>
    <th scope="row">Starting Date : </th>
    <td><%= prj_det.getPrj_starting_date() %></td>
  </tr>
  <tr>
    <th scope="row">Ending Date : </th>
    <td><%= prj_det.getPrj_ending_date() %></td>
  </tr>
  <tr>
    <th scope="row">Total Seats : </th>
    <td><%= prj_det.getPrj_total_seat() %></td>
  </tr>
  <tr>
    <th scope="row">Left Seats :</th>
    <td><%= prj_det.getPrj_left_seat() %></td>
  </tr>
  <tr>
    <th scope="row">Gram Panchayet : </th>
    <td><%= prj_det.getPrj_gp_name().replace("GP", "Gram Panchayet") %></td>
  </tr>
  
  <%
  if(empdao.checkForApprovedEmployee(lgn_emp.getEmp_userid())==true){
	  if(empdao.checkApplibleProjectByApprovedProjectDate(prj_det.getPrj_starting_date(), lgn_emp.getEmp_jobcard_no())==false){
		  %>
		  <tr>
		    <th scope="row" colspan="2">
		    <input type="button" value="Apply" onclick="alert('You Are Already Approved For The Next Project Please Apply Later')" /></th> 
		  </tr>
		  <%
	  }else{
		  int no=empdao.getNoOfAvailableSeatsByProjectId(prj_det.getPrj_id());
  %>
  <tr>
    <th scope="row" colspan="2">
    <input type="button" value="Apply" 
    								<%if(no==0){ %>
    									onclick="alert('No Seats Are Available !!')"
    								<%}else{ %>
    									onclick="ApplyFrProjEmp('<%=prj_det.getPrj_id()%>','SubmitApplicationForNewProject.xweb')" /></th> 
    								<% }%>
  </tr>
  <%
	 }
  }else{
  %>
   <tr>
    <th scope="row" colspan="2">
    <input type="button" value="Apply" onclick="alert('You Are Not Approved By The Admin Yet !!')" /></th> 
  </tr>
  <%} %>
</table>
<%}else{
	%>
		<jsp:forward page="../index.jsp"></jsp:forward>
	<%
}

%>