<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">
    	<div class="col-lg-12">
			<div class="hpanel">
				<div class="panel-body">
					<b style="font-size: 18px;">${googicdata.title }</b>
					<input type="hidden" value="${googicdata.title}" id="title" name="title">
					<hr style="border: 1px solid #ddd;">
					<table style="border: 1px solid #ddd;">
						<tr style="border: 1px solid #ddd;">
							<td rowspan="3" style="border: 1px solid #ddd; width: 270px;">
								<img src="../updata/picture/googic/${googicdata.pic}" alt="이력서 사진">
  							    <input type="hidden" value="${googicdata.pic}" id="userpicture" name="userpicture">
  							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								이름 : ${googicdata.username }
								<input type="hidden" id="wanttel" class="form-control" name="username" value="${googicdata.username}" readonly="readonly">
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								이메일 : ${googicdata.useremail}
       						 	<input type="hidden" id="wanttel" class="form-control" name="useremail" value="${googicdata.useremail}" readonly="readonly">
							</td>
							<td style="width: 270px;">
								휴대폰 : ${googicdata.userphone}
								<input type="hidden" id="wanttel" class="form-control" name="userphone" value="${googicdata.userphone}" readonly="readonly">
							</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								나이 : ${googicdata.age}
								<input type="hidden" id="wanttel" class="form-control" name="age" value="${googicdata.age}" readonly="readonly">
							</td>
							<td colspan="2" style="border: 1px solid #ddd; width: 270px; height: 60px;">
							주소 : ${googicdata.useraddr1 } ${googicdata.useraddr2 }
							</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td colspan="3" style="border: 1px solid #ddd; width: 270px; height: 60px;">간단한 한마디 : ${googicdata.sprofiletext }</td>
						</tr>
					</table>
					
					<br/><br/><br/><br/>
					ㅁ지원정보
					<hr style="border: 1px solid #ddd;">
					<table style="border: 1px solid #ddd; text-align: center;">
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 204px;">희망연봉</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">근무형태</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">희망근무지</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">지원부문</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">예상출근가능일</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">경력구분</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">근무경험</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.salary_detail eq '01' }">연 ${googicdata.salary_min } ~ ${googicdata.salary_max }만원</c:when>
									<c:when test="${googicdata.salary_detail eq '02' }">월 ${googicdata.salary_min } ~ ${googicdata.salary_max }만원</c:when>
								</c:choose>
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.wantstatus eq '01' }">정규직</c:when>
									<c:when test="${googicdata.wantstatus eq '02' }">비정규직</c:when>
									<c:when test="${googicdata.wantstatus eq '03' }">아르바이트</c:when>
									<c:when test="${googicdata.wantstatus eq '04' }">단기아르바이트</c:when>
								</c:choose>
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								${googicdata.location}
      							<input type="hidden" value="${googicdata.sido}" id="sido" name="sido">
								<input type="hidden" value="${googicdata.gugun}" id="gugun" name="gugun">
								<input type="hidden" value="${googicdata.dong}" id="dong" name="dong">
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.wantjob eq 'cs'}">
										CS
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="CS" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.wantjob eq 'seller'}">
										판매사
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="판매사" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.wantjob eq 'csseller'}">
										판매사 / CS
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="판매사 / CS" readonly="readonly">
									</c:when>
								</c:choose>
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
       						 		<c:when test="${googicdata.possibledate eq 'A001'}">즉시 가능</c:when>
       						 		<c:when test="${googicdata.possibledate eq 'A002'}">일주일 이내</c:when>
       						 		<c:when test="${googicdata.possibledate eq 'A003'}">15일  이내</c:when>
       						 		<c:when test="${googicdata.possibledate eq 'A004'}">한달 이내</c:when>
       						 		<c:when test="${googicdata.possibledate eq 'A005'}">협의 후 결정</c:when>
       						 	</c:choose>       						 	
       						 	<input type="hidden" class="form-control" name="possibledate" id="possibledate" value="${googicdata.possibledate }" readonly="readonly">
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.telhistory eq 'non'}">
										신입
									</c:when>
									<c:otherwise>
										경력
									</c:otherwise>
								</c:choose>
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.telhistory eq 'non'}">
										-
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="경력 없음" readonly="readonly">
									</c:when>
								 	<c:when test="${googicdata.telhistory eq 'sk'}">
								 		SK
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="SK" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'sk|kt'}">
										SK / KT
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="SK / KT" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'sk|kt|lg'}">
										SK / KT / LG
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="SK / KT / LG" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'sk|lg'}">
										SK / LG
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="SK / LG" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'kt'}">
										KT
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="KT" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'kt|lg'}">
										KT / LG
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="KT / LG" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'lg'}">
										LG
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="LG" readonly="readonly">
									</c:when>
								</c:choose>
							</td>
						</tr>
					</table>
					
					<br/><br/><br/><br/>
					ㅁ취업 우대사항
					<hr style="border: 1px solid #ddd;">
					<table style="border: 1px solid #ddd; text-align: center;">
						<tr style="border: 1px solid #ddd; text-align: center;">
							<th style="border: 1px solid #ddd; width: 215px; height: 60px; text-align: center;">보훈대상여부</th>
							<th style="border: 1px solid #ddd; width: 215px; height: 60px; text-align: center;">취업보호대상여부</th>
							<th style="border: 1px solid #ddd; width: 215px; height: 60px; text-align: center;">고용지원금대상여부</th>
							<th style="border: 1px solid #ddd; width: 215px; height: 60px; text-align: center;">병역사항</th>
							<th style="border: 1px solid #ddd; width: 215px; height: 60px; text-align: center;">장애여부</th>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.bohun eq 'B001' }">대상</c:when>
									<c:when test="${googicdata.bohun eq 'B002' }">비대상</c:when>
								</c:choose>
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.chuiboho eq 'B001' }">대상</c:when>
									<c:when test="${googicdata.chuiboho eq 'B002' }">비대상</c:when>
								</c:choose>
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.goji eq 'B001' }">대상</c:when>
									<c:when test="${googicdata.goji eq 'B002' }">비대상</c:when>
								</c:choose>
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.army eq 'B001' }">전역</c:when>
									<c:when test="${googicdata.army eq 'B002' }">미필</c:when>
								</c:choose>
							</td>
							<td style="border: 1px solid #ddd; width: 204px; height: 60px;">
								<c:choose>
									<c:when test="${googicdata.handicap eq 'B001' }">대상</c:when>
									<c:when test="${googicdata.handicap eq 'B002' }">비대상</c:when>
								</c:choose>       						 	
       						 	<input type="hidden" class="form-control" name="possibledate" id="possibledate" value="${googicdata.possibledate }" readonly="readonly">
							</td>
						</tr>
					</table>
					
					<c:if test="${not empty googicdata.onename}">
					<br/><br/><br/><br/>
					ㅁ학력 사항
					<hr style="border: 1px solid #ddd;">
					<table style="border: 1px solid #ddd; text-align: center;">
						<tr style="border: 1px solid #ddd; text-align: center;">
							<th style="border: 1px solid #ddd; width: 270px; height: 60px; text-align: center;">학교명</th>
							<th style="border: 1px solid #ddd; width: 270px; height: 60px; text-align: center;">입학년월</th>
							<th style="border: 1px solid #ddd; width: 270px; height: 60px; text-align: center;">졸업년월</th>
							<th style="border: 1px solid #ddd; width: 270px; height: 60px; text-align: center;">전공</th>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.onename }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.onedate_1 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.onedate_2 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.onejob }
							</td>
						</tr>
						
						<c:if test="${not empty googicdata.twoname}">
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.twoname }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.twodate_1 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.twodate_2 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.twojob }
							</td>
						</tr>
						</c:if>
						
						<c:if test="${not empty googicdata.threename}">
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.threename }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.threedate_1 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.threedate_2 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.threejob }
							</td>
						</tr>
						</c:if>
						
						<c:if test="${not empty googicdata.fourname}">
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.fourname }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.fourdate_1 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.fourdate_2 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.fourjob }
							</td>
						</tr>
						</c:if>
						
						<c:if test="${not empty googicdata.fivename}">
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.fivename }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.fivedate_1 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.fivedate_2 }
							</td>
							<td style="border: 1px solid #ddd; width: 270px; height: 60px;">
								${googicdata.fivejob }
							</td>
						</tr>
						</c:if>
						
					</table>
					</c:if>
					
					<br/><br/><br/><br/>
					ㅁ자기소개서
					<hr style="border: 1px solid #ddd;">
					${googicdata.profiletext }
       				<input type="hidden" class="form-control"  name="profiletext" id="profiletext" value="${googicdata.profiletext }" readonly="readonly">	
					
				</div>
				<br/><br/><br/><br/>
				<div class="text-center">
					<c:if test="${loginData.userid eq googicdata.userid }">
						<input type="submit" class="btn btn-success" value="수정하기">
					</c:if>
						<input type="button" class="btn btn-default" onclick="javascript:goPage()" value="목록으로">							
				</div>
			</div>
		</div>
	</div>
</div>




