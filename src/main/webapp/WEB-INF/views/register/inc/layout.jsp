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
    <link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.css" />
    <link rel="stylesheet" href="vendor/metisMenu/dist/metisMenu.css" />
    <link rel="stylesheet" href="vendor/animate.css/animate.css" />
    <link rel="stylesheet" href="vendor/bootstrap/dist/css/bootstrap.css" />
    <link rel="stylesheet" href="vendor/chartist/custom/chartist.css" />

    <!-- App styles -->
    <link rel="stylesheet" href="fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css" />
    <link rel="stylesheet" href="fonts/pe-icon-7-stroke/css/helper.css" />
    <link rel="stylesheet" href="styles/style.css">
    
    


</head>
<body class="boxed fixed-footer">

<!-- Simple splash screen-->
<div class="splash"> <div class="color-line"></div><div class="splash-title"><img src="./images/main_logo.png" alt="Phone & Job"><p>Now loading...</p><div class="spinner"> <div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div> </div> </div>
<!--[if lt IE 7]>
<p class="alert alert-danger">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Header -->
<tiles:insertAttribute name="header" />


<!-- Main Wrapper -->
<div style="text-align: center">
	<div id="boxed-wrapper">
<tiles:insertAttribute name="content" />


<!-- Footer-->
<tiles:insertAttribute name="footer" />

	</div>
</div>



<!-- Vendor scripts -->
<script src="vendor/jquery/dist/jquery.min.js"></script>
<script src="vendor/jquery-ui/jquery-ui.min.js"></script>
<script src="vendor/slimScroll/jquery.slimscroll.min.js"></script>
<script src="vendor/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="vendor/jquery-flot/jquery.flot.js"></script>
<script src="vendor/jquery-flot/jquery.flot.resize.js"></script>
<script src="vendor/jquery-flot/jquery.flot.pie.js"></script>
<script src="vendor/flot.curvedlines/curvedLines.js"></script>
<script src="vendor/jquery.flot.spline/index.js"></script>
<script src="vendor/metisMenu/dist/metisMenu.min.js"></script>
<script src="vendor/iCheck/icheck.min.js"></script>
<script src="vendor/peity/jquery.peity.min.js"></script>
<script src="vendor/sparkline/index.js"></script>
<script src="vendor/chartjs/Chart.min.js"></script>
<script src="vendor/chartist/dist/chartist.min.js"></script>
<script src="vendor/slimScroll/jquery.slimscroll.min.js"></script>
<!-- App scripts -->
<script src="scripts/homer.js"></script>
<script src="scripts/charts.js"></script>


<!-- Daum_address_search_js -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>



