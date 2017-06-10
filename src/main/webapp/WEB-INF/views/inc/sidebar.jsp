<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside id="menu">

	<div id="navigation">
		<div class="profile-picture">

			<a href="${pageContext.request.contextPath}/index.do"> <img	src="${pageContext.request.contextPath}/img/upload/${Emp.pic}"
				style="width: 128px; height: 128px;" class="img-circle m-b"	alt="회원가입시 등록 이미지">
			</a>
			<c:if test="${not empty pageContext.request.userPrincipal}">
				<div class="stats-label text-color">
					<span class="font-extra-bold font-uppercase"><i class="fa fa-user"></i> ${username}님 환영합니다</span>
				</div>
			</c:if>
			<c:if test="${empty pageContext.request.userPrincipal}">
				<span class="font-extra-bold font-uppercase"><i class="fa fa-user"></i>환영합니다</span>
			</c:if>
		</div>
	</div>

	<!-- <span class="label label-success pull-right">버튼달고 싶으면 여기에 메세지 입력</span> -->
	<ul class="nav" id="side-menu">
		<!-- <li class="active">
                <a href="index.do"> <span class="nav-label">Main</span> <span class="label label-success pull-right"></span> </a>
            </li> -->
		<li><a href="#"> <span class="nav-label">채용정보</span><span class="label label-warning pull-right"></span>
		</a></li>
		<li><a href="registerPrivate.do"> <span class="nav-label">인재정보</span><span class="label label-warning pull-right"></span>
		</a></li>

		<li><a href="#"><span class="nav-label">판매처/거래처 모집</span><span
				class="fa arrow"></span> </a></li>

		<li><a href="#"><span class="nav-label">커뮤니티</span><span
				class="fa arrow"></span> </a>
				
				
		<li>
			<a href="#"><span class="nav-label">서비스 안내</span><span class="fa arrow"></span> </a>
		</li>




		<se:authorize access="hasRole('ROLE_ADMIN')">

		</se:authorize>
		<li>&nbsp;</li>
	</ul>

</aside>