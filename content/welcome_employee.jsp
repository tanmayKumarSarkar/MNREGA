<%@page import="com.obj.ApplicationProject"%>
<%@page import="com.DAO.EmployeeDAO"%>
<%@page import="com.obj.Employee"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! %> 
<%
if(session!=null || null!=session.getAttribute("lgn_emp")){
Employee lgn_emp=(Employee)session.getAttribute("lgn_emp");
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Employee</title>
<link rel="stylesheet" type="text/css" href="../css/welcome_employee.css" >
<style type="text/css">

</style>
<script src="../js/welcome_employee.js" type="text/javascript"></script>
<script src="../jquery/jquery.min.2.0.2.js" type="text/javascript"></script>
<script type="text/javascript">
window.onload=loadAjax1('../MyProjectDetails.xweb');
window.onload=loadAjax2('');
function loadAjax1(ajaxContentUrl) {
		
		$('#project_content_details').append('<img style=" text-align:center; margin-top:-30px;margin-left:260px" 	src="../images/loading.png"/>');			
			
			url=ajaxContentUrl;
			
			$.ajax({
				type: "GET",
				url: url,
				dataType: "html",
				success:function(msg){
					if(parseInt(msg)!=0)
					{	
						$('#project_content_details').empty();
						$('#project_content_details').html(msg);
					}
				},
				error:function(){
					alert('Sorry Try Again!');
				}
			});
}
function loadAjax2(ajaxContentUrl) {
			$('#upcoming_content').append('<img style=" text-align:center; margin-top:10px;margin-left:10px" 	src="../images/loading.png"/>');			
			
			$.ajax({
				type: "GET",
				url: "../content/UpcomingProjects.jsp",
				dataType: "html",
				success:function(msg){
					if(parseInt(msg)!=0)
					{	
						$('#upcoming_content').empty();
						$('#upcoming_content').html(msg);
					}
				},
				error:function(){
					alert('Sorry Try Again!');
				}
			});
			$('#ongoing_content').append('<img style=" text-align:center; margin-top:10px;margin-left:10px" 	src="../images/loading.png"/>');			
			
			$.ajax({
				type: "GET",
				url: "../content/OngoingProjects.jsp",
				dataType: "html",
				success:function(msg){
					if(parseInt(msg)!=0)
					{	
						$('#ongoing_content').empty();
						$('#ongoing_content').html(msg);
					}
				},
				error:function(){
					alert('Sorry Try Again!');
				}
			});
			
}

</script>
</head>

<body>
<%
//HttpSession sessoion=request.getSession(false);
ServletContext ctx=getServletContext();
String dburl=ctx.getInitParameter("dburl");
String usr=ctx.getInitParameter("usr");
String pwd=ctx.getInitParameter("pwd");
String driver=ctx.getInitParameter("driver");

EmployeeDAO empdao=new EmployeeDAO(usr, pwd,dburl, driver);
%>
<div id="fullpage" >


<div id="header" align="center">
<img src="../images/mgnrega_banner.gif" />
</div>

<div id="menubar_container" align="center" >
<div id="left_trns_grad"></div>
<div id="menubar">
<span id="home"><a href="">HOME</a></span>
<span id="act2005"><a style="text-decoration:none; color:#F8F8FF;" href="../pdf/rajaswa.pdf">ACT 2005</a></span>
<span id="aboutus"><a style="text-decoration:none; color:#F8F8FF;" href="about_us.jsp">ABOUT US</a></span>
<span id="contactus"><a  style="text-decoration:none; color:#F8F8FF;" href="contactUs.jsp">CONTACT US</a></span>
</div>
<div id="right_trns_grad"></div>
</div>


<div id="content_footer" align="center"><div id="content_transparent">
<table id="content_table" height="485px" >

<tr>
<td width="260px">
<div id="upcoming" align="center">
<div id="upcoming_header">Upcoming Projects....</div>
<div id="upcoming_content"></div>
</div>
<div id="ongoing" align="center">
<div id="ongoing_header">Ongoing Projects....</div>
<div id="ongoing_content"></div>
</div>
</td>

<td width="580px">
<div id="curr_project_container">
<div id="curr_project">
<span>Name Of Current Project : <span style="color:rgba(0,204,255,1)">
<%
ApplicationProject ap_pr=empdao.viewCurrentRunningProject(lgn_emp.getEmp_jobcard_no());
if(ap_pr!=null){out.print(ap_pr.getPrj_name());}else{out.print("NONE");}
%>
 </span></span>
<hr width="99.90%" color="white"/>
<span>Numbers Of Applied Projects : <%out.print(empdao.getNoOfAppliedProjectsAfterCurDate(lgn_emp.getEmp_jobcard_no())); %> </span>
</div></div>

<div id="project_content">

<div id="project_content_btns" align="center">
	<a >
    <span id="prj_details" onClick="loadAjax1('../MyProjectDetails.xweb')">Project Details</span></a>
   <a >
   <span id="app_nw_prj" onClick="loadAjax1('../ApplyNewProject.xweb')">Apply New Project</span></a>
   <a ><span id="report" onClick="loadAjax1('../content/EmployeeJobReport.jsp')">Reports</span></a>
</div>
<div id="margin_1" style="position:relative"></div><div id="margin_2" style="position:relative"></div>
<div id="project_content_details_container" align="center">
<div id="project_content_details" align="center">

</div>
</div>

</div>
</td>

<td width="280px">
<div id="details_panel">
<div id="details_panel_header">Eployee Details</div>
<div id="details_panel_content">
<table width="270" border="0" cellpadding="0px" id="table_details_panel_content" border="2px solid black" align="left">
  <tr>
    <td>Name : </td>
    <td><div style="overflow-x:hidden;width:136px"><%= lgn_emp.getEmp_name() %></div></td>
  </tr>
  <tr>
    <td>UserId : </td>
    <td><div style="overflow-x:hidden;width:136px"><%= lgn_emp.getEmp_userid() %></div></td>
  </tr>
  <tr>
    <td>Job Card No. : </td>
    <td><div style="overflow-x:hidden;width:136px"><%= lgn_emp.getEmp_jobcard_no() %></div></td>
  </tr>
  <tr>
    <td>Village : </td>
    <td><div style="overflow-x:hidden;width:136px"><%= lgn_emp.getEmp_village() %></div></td>
  </tr>
  <tr>
    <td>District : </td>
    <td><div style="overflow-x:hidden;width:136px"><%= lgn_emp.getEmp_district() %></div></td>
  </tr>
  <tr>
    <td width="126px">Gram Panchayet : </td>
    <td><div style="overflow-x:hidden;width:136px"><%= lgn_emp.getEmp_gp() %></div></td>
  </tr>
  <tr>
    <td>Phone No. : </td>
    <td><%= lgn_emp.getEmp_phone() %></td>
  </tr>
  <tr>
    <td>Email : </td>
    <td><div style="overflow-x:hidden;width:136px"><%= lgn_emp.getEmp_email() %></div></td>
  </tr>
  <tr>
    <td>Approved : </td>
    <td><% if(lgn_emp.isEmp_approve()==true){ %> YES <%}else{ %> NO <%} %></td>
  </tr>
  <tr id="change_pwd_row">
  <%if(lgn_emp.isEmp_approve()==true){ %>
    <td  colspan="2" id="change_pwd" onClick="change_pwd()" ><a id="change_pwd_line"> Change Password ?  </a>
    <div id="change_pwd_frm">
    <div id="change_pwd_frm_inside">
    <form method="post" action="" id="frm_change_pwd">
    <table align="center">
    <tr><td align="left">New Password </td><td><input type="password" id="new_pwd" name="new_pwd"/></td></tr>
    <tr><td align="left">ReEnter </td><td><input type="password" id="new_pwd_re" name="new_pwd_re"/></td></tr>
    <tr><td align="center">
    <input type="button" name="new_pwd_submit" id="new_pwd_submit" value="OK" onClick="change_pwd_js()" required/></td>
    <td align="center">
    <input type="submit" name="new_pwd_cancel" id="new_pwd_cancel" value="CANCEL" onClick="cancel_pwd_js()" required/></td></tr>
    </table>
    </form>
    </div>
    </div>
    </td>
    <%}else{ %>
<td colspan="2"  style="padding-left:60px; cursor:pointer; padding-top:30px;" onClick="alert('You Are Not Approved By The Admin Yet !!')" style="cursor: pointer;" > Change Password ? </td>
    
    <%} %>
  </tr>
  <tr>
    <td  colspan="2"><a href="../Logout.xweb"  title="Click Here To Logout"><div id="logout_btn">Logout</div></a></td>
  </tr>
</table>

</div>

</div>
</td>
</tr>


</table>
<div id="footer">

<div style="float:left; padding-top:8px; margin-left:50px">@ copy right</div>
        <div style="float:right;  padding-top:8px; margin-right:50px"> Project: MNREGA on JEE : <a href="http://www.globsyn.com">Globsyn</a> :2014 </div>
</div>
</div></div>

</div>

</body>
</html>
<%}else{
	%>
		<jsp:forward page="../index.jsp"></jsp:forward>
	<%
}

%>