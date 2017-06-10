<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">
    			<div class="col-lg-12">
			<div class="hpanel">
				<div class="panel-body">
				<c:forEach var="googicdata" items="${googicdata}">
					<form class="form-horizontal" method="POST" id="googicModify" name="googicModify" action="/phonejob/googicModifyOk.do">
 						<div class="row">
 							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">사진</label>
								<div class="col-sm-7">
									<img src="default.jsp" alt="이력서 사진">
									<input type="hidden" value="${googicdata.pic}" id="pic" name="pic">
								</div>
							</div>
 						
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">이름</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" id="username" name="username" value="${googicdata.username}">
									<input type="hidden" value="${googicdata.userid}" id="userid" name="userid">
									<input type="hidden" value="${googicdata.googic_no}" id="googic_no" name="googic_no">
								</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">나이</label>
									<div class="col-sm-7">
										<input type="text" id="age" class="form-control" name="age" value="${googicdata.age }">
									</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">희망근무지역</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" id="deafultlocation" name="deafultlocation" value="기존 선택 지역은 [${googicdata.sido} ${googicdata.gugun } ${googicdata.dong }] 입니다">
									<input type="hidden" name="dsido" id="dsido" value="${googicdata.sido}">
									<input type="hidden" name="dgugun" id="dgugun" value="${googicdata.gugun }">
									<input type="hidden" name="ddong" id="ddong" value="${googicdata.dong }">
									<input type="checkbox" class="" value="newlocation" id="uselocation" name="uselocation" onclick="useNewlocation()">이전 주소를 사용하시려면 체크하세요
									<select class="form-control" name="sido" id="sido"><option value="">-시도-</option></select>
									<select class="form-control" name="gugun" id="gugun"><option value="">-구군-</option></select>
									<select class="form-control" name="dong" id="dong"><option value="">-동-</option></select>
								</div>
							</div>

							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">출근가능날짜</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="possibledate" id="possibledate" placeholder="2017-05-13" value="${googicdata.possibledate}">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">연락처</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name=userphone id="userphone" value="${loginData.userphone}">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">이메일</label>
								<div class="col-sm-7">
									<input type="email" class="form-control"  placeholder="example@gmail.com" name="useremail" id="useremail" value="${googicdata.useremail}">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">선호하는 업무</label>
								<div class="col-sm-7">
									<select class="form-control" name="wantjob" id="wantjob">
										<c:choose>
											<c:when test="${googicdata.wantjob eq 'cs'}">
												<option value="cs" selected="selected">CS</option>
												<option value="seller">판매사</option>
												<option value="csseller">CS / 판매사</option>
											</c:when>
											<c:when test="${googicdata.wantjob eq 'seller'}">
												<option value="cs">CS</option>
												<option value="seller" selected="selected">판매사</option>
												<option value="csseller" selected="selected">CS / 판매사</option>
											</c:when>
											<c:when test="${googicdata.wantjob eq 'csseller'}">
												<option value="cs">CS</option>
												<option value="seller">판매사</option>
												<option value="csseller">CS / 판매사</option>
											</c:when>
										</c:choose>
									</select>
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">근무경험</label>
								<div class="col-sm-7">
									<c:choose>
										<c:when test="${googicdata.telhistory eq 'non'}">
											<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory">SK
											<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory">LG
											<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory">KT
										</c:when>
										<c:when test="${googicdata.telhistory eq 'sk'}">
											<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory" checked="checked">SK
											<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory">LG
											<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory">KT
										</c:when>
										<c:when test="${googicdata.telhistory eq 'sk|kt'}">
											<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory" checked="checked">SK
											<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory">LG
											<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory" checked="checked">KT
										</c:when>
										<c:when test="${googicdata.telhistory eq 'sk|kt|lg'}">
											<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory" checked="checked">SK
											<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory" checked="checked">LG
											<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory" checked="checked">KT
										</c:when>
										<c:when test="${googicdata.telhistory eq 'sk|lg'}">
											<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory" checked="checked">SK
											<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory" checked="checked">LG
											<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory">KT
										</c:when>
										<c:when test="${googicdata.telhistory eq 'kt'}">
											<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory">SK
											<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory" checked="checked">LG
											<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory">KT
										</c:when>
										<c:when test="${googicdata.telhistory eq 'kt|lg'}">
											<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory">SK
											<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory" checked="checked">LG
											<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory" checked="checked">KT
										</c:when>
										<c:when test="${googicdata.telhistory eq 'lg'}">
											<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory">SK
											<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory" checked="checked">LG
											<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory">KT
										</c:when>
									</c:choose>
								</div>
							</div>


							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">경력</label>
								<div class="col-sm-7">
									<select class="form-control" name="history" id="history">
										<c:choose>
											<c:when test="${googicdata.history eq '0'}">
												<option value="0" selected="selected">1년 미만</option>
												<option value="1">1~2년</option>
												<option value="2">2~3년</option>
												<option value="3">3~4년</option>
												<option value="4">4년 이상</option>
											</c:when>
											<c:when test="${googicdata.history eq '1'}">
												<option value="0">1년 미만</option>
												<option value="1" selected="selected">1~2년</option>
												<option value="2">2~3년</option>
												<option value="3">3~4년</option>
												<option value="4">4년 이상</option>
											</c:when>
											<c:when test="${googicdata.history eq '2'}">
												<option value="0">1년 미만</option>
												<option value="1">1~2년</option>
												<option value="2" selected="selected">2~3년</option>
												<option value="3">3~4년</option>
												<option value="4">4년 이상</option>
											</c:when>
											<c:when test="${googicdata.history eq '3'}">
												<option value="0">1년 미만</option>
												<option value="1">1~2년</option>
												<option value="2">2~3년</option>
												<option value="3" selected="selected">3~4년</option>
												<option value="4">4년 이상</option>
											</c:when>
											<c:when test="${googicdata.history eq '4'}">
												<option value="0">1년 미만</option>
												<option value="1">1~2년</option>
												<option value="2">2~3년</option>
												<option value="3">3~4년</option>
												<option value="4" selected="selected">4년 이상</option>
											</c:when>
											<c:otherwise>
												<option>선택</option>
												<option value="0">1년 미만</option>
												<option value="1">1~2년</option>
												<option value="2">2~3년</option>
												<option value="3">3~4년</option>
												<option value="4">4년 이상</option>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">자기소개</label>
								<div class="col-sm-7">
									<textarea rows="8" cols="75" style="resize: none;" id="profiletext" name="profiletext">${googicdata.profiletext }</textarea>
								</div>
							</div>
							
						</div>
						
						<div class="text-center">
								<button class="btn btn-success">수정하기</button>
								<input type="button" class="btn btn-default" onclick="javascript:goPage()" value="목록으로">
						</div>
					</form>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>





