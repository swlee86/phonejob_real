<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

    <!-- App styles -->
    <link rel="stylesheet" href="../fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css" />
    <link rel="stylesheet" href="../fonts/pe-icon-7-stroke/css/helper.css" />
    <link rel="stylesheet" href="../styles/style.css">

<style type="text/css">
 #popDiv{
  position:absolute;
  display:none;
  border:1px solid #808080;
 }

 #popDiv .close{
  position:absolute;
  bottom:5px;
  right:5px;
 }

</style>


</head>
<body class="boxed fixed-footer hide-sidebar">


<!-- Simple splash screen-->
<div class="splash"> <div class="color-line"></div><div class="splash-title"><img src="../images/main_logo.png" alt="Phone & Job"><p>Now loading...</p><div class="spinner"> <div class="rect1"></div> <div class="rect2"></div> <div class="rect3"></div> <div class="rect4"></div> <div class="rect5"></div> </div> </div> </div>
<!--[if lt IE 7]>
<p class="alert alert-danger">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Header -->
<tiles:insertAttribute name="header" />

<!-- Header -->
<tiles:insertAttribute name="sidebar" />

<!-- Main Wrapper -->
<div style="text-align: center">
	<div id="boxed-wrapper">
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
<script src="../vendor/jquery-flot/jquery.flot.js"></script>
<script src="../vendor/jquery-flot/jquery.flot.resize.js"></script>
<script src="../vendor/jquery-flot/jquery.flot.pie.js"></script>
<%--<script src="js/common.js"></script>--%>

<script src="../vendor/flot.curvedlines/curvedLines.js"></script>
<script src="../vendor/jquery.flot.spline/index.js"></script>
<script src="../vendor/metisMenu/dist/metisMenu.min.js"></script>
<script src="../vendor/iCheck/icheck.min.js"></script>
<script src="../vendor/peity/jquery.peity.min.js"></script>
<script src="http://img.newscj.com/625photo/js/ie9_fix.js"></script>
<script src="../vendor/sparkline/index.js"></script>
<script src="../vendor/chartjs/Chart.min.js"></script>
<script src="../vendor/chartist/dist/chartist.min.js"></script>


<!-- App scripts -->
<script src="../scripts/homer.js"></script>
<script src="../scripts/charts.js"></script>


</body>
</html>