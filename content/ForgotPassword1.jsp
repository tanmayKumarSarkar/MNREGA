<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>    
<%! %>   
<script src="../js/index.js"></script>
<style type="text/css">
#tab_frgtpwd1{
	margin-top:-15px;
	margin-bottom:10px;
	font:"Courier New", Courier, monospace;
	font-size:17px;
	line-height:20px;
	color:white;
	text-shadow:1px 1px 1px black;
	letter-spacing:2px;
	word-spacing:4px;
	}
#frm_user_id,#frm_user_jobcard,#frm_user_pwd,#frm_user_repwd{
	border: 1px solid white;
	border-radius:2px;
	background: rgba(255,255,255,0);
	box-shadow:1px 1px 1px black;
	text-align:center;
	letter-spacing:1px;
	font:"Times New Roman", Times, serif;
	font-style:oblique;
	}	
</style>
<table id="tab_frgtpwd1" width="467" border="0" cellspacing="0px" cellpadding="3px" align="center">
  <tr>
    <th scope="col" colspan="2">USER AUTHENTICATION</th>
  </tr>
  <td width="205"><form id="frm_frgtpwd" >
  <tr>
    <td>Enter User Id</td>
    <td width="238" align="center">
    	<input type="text" id="frm_user_id" name="frm_user_id" required="required" />
    </td>
  </tr>
  <tr>
    <td>Enter Job Card no</td>
    <td align="center">
    	<input type="text" id="frm_user_jobcard" name="frm_user_jobcard" required="required" />
    </td>
  </tr>
  <tr>
    <td>Enter New Password</td>
    <td align="center">
    	<input type="password" id="frm_user_pwd" name="frm_user_pwd" required="required" />
    </td>
  </tr>
  <tr>
    <td>ReEnter New Password</td>
    <td align="center">
    	<input type="password" id="frm_user_repwd" name="frm_user_repwd" required="required" />
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    	<input type="submit" id="frm_user_submit" value="Submit" name="frm_user_submit" onclick="FrgtPwdCheckForUserDetailsGet()" />
    </td>
  </tr>
</table>
