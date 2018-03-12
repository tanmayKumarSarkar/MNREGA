

function change_pwd(){
	$("#change_pwd_frm").slideDown("slow");
	$("#change_pwd_frm").animate({ top: "427px",left:"957px",opacity:"1.0" });
	$("#change_pwd_line").css('display','none'); 
	$("#change_pwd_row").css('height','85px');
	$("#change_pwd_frm").bind({},1000,callbackD);
	
	}
	
	function callbackD() {
      setTimeout(function() {
        $( "#change_pwd_frm" ).removeAttr( "style" ).hide().fadeIn();
      }, 1000 );
	}
	
/*-------------------------------------------------------------------------------------------------------------*/	


function change_pwd_js(){
	var new_pwd=window.document.getElementById('new_pwd').value;
	var new_pwd_re=window.document.getElementById('new_pwd_re').value;
	if(new_pwd==="" || new_pwd_re=== ""){alert("Fill Both Of The Fields !!");}
	else{ if(new_pwd===new_pwd_re){

	$.ajax({
				type: "GET",
				data:"new_pwd_submit="+new_pwd,
				url: "../UpdatePasswordServ.xweb",
				success:function(msg){
					if(parseInt(msg)!=0)
					{	
						//alert(msg);
						window.location="./welcome_employee.jsp";
					}
				}
			});
	}else{alert("both password didn't match !!")}}
}
	
/*---------------------------------------------------------------------------------------------------------------*/

function viewForApplicationProject(getPrj_id,ajaxContentUrl){			
			
			url="../"+ajaxContentUrl;
			
			$.ajax({
				type: "GET",
				url: url,
				data:"getPrj_id="+getPrj_id,
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

/*--------------------------------------------------------------------------------------------------------------------------*/

function ApplyFrProjEmp(getPrj_id,ajaxContentUrl){			
			
			url="../"+ajaxContentUrl;
			
			$.ajax({
				type: "GET",
				url: url,
				data:"getPrj_id="+getPrj_id,
				dataType: "html",
				success:function(msg){
					if(parseInt(msg)!=0)
					{	alert("Successfully Applied !!");
						$('#project_content_details').empty();
						$('#project_content_details').html(msg);
					}
				},
				error:function(){
					alert('Sorry Try Again!');
				}
			});
	}

/*----------------------------------------------------------------------------------------------------------------------------------*/

function refOfUpcomingPrjs(getPrj_id,ajaxContentUrl){
	if(document.getElementById('project_content_details')){
	
			url="../content/"+ajaxContentUrl;
			
			$.ajax({
				type: "GET",
				url: url,
				data:"getPrj_id="+getPrj_id,
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
	}else{}	
	}

/*----------------------------------------------------------------------------------------------------------------------------------*/








	