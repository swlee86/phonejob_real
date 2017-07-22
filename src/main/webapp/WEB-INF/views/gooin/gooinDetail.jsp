<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


   
<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">
    	<div class="col-lg-12">
			<div class="hpanel">
				<div class="panel-body">
					<c:forEach var="gooinDetail" items="${gooinDetail}">
					<form class="form-horizontal" method="POST" id="googicModify" action="gooinModify.do?gooin_no=${gooinDetail.gooin_no}">
 					<div class="row" style="text-align: center;">
					<table class="type10">
					    <tbody>
						    <tr>
 						       <th scope="row">제목</th>
  							      <td>
  							      	${gooinDetail.title }
  							     	 <input type="hidden" value="${gooinDetail.title}" id="title" name="title">
  							      </td>
    						</tr>
   						    <tr>
     						   <th scope="row" class="even">매장 사진</th>
      							  <td class="even">
      							  	<img src="./gooin/picture/${gooinDetail.userpicture}" alt="매장 사진">
  							     	 <input type="hidden" value="${gooinDetail.userpicture}" id="userpicture" name="userpicture">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">모집매장</th>
       						 <td>
       						 	<c:if test="${gooinDetail.wanttel eq 'A001'}">
									<img src="images/kt1.jpg">
								</c:if>
								<c:if test="${gooinDetail.wanttel eq 'A002'}">
									<img src="images/sk1.jpg">
								</c:if>
								<c:if test="${gooinDetail.wanttel eq 'A003'}">
									<img src="images/lg1.jpg">
								</c:if>
       						 	<input type="hidden" id="wanttel" class="form-control" name="wanttel" value="${gooinDetail.wanttel}" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">모집부문</th>
      							  <td class="even">
      							  	<c:choose>
										<c:when test="${gooinDetail.wantjob eq 'cs'}">
											CS
											<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="CS" readonly="readonly">
										</c:when>
										<c:when test="${gooinDetail.wantjob eq 'seller'}">
											판매사
											<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="판매사" readonly="readonly">
										</c:when>
										<c:when test="${gooinDetail.wantjob eq 'csseller'}">
											판매사 / CS
											<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="판매사 / CS" readonly="readonly">
										</c:when>
									</c:choose>
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">근무형태</th>
       						 <td>
       						 	${gooinDetail.jobstatus}
       						 	<input type="hidden" class="form-control" name="jobstatus" id="jobstatus" value="${gooinDetail.jobstatus }" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">학력</th>
      							  <td class="even">
									${gooinDetail.school}
									<input type="hidden" class="form-control" name=school id="school" value="${gooinDetail.school}" readonly="readonly">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">모집인원</th>
       						 <td>
       						 	${gooinDetail.wanthuman}
       						 	<input type="hidden" class="form-control" name="wanthuman" id="wanthuman" value="${gooinDetail.wanthuman}" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">성별</th>
      							  <td class="even">
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
    						<tr>
     					    <th scope="row">예상 근무지</th>
       						 <td>
								${gooinDetail.location_addr1 } ${gooinDetail.location_addr2 }
								<input type="hidden" class="form-control"  name="location_addr1" id="location" value="${gooinDetail.location_addr1 }" readonly="readonly">
								<input type="hidden" class="form-control"  name="location_addr2" id="location" value="${gooinDetail.location_addr1 }" readonly="readonly">								
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">급여</th>
      							  <td class="even">
      							  <c:if test="${gooinDetail.salary_detail ne null }">
      							 	<c:if test="${gooinDetail.salary_detail eq '01' }">연</c:if>
									<c:if test="${gooinDetail.salary_detail eq '02' }">월</c:if>
									${gooinDetail.salary_min } ~ ${gooinDetail.salary_max }
								  </c:if>
								  <c:if test="${best.salary_detail eq null }">
									<p>추후협의</p>								
							   	  </c:if>
									<input type="hidden" class="form-control"  name="salary_detail" id="salary_detail" value="${gooinDetail.salary_detail }" readonly="readonly">
									<input type="hidden" class="form-control"  name="salary_min" id="salary_min" value="${gooinDetail.salary_min }" readonly="readonly">
									<input type="hidden" class="form-control"  name="salary_max" id="salary_max" value="${gooinDetail.salary_max }" readonly="readonly">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">근무시간</th>
       						 <td>
       						 	${gooinDetail.jobtime }
       						 	<input type="hidden" class="form-control"  name="jobtime" id="jobtime" value="${gooinDetail.jobtime }" readonly="readonly">	
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">휴무</th>
      							  <td class="even">
      							 	${gooinDetail.breaktime }
									<input type="hidden" class="form-control"  name="breaktime" id="breaktime" value="${gooinDetail.breaktime }" readonly="readonly">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">복리후생</th>
       						 <td>
								${gooinDetail.wage }
								<input type="hidden" class="form-control"  name="wage" id="wage" value="${gooinDetail.wage }" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">채용기간</th>
      							  <td class="even">
      							 	${gooinDetail.gooinweekstart } ~ ${gooinDetail.gooinweekend }
									<input type="hidden" class="form-control"  name="gooinweekstart" id="gooinweekstart" value="${gooinDetail.gooinweekstart }" readonly="readonly">
      							  	<input type="hidden" class="form-control"  name="gooinweekend" id="gooinweekend" value="${gooinDetail.gooinweekend }" readonly="readonly">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">접수방법</th>
       						 <td>
								${gooinDetail.gooinhow }
								<input type="hidden" class="form-control"  name="gooinhow" id="gooinhow" value="${gooinDetail.gooinhow }" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">필요서류</th>
      							  <td class="even">
      							 	${gooinDetail.gooindocument }
									<input type="hidden" class="form-control"  name="gooindocument" id="gooindocument" value="${gooinDetail.gooindocument }" readonly="readonly">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">담당자</th>
       						 <td>
								${gooinDetail.gooinman }
								<input type="hidden" class="form-control"  name="gooinman" id="gooinman" value="${gooinDetail.gooinman }" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">담당자 연락처</th>
      							  <td class="even">
      							 	${gooinDetail.goointel }
									<input type="hidden" class="form-control"  name="goointel" id="goointel" value="${gooinDetail.goointel }" readonly="readonly">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">담당자 이메일</th>
       						 <td>
								${gooinDetail.gooinmail }
								<input type="hidden" class="form-control"  name="gooinmail" id="gooinmail" value="${gooinDetail.gooinmail }" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">모집 상세</th>
      							  <td class="even">
      							 	${gooinDetail.content }
									<input type="hidden" class="form-control"  name="content" id="content" value="${gooinDetail.content }" readonly="readonly">
      							  </td>
    						</tr>
    						
    						
  						  </tbody>
						</table>
							
						</div>
						<div class="text-center">
							<c:if test="${loginData.userid eq gooinDetail.userid }">
								<input type="submit" class="btn btn-success" value="수정하기">
							</c:if>
							<input type="button" class="btn btn-default" onclick="javascript:goPage()" value="목록으로">							
						</div>
						</form>
						</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>


