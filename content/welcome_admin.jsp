<%@page import="com.DAO.GpDAO"%>
<%@page import="com.obj.Gp"%>
<%@page import="java.util.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="error.jsp"
    pageEncoding="UTF-8"%>
<%! %>    
<%
if(session!=null || null!=session.getAttribute("lgn_admn")){
Gp lgn_admn=(Gp)session.getAttribute("lgn_admn");
//HttpSession sessoion=request.getSession(false);
ServletContext ctx=getServletContext();
String dburl=ctx.getInitParameter("dburl");
String usr=ctx.getInitParameter("usr");
String pwd=ctx.getInitParameter("pwd");
String driver=ctx.getInitParameter("driver");
String gp_name=lgn_admn.getName();
GpDAO gp=new GpDAO(usr, pwd, dburl, driver);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MNREGA:: <%= lgn_admn.getName() %></title>
<link type="text/css" href="../css/Basic.css" rel="stylesheet" />
<link type="text/css" href="../css/jquery-ui.css" rel="stylesheet" />
<link type="text/css" href="../css/welcome_admin.css" rel="stylesheet" />
<link rel="stylesheet" href="../css/datepicker_jquery.css" />
<script type="text/javascript" src="../jquery/jquery.1.11.1.min.js"></script>
<script type="text/javascript" src="../jquery/jquery-ui.js"></script>
<script type="text/javascript" src="../js/welcome_admin.js"></script>



<script type="text/javascript">
window.onload=viewallemployee();



function approveemplist() {
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	document.getElementById("content_load_ajax").innerHTML=xmlhttp.responseText;
	}

	}
	xmlhttp.open("GET","../approveemployee.xweb?userid=<%=lgn_admn.getName().replace(" ", "_")%>&len=<%= (int) (Math.random() * 90) %>", true);
	xmlhttp.send();
	}
function addprojectgp_validation(){
	
	var prj_name = $("#project_name").val();
	var prj_under_gp= $("#gp_name").val();
	var prj_des= $("#project_des").val();
	var prj_s_date= $("#s_date").val();
	var prj_e_date= $("#e_date").val();
	var prj_emp_needed= $("#emp_no").val();
	
	if(prj_name!="" && prj_under_gp!="" && prj_des!="" && prj_s_date!="" && prj_e_date!="" && prj_emp_needed!=0){
		
				addprojectgp();
		
		}else{
				alert("Fillup The Form Properly !!!");
			}	
	}
function addprojectgp(){
	
		var form = $('#addprojectform');  
		var url= "../addproject.xweb?"+form.serialize();     //form.attr('action'),
		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				alert("Project Successfully Uploaded");
				$('#content_load_ajax').empty();
				AddProjects();
					}
				}
		xmlhttp.open("GET",url, true);
		xmlhttp.send();

	
	}
</script>

</head>

<body>

<div id="fullpage" >


<div id="header" align="center"><img src="../images/mgnrega_banner.gif" /></div>

<div id="menubar_container" align="center" >
	<div id="left_trns_grad"></div>
	<div id="menubar">
		<a href="" style="text-decoration:none;"><span id="home">HOME</span></a>
			<span id="act2005"><a style="text-decoration:none; color:#F8F8FF;" href="../pdf/rajaswa.pdf">ACT 2005</a></span>
			<span id="aboutus"><a style="text-decoration:none; color:#F8F8FF;" href="about_us.jsp">ABOUT US</a></span>
			<span id="contactus"><a  style="text-decoration:none; color:#F8F8FF;" href="contactUs.jsp">CONTACT US</a></span>
	</div>
	<div id="right_trns_grad"></div>
</div>


<div id="content_footer" align="center">
	<div id="content_transparent">
    
		<table id="content_table"  height="485px">
        <div id="container">
        	<div id="btns">
            	<a href="#"><div onclick="viewallemployee();">View all Employees</div></a>
            	<a href="#"><div onclick="approveemplist();">Verify Employee</div></a>
                <a href="#"><div onclick="verifyProject();">Verify Project</div></a>
                <a href="#"><div onclick="AddProjects();">Add Project</div></a>
                <a href="#"><div onclick="AllProjects();">Projects</div></a>
            </div>
            <div id="details_admin">
            	<div id="d_m_header"><%= lgn_admn.getName().replace(" GP", " Gram Panchayet")  %></div>
                <div id="d_m_details">
                	Phone : <%= lgn_admn.getPhone()  %><br />
					Email : <%= lgn_admn.getEmail()  %><br />
					Village : <%= lgn_admn.getVillage()  %><br />
					District : <%= lgn_admn.getDistrict()  %><br />
					State : West Bengal<br /><br />
                    Total Employees :<%= gp.totalEmployee(gp_name) %><br />
                    All Projects :<%= gp.totalprojects(gp_name) %><br />
					On Going Projects :<%= gp.totalOngoingProjects(gp_name) %><br />
					
                    <br />

					User Id :<%= lgn_admn.getUser_gp()  %><br /><br />
					
					
                </div>
                <a href="../Logout.xweb" title="Click Here To Logout"><div id="logout_btn">Logout</div></a>
            </div>
            <div id="main_box">
            	<div id="basic_details">
                	<p>Total Projects to Approve: <%= gp.totalProjectApproval(gp_name) %></p>
                    <p>Total Employee to Verify:<%= gp.totalEmployeeApproval(gp_name) %></p>
                </div>
                <div id="content_load_ajax"></div>
            </div>
			
        </div>
		</table>
    
		<div id="footer"><div style="float:left; padding-top:8px; margin-left:50px">@ copy right</div>
        <div style="float:right;  padding-top:8px; margin-right:50px"> Project: MNREGA on JEE : <a href="http://www.globsyn.com">Globsyn</a> :2014 </div></div>
		

	</div>
</div>

</div>

</body>
</html>
<%}else{
	%>
		<jsp:forward page="../index.jsp"></jsp:forward>
	<%
}

%>