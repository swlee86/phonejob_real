<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="systemdate" />

<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">
		<div class="col-lg-12 text-center m-t-md">
			<h3>
				<span style="font-family: Arial">Welcome to <b>Phone & Job</b></span>
			</h3>
			<p>
				이동통신 관련 <strong>구직, 구인, 노하우</strong> 그 모든 것을 위한 사이트

			</p>
		</div>
	</div>

	<div class="row">&nbsp;</div>
	
	
	
	<h3><span style="font-family: Arial"><b>헤드라인 VIP 채용정보</b></span></h3>
	<hr style="border: 1px solid #ddd;">
	<div class="row">
			<c:forEach items="${gooinbest}" var="best" end="3">
			<a href="gooinDetail.do?gooin_no=${best.gooin_no }">
			<div style="width: 283px;display:inline-block; padding-left: 15px; padding-right: 15px;">
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
					<p><b>${best.comname }</b></p>
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
	
	<br />
	
	
	
	
	
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
					<p><b>${luxury.comname }</b></p>
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
					<p><b>${best.comname }</b></p>
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
	
	
	
	
	


	<h3><span style="font-family: Arial"><b>인재 리스트</b></span></h3>
	<hr style="border: 1px solid #ddd;">
			&nbsp; 
		<div class="row">
		<div>
			<c:forEach var="resultData" items="${result}">
					<a href="googicDetail.do?googic_no=${resultData.googic_no}">
						<div style="width: 227px; display: inline-block; padding-left: 15px; padding-right: 15px;">
							<div class="hpanel hblue">
								<div class="panel-heading hbuilt" style="text-align: center;">
									<img src="../updata/picture/googic/${resultData.pic}" alt="이력서 사진">
								</div>
								<div class="panel-body" style="height: 220px;">
									<p>
									<b>${resultData.username}</b>
									(
									<c:choose>
									<c:when test="${resultData.wantjob eq 'seller'}">
										판매사
									</c:when>
									<c:when test="${resultData.wantjob eq 'cs'}">
										CS
									</c:when>
									<c:when test="${resultData.wantjob eq 'csseller'}">
										판매사/CS
									</c:when>
									</c:choose>
									)
									</p>
									<p>나이 : ${resultData.age}</p>
									<p>
										<c:choose>
											<c:when test="${resultData.telhistory eq 'non' }">
												경력 여부 : 신입
											</c:when>
											<c:otherwise>
												경력 여부 : 경력
											</c:otherwise>
										</c:choose>
									</p>
									<p>선호지역 : ${resultData.location}</p>
									<p>출근가능일 :
										<c:choose>
       						 				<c:when test="${resultData.possibledate eq 'A001'}">즉시 가능</c:when>
       						 				<c:when test="${resultData.possibledate eq 'A002'}">일주일 이내</c:when>
       						 				<c:when test="${resultData.possibledate eq 'A003'}">15일  이내</c:when>
       						 				<c:when test="${resultData.possibledate eq 'A004'}">한달 이내</c:when>
       						 				<c:when test="${resultData.possibledate eq 'A005'}">협의 후 결정</c:when>
       						 			</c:choose>
       						 		</p>
								</div>
								<div class="panel-footer">등록자 : ${resultData.userid }</div>
							</div>
						</div>
					</a>
				</c:forEach>
			</div>
	</div>
</div>


<div id="popDiv" style="background-color: white; text-align: left;">
 <!-- 팝업내용 및 이미지 -->
	<h5 style="color: blue;">1. 현재 작업 진행 상황</h5>
	 &nbsp;&nbsp;&nbsp;-구인글 등록 / 읽기(수정 / 삭제 불가)<br/>
	 &nbsp;&nbsp;&nbsp;-구직글 등록 / 읽기 / (수정 / 삭제 불가)<br/>
	 &nbsp;&nbsp;&nbsp;-회원 가입(개인 / 사업자) 가능<br/>
	 &nbsp;&nbsp;&nbsp;-커뮤니티 글쓰기 / 수정 / 삭제 가능<br/><br> 
	
	<h5 style="color: blue;">2. 2017-09-18 반영 사항</h5>
	 &nbsp;&nbsp;&nbsp;-배포환경 구축 완료<br/>
	 &nbsp;&nbsp;&nbsp;-shop 구축 시작<br/><br/>
	 
	 <b>※테스트 데이터는 많을 수록 좋으므로 수시로 등록 부탁드립니다. <br/>
	 오류 발생시 커뮤니티 게시글에 사항 남겨 주시면 확인 하겠습니다.<br/>
	 </b>
	 
  <span class="close" style="font-size: 13px;">
  <input type="checkbox" onClick="javascript:controlCOOKIE();" style="text-align: left;">오늘은 그만보기
  &nbsp;&nbsp;&nbsp;<a href="#" onclick="closePopup('popDiv')" >닫기</a>
 </span>
</div>