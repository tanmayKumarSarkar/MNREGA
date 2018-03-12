
function loadAjax(ajaxContentUrl) {
			
			
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
			
}

/*-------------------------------------------------------------------------------------------------------------------------*/
function FrgtPwdCheckForUserDetails(){
$.ajax({
				type: "GET",
				url: "content/ForgotPassword1.jsp",
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
}

/*---------------------------------------------------------------------------------------------------------------------------*/

function FrgtPwdCheckForUserDetailsGet(){
	var frm_user_id=window.document.getElementById('frm_user_id').value;
	var frm_user_jobcard=window.document.getElementById('frm_user_jobcard').value;
	var frm_user_pwd=window.document.getElementById('frm_user_pwd').value;
	var frm_user_repwd=window.document.getElementById('frm_user_repwd').value;
	if(frm_user_pwd==="" || frm_user_repwd=== "" || frm_user_id==="" || frm_user_jobcard===""){
					alert("Fill All Of The Fields !!"); }
	else{ if(frm_user_pwd===frm_user_repwd){
	$.ajax({
				type: "GET",
				data:{
					frm_user_id: frm_user_id,
					frm_user_jobcard: frm_user_jobcard,
					frm_user_pwd: frm_user_pwd,
					frm_user_repwd: frm_user_repwd
				},
				url: "./ForgotPasswordServ.xweb",
				dataType: "html",
				success:function(msg){
					if(parseInt(msg)!=0)
					{	
						if(msg==="failed"){alert("UserID Or Job Card No Didn't Match !!")}
						else if(msg==="success"){
									alert("successfull !!")
									$.ajax({
											type: "GET",
											url: "content/statictics.jsp",
											dataType: "html",
											success:function(msg){
												if(parseInt(msg)!=0){	
												$('#details_inner').empty();
												$('#details_inner').html(msg);
												}
											}
									 });
						
						}
						else{
						$('#details_inner').empty();
						$('#details_inner').html(msg);}
					}
				},
				error:function(){
					alert('Sorry Try Again!');
				}
			});
		}else{alert("both password didn't match !!")}
	  }
	}
	
	/*---------------------------------------------------------------------------------------------------------------------*/
	
function scrollDiv_init() {
	DivElmnt = $('#upcoming_content');
	DivElmnt.scrollTop = 100;
	PreviousScrollTop  = 0;
	ScrollInterval = setInterval(ScrollDiv, 100);
}
function ScrollDiv(){

   if(DivElmnt.scrollTop<(DivElmnt.scrollHeight-DivElmnt.offsetHeight)){
         DivElmnt.scrollTop=DivElmnt.scrollTop+1;
		 PreviousScrollTop=DivElmnt.scrollTop;
         }
   else {DivElmnt.scrollTop=0;}
}

function pauseDiv() {
	clearInterval(ScrollInterval);
}
function resumeDiv() {
	PreviousScrollTop = DivElmnt.scrollTop;
	ScrollInterval    = setInterval(ScrollDiv, 100);
}

