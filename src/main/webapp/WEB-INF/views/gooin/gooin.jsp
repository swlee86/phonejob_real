<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content animate-panel"
	style="width: 1200px; text-align: left; display: inline-block">

	<div class="row">
		<div style="float: right">
			<a href="gooinRegister.do" style="float: right"	class="btn btn-default next" id="gooin">구인등록</a>
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
						<div class="hpanel hred">
							<div class="panel-heading hbuilt" style="text-align: center;">
								<c:if test="${best.wanttel eq 'A001'}">
									<img src="../images/kt1.jpg">
								</c:if>
								<c:if test="${best.wanttel eq 'A002'}">
									<img src="../images/sk1.jpg">
								</c:if>
								<c:if test="${best.wanttel eq 'A003'}">
									<img src="../images/lg1.jpg">
								</c:if>
							</div>
							<div class="panel-body" style="height: 220px;">
								<p>
									<b>${best.comname}</b>
								</p>
								<p>${best.title}</p>
								<p>
									모집분야 :
									<c:if test="${best.wantjob eq 'cs' }"> CS 직원</c:if>
									<c:if test="${best.wantjob eq 'seller' }"> 판매 직원</c:if>
									<c:if test="${best.wantjob eq 'csseller' }"> CS/판매 직원</c:if>
									<c:if test="${best.wantjob eq 'etc' }"> 기타 직원</c:if>
								</p>
								<p>${best.location_addr1 } ${best.location_addr2 }</p>
								
								<c:if test="${best.salary_detail ne null }">
								<p>
									<c:if test="${best.salary_detail eq '01' }">급여 : 연</c:if>
									<c:if test="${best.salary_detail eq '02' }">급여 : 월</c:if>
									${best.salary_min } ~ ${best.salary_max }
								</p>
								</c:if>
								<c:if test="${best.salary_detail eq null }">
									<p>급여 : 추후협의</p>								
								</c:if>
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
				<div class="hpanel hyellow">
				<div class="panel-heading hbuilt" style="text-align: center;">
					<c:if test="${luxury.wanttel eq 'A001'}">
						<img src="../images/kt1.jpg">
					</c:if>
					<c:if test="${luxury.wanttel eq 'A002'}">
						<img src="../images/sk1.jpg">
					</c:if>
					<c:if test="${luxury.wanttel eq 'A003'}">
						<img src="../images/lg1.jpg">
					</c:if>
					
				</div>
				<div class="panel-body" style="height: 220px;">
					<p><b>${luxury.comname}</b></p>
					<p>${luxury.title}</p>
					<p>모집분야 : <c:if test="${luxury.wantjob eq 'cs' }"> CS 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'seller' }"> 판매 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'csseller' }"> CS/판매 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'etc' }"> 기타 직원</c:if>
					</p>
					<p>${luxury.location_addr1 } ${luxury.location_addr2 }</p>
					<c:if test="${luxury.salary_detail ne null }">
						<p>
							<c:if test="${luxury.salary_detail eq '01' }">급여 : 연</c:if>
							<c:if test="${luxury.salary_detail eq '02' }">급여 : 월</c:if>
							${luxury.salary_min } ~ ${luxury.salary_max }
						</p>
						</c:if>
						<c:if test="${luxury.salary_detail eq null }">
							<p>급여 : 추후협의</p>								
						</c:if>
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
					<c:if test="${best.wanttel eq 'A001'}">
						<img src="../images/kt1.jpg">
					</c:if>
					<c:if test="${best.wanttel eq 'A002'}">
						<img src="../images/sk1.jpg">
					</c:if>
					<c:if test="${best.wanttel eq 'A003'}">
						<img src="../images/lg1.jpg">
					</c:if>
				</div>
				<div class="panel-body" style="height: 220px;">
					<p><b>${best.comname}</b></p>
					<p> ${best.title}</p>
					<p>모집분야 : <c:if test="${best.wantjob eq 'cs' }"> CS 직원</c:if>
							   <c:if test="${best.wantjob eq 'seller' }"> 판매 직원</c:if>
							   <c:if test="${best.wantjob eq 'csseller' }"> CS/판매 직원</c:if>
							   <c:if test="${best.wantjob eq 'etc' }"> 기타 직원</c:if>
					</p>
					<p>${best.location_addr1 } ${best.location_addr2 }</p>
					<c:if test="${best.salary_detail ne null }">
						<p>
							<c:if test="${best.salary_detail eq '01' }">급여 : 연</c:if>
							<c:if test="${best.salary_detail eq '02' }">급여 : 월</c:if>
							${best.salary_min } ~ ${best.salary_max }
						</p>
						</c:if>
						<c:if test="${best.salary_detail eq null }">
							<p>급여 : 추후협의</p>								
						</c:if>
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

