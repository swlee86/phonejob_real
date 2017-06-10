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
                <h4><span class="text-success">${today}</span> </h4>
                <p><strong>접근하실수 있는 권한이 없습니다.<Br> 관리자에게 문의해주세요. </strong></p>
                <br>
                  <a href="javascript:history.back();" class="btn btn-default">뒤로가기</a>
            </div>
        </div>


    </div>
</div>