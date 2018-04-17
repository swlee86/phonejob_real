<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<jsp:useBean id="today" class="java.util.Date" />
<jsp:useBean id="sysdate" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd a hh:mm" var="today" /> 
<fmt:formatDate value="${sysdate}" pattern="yyyy-MM-dd a hh:mm" var="sysdate" /> 
<!--  
	작성자	: 이상원
	작성일	: 2017-07-10
	목 적  	: 접근 차단 화면
-->
<div class="color-line"></div>

<div class="lock-container">
    <div>

        <div class="hpanel">
            <div class="panel-body text-center">

                <i class="pe-7s-lock big-icon text-success"></i>
                <br/>
                <h4><span class="text-success">${msg }</span></h4>
                <p><strong>접근하실수 있는 권한이 없습니다.<Br> 관리자에게 문의해주세요. </strong></p>
                <br>
                 <form action="s_adminIpRegister.do" method="post">
					<table>
						<tr>
							<td>이름 : </td>
							<td><input type="text" name="user_name"></td>
						</tr>
						<tr>
							<td>휴대전화번호 : </td>
							<td><input type="text" name="register" placeholder="- 없이 입력"></td>
						</tr>
						<tr>
							<td>등록할 아이피 명칭 : </td>
							<td><input type="text" name="ip_name" placeholder="~의 아이피"></td>
						</tr>
						<tr>
							<td>등록할 아이피 : </td>
							<td><input type="text" name="user_ip" placeholder="0.0.0.0" value="${cIp}"></td>
						</tr>
					</table>             
					<input type="submit" value="아이피 등록">    
                 
                 
                 </form>

                
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