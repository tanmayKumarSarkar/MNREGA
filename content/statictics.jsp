<%@ page errorPage="error.jsp" %>
<%@page import="com.DAO.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! %>    
<style type="text/css">
#mnregaAtGlance {
	font-family: "Courier New", Courier, monospace;
	font-size: 21px;
}
#tab_stat{
	margin-top:-5px;
	margin-bottom:10px;
	font:"Courier New", Courier, monospace;
	font-size:14px;
	line-height:20px;
	color:white;
	text-shadow:1px 1px 1px black;
	line-height:16px;
	letter-spacing:1px;
	word-spacing:3px;
	}
</style>
<%
ServletContext ctx=getServletContext();
String dburl=ctx.getInitParameter("dburl");
String usr=ctx.getInitParameter("usr");
String pwd=ctx.getInitParameter("pwd");
String driver=ctx.getInitParameter("driver");

EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
%>
<table id="tab_stat" width="525" border="1px solid black" cellpadding="4px" cellspacing="0px" align="center">
  <tr>
    <th colspan="2" id="mnregaAtGlance" scope="col" style="background:url(../images/bg22.png)">
    				 MNREGA At A Glance </th>
  </tr>
  <tr>
    <td width="369">Total No. Of Disticts </td>
    <td width="130" align="center">1</td>
  </tr>
  <tr>
    <td>Total No. Of Villages </td>
    <td align="center"> 1000</td>
  </tr>
  <tr>
    <td>Total No. Of Gram Panchayets </td>
    <td align="center"> 57</td>
  </tr>
  <tr>
    <td>Total No. Of Projects </td>
    <td align="center"><%=empdao.getTotalNoOfProjects() %></td>
  </tr>
  <tr>
    <td>Total No. Of Employees </td>
    <td align="center"><%=empdao.getTotalNoOfEmployees() %></td>
  </tr>
  <tr>
    <td>Wage Rate Per Day Per Person </td>
    <td align="center"> 100 Rs/-</td>
  </tr>
  <tr>
    <td>Total No. Of Completed 100 Day Wages</td>
    <td align="center"> 5</td>
  </tr>
</table>

