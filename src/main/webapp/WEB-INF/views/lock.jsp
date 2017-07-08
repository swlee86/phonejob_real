<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<jsp:useBean id="today" class="java.util.Date" />
<jsp:useBean id="sysdate" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd a hh:mm" var="today" /> 
<fmt:formatDate value="${sysdate}" pattern="yyyy-MM-dd a hh:mm" var="sysdate" /> 
<!--  
	작성자	: 박지은
	작성일	: 2016-12-12
	목 적  	: 잠금 화면 view
-->
<div class="color-line"></div>

<div class="lock-container">
    <div>

        <div class="hpanel">
            <div class="panel-body text-center">

                <i class="pe-7s-lock big-icon text-success"></i>
                <br/>
                <h4><span class="text-success">${msg }</span> </h4>
                <p><strong>접근하실수 있는 권한이 없습니다.<Br> 관리자에게 문의해주세요. </strong></p>
                <br>
                  <a href="javascript:history.back();" class="btn btn-default">뒤로가기</a>
            </div>
        </div>


    </div>
</div>


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