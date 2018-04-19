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
    <link rel="stylesheet" href="../styles/static_custom.css">
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
<script src="../vendor/sweetalert/lib/sweet-alert.min.js"></script>
<script src="../vendor/toastr/build/toastr.min.js"></script>

<!-- App scripts -->
<script src="../scripts/homer.js"></script>

<!-- alert 창 -->
<script src="../vendor/sweetalert/lib/sweet-alert.min.js"></script>


<script>
    $(function () {
        // Initialize summernote plugin
        $('.summernote').summernote();

        //var sHTML = $('.summernote').code();

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


    toastr.options = {
        "debug": false,
        "newestOnTop": false,
        "positionClass": "toast-top-center",
        "closeButton": true,
        "toastClass": "animated fadeInDown",
    };


    $('.article-register').click(function () {
        swal({
                title: "확인",
                text: "공지사항을 등록 하시겠습니까?",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "네",
                cancelButtonText: "아니오",
                closeOnConfirm: false,
                closeOnCancel: false
            },
            function (isConfirm) {
                if (isConfirm) {
                    $.ajax({
                        type: 'POST' ,
                        url: 'noticeWrite.do' ,
                        data : $('form').serialize(),
                        success: function(data) {
                            console.log(data);
                            if(data==1){
                                isConfirm = false;
                                swal("처리 결과", "공지사항 등록 처리 완료", "success");
                                //toastr.success('성공 - 공지사항 등록 처리 완료');
                                if (isConfirm) {
                                    window.location.replace('../notice/noticeBoardMain.do');
                                }
                                /*
                                setTimeout(function() {
                                    window.location.replace('../notice/noticeBoardMain.do');
                                }, 1500);
                                */
                            }else{
                                swal("처리 결과", "등록 실패. 잠시 후 다시 시도해 주세요", "error");
                                //toastr.error('실패 - 공지사항 등록 처리 실패');
                            }
                        }
                    });
                } else {
                    swal("등록 취소", "공지사항 등록이 취소 되었습니다:)", "error");
                    return false;
                }
            });
    });

    function delete_notice_event(){
        var notice_no= "notice_no=" + $("#notice_no").val();


        swal({
                title: "확인",
                text: "정말 삭제하시겠습니까?",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "네",
                cancelButtonText: "아니오",
                closeOnConfirm: false,
                closeOnCancel: false
            },
            function (isConfirm) {
                if (isConfirm) {
                    $.ajax({
                        type: 'POST' ,
                        url: 'noticeDelete.do' ,
                        data : notice_no,
                        success: function(data) {
                            console.log(data);
                            if(data==1){
                                swal("처리 결과", $("#notice_no").val()+"번글 삭제 완료", "success");
                                //toastr.success('성공 - 삭제 완료');
                                //alert('공지사항 등록 처리 완료');
                                if (isConfirm) {
                                    window.location.replace('../notice/noticeBoardMain.do');
                                }
                                /*
                                setTimeout(function() {
                                    window.location.replace('../notice/noticeBoardMain.do');
                                }, 1500);
                                */
                            }else{
                                //toastr.error('삭제 실패. 잠시 후 다시 시도해 주세요');
                                swal("처리 결과", $("#notice_no").val()+"번글 삭제 실패. 잠시 후 다시 시도해 주세요", "error");
                            }
                        }
                    });
                } else {
                    swal("작업 취소", "삭제 작업이 취소 되었습니다:)", "error");
                    return false;
                }
            });
    }
	
</script>
</body>
</html>