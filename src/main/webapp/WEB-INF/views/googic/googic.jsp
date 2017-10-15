<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content animate-panel" style="width: 1200px; text-align: left; display: inline-block">
	<div class="row">
		<div style="float:right">
    			<a href="googicRegister.do" style="float: rignt" class="btn btn-default next" id="googic">구직자등록</a>
    	</div>
		<div>
			&nbsp; 
			<hr style="border: 1px solid #ddd;">
			<c:forEach var="resultData" items="${result}">
					<a href="googicDetail.do?googic_no=${resultData.googic_no}">
						<div style="width: 227px; display: inline-block; padding-left: 15px; padding-right: 15px;">
							<div class="hpanel hblue">
								<div class="panel-heading hbuilt" style="text-align: center;">
									<img src="./updata/picture/googic/${resultData.pic}" alt="이력서 사진">
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