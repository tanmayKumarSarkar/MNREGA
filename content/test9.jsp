
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<body onLoad="scrollDiv_init()">
 <div id="ecran" style='overflow:auto;width:200px;height:200px;border:solid 1px green;' onMouseOver="pauseDiv()" onMouseOut="resumeDiv()">
 <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
 Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.

Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

</div>
         
	
<script type='text/javascript'>
function scrollDiv_init() {
	DivElmnt = document.getElementById('ecran');
	alert(DivElmnt);
	DivElmnt.scrollTop = 0;
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

</script> 
</body>