<script type="text/javascript">
	$(function() {
		
		//////////////////////////////////////////개인회원 스크립트///////////////////////////////////////////////
		
		//회원가입 step1 넘어갈 때 메뉴 처리
		$('#moveStep1').click(function() {
			$("#step1on").css("display", "");
			$("#step1off").css("display", "none");
			$("#step2on").css("display", "none");
			$("#step2off").css("display", "");
			$("#step3on").css("display", "none");
			$("#step3off").css("display", "");				
		});
		
		
		//회원가입 step2 넘어갈 때 validation 체크 및 메뉴 처리
		$('#moveStep2').click(function() {
			var approveChk = document.privateregisterform.approveCheck.checked;
			if(!approveChk){
				alert('약관 동의 여부를 확인하세요');
				return false;
			}else{
			$("#step1on").css("display", "none");
			$("#step1off").css("display", "");
			$("#step2on").css("display", "");
			$("#step2off").css("display", "none");
			$("#step3on").css("display", "none");
			$("#step3off").css("display", "");
			}
		});
		
		//회원가입 step3 넘어갈 때 validation 체크
		$('#moveStep3').click(function() {
			if($('#userid').val()==""){
				alert("아이디를 입력하세요");
				$('#userid').focus();
				return false;
			}
			
			if($('#userpwd').val()==""){
				alert("비밀번호를 입력해 주세요");
				$('#userpwd').focus();
				return false;
			}
			
			if($('#confirmpassword').val()==""){
				alert("비밀번호 확인을 입력해 주세요");
				$('#confirmpassword').focus();
				return false;
			}
			
			if($('#userpwd').val()!=$('#confirmpassword').val()){
				alert("비밀번호와 비밀번호 확인이 맞지 않습니다");
				$('#userpwd').focus();
				return false;
			}
			
			if( $('#username').val()==""){
				alert("이름을 입력해 주세요");
				$('#username').focus();
				return false;
			}
			
			if($('#usermail').val()==""){
				alert("이메일을 입력해 주세요");
				$('#usermail').focus();
				return false;
			}
			
			
			
			$("#step1on").css("display", "none");
			$("#step1off").css("display", "");
			$("#step2on").css("display", "none");
			$("#step2off").css("display", "");
			$("#step3on").css("display", "");
			$("#step3off").css("display", "none");
		});
		
		$('#moveStepback').click(function() {
			$("#step1on").css("display", "none");
			$("#step1off").css("display", "");
			$("#step2on").css("display", "");
			$("#step2off").css("display", "none");
			$("#step3on").css("display", "none");
			$("#step3off").css("display", "");
		});
		
		
		//최종 회원 가입시 validation check 및 메뉴 처리
		$('#registerOk').click(function(){
			var approveChk = document.privateregisterform.approveCheck.checked;
			var smschk = document.privateregisterform.smsok.checked;
			var emailchk = document.privateregisterform.mailok.checked;
			
			var id = $('#userid').val()
			var password = $('#password').val()
			var confirmpassword = $('#confirmpassword').val();
			var username = $('#username').val();
			var email = $('#email').val();
			
			if($('#addrnum').val()==""){
				alert('우편 번호 입력을 통해 우편번호를 선택해 주세요');
				$('#addrnumsearch').focus();
				return false;
			};
			
			if($('#useraddr1').val()==""){
				alert('우편 번호 입력을 통해 기본 주소를 선택해 주세요');
				$('#addrnumsearch').focus();
				return false;
			}
			
			if($('#useraddr2').val()==""){
				alert('상세 주소를 입력해 주세요');
				$('#useraddr2').focus();
				return false;
			}
			
			if($('#userbirth').val()==""){
				alert('생일을 입력해 주세요');
				$('#userbirth').focus();
				return false;
			}
			
		/* 			
			var fileName =$('#pic').val();
			
			if($('#pic').val()==""){
				alert("증명 사진은 필수 입니다.");
				return false;
			}else{
				var ext = fileName.substring(fileName.lastIndexOf(".")+1);
				if(ext!="jpg"&&ext!="png"&&ext!="jpeg"&&ext!="bmp"&&ext!="gif"){
					alert("그림파일만 업로드 가능합니다.");
					return false;
				}				
			}
		 */
			
			$('#privateregisterform').submit();
			
		});
		
		
		
		
		//////////////////////////////////////////기업회원 스크립트///////////////////////////////////////////////
		
		
		
		//회원가입 step1 넘어갈 때 메뉴 처리
		$('#cmoveStep1').click(function() {
			$("#cstep1on").css("display", "");
			$("#cstep1off").css("display", "none");
			$("#cstep2on").css("display", "none");
			$("#cstep2off").css("display", "");
			$("#cstep3on").css("display", "none");
			$("#cstep3off").css("display", "");				
		});
		
		
		//회원가입정보 step2 넘어갈 때 validation 체크 및 메뉴 처리
		$('#cmoveStep2').click(function() {
			var approveChk = document.privateregisterform.approveCheck.checked;
			if(!approveChk){
				alert('약관 동의 여부를 확인하세요');
				return false;
			}else{
			$("#cstep1on").css("display", "none");
			$("#cstep1off").css("display", "");
			$("#cstep2on").css("display", "");
			$("#cstep2off").css("display", "none");
			$("#cstep3on").css("display", "none");
			$("#cstep3off").css("display", "");
			$("#cstep4on").css("display", "none");
			$("#cstep4off").css("display", "");
			}
		});
		
		$('#cmoveStepback2').click(function() {
			$("#cstep1on").css("display", "none");
			$("#cstep1off").css("display", "");
			$("#cstep2on").css("display", "");
			$("#cstep2off").css("display", "none");
			$("#cstep3on").css("display", "none");
			$("#cstep3off").css("display", "");
			$("#cstep4on").css("display", "none");
			$("#cstep4off").css("display", "");
		});
		
		
		
		//회원가입 step3 넘어갈 때 validation 체크
		$('#cmoveStep3').click(function() {
			if($('#userid').val()==""){
				alert("아이디를 입력하세요");
				$('#userid').focus();
				return false;
			}
			
			if($('#userpwd').val()==""){
				alert("비밀번호를 입력해 주세요");
				$('#userpwd').focus();
				return false;
			}
			
			if($('#confirmpassword').val()==""){
				alert("비밀번호 확인을 입력해 주세요");
				$('#confirmpassword').focus();
				return false;
			}
			
			if($('#userpwd').val()!=$('#confirmpassword').val()){
				alert("비밀번호와 비밀번호 확인이 맞지 않습니다");
				$('#userpwd').focus();
				return false;
			}
			
		
			
			
			$("#cstep1on").css("display", "none");
			$("#cstep1off").css("display", "");
			$("#cstep2on").css("display", "none");
			$("#cstep2off").css("display", "");
			$("#cstep3on").css("display", "");
			$("#cstep3off").css("display", "none");
			$("#cstep4on").css("display", "none");
			$("#cstep4off").css("display", "")
		});
		
		
		//담당자정보 step4 넘어갈 때 validation 체크 및 메뉴 이동
		$('#cmoveStep4').click(function() {		
			var approveChk = document.privateregisterform.approveCheck.checked;
			var smschk = document.privateregisterform.smsok.checked;
			var emailchk = document.privateregisterform.mailok.checked;
			
			var id = $('#userid').val()
			var password = $('#password').val()
			var confirmpassword = $('#confirmpassword').val();
			var username = $('#username').val();
			var email = $('#email').val();
			
			if($('#comname').val()==""){
				alert('회사명을 입력하세요');
				$('#comname').focus();
				return false;
			};
			
			if($('#comidfyno').val()==""){
				alert('사업자 번호를 입력하세요');
				$('#comidfyno').focus();
				return false;
			};
			
			
			if($('#addrnum').val()==""){
				alert('우편 번호 입력을 통해 우편번호를 선택해 주세요');
				$('#addrnumsearch').focus();
				return false;
			};
			
			if($('#useraddr1').val()==""){
				alert('우편 번호 입력을 통해 기본 주소를 선택해 주세요');
				$('#addrnumsearch').focus();
				return false;
			}
			
			if($('#useraddr2').val()==""){
				alert('상세 주소를 입력해 주세요');
				$('#useraddr2').focus();
				return false;
			}
			
			if( $('#username').val()==""){
				alert("대표자명을 입력해 주세요");
				$('#username').focus();
				return false;
			}
			
			
			
			$("#cstep1on").css("display", "none");
			$("#cstep1off").css("display", "");
			$("#cstep2on").css("display", "none");
			$("#cstep2off").css("display", "");
			$("#cstep3on").css("display", "none");
			$("#cstep3off").css("display", "");
			$("#cstep4on").css("display", "");
			$("#cstep4off").css("display", "none")
			
			
		});
		
		$('#cmoveStepback').click(function() {
			$("#cstep1on").css("display", "none");
			$("#cstep1off").css("display", "");
			$("#cstep2on").css("display", "none");
			$("#cstep2off").css("display", "");
			$("#cstep3on").css("display", "");
			$("#cstep3off").css("display", "none");
			$("#cstep4on").css("display", "none");
			$("#cstep4off").css("display", "");
		});
		
		
		//최종 회원 가입시 validation check 및 메뉴 처리
		$('#comRegisterOk').click(function(){
			
			
		/* 			
			var fileName =$('#pic').val();
			
			if($('#pic').val()==""){
				alert("증명 사진은 필수 입니다.");
				return false;
			}else{
				var ext = fileName.substring(fileName.lastIndexOf(".")+1);
				if(ext!="jpg"&&ext!="png"&&ext!="jpeg"&&ext!="bmp"&&ext!="gif"){
					alert("그림파일만 업로드 가능합니다.");
					return false;
				}				
			}
		 */
			
			$('#comregisterform').submit();
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	});
	
	
	//SMS 최초 인증 발송 버튼 클릭
	function smsValidation(){
		$('#smsOknum').remove();
		$('#smsOkValidation').remove();
		$('#smsSecondgo').remove();
		
		$('#username').attr("readonly",true);
		$('#userbirth').attr("readonly",true);
		$('#telecom').attr("readonly",true);
		$('#phnum01').attr("readonly",true);
		$('#phnum').attr("readonly",true);
		
		alert('인증번호가 발송되었습니다');
		$('#smsFirstgo').css("display", "none");
		$('#smsGo').append('<input type="text" value="" id="smsOknum" class="form-control smsOknum" name="smsOknum" placeholder="인증번호 입력">');
		$('#smsSecondButton').append('<a class="btn btn-default next" href="javascript:void(0);" onclick="smsOkValidation()" id="smsOkValidation">인증번호 확인</a>');
		$('#smsSecondButton').append('<a class="btn btn-default next" href="javascript:void(0);" onclick="smsreValidation()" id="smsSecondgo">SMS 재발송</a>');

	}
	
	//SMS 인증 재발송 버튼
	function smsreValidation(){
		$('#smsOknum').remove();
		$('#smsOkValidation').remove();
		$('#smsSecondgo').remove();
		alert('인증번호가 재발송되었습니다');
		$('#smsGo').append('<input type="text" value="" id="smsOknum" class="form-control smsOknum" name="smsOknum" placeholder="인증번호 입력">');
		$('#smsSecondButton').append('<a class="btn btn-default next" href="javascript:void(0);" onclick="smsOkValidation()" id="smsOkValidation">인증번호 확인</a>');
		$('#smsSecondButton').append('<a class="btn btn-default next" href="javascript:void(0);" onclick="smsreValidation()" id="smsSecondgo">SMS 재발송</a>');
		$('smsOknum').focus();
	};
		
	function smsOkValidation(){
		$('#smsOknum').remove();
		$('#smsOkValidation').remove();
		$('#smsSecondgo').remove();
		alert('인증에 성공하였습니다.');
		
	};
	
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
            document.getElementById('addrnum').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('useraddr1').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('useraddr2').focus();
        }
    }).open();
	   
	    
	}

	
	
	
	
	
	</script>


</body>
</html>