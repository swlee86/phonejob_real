<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


   
<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">
    	<div class="col-lg-12">
			<div class="hpanel">
				<div class="panel-body">
					<c:forEach var="googicdata" items="${googicdata}">
					<form class="form-horizontal" method="POST" id="googicModify" action="googicModify.do?googic_no=${googicdata.googic_no}">
 					<div class="row" style="text-align: center;">
					<table class="type10">
					    <tbody>
						    <tr>
 						       <th scope="row">사진</th>
  							      <td>
  							      	<img src="images/${googicdata.pic}" alt="이력서 사진">
  							     	 <input type="hidden" value="${googicdata.pic}" id="pic" name="pic">
  							      </td>
    						</tr>
   						    <tr>
     						   <th scope="row" class="even">이름</th>
      							  <td class="even">
      							  	${googicdata.username}
      							  	<input type="hidden" class="form-control" id="username" name="username" value="${googicdata.username}" readonly="readonly">
									<input type="hidden" value="${googicdata.userid}" id="userid" name="userid">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">나이</th>
       						 <td>
       						 	${googicdata.age}
       						 	<input type="hidden" id="age" class="form-control" name="age" value="${googicdata.age}" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">희망근무지역</th>
      							  <td class="even">
      							  	${googicdata.location}
      							  	<input type="hidden" value="${googicdata.sido}" id="sido" name="sido">
									<input type="hidden" value="${googicdata.gugun}" id="gugun" name="gugun">
									<input type="hidden" value="${googicdata.dong}" id="dong" name="dong">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">출근가능날짜</th>
       						 <td>
       						 	${googicdata.possibledate}
       						 	<input type="hidden" class="form-control" name="possibledate" id="possibledate" value="${googicdata.possibledate }" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">연락처</th>
      							  <td class="even">
									${googicdata.userphone}
									<input type="hidden" class="form-control" name=userphone id="userphone" value="${googicdata.userphone}" readonly="readonly">
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">이메일</th>
       						 <td>
       						 	${googicdata.useremail}
       						 	<input type="hidden" class="form-control"  placeholder="example@gmail.com" name="useremail" id="useremail" value="${googicdata.useremail}" readonly="readonly">
       						 </td>
    						</tr>
    						<tr>
     						   <th scope="row" class="even">선호하는 업무</th>
      							  <td class="even">
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
    						</tr>
    						<tr>
     					    <th scope="row">근무경험</th>
       						 <td>
       						 	<c:choose>
									<c:when test="${googicdata.telhistory eq 'non'}">
										경력 없음
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
    						<tr>
     						   <th scope="row" class="even">경력</th>
      							  <td class="even">
      							 <c:choose>
										<c:when test="${googicdata.history eq '0'}">
											1년 미만
											<input type="hidden" class="form-control"  name="history" id="history" value="1년 미만" readonly="readonly">	
										</c:when>
										<c:when test="${googicdata.history eq '1'}">
											1 ~ 2년
											<input type="hidden" class="form-control"  name="history" id="history" value="1~2년" readonly="readonly">	
										</c:when>
										<c:when test="${googicdata.history eq '2'}">
											2 ~ 3년
											<input type="hidden" class="form-control"  name="history" id="history" value="2~3년" readonly="readonly">	
										</c:when>
										<c:when test="${googicdata.history eq '3'}">
											3 ~ 4년
											<input type="hidden" class="form-control"  name="history" id="history" value="3~4년" readonly="readonly">	
										</c:when>
										<c:when test="${googicdata.history eq '4'}">
											4년 이상
											<input type="hidden" class="form-control"  name="history" id="history" value="4년 이상" readonly="readonly">	
										</c:when>
									</c:choose>	
      							  </td>
    						</tr>
    						<tr>
     					    <th scope="row">자기소개</th>
       						 <td>
       						 	${googicdata.profiletext }
       						 	<input type="hidden" class="form-control"  name="profiletext" id="profiletext" value="${googicdata.profiletext }" readonly="readonly">	
       						 </td>
    						</tr>
  						  </tbody>
						</table>
							
						</div>
						<div class="text-center">
							<c:if test="${loginData.userid eq googicdata.userid }">
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


