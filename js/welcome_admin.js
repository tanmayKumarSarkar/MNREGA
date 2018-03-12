										/*-----------------Functions for Admin Page-------------------*/

/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/

function AddProjects() {
	
	$('#content_load_ajax').append('<img align="center" style=" text-align:center; margin-left:50%; margin-top:200px;" src="../images/loading.png"/>');			
		
		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("content_load_ajax").innerHTML=xmlhttp.responseText;
					}
				}
		xmlhttp.open("GET","addProject.jsp", true);
		xmlhttp.send();
}

/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/

function loadAjaxApprove(url) {
	
	$('#content_load_ajax').append('<img align="center" style=" text-align:center; margin-left:50%; margin-top:200px;" src="../images/loading.png"/>');			
		
		
		$.ajax({
			type: "GET",
			url: url,
			dataType: "html",
			success:function(msg){
				if(parseInt(msg)!=0)
				{	
					$('#content_load_ajax').empty();
					$('#content_load_ajax').html(msg);
					verifyProject();
					
				}
				else{
					
					alert("not done")
				}
			},
			error:function(){
				alert('Sorry Try Again!');
			}
		});
}
/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/

function loadAjaxApproveEmp(url) {
		
	$('#content_load_ajax').append('<img align="center" style=" text-align:center; margin-left:50%; margin-top:200px;" src="../images/loading.png"/>');					
		
		$.ajax({
			type: "GET",
			url: url,
			dataType: "html",
			success:function(msg){
				if(parseInt(msg)!=0)
				{	
					$('#content_load_ajax').empty();
					$('#content_load_ajax').html(msg);
					approveemplist();					
				}
				else{
					
					alert("not done")
				}
			},
			error:function(){
				alert('Sorry Try Again!');
			}
		});
}
/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/

function AllProjects() {
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function() {
if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
document.getElementById("content_load_ajax").innerHTML=xmlhttp.responseText;
}

}
xmlhttp.open("GET","loadProject.jsp", true);
xmlhttp.send();
}

/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/

function verifyProject() {
xmlhttp=new XMLHttpRequest();
xmlhttp.onreadystatechange=function() {
if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
document.getElementById("content_load_ajax").innerHTML=xmlhttp.responseText;
}

}
xmlhttp.open("GET","verifyproject.jsp", true);
xmlhttp.send();
}
/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/

function viewProject(ajaxContentUrl) {
	
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	document.getElementById("content_load_ajax").innerHTML=xmlhttp.responseText;
	}
	}
	xmlhttp.open("GET",ajaxContentUrl, true);
	xmlhttp.send();		
}

/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/

function viewallemployee() {
	
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	document.getElementById("content_load_ajax").innerHTML=xmlhttp.responseText;
	}
	}
	xmlhttp.open("GET","../viewallemployee.xweb", true);
	xmlhttp.send();		
}

/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/

function viewemployee(ajaxurl) {
	
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	document.getElementById("content_load_ajax").innerHTML=xmlhttp.responseText;
	}
	}
	xmlhttp.open("GET",ajaxurl, true);
	xmlhttp.send();		
}

/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/
$(function() {
		$( "#s_date" ).datepicker({
			changeMonth: true,
			changeYear: true
		});
		$( "#s_date" ).datepicker({ dateFormat: "yyyy-mm-dd" });
	});
$(function() {
		$( "#e_date" ).datepicker({
			changeMonth: true,
			changeYear: true
		});
	});