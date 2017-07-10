<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">
    			<div class="col-lg-12">
			<div class="hpanel">
				<div class="panel-body">
					<form class="form-horizontal" method="POST" id="googicRegister">
 						<div class="row">
 							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">사진</label>
								<div class="col-sm-7">
									<img src="default.jsp" alt="이력서 사진">
									<input type="hidden" value="${loginData.pic}" id="pic" name="pic">
								</div>
							</div>
 						
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">이름</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" id="username" name="username" value="${loginData.username}">
									<input type="hidden" value="${loginData.userid}" id="userid" name="userid">
								</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">나이</label>
									<div class="col-sm-7">
										<input type="text" id="age" class="form-control" name="age">
									</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">희망근무지역</label>
								<div class="col-sm-7">
									<select class="form-control" name="sido" id="sido"><option value="">-시도-</option></select>
									<select class="form-control" name="gugun" id="gugun"><option value="">-구군-</option></select>
									<select class="form-control" name="dong" id="dong"><option value="">-동-</option></select>
								</div>
							</div>

							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">출근가능날짜</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="possibledate" id="possibledate" placeholder="2017-05-13" readonly="readonly">
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
									<input type="email" class="form-control"  placeholder="example@gmail.com" name="useremail" id="useremail" value="${loginData.usermail}">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">선호하는 업무</label>
								<div class="col-sm-7">
									<select class="form-control" name="wantjob" id="wantjob">
											<option>선택</option>
											<option value="cs">CS</option>
											<option value="seller">판매사</option>
											<option value="csseller">CS / 판매사</option>
									</select>
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">근무경험</label>
								<div class="col-sm-7">
									<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory">SK
									<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory">LG
									<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory">KT
								</div>
							</div>


							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">경력</label>
								<div class="col-sm-7">
									<select class="form-control" name="history" id="history">
											<option>선택</option>
											<option value="0">1년 미만</option>
											<option value="1">1~2년</option>
											<option value="2">2~3년</option>
											<option value="3">3~4년</option>
											<option value="4">4년 이상</option>
									</select>
								</div>
							</div>
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">자기소개</label>
								<div class="col-sm-7">
									<textarea rows="8" cols="75" style="resize: none;" id="profiletext" name="profiletext"></textarea>
								</div>
							</div>
							
						</div>
						
						<div class="text-center">
								<button class="btn btn-success">등록하기</button>
								<button class="btn btn-default">취소하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>