<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<style type="text/css">
body,a,p,div{ margin:0; padding:0;}
	html {
    height: 100%;
		}
	body{ position:relative;min-width: 1366px; min-width:678;
	  animation:mymove 5000ms infinite;
	  background: url(../images/wood.jpg) repeat left top;
	  height: 100%;
	  
	}
a{ text-decoration:none; color:#F8F8FF;}
.big_content{ height:100%; width:100%; 	  background-color:rgba(0,0,0,0.6);
	  background-repeat:repeat;}
.main_contain{
	  
	  position:absolute; height:400px; width:400px; top:50%; left:50%; margin-left:-200px; margin-top:-200px;
	  background: linear-gradient(to bottom right,#FF7F24,#CD661D); 
	  background: -prefix-linear-gradient(left top, #FF7F24,#CD661D);
	  background-repeat: no-repeat;
      background-attachment: fixed;
	  border:8px solid rgba(255,255,255,0.8);
	  border-radius:12px;
	  box-shadow:0 0 8px white;
	  
	
	}	
.header{  height:30px; color:white; width:100%; text-align:center; font-style:bold;
		 background-color:rgba(0,0,0,0.4); font-family:Tahoma, Geneva, sans-serif;
		 font-size:18px;
		}
.content{	
			height:250px; width:250px; margin-left:75px; margin-top:35px; background-color:rgba(0,0,0,0.4); box-shadow:0 0 5px #FFD700; color:white;
			font-family:Tahoma, Geneva, sans-serif; text-align:center; border-radius:5px; border:2px solid rgba(0,0,0,0.8);
		}
.btn{
		height:30px; width:100px; border-radius:15px 2px 15px 2px; color:white;
		 background-color:#63B8FF; border:1px solid rgba(255,255,255,0.5); cursor:pointer;
		 position:absolute; bottom:30px; left:50%; margin-left:-50px; font-family:Tahoma, Geneva, sans-serif; font-size:18px;
	}
</style>
<title>MNREGA :: Error</title>
</head>
<body>
<div class="big_content">
<div class="main_contain">
	<div class="header">
    	Error Msg
    </div>
    <div class="content">
    	<% if(response.getStatus() == 500){ %>
        	<br><br><br><br>
			<h3>Error: <%=exception.getMessage() %></h3>
			<input type="button" value="Home" title="Back To Home" class="btn" onClick="location.href='../index.jsp'"/>
			<%-- include login page --%>
			<%-- <%@ include file="../index.jsp"%> --%>
			<%}else {%><br><br><br><br>
			<h3>Error code is <%=response.getStatus() %></h3>
			<input type="button" value="Home" title="Back To Home" class="btn" onClick="location.href='../index.jsp'"/>
		<%} %>
    </div>
</div>
<div class="footer"></div>
</div>
</body>
</html>