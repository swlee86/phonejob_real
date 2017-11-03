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

	<!--텍스트 에디터 사용시 추가해야할 css -->
    <link rel="stylesheet" href="../vendor/summernote/dist/summernote.css" />
    <link rel="stylesheet" href="../vendor/summernote/dist/summernote-bs3.css" />

    <!-- App styles -->
    <link rel="stylesheet" href="../fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css" />
    <link rel="stylesheet" href="../fonts/pe-icon-7-stroke/css/helper.css" />
    <link rel="stylesheet" href="../styles/style.css">
    <link rel="stylesheet" href="../vendor/sweetalert/lib/sweet-alert.css" />
    


</head>
<body class="boxed fixed-footer">

<!-- Simple splash screen-->
<div class="splash"> <div class="color-line"></div><div class="splash-title"><img src="../images/main_logo.png" alt="Phone & Job"><p>Now loading...</p><div class="spinner"> <div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div> </div> </div>


<!-- Header -->
<tiles:insertAttribute name="header" />


<!-- Main Wrapper -->
<div style="text-align: center">
	<div id="boxed-wrapper" style="left: 181px; right: 181px;">
		<tiles:insertAttribute name="content" />
	</div>


<!-- Footer-->
<tiles:insertAttribute name="footer" />
</div>


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


<script>

    $(function () {

        // Initialize summernote plugin
        $('.summernote').summernote();

        var sHTML = $('.summernote').code();

        $('.summernote1').summernote({
            toolbar: [
                ['headline', ['style']],
                ['style', ['bold', 'italic', 'underline', 'superscript', 'subscript', 'strikethrough', 'clear']],
                ['textsize', ['fontsize']],
                ['alignment', ['ul', 'ol', 'paragraph', 'lineheight']],
            ]
        });

        $('.summernote2').summernote({
            airMode: true,
        });
        


 });
    
    function delete_event(){
    	if (confirm("정말 삭제하시겠습니까??") == true){    //확인
    		var list_no= "list_no=" + $("#listno").val();
    		console.log(list_no);
    		$.ajax({ 
    			type: 'POST' , 
    			url: 'freeDelete.do' ,
    			data : list_no , 
    			success: function(data) { 
    				console.log(data);
    				if(data==1){
                        alert($("#listno").val()+'번글 삭제 처리 완료');
    					window.location.replace('../free/freeboardMain.do');
    				}else{
    					alert($("#listno").val()+'번글 삭제 실패. 잠시 후 다시 시도해 주세요');
    				}
    			} 
    		});

    	}else{   //취소
    	    return;
    	}
    }

	
</script>
</body>
</html>