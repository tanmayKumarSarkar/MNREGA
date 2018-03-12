<%@page import="com.obj.Gp"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<script type="text/javascript" src="../jquery/jquery.1.11.1.min.js"></script>
<script type="text/javascript" src="../jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="../css/datepicker_jquery.css" />
  <script>

  $(function() {
	    $( "#datepicker" ).datepicker({
			changeMonth: true,
			changeYear: true,
			dateFormat:'dd-mm-yy'
		}).on('changeDate', function(ev){
	      $('#datepicker').datepicker('hide');
	});
	});


</script>
<style type="text/css">
	
	table {
    border-collapse: collapse;
    text-align: center;
    width:100%; padding:0px;
}


</style>
<form id="addprojectform"  style="width:100%;">
		<%
		
			Gp lgn_admn=(Gp)session.getAttribute("lgn_admn");   	
        	String id = lgn_admn.getName();
		%>
		
	
		
	<table>
	<tr><td colspan="3" style=" margin-bottom:5px;background-color:rgba(70,130,180,0.5); text-shadow:0 0 2px #1E90FF; color:white; font-family:tahoma;">Project Form</td></tr>
    	<tr><td>Gp Name</td><td><input style=" margin-left:20px; width:200px; padding-left:10px; height:20px;" 
        value="<%= id %>" type="text" id="gp_name" name="gp_name" readonly/></td></tr>
        
    	<tr><td>Project Name</td><td><input style=" margin-left:20px; width:200px; padding-left:10px; height:20px;" 
        placeholder="Project Name" type="text" name="project_name" required id="project_name" /></td></tr>
       
        <tr><td>Project description</td><td><textarea style=" margin-left:20px;resize:none; padding-left:10px; width:200px;"
         placeholder="Project description" type="text" id="project_des" required name="project_des" rows=5></textarea></td></tr>
       
        <tr><td>Starting Date</td><td><input style=" margin-left:20px; width:200px; padding-left:10px; height:20px;"
         placeholder="yyyy-mm-dd" id="s_date" type="text" required name="s_date" /></td></tr>
       
        <tr><td>Ending Date</td><td><input style=" margin-left:20px; width:200px; padding-left:10px; height:20px;"
         placeholder="yyyy-mm-dd"  type="text" id="e_date" required name="e_date" /></td></tr>
         
       
        <tr><td>Employee Needed</td><td><input style=" margin-left:20px; width:200px; padding-left:10px; height:20px;"
         placeholder="Employee Needed" type="text" id="emp_no" required name="emp_no" /></td>
       
        <td><input Style=" margin-left:0px;"  type="button" id="submit" onclick="addprojectgp_validation();"  name="submit" value="Submit" /></td></tr>      
    </table>
</form>