<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.apache.log4j.Logger"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%! static Logger logger = Logger.getLogger("layout.jsp"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Page title -->
    <title>Phone&Job</title>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!--<link rel="shortcut icon" type="image/ico" href="favicon.ico" />-->

    <!-- Vendor styles -->
    <link rel="stylesheet" href="../vendor/fontawesome/css/font-awesome.css" />
    <link rel="stylesheet" href="../vendor/metisMenu/dist/metisMenu.css" />
    <link rel="stylesheet" href="../vendor/animate.css/animate.css" />
    <link rel="stylesheet" href="../vendor/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="../vendor/chartist/custom/chartist.css" />

    <!-- App styles -->
    <link rel="stylesheet" href="../fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css" />
    <link rel="stylesheet" href="../fonts/pe-icon-7-stroke/css/helper.css" />
    <link rel="stylesheet" href="../styles/style.css">
    
    <link rel="stylesheet" href="../vendor/summernote/dist/summernote.css" />
    <link rel="stylesheet" href="../vendor/summernote/dist/summernote-bs3.css" />
    
    <link rel="stylesheet" href="../vendor/sweetalert/lib/sweet-alert.css" />
   
     <!-- DatePicker 소스 -->
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
    
<style type="text/css">
table.type10 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    margin: 20px 10px;
    display: inline-block;
}
table.type10 thead th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #e7708d;
    margin: 20px 10px;
}
table.type10 tbody th {
    width: 150px;
    padding: 10px;
}
table.type10 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
}
table.type10 .even {
    background: #fdf3f5;
}


</style>
    
    
    
    
</head>
<body class="boxed fixed-footer">


<!-- Simple splash screen-->
<div class="splash"> <div class="color-line"></div><div class="splash-title"><img src="./images/main_logo.png" alt="Phone & Job"><p>Now loading...</p><div class="spinner"> <div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div> </div> </div>




<!-- Header -->
<tiles:insertAttribute name="header" />


<!-- Main Wrapper -->
<div style="text-align: center">
	<div id="boxed-wrapper">
		<tiles:insertAttribute name="content" />
	</div>
</div>
																																																																																																																																																																																																						<!-- Footer-->
																																																																																																																																																																																																						<tiles:insertAttribute name="footer" />
																																																																																																																																																																																																				</div>

<!-- Footer-->
<tiles:insertAttribute name="footer" />


<!-- Vendor scripts -->
<script src="../vendor/jquery/dist/jquery.min.js"></script>
<script src="../vendor/jquery-ui/jquery-ui.min.js"></script>
<script src="../vendor/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../vendor/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="../vendor/metisMenu/dist/metisMenu.min.js"></script>
<script src="../vendor/iCheck/icheck.min.js"></script>
<script src="../vendor/sparkline/index.js"></script>
<script src="../vendor/summernote/dist/summernote.min.js"></script>

<!-- App scripts -->
<script src="../scripts/homer.js"></script>

<!-- alert 창 -->
<script src="../vendor/sweetalert/lib/sweet-alert.min.js"></script>
<script src="../scripts/sojaeji.js"></script>



<script type="text/javascript"> 
//sojaeji('<?php echo $wr_1?>', '<?php echo $wr_2?>', '<?php echo $wr_3?>');
sojaeji('서울', '강남구', '신사동');


function goPage() { 
	location.href="googic.do"; 
};

function useNewlocation(){
	var uselocation = document.getElementById("uselocation").checked;
	if ( uselocation == true ){
		alert("클릭하셨습니다");
	   	 $("#sido").attr("disabled", true);
	   	 $("#gugun").attr("disabled", true);
	   	 $("#dong").attr("disabled", true);
		}
		if ( uselocation != true ){
		alert("해제");
	    	$("#sido").attr("disabled", false);
	    	$("#gugun").attr("disabled", false);
	    	$("#dong").attr("disabled", false);
		}
}

	$(function(){
	
		  $( ".dateSelect" ).datepicker({
 		     dateFormat: 'yy-mm-dd',
 		     minDate: '-100y',
 		     yearRange: 'c-100:c+10',
 		     showButtonPanel: true,
 		     currentText: '오늘 날짜',
 		     monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
 		     dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
 		     changeMonth: true, 
 	         changeYear: true,
 	         nextText: '다음 달',
 	         prevText: '이전 달' 
 	  });
 	  
	});
	
	





</script>

</body>
</html>