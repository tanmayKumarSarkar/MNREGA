<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MNREGA :: Registration Form</title>
<script type="text/javascript" src="../jquery/jquery.1.11.1.min.js"></script>
<script type="text/javascript" src="../js/registration.js"></script>
<link type="text/css" href="../css/Basic.css" rel="stylesheet" />
<link type="text/css" href="../css/registration.css" rel="stylesheet" />
<script type="text/javascript">
function checkPasswordMatch() {
    var password = $("#password1").val();
    var confirmPassword = $("#password2").val();

    if (password != confirmPassword){
        $("#divCheckPasswordMatch").html("Passwords mismatch!");
		$("#divCheckPasswordMatch").css({"color":"red","font-size":"14px"});}
    else{
        $("#divCheckPasswordMatch").html("Passwords match.");
		$("#divCheckPasswordMatch").css({"color":"green","font-size":"14px"});}
}
$(document).ready(function () {
   $("#password2").keyup(checkPasswordMatch);
});

$(document).ready(function(e) {

$('#rad_btn_a').click(function(){
	if($(this).val()=="admin"){
		$('#frm_login_panel').attr('action','../GpLoginServ.xweb');}
	});
$('#rad_btn_e').click(function(){
	if($(this).val()=="employee"){
		$('#frm_login_panel').attr('action','../EmpLoginServ.xweb');}
	});	
});	

function validateForm(){
	
	var email = $("#email").val();
	var phone = $("#phone").val();
	var password = $("#password1").val();
    var confirmPassword = $("#password2").val();
	if (password!=confirmPassword) {
        alert("Password Mismatch");
        return false;
    }else{
		return true;
		}
	var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }else{
		return true;
		}
	var phoneno = /^\(\d{3}\)\s*\d{3}(?:-|\s*)\d{4}$/;  
  	if(phone.value.match(phoneno))  
  		{  
    	  return true;  
 		 }  
 	 else  
	  {  
    	 alert("Not a valid Phone Number");  
     	 return false;  
  	  }
}
function submitform(){
	var returntype=validateForm();
	if(returntype!=false){
		var form = $('#reg_form');  
		var url= "../reg.xweb?"+form.serialize();     //form.attr('action'),
		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				alert("Registration Successful!");
				window.location="http://localhost:8080/MNREGAwar/content/welcome_employee.jsp";
					}
				}
		xmlhttp.open("GET",url, true);
		xmlhttp.send();
		}
	
	}

</script>
</head>
<body>
<div id="fullpage" >


<div id="header" align="center">
<img src="../images/mgnrega_banner.gif" />
</div>

<div id="menubar_container" align="center" >
<div id="left_trns_grad"></div>
<div id="menubar">
<a href="/MNREGAwar/index.jsp" style="text-decoration:none; color:#F8F8FF;"><span id="home">HOME</span></a>
<span id="act2005" ><a style="text-decoration:none; color:#F8F8FF;" href="../pdf/rajaswa.pdf">ACT 2005</a></span>
<span id="aboutus"><a style="text-decoration:none; color:#F8F8FF;" href="about_us.jsp">ABOUT US</a></span>
<span id="contactus"><a style="text-decoration:none; color:#F8F8FF;" href="contactUs.jsp">CONTACT US</a></span>
</div>

<div id="right_trns_grad"></div>
</div>


<div id="content_footer" align="center">
	<div id="content_transparent">
		<table id="content_table" height="485px">

