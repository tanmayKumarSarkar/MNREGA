<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MNREGA</title>
<script src="jquery/jquery.min.js"></script>
<script src="jquery/cycle.js"></script>
<script src="jquery/jquery.easing.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css" >
<style type="text/css">
	
</style>
<script type="text/javascript">
window.onload=loadAjax('../MyProjectDetails.xweb');

/*-------------------------------------------------------------------------------------------------------------------------------------------------*/
var QueryString = function () {
  var query_string = {};
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");

    if (typeof query_string[pair[0]] === "undefined") {
      query_string[pair[0]] = pair[1];

    } else if (typeof query_string[pair[0]] === "string") {
      var arr = [ query_string[pair[0]], pair[1] ];
      query_string[pair[0]] = arr;
    	
    } else {
      query_string[pair[0]].push(pair[1]);
    }
  } 
    return query_string;
} ();

if(QueryString.msg!=null){alert(" Invalid UserName Or PassWord !!");}
/*-------------------------------------------------------------------------------------------------------------------------------------------------*/
function loadAjax(ajaxContentUrl) {
					
			url=ajaxContentUrl;
			
			$.ajax({
				type: "GET",
				url: "content/UpcomingProjects.jsp",
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
					
			
			$.ajax({
				type: "GET",
				url: "content/OngoingProjects.jsp",
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
			
			$.ajax({
				type: "GET",
				url: "content/statictics.jsp",
				dataType: "html",
				success:function(msg){
					if(parseInt(msg)!=0)
					{	
						$('#details_inner').empty();
						$('#details_inner').html(msg);
					}
				},
				error:function(){
					alert('Sorry Try Again!');
				}
			});
			
			scrollDiv_init();		
}

/*-------------------------------------------------------------------------------------------------------------------------------------------------*/
</script>
</head>
<body>
<div id="fullpage" >


<div id="header" align="center">
<img src="./images/mgnrega_banner.gif" />
</div>

<div id="menubar_container" align="center" >
<div id="left_trns_grad"></div>
<div id="menubar">
<span id="home"><a href="">HOME</a></span>
<span id="act2005"><a style="text-decoration:none; color:#F8F8FF;" href="pdf/rajaswa.pdf">ACT 2005</a></span>
<span id="aboutus"><a style="text-decoration:none; color:#F8F8FF;" href="content/about_us.jsp">ABOUT US</a></span>
<span id="contactus"><a style="text-decoration:none; color:#F8F8FF;" href="content/contactUs.jsp">CONTACT US</a></span>
</div>
<div id="right_trns_grad"></div>
</div>


<div id="content_footer" align="center"><div id="content_transparent">
<table id="content_table" height="485px" >

<tr>
<td width="260px">
<div id="upcoming" align="center">
<div id="upcoming_header">Upcoming Projects....</div>
 
	<div id="upcoming_content"
						 onclick="alert('You Must Have To Login To See The Details !!')"
						 style='overflow:auto;width:250px;height:200px;' onMouseOver="pauseDiv()" onMouseOut="resumeDiv()">
    
    </div>
</div>
<div id="ongoing" align="center">
<div id="ongoing_header">Ongoing Projects....</div>
<div id="ongoing_content" ></div>
</div>
</td>

<td width="580px">
<div id="slide">
<div id="slide_box">
	<div class="slide_show" id="slide_show">
        	<img src="images/1.jpg"  class="active"/>
            <img src="images/2.jpg" />
            <img src="images/3.jpg" />
            <img src="images/4.jpg" />
            <img src="images/5.jpg" />
	</div>
<script type="text/javascript">
$.fn.cycle.defaults.timeout = 4000;
$(function() {
    $('#slide_show').cycle({
    fx:    'scrollHorz',
	easing: 'easeOutQuart',
    sync:   1200,
	pause: 1,
    delay: -1500,
	next:'#slide_right_arrow',
	prev:'#slide_left_arrow'
});
});



</script>
<div id="slide_left_arrow"><img src="images/left_arrows.png" /></div>
<div id="slide_right_arrow"><img src="images/right_arrows.png" /></div>
</div>
</div>
<div id="details" align="center">
<div id="details_inner" align="center" style="margin-top:-8px;">
</div>
</div>
</td>

<td width="280px">
<div id="login_panel">
<div id="login_panel_header">LOGIN HERE</div>
<script type="text/javascript">
$(document).ready(function(e) {

$('#rad_btn_a').click(function(){
	if($(this).val()=="admin"){
		$('#frm_login_panel').attr('action','GpLoginServ.xweb');}
	});
$('#rad_btn_e').click(function(){
	if($(this).val()=="employee"){
		$('#frm_login_panel').attr('action','EmpLoginServ.xweb');}
	});	
});	
</script>

<div id="login_panel_form">
<form action="" method="post" id="frm_login_panel">
  <p><span>UserId </span> 
    <input type="text" name="userid" id="userid" placeholder="Enter UserId" required/><br>
    <span>Password </span>
    <input type="password" name="password" id="password" placeholder="Enter Password" required/>
  <br>
  <span>Select Catagory</span><br>
  <span>Admin</span>
  <input type="radio" id="rad_btn_a" name="user_type" value="admin" required/>&nbsp;&nbsp;
  <span>Employee</span>
  <input type="radio" id="rad_btn_e" name="user_type" value="employee" required/><br>
  <input type="submit" value="Login" id="login_btn"/><br>
  <span id="frgt_pwd" onClick="FrgtPwdCheckForUserDetails()"><a style="cursor:pointer">Forgot Password ?</a></span><br>
  <a href="./content/registration.jsp"><input type="button"  value="Register" id="register_btn"/></a>
  </p>
</form>

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
