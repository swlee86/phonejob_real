<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content animate-panel"
	style="width: 1200px; text-align: left; display: inline-block">

	<div class="row">
		<div style="float: right">
			<a href="gooinRegister.do" style="float: rignt"
				class="btn btn-default next" id="gooin">구인등록</a>
		</div>


		<div class="row">&nbsp;</div>



		<h3>
			<span style="font-family: Arial"><b>헤드라인 VIP 채용정보</b></span>
		</h3>
		<hr style="border: 1px solid #ddd;">
		<div class="row">
			<c:forEach items="${gooinbest}" var="best" end="3">
				<a href="gooinDetail.do?gooin_no=${best.gooin_no }">
					<div
						style="width: 283px; display: inline-block; padding-left: 15px; padding-right: 15px;">
						<div class="hpanel hblue">
							<div class="panel-heading hbuilt" style="text-align: center;">
								<c:if test="${best.wanttel eq 'sk'}">
									<img src="images/sk1.jpg">
								</c:if>
								<c:if test="${best.wanttel eq 'lg'}">
									<img src="images/lg1.jpg">
								</c:if>
								<c:if test="${best.wanttel eq 'kt'}">
									<img src="images/kt1.jpg">
								</c:if>

							</div>
							<div class="panel-body" style="height: 220px;">
								<p>
									<b>상호이름 들어갈 위치</b>
								</p>
								<p>${best.title}</p>
								<p>
									모집분야 :
									<c:if test="${best.wantjob eq 'cs' }"> CS 직원</c:if>
									<c:if test="${best.wantjob eq 'seller' }"> 판매 직원</c:if>
									<c:if test="${best.wantjob eq 'csseller' }"> CS/판매 직원</c:if>
									<c:if test="${best.wantjob eq 'etc' }"> 기타 직원</c:if>
								</p>
								<p>${best.location }</p>
								<p>${best.salary }</p>
							</div>
							<div class="panel-footer">-</div>
						</div>
					</div>
				</a>
			</c:forEach>

		</div>
		
		
		
	
	<h3><span style="font-family: Arial"><b>프리미엄 채용정보</b></span></h3>
	<hr style="border: 1px solid #ddd;">
	<div class="row">
		<c:forEach items="${gooinluxury}" var="luxury">
			<a href="gooinDetail.do?gooin_no=${luxury.gooin_no }">
			<div style="width: 227px;display:inline-block; padding-left: 15px; padding-right: 15px;">
			<div class="hpanel hblue">
				<div class="panel-heading hbuilt" style="text-align: center;">
					<c:if test="${luxury.wanttel eq 'sk'}">
						<img src="images/sk1.jpg">
					</c:if>
					<c:if test="${luxury.wanttel eq 'lg'}">
						<img src="images/lg1.jpg">
					</c:if>
					<c:if test="${luxury.wanttel eq 'kt'}">
						<img src="images/kt1.jpg">
					</c:if>
					
				</div>
				<div class="panel-body" style="height: 220px;">
					<p><b>상호이름 들어갈 위치</b></p>
					<p>${luxury.title}</p>
					<p>모집분야 : <c:if test="${luxury.wantjob eq 'cs' }"> CS 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'seller' }"> 판매 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'csseller' }"> CS/판매 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'etc' }"> 기타 직원</c:if>
					</p>
					<p>${luxury.location }</p>
					<p>${luxury.salary }</p>
				</div>
				<div class="panel-footer">-</div>
			</div>
			</div>
			</a>
		</c:forEach>
		
	</div>
	

	<br/>
	
	


	<h3><span style="font-family: Arial"><b>베스트 채용정보</b></span></h3>
	<hr style="border: 1px solid #ddd;">
	<div class="row">
			<c:forEach items="${gooinbest}" var="best">
			<a href="gooinDetail.do?gooin_no=${best.gooin_no }">
			<div style="width: 227px;display:inline-block; padding-left: 15px; padding-right: 15px;">
			<div class="hpanel hblue">
				<div class="panel-heading hbuilt" style="text-align: center;">
					<c:if test="${best.wanttel eq 'sk'}">
						<img src="images/sk1.jpg">
					</c:if>
					<c:if test="${best.wanttel eq 'lg'}">
						<img src="images/lg1.jpg">
					</c:if>
					<c:if test="${best.wanttel eq 'kt'}">
						<img src="images/kt1.jpg">
					</c:if>
					
				</div>
				<div class="panel-body" style="height: 220px;">
					<p><b>상호이름 들어갈 위치</b></p>
					<p> ${best.title}</p>
					<p>모집분야 : <c:if test="${best.wantjob eq 'cs' }"> CS 직원</c:if>
							   <c:if test="${best.wantjob eq 'seller' }"> 판매 직원</c:if>
							   <c:if test="${best.wantjob eq 'csseller' }"> CS/판매 직원</c:if>
							   <c:if test="${best.wantjob eq 'etc' }"> 기타 직원</c:if>
					</p>
					<p>${best.location }</p>
					<p>${best.salary }</p>
				</div>
				<div class="panel-footer">-</div>
			</div>
			</div>
			</a>
		</c:forEach>
		
	</div>

	<br/>
		
	</div>
</div>