<tr>
	<td>
		<div class="content_reg">
			<div class="header">Registration Form</div>
            <div class="form_d">
        	  <form  id="reg_form" name="reg_form">
              <table class="table_f">
              <tr><td>
              	Name:</td><td><input name="name" style=" margin-left:20px; width:200px; padding-left:10px; height:20px;" 
                type="text" placeholder="Type your Name" required/>
                </td></tr><br>
                <tr><td>
                Userid:</td><td><input name="userid" style=" margin-left:20px; width:200px; padding-left:10px; height:20px;" 
                type="text" placeholder="Type UserID" required/></td></tr>

                <tr><td>Job Card No:</td><td><input name="job_card" style="margin-left:20px; padding-left:10px; width:200px; height:20px;"" type="text"
                 placeholder="Type Job card Number" required/></td></tr>

            	<tr><td>Password:</td><td><input id="password1" name="password" style="margin-left:20px; width:200px; padding-left:10px; height:20px;"
                 placeholder="Set Password" type="password" required/>

               <tr><td> Retype Password:</td><td><input id="password2" name="password2" type="password" required style="margin-left:20px; width:200px;
                padding-left:10px; height:20px;"
                placeholder="Retype Password"/></td><td><div id="divCheckPasswordMatch"></div>
               </td></tr>
            	<tr><td>District:</td><td><select required name="district" required id="District_list" style="margin-left:20px;width: 210px;
                 padding-left:10px; height:20px;"
                 onchange="ChangeDistrictList();"> 
  					<option value="" selected="selected" disabled="disabled">-- Select District --</option> 
  					<option value="Bankura">Bankura</option> 
 					<option value="Bardhaman">Bardhaman</option> 
 					<option value="Birbhum">Birbhum</option> 
                    <option value="Cooch Behar">Cooch Behar</option> 
                    <option value="East Midnapore">East Midnapore</option>
                    <option value="Jalpaiguri">Jalpaiguri</option> 
                    <option value="Malda">Malda</option> 
                    <option value="North 24 Parganas">North 24 Parganas</option> 
                    <option value="Purulia">Purulia</option> 
                    <option value="Hooghly">Hooghly</option>
                    <option value="Howrah">Howrah</option>
                    <option value="Murshidabad">Murshidabad</option>
                    <option value="Nadia">Nadia</option>
                    <option value="Siliguri">Siliguri</option>
                    <option value="South 24 Parganas">South 24 Parganas</option>
                    <option value="Uttar Dinajpur">Uttar Dinajpur</option>
                    <option value="West Midnapore">West Midnapore</option>
                     
				</select> </td></tr>

				<tr><td>Gram Panchayat:</td><td><select required name="gp_name" style="width: 210px;margin-left:20px; padding-left:10px; height:20px;"
                 id="Gram_Panchayat_list" onchange="ChangeGP();">
                <option value="" selected="selected" disabled="disabled">-- Select Gram Panchayat --</option> 
                </select></td></tr>

                <tr><td>Village:</td><td><input required name="village" id="Village_list" required type="text" 
                style=" margin-left:20px;padding-left:10px;width:200px;  height:20px;"
                 placeholder="Type Your Village"/></td></tr>

                <tr><td>Phone No. :</td><td><input required name="phone" id="phone" type="text" 
                style="margin-left:20px;width:200px;  padding-left:10px; height:20px;"
                 placeholder="Type Your Valid Ph no" required/></td></tr>

                <tr><td>Email ID:</td><td><input name="email" id="email" required type="text" 
                style=" margin-left:20px;padding-left:10px;width:200px;  height:20px;"
                 placeholder="Type Email ID"/></td><td>
                 
                 <input title="Click Here to Register" 
                style="margin-left:50px;padding-bottom:3px; font-family:Tahoma, Geneva, sans-serif; font-size:17px; 
                 border: 1px solid #006; cursor:pointer; height:30px; width:120px; background: #BADA55;" 
                type="button" onClick="submitform();" value="Register">
                 </td></tr>
                </table>
                <br><br>
                
                

            </form>
            </div>
 		</div> 

	</td>

<td width="280px">
<div id="login_panel">
<div id="login_panel_header">LOGIN HERE</div>

<div id="login_panel_form">
<form  method="post" id="frm_login_panel">
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
  <input type="submit" value="Login" id="login_btn"/><br><br>
  </p>
  <a href="../index.jsp" style="padding-left:40%; " id="home_button" title="Goto The Home Page"><img src="../images/home_icon.png" width="58px" height="58px"></a>
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

</div>
</div>
</div>

</body>
</html>