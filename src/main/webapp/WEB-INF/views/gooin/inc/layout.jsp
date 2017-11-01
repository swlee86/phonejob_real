<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.apache.log4j.Logger"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

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
    <link rel="stylesheet" href="vendor/animate.css/animate.css" />
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
<div class="splash"> <div class="color-line"></div><div class="splash-title"><img src="../images/main_logo.png" alt="Phone & Job"><p>Now loading...</p><div class="spinner"> <div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div> </div> </div>


<!-- Header -->
<tiles:insertAttribute name="header" />


<!-- Main Wrapper -->
<div style="text-align: center">
	<div id="boxed-wrapper" style="display: inline-block;">
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


<!-- Daum_address_search_js -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>

//다음 주소 API
function daumPostcode() {  
	new daum.Postcode({
    oncomplete: function(data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
        var fullAddr = ''; // 최종 주소 변수
        var extraAddr = ''; // 조합형 주소 변수

        
        
        // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            fullAddr = data.roadAddress;

        } else { // 사용자가 지번 주소를 선택했을 경우(J)
            fullAddr = data.jibunAddress;
        }


        // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
        if(data.userSelectedType === 'R'){
            //법정동명이 있을 경우 추가한다.
            if(data.bname !== ''){
                extraAddr += data.bname;
            }
            // 건물명이 있을 경우 추가한다.
            if(data.buildingName !== ''){
                extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
            fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
        }

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        //document.getElementById('addrnum').value = data.zonecode; //5자리 새우편번호 사용
        
        //다시 클릭했을 때를 대비해서 새로운 기본 주소 선택시 상세주소 초기화 후 데이터를 추가한다
        document.getElementById('location_addr2').value = '';
        document.getElementById('location_addr1').value = fullAddr;

        // 커서를 상세주소 필드로 이동한다.
        document.getElementById('location_addr2').focus();
    }
}).open();
   
    
}







    $(function () {


        $("#volunteer").click(function () {
            if (confirm("지원하시겠습니까") == true){
                $('#volunteerE').attr('action','gooin/volunteerOk.do').submit();
            }else{   //취소
                return;
            }
        });
    	
    	  $( "#gooinweekstart" ).datepicker({
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
    	  
    	  $( "#gooinweekend" ).datepicker({
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

        $('.deletechk').click(function () {
      		var listno =   $('#listno').val();
      		
      		 swal({
                 title: "삭제하시겠습니까?",
                 text: "확인을 클릭할시 글이 삭제 됩니다.",
                 type: "warning",
                 showCancelButton: true,
                 confirmButtonColor: "#DD6B55",
                 confirmButtonText: "확인",
                 cancelButtonText: "취소",
                 closeOnConfirm: false,
                 closeOnCancel: false 
                 },
                 function (isConfirm){
                     if(isConfirm){
                     	 $.ajax({
                     		url : "free_board_delete.do",
                     		data : {
                     			no : listno,
                     		},
                     		success : function(data){
    								console.log(data);
                     		}
                     	}); 
                     	swal("삭제되었습니다.", "", "success");
                     	window.location.href='free_board_list.do';
                     } else {
                         swal("취소되었습니다.", "", "error");
                     }
        	});	
        
        });

        

        
 });
    

    function goPage() { 
    	location.href="gooin/gooinMain.do";
    };
    
    
    function useDefaultGo(){
    	var useDefault = document.getElementById("useDefault").checked;
    	if ( useDefault == true ){
    		alert("추후 협의를 선택하셨습니다.");
    	   	 $("#salary_detail").attr("disabled", true);
    	   	 $("#salary_min").attr("disabled", true);
    	   	 $("#salary_max").attr("disabled", true);
    		}
    		if ( useDefault != true ){
    		alert("추후협의를 선택 해제 하셨습니다. 급여를 입력해 주세요.");
    	    	$("#salary_detail").attr("disabled", false);
    	    	$("#salary_min").attr("disabled", false);
    	    	$("#salary_max").attr("disabled", false);
    		}
    	
    }
    
    
    function usenonhomepageGo(){
    	var usenonhomepage = document.getElementById("usenonhomepage").checked;
    	if ( usenonhomepage == true ){
    		alert("홈페이지 없음 선택");
    	   	 $("#homepage").attr("readonly", true);
    	   	 $("#homepage").val('없음');
    	   	}
    		if ( usenonhomepage != true ){
    		alert("홈페이지 주소를 반드시 입력해 주세요.");
    	    	$("#homepage").attr("readonly", false);
    	    	$("#homepage").val('');
    		}
    	
    }
	
	
</script>
</body>
</html>