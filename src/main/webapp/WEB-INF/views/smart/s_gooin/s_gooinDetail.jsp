<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="content animate-panel" style="text-align:left; display:inline-block">
	<div class="row">
    	<div class="col-lg-12-smart">
			<div class="hpanel">
				<form action="" id="volunteerE" name="volunteerE" method="post">
				<c:forEach var="gooinDetail" items="${gooinDetail}">
				<div class="panel-body-mobile">
					<b style="font-size: 18px;">${gooinDetail.title }</b>
					<input type="hidden" value="${gooinDetail.title}" id="title" name="title">
					<hr style="border: 1px solid #ddd;">
					<table style="border: 1px solid #ddd;">
						<tr style="border: 1px solid #ddd;">
							<td colspan="3" style="border: 1px solid #ddd; width: 270px; text-align: center">
								<img src="../updata/picture/gooin/${gooinDetail.userpicture}" alt="매장 사진">
  							    <input type="hidden" value="${gooinDetail.userpicture}" id="userpicture" name="userpicture">
  							</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td colspan="3" style="border: 1px solid #ddd; width: 1800px; height: 60px; text-align: center;">
								<c:if test="${gooinDetail.wanttel eq 'A001'}">
									<img src="../images/kt1.jpg">
								</c:if>
								<c:if test="${gooinDetail.wanttel eq 'A002'}">
									<img src="../images/sk1.jpg">
								</c:if>
								<c:if test="${gooinDetail.wanttel eq 'A003'}">
									<img src="../images/lg1.jpg">
								</c:if>
								<input type="hidden" id="wanttel" class="form-control" name="wanttel" value="${gooinDetail.wanttel}" readonly="readonly">
							</td>

						</tr>
						<tr style="border: 1px solid #ddd;">
							<td colspan="3" style="border: 1px solid #ddd; width: 1800px; height: 60px;">회사명 : ${gooinDetail.comname }</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td colspan="3" style="border: 1px solid #ddd; width: 1800px; height: 60px;">사업자번호 : ${gooinDetail.comidfyno }</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td colspan="3" style="border: 1px solid #ddd; width: 1800px; height: 60px;">대표 번호 : ${gooinDetail.phone }</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td colspan="3" style="border: 1px solid #ddd; width: 1800px; height: 60px;">
								<c:choose>
									<c:when test="${gooinDetail.homepage eq 'non' }">
										홈페이지 없음
									</c:when>
									<c:otherwise>
										홈페이지 :${gooinDetail.homepage }
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td colspan="3" style="border: 1px solid #ddd; width: 1800px; height: 60px;">회사 주소 : ${gooinDetail.adress }</td>
						</tr>
					</table>
					
					<br/><br/><br/><br/>
					ㅁ모집내용
					<hr style="border: 1px solid #ddd;">
					<table style="border: 1px solid #ddd; text-align: center;">
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 1500px; background-color: #77d5f7">모집 구분</td>
							<td style="border: 1px solid #ddd; width: 1500px; height: 60px;">
								<c:choose>
									<c:when test="${gooinDetail.wantjob eq 'cs'}">
										CS
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="cs" readonly="readonly">
									</c:when>
									<c:when test="${gooinDetail.wantjob eq 'seller'}">
										판매사
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="seller" readonly="readonly">
									</c:when>
									<c:when test="${gooinDetail.wantjob eq 'csseller'}">
										판매사 / CS
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="csseller" readonly="readonly">
									</c:when>
								</c:choose>
							</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 300px; background-color: #77d5f7">자격요건</td>
							<td style="border: 1px solid #ddd; width: 400px; height: 60px;">
								고용형태 : ${gooinDetail.jobstatus}<br/>
								학력 : ${gooinDetail.school}
								<input type="hidden" class="form-control" name="jobstatus" id="jobstatus" value="${gooinDetail.jobstatus }" readonly="readonly">
								<input type="hidden" class="form-control" name=school id="school" value="${gooinDetail.school}" readonly="readonly">

							</td>

						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 300px; background-color: #77d5f7">경력구분</td>
							<td style="border: 1px solid #ddd; width: 400px; height: 60px;">
								<c:choose>
									<c:when test="${gooinDetail.wantstatus eq '01'}">신입</c:when>
									<c:when test="${gooinDetail.wantstatus eq '02'}">경력</c:when>
									<c:when test="${gooinDetail.wantstatus eq '03'}">무관</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 300px; background-color: #77d5f7">모집인원</td>
							<td style="border: 1px solid #ddd; width: 400px; height: 60px;">
									${gooinDetail.wanthuman}명
								<input type="hidden" class="form-control" name="wanthuman" id="wanthuman" value="${gooinDetail.wanthuman}" readonly="readonly">
							</td>


						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 300px; background-color: #77d5f7">성별</td>
							<td style="border: 1px solid #ddd; width: 400px; height: 60px;">
								<c:choose>
									<c:when test="${gooinDetail.gender eq 'male'}">
										남성
										<input type="hidden" class="form-control"  name="gender" id="gender" value="${gooinDetail.gender }" readonly="readonly">
									</c:when>
									<c:when test="${gooinDetail.gender eq 'female'}">
										여성
										<input type="hidden" class="form-control"  name="gender" id="gender" value="${gooinDetail.gender }" readonly="readonly">
									</c:when>
									<c:when test="${gooinDetail.gender eq 'allgender'}">
										남녀 무관
										<input type="hidden" class="form-control"  name="gender" id="gender" value="${gooinDetail.gender }" readonly="readonly">
									</c:when>
								</c:choose>
							</td>
						</tr>
						<tr style="border: 1px solid #ddd;">
							<td style="border: 1px solid #ddd; width: 300px; background-color: #77d5f7">근무지</td>
							<td style="border: 1px solid #ddd; width: 400px; height: 60px;">
									${gooinDetail.location_addr1 } ${gooinDetail.location_addr2 }
								<input type="hidden" class="form-control"  name="location_addr1" id="location" value="${gooinDetail.location_addr1 }" readonly="readonly">
								<input type="hidden" class="form-control"  name="location_addr2" id="location" value="${gooinDetail.location_addr1 }" readonly="readonly">
							</td>
						</tr>
					</table>
					
					<br/><br/><br/><br/>
					
					
					ㅁ근무조건
					<hr style="border: 1px solid #ddd;">
					※급여 : 
					<c:if test="${gooinDetail.salary_detail ne null }">
      					<c:if test="${gooinDetail.salary_detail eq '01' }">연</c:if>
						<c:if test="${gooinDetail.salary_detail eq '02' }">월</c:if>
						${gooinDetail.salary_min } ~ ${gooinDetail.salary_max }
					</c:if>
					<c:if test="${gooinDetail.salary_detail eq null }">
						추후협의								
					</c:if>
					<input type="hidden" class="form-control"  name="salary_detail" id="salary_detail" value="${gooinDetail.salary_detail }" readonly="readonly">
					<input type="hidden" class="form-control"  name="salary_min" id="salary_min" value="${gooinDetail.salary_min }" readonly="readonly">
					<input type="hidden" class="form-control"  name="salary_max" id="salary_max" value="${gooinDetail.salary_max }" readonly="readonly">	
					
					
					
					
					<c:if test="${null ne gooinDetail.wage}">
					<br/><br/><br/><br/>
					ㅁ회사복지
					<hr style="border: 1px solid #ddd;">
					${gooinDetail.wage }
					<input type="hidden" class="form-control"  name="wage" id="wage" value="${gooinDetail.wage }" readonly="readonly">
					</c:if>
					
					
					
					<br/><br/><br/><br/>
					ㅁ모집상세
					<hr style="border: 1px solid #ddd;">
					${gooinDetail.content }
					<input type="hidden" class="form-control"  name="content" id="content" value="${gooinDetail.content }" readonly="readonly">
					
					
					
					<br/><br/><br/><br/>
					ㅁ접수기간 및 방법
					<hr style="border: 1px solid #ddd;">
					채용기간 : ${gooinDetail.gooinweekstart } ~ ${gooinDetail.gooinweekend }<br/>
					접수방법 : ${gooinDetail.gooinhow }<br/>
					필요서류 : ${gooinDetail.gooindocument }
					<input type="hidden" class="form-control"  name="gooinweekstart" id="gooinweekstart" value="${gooinDetail.gooinweekstart }" readonly="readonly">
      				<input type="hidden" class="form-control"  name="gooinweekend" id="gooinweekend" value="${gooinDetail.gooinweekend }" readonly="readonly">
					<input type="hidden" class="form-control"  name="gooinhow" id="gooinhow" value="${gooinDetail.gooinhow }" readonly="readonly">
					<input type="hidden" class="form-control"  name="gooindocument" id="gooindocument" value="${gooinDetail.gooindocument }" readonly="readonly">
					
					
					
					<br/><br/><br/><br/>
					ㅁ채용 관련 문의
					<hr style="border: 1px solid #ddd;">
					담당자 : ${gooinDetail.gooinman }<br/>
					담당자 연락처 : ${gooinDetail.gooinmail } 
					<input type="hidden" class="form-control"  name="gooinman" id="gooinman" value="${gooinDetail.gooinman }" readonly="readonly">
					<input type="hidden" class="form-control"  name="gooinmail" id="gooinmail" value="${gooinDetail.gooinmail }" readonly="readonly">
					
					
					<br/><br/><br/><br/>
					ㅁ매장 위치
					<hr style="border: 1px solid #ddd;">
					!!다음맵 지도 API로 세팅 예정!! 
					
				</div>
				<br/>
				<div class="text-center">
					<c:if test="${loginData.userid eq gooinDetail.userid }">
						<input type="submit" class="btn btn-success" value="수정하기">
					</c:if>
					<c:if test="${loginData.gubun eq '1' }">
						<input type="text" class="btn btn-warning" id="volunteer" value="지원하기">
					</c:if>
					<input type="button" class="btn btn-default" onclick="javascript:goPage()" value="목록으로">							
				</div>
					<input type="hidden" name="gooin_no" value="${gooinDetail.gooin_no}">
					<input type="hidden" name="grade" value="${gooinDetail.grade}">
					<input type="hidden" name="goointel" value="${gooinDetail.goointel}">
					<input type="hidden" name="phone" value="${gooinDetail.phone}">
					<input type="hidden" name="comname" value="${gooinDetail.comname}">
					<input type="hidden" name="comidfyno" value="${comidfyno.goointel}">
					<input type="hidden" name="adress" value="${comidfyno.adress}">
					<input type="hidden" name="homepage" value="${comidfyno.homepage}">
					<input type="hidden" name="wantstatus" value="${comidfyno.wantstatus}">
				</c:forEach>
				</form>
			</div>
		</div>
	</div>
	<div style="height: 50px;" />
</div>