<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>About Us</title>
<style type="text/css">
body,a,p,div,h4{ margin:0; padding:0;}
	html {
    height: 100%;
		}
	body{ position:relative;min-width: 1366px; min-width:678;
	  animation:mymove 5000ms infinite;
	  background: url(../images/29.png) repeat left top;
	  height: 100%;
	  
	}
h4{ font-family:Tahoma, Geneva, sans-serif; font-size:18px; margin-top:-18px;}
a{ text-decoration:none; color:#F8F8FF;}
#fullpage {
height:100%; width:100%; background-color:rgba(0,0,0,0.6);  background-repeat:repeat;
}
#menubar_container{
	height: 45px;
	}
#menubar{
	height: 25px;
	width: 482px;
	position: absolute;
	background-color: rgba(171,94,47,0.7);
	left: 419px;
	top: 78px;
	letter-spacing: 2px;
	word-spacing: 7px;
	text-align: center;
	vertical-align: middle;
	padding-top: 3px;
	padding-right: 7px;
	padding-bottom: 5px;
	padding-left: 7px;
	border-top:2px solid rgba(102,102,102,1);
	border-bottom: 2px solid rgba(102,102,102,1);
	}
#left_trns_grad{
	position: absolute;
	top: 78px;
	width: 92px;
	height: 33px;
	background-color: rgba(233,195,122,0.8);
	background: -moz-linear-gradient(left, rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	background: -webkit-linear-gradient(left,rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	background: -0-linear-gradient(left,rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	background: -ms-linear-gradient(left,rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	background: linear-gradient(left,rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	left: 327px;
	border-width: 2px 0 2px 0;
	border-style: solid;
	-moz-border-image: -moz-linear-gradient(left, rgba(233,195,122,0) , rgba(102,102,102,1)) 100% 1;
	-webkit-border-image: -webkit-gradient(linear,0 0,100% 0,from( rgba(233,195,122,0)), to(rgba(102,102,102, 1))) 100% 1;
	-webkit-border-image: -webkit-linear-gradient(left,rgba(233,195,122,0), rgba(102,102,102, 1)) 100% 1;
	-o-border-image: -o-linear-gradient(left,rgba(233,195,122,0), rgba(102,102,102, 1)) 100% 1;
	-ms-border-image: -ms-linear-gradient(left,rgba(233,195,122,0)), rgba(102,102,102, 1)) 100% 1;
	}	
#right_trns_grad{
	position: absolute;
	top: 78px;
	width: 92px;
	height: 33px;
	background-color: rgba(233,195,122,0.8);
	background: -moz-linear-gradient(right, rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	background: -webkit-linear-gradient(right,rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	background: -0-linear-gradient(right,rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	background: -ms-linear-gradient(right,rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	background: linear-gradient(right,rgba(233,195,122,0) 0%, rgba(189,124,70,0.8) 85%, rgba(171,94,47,0.7) 100%);
	left: 915px;
	border-width: 2px 0 2px 0;
	border-style: solid;
	-moz-border-image: -moz-linear-gradient(right, rgba(233,195,122,0) , rgba(102,102,102,1)) 100% 1;
	-webkit-border-image: -webkit-gradient(linear,100% 0,0 0,from( rgba(233,195,122,0)), to(rgba(102,102,102, 1))) 100% 1;
	-webkit-border-image: -webkit-linear-gradient(right,rgba(233,195,122,0), rgba(102,102,102, 1)) 100% 1;
	-o-border-image: -o-linear-gradient(right,rgba(233,195,122,0), rgba(102,102,102, 1)) 100% 1;
	-ms-border-image: -ms-linear-gradient(right,rgba(233,195,122,0)), rgba(102,102,102, 1)) 100% 1;
}	
#home,#act2005,#aboutus,#contactus {
	height: auto;
	width: auto;
	background-color: rgba(109,55,29,1);
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	color:white;
	text-shadow: 1px 1px rgba(255,0,0,1);
	font-size: 16px;
	padding:3px;
	font-style: oblique;
	margin: -1px;
	margin-top:5px;
	padding-top: -4px;
	padding-right: -1px;
	padding-bottom: -4px;
	padding-left: -1px;
	border-top-width: 2px;
	border-right-width: 3px;
	border-bottom-width: 2px;
	border-left-width: 3px;
	border-top-style: inset;
	border-right-style: inset;
	border-bottom-style: inset;
	border-left-style: inset;
	border-top-color: rgba(159,81,43,1);
	border-right-color: rgba(159,81,43,1);
	border-bottom-color: rgba(159,81,43,1);
	border-left-color: rgba(159,81,43,1);
	overflow:hidden;
	-moz-transition: all 0.5s ease-in-out; /* CSS3 transition to animate all A properties */
	-webkit-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-moz-transition: all 0.3s ease-in-out;
	-ms-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	}
	#home:hover,#act2005:hover,#aboutus:hover,#contactus:hover {
	color:black;
	text-shadow: 1px 1px white ;
	background-color:rgba(231,177,99,1);
	border: 1px 2px 1px 2px;
	//border-style: solid;
	border-color:rgba(109,55,29,1);
	box-shadow: 1px 1px 2px 1px white inset;
	-webkit-border-radius: 37%; /* large radius to create circular borders */
	-moz-border-radius: 37%;
	border-radius: 37%;
	}
#content_transparent{
	width:1140px;
	height:auto;
	padding-top:20px;
	background-color:rgba(0,0,0,0.2);
	border:1px solid rgba(0,0,0,0.5);
	box-shadow:0 0 10px #000;
	}	
#footer{
	position:absolute; bottom:0px; left:0px; color:white; text-shadow:0px 0px 3px blue;
	height:37px; width:100%;
	background-color:rgba(171,94,51,0.3);
	border-top:2px;
	border-width:1px 0px 0px 0px; border-style:solid;
	border-color:white;
	-moz-border-image: -moz-linear-gradient(left,rgba(255,255,255, 0.5), white, rgba(255,255,255, 0.5)) 100% 1;
	-webkit-border-image: -webkit-gradient(linear,0 0,100% 0,from( white), to(rgba(255,255,255, 0.5))) 100% 1;
	-webkit-border-image: -webkit-linear-gradient(left,rgba(255,255,255, 0.5), white, rgba(255,255,255, 0.5)) 100% 1;
	-o-border-image: -o-linear-gradient(left,rgba(255,255,255, 0.5), white, rgba(255,255,255, 0.5)) 100% 1;
	}
#content{ height:450px;}
.dev{ background-color:rgba(0,0,0,0.3); border-radius:8px; margin:5px; padding-bottom:5px;}
</style>
</head>

<body>
<div id="fullpage" >


<div id="header" align="center">
<img src="../images/mgnrega_banner.gif" />
</div>

<div id="menubar_container" align="center" >
<div id="left_trns_grad"></div>
<div id="menubar">
<span id="home"><a href="/MNREGAwar/index.jsp">HOME</a></span>
<span id="act2005"><a style="text-decoration:none; color:#F8F8FF;" href="../pdf/rajaswa.pdf">ACT 2005</a></span>
<span id="aboutus"><a href="">ABOUT US</a></span>
<span id="contactus"><a href="contactUs.jsp">CONTACT US</a></span>
</div>
<div id="right_trns_grad"></div>
</div>


<div id="content_footer" align="center"><div id="content_transparent">
<div id="content">
	<div style="border:1px solid white; height:95%; width:300px;
    		border-radius:7px; 
    	 background: linear-gradient(45deg, #F8F8FF,#BFEFFF,#ccc); box-shadow:0 0 5px blue;
	  background: -prefix-linear-gradient(45deg, #F8F8FF,#BFEFFF,#ccc); float:left; margin-left:20px;">
    	<div style=" height:30px; font-family:Tahoma, Geneva, sans-serif; color:white; text-align:center;
         background-color:rgba(0,0,0,0.4); padding-top:5px;"> About Software Developers</div>
         <div style=" margin:0; padding:0;">
         <div class="dev">
         	<h3>Sumit Pal <br />Information Technology</h3>           
            <h4>Jalpaiguri Govt. Engg. College</h4>
         </div>
         <div class="dev">
            <h3>Tanmay Kumar Sarkar,<br />Information Technology</h3>
            <h4>Jalpaiguri Govt. Engg. College</h4>
         </div>
		<div class="dev">
            <h3>Shuvankar Mandol ,<br />Information Technology</h3>
            <h4>Jalpaiguri Govt. Engg. College</h4>
        </div>
        <div class="dev">
            <h3>Arijit Ghosh <br />Information Technology</h3>
            <h4>Asansol Engineering College</h4>
        </div>
         
            
         </div>
    </div>
	<div style="border:5px solid white; height:95%; width:780px; float:right; margin-right:20px; border-radius:10px; 
    	 background: linear-gradient(45deg, #F8F8FF,#FFBBFF,#ccc); box-shadow:0 0 5px blue;
	  background: -prefix-linear-gradient(45deg, #F8F8FF,#FFBBFF,#ccc);">
    	<div style=" height:30px; font-family:Tahoma, Geneva, sans-serif; color:white;
         background-color:rgba(0,0,0,0.4); padding-top:5px;"> About National Rural Employment Guarantee Act 2005</div>
         
         <div style="overflow-y: auto; padding:3px;">
         	<br /><p>
            	The National Rural Employment Guarantee Act 2005 , also known as the "Mahatma Gandhi National Rural Employment Guarantee Act", and abbreviated to MGNREGA, is an Indian labour law and social security measure that aims to guarantee the 'right to work' and ensure livelihood security in rural areas by providing at least 100 days of guaranteed wage employment in a financial year to every household whose adult members volunteer to do unskilled manual work. The UPA Government is also planning to increase the number of working days from 100 to 150 before the 2014 Lok Sabha Elections in the country. The statute is hailed by the government as "the largest and most ambitious social security and public works programme in the world". The more comprehensive survey of Comptroller and Auditor General (CAG) of India, a ‘Supreme Audit Institution’ defined in Article 148 of the Constitution of India, reports serious lapses in implementation of the act.

The statement of the law provides adequate safeguards to promote its effective management and implementation. The act explicitly mentions the principles and agencies for implementation, list of allowed works, financing pattern, monitoring and evaluation, and most importantly the detailed measures to ensure transparency and accountability. Further the provisions of the law adhere to the principles enunciated in the Constitution of India.

The comprehensive assessment of the performance of the law by the constitutional auditor revealed serious lapses arising mainly due to lack of public awareness, mismanagement and institutional incapacity. The CAG also suggests a list of recommendations to the government for corrective measures. The government, however, had also released a collection of reportedly independent researches evaluating the functioning of the act whose results significantly differed from the CAG report. Meanwhile, the social audits in two Indian states highlight the potential of the law if implemented effectively.
            </p>
         </div>
    </div>	

<div id="footer">
		<div style="float:left; padding-top:8px; margin-left:50px">@ copy right</div>
        <div style="float:right;  padding-top:8px; margin-right:50px"> Project: MNREGA on JEE : <a href="http://www.globsyn.com">Globsyn</a> :2014 </div>
</div>



</div>
</div></div></div>
</body>
</html>

