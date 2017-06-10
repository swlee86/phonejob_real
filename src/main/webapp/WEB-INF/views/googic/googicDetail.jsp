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
 						<div class="row">
 							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">사진</label>
								<div class="col-sm-7">
									<img src="images/${googicdata.pic}" alt="이력서 사진">
									<input type="hidden" value="${googicdata.pic}" id="pic" name="pic">
								</div>
							</div>
 						
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">이름</label>
								<div class="col-sm-7">
									<label class="col-lg-12 control-label" style="text-align: left;">${googicdata.username}</label>
									<input type="hidden" class="form-control" id="username" name="username" value="${googicdata.username}" readonly="readonly">
									<input type="hidden" value="${googicdata.userid}" id="userid" name="userid">
								</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">나이</label>
									<div class="col-sm-7">
										<label class="col-sm-3 control-label" style="text-align: left;">${googicdata.age}</label>
										<input type="hidden" id="age" class="form-control" name="age" value="${googicdata.age}" readonly="readonly">
									</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">희망근무지역</label>
								<div class="col-sm-7">
									<label class="col-sm-3 control-label" style="text-align: left;">${googicdata.location}</label>
									<input type="hidden" value="${googicdata.sido}" id="sido" name="sido">
									<input type="hidden" value="${googicdata.gugun}" id="gugun" name="gugun">
									<input type="hidden" value="${googicdata.dong}" id="dong" name="dong">
								</div>
							</div>

							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">출근가능날짜</label>
								<div class="col-sm-7">
									<label class="col-sm-3 control-label" style="text-align: left;">${googicdata.possibledate}</label>
									<input type="hidden" class="form-control" name="possibledate" id="possibledate" value="${googicdata.possibledate }" readonly="readonly">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">연락처</label>
								<div class="col-sm-7">
									<label class="col-sm-3 control-label" style="text-align: left;">${googicdata.userphone}</label>
									<input type="hidden" class="form-control" name=userphone id="userphone" value="${googicdata.userphone}" readonly="readonly">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">이메일</label>
								<div class="col-sm-7">
									<label class="col-sm-3 control-label" style="text-align: left;">${googicdata.useremail}</label>
									<input type="hidden" class="form-control"  placeholder="example@gmail.com" name="useremail" id="useremail" value="${googicdata.useremail}" readonly="readonly">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">선호하는 업무</label>
								<div class="col-sm-7">
									<c:choose>
										<c:when test="${googicdata.wantjob eq 'cs'}">
											<label class="col-sm-3 control-label" style="text-align: left;">CS</label>
											<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="CS" readonly="readonly">
										</c:when>
										<c:when test="${googicdata.wantjob eq 'seller'}">
											<label class="col-sm-3 control-label" style="text-align: left;">판매사</label>
											<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="판매사" readonly="readonly">
										</c:when>
										<c:when test="${googicdata.wantjob eq 'csseller'}">
											<label class="col-sm-3 control-label" style="text-align: left;">판매사 / CS</label>
											<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="판매사 / CS" readonly="readonly">
										</c:when>
									</c:choose>
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">근무경험</label>
								<div class="col-sm-7">
								<c:choose>
									<c:when test="${googicdata.telhistory eq 'non'}">
										<label class="col-sm-3 control-label" style="text-align: left;">경력 없음</label>
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="경력 없음" readonly="readonly">
									</c:when>
								 	<c:when test="${googicdata.telhistory eq 'sk'}">
								 		<label class="col-sm-3 control-label" style="text-align: left;">SK</label>
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="SK" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'sk|kt'}">
										<label class="col-sm-3 control-label" style="text-align: left;">SK / KT</label>
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="SK / KT" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'sk|kt|lg'}">
										<label class="col-sm-3 control-label" style="text-align: left;">SK / KT / LG</label>
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="SK / KT / LG" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'sk|lg'}">
										<label class="col-sm-3 control-label" style="text-align: left;">SK / LG</label>
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="SK / LG" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'kt'}">
										<label class="col-sm-3 control-label" style="text-align: left;">KT</label>
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="KT" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'kt|lg'}">
										<label class="col-sm-3 control-label" style="text-align: left;">KT / LG</label>
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="KT / LG" readonly="readonly">
									</c:when>
									<c:when test="${googicdata.telhistory eq 'lg'}">
										<label class="col-sm-3 control-label" style="text-align: left;">LG</label>
										<input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="LG" readonly="readonly">
									</c:when>
								</c:choose>
								</div>
							</div>


							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">경력</label>
								<div class="col-sm-7">
									<c:choose>
										<c:when test="${googicdata.history eq '0'}">
											<label class="col-sm-3 control-label" style="text-align: left;">1년 미만</label>
											<input type="hidden" class="form-control"  name="history" id="history" value="1년 미만" readonly="readonly">	
										</c:when>
										<c:when test="${googicdata.history eq '1'}">
											<label class="col-sm-3 control-label" style="text-align: left;">1 ~ 2년</label>
											<input type="hidden" class="form-control"  name="history" id="history" value="1~2년" readonly="readonly">	
										</c:when>
										<c:when test="${googicdata.history eq '2'}">
											<label class="col-sm-3 control-label" style="text-align: left;">2 ~ 3년</label>
											<input type="hidden" class="form-control"  name="history" id="history" value="2~3년" readonly="readonly">	
										</c:when>
										<c:when test="${googicdata.history eq '3'}">
											<label class="col-sm-3 control-label" style="text-align: left;">3 ~ 4년</label>
											<input type="hidden" class="form-control"  name="history" id="history" value="3~4년" readonly="readonly">	
										</c:when>
										<c:when test="${googicdata.history eq '4'}">
											<label class="col-sm-3 control-label" style="text-align: left;">4년 이상</label>
											<input type="hidden" class="form-control"  name="history" id="history" value="4년 이상" readonly="readonly">	
										</c:when>
									</c:choose>	
								</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">자기소개</label>
								<div class="col-sm-7">
									<label class="col-lg-12 control-label" style="text-align: left;">${googicdata.profiletext }</label>
									<input type="hidden" class="form-control"  name="profiletext" id="profiletext" value="${googicdata.profiletext }" readonly="readonly">	
								</div>
							</div>
							
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