<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  
	작성자	: 이상원
	작성일	: 2017-03-17
	목 적  	: 구인 등록 view
-->	
<!-- 
<div class="normalheader transition animated fadeIn">
	<div class="hpanel">
		<div class="panel-body" style="text-align: left;">
			<h2 class="font-light m-b-xs">구인 등록</h2>
		</div>
	</div>
</div>
 -->

<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">
		<div class="col-lg-12">
		<div class="hpanel">
			<div class="panel-body">
				<form method="POST" class="form-horizontal" enctype="multipart/form-data">
						<div class="row">
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">광고방법</label>
							<div class="col-sm-7">
								<select class="form-control" name="grade" id="grade">
										<option>선택</option>
										<option value="luxury">럭셔리채용공고</option>
										<option value="best">베스트채용공고</option>
										<option value="normal">일반채용공고</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="text-align: right"> 제목 </label>
							<div class="col-sm-7">
								<input type="text" class="form-control input-sm" placeholder="제목" name="title">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="text-align: right">회사사진</label>
								<div class="col-sm-7">
									<div>
										<input type="file" class="btn btn-default" name="uploadfile" style="text-align: left;">
									</div>
								</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="text-align: right"> 회사명 </label>
							<div class="col-sm-7">
								<input type="text" class="form-control input-sm" name="comname" value="${loginData.comname }">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="text-align: right"> 사업자번호 </label>
							<div class="col-sm-7">
								<input type="text" class="form-control input-sm" name="comidfyno" value="${loginData.comidfyno }">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="text-align: right"> 대표번호 </label>
							<div class="col-sm-7">
								<input type="text" class="form-control input-sm" name="phone" value="${loginData.userphone }">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="text-align: right"> 회사 주소 </label>
							<div class="col-sm-7">
								<input type="text" class="form-control input-sm" name="adress" value="${loginData.useraddr1 } ${loginData.useraddr2 }">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="text-align: right"> 회사 홈페이지 </label>
							<input type="checkbox" class="" value="useDefault" id="usenonhomepage" name="usenonhomepage" onclick="usenonhomepage()">별도 홈페이지가 없는 경우 체크하세요.
							<div class="col-sm-7">
								<input type="text" class="form-control input-sm" name="homepage" id="homepage" value="${loginData.usermail }">
							</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label" style="text-align: right">통신사</label>
								<div class="col-sm-7">
								<select class="form-control" name="wanttel" id="wanttel">
										<option>선택</option>
										<option value="A001">KT</option>
										<option value="A002">SK</option>
										<option value="A003">LG</option>
										<option value="A004">알뜰폰</option>
										<option value="A005">판매점</option>
										<option value="A006">기타</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" style="text-align: right">모집부문</label>
							<div class="col-sm-7">
								<select class="form-control" name="wantjob" id="wantjob">
										<option>선택</option>
										<option value="cs">CS</option>
										<option value="seller">판매사</option>
										<option value="csseller">CS / 판매사</option>
										<option value="etc">기타</option>
								</select>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">근무형태</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="jobstatus" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">학력</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="school" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">모집인원</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="wanthuman" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">성별</label>
							<div class="col-sm-7">
								<select class="form-control" name="gender" id="gender">
										<option>선택</option>
										<option value="male">남</option>
										<option value="female">여</option>
										<option value="allgender">성별 무관</option>
								</select>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">근무지</label>
							<div class="col-sm-7">
								<div>
									<a style="text-align: left;" class="btn btn-default next" href="javascript:void(0);" onclick="daumPostcode()" id="addrnumsearch">매장 주소검색</a>
									<input type="text" class="form-control" name="location_addr1" id="location_addr1" style="text-align: left;" readonly="readonly">
									<input type="text" class="form-control" name="location_addr2" id="location_addr2" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">급여</label>
							<div class="col-md-3">
								<div>
									<table>
										<tr>
											<td>
                               					<select class="form-control" name="salary_detail" id="salary_detail" style="width: 75px;">
													<option>선택</option>
													<option value="01">연</option>
													<option value="02">월</option>
												</select>
                           					
											</td>
											<td>
												<input type="text" class="form-control" name="salary_min" id="salary_min" style="text-align: left;">
											</td>
											<td>
												&nbsp;~&nbsp;
											</td>
											<td>
												<input type="text" class="form-control" name="salary_max"  id="salary_max" style="text-align: left;">
											</td>
											<td style="width: 30px;">
												&nbsp;만원
											</td>
										</tr>
									</table>
									<input type="checkbox" class="" value="useDefault" id="useDefault" name="useDefault" onclick="useDefaultGo()">추후 협의로 진행하실 경우 체크해 주세요
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">근무 시간</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="jobtime" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">휴무</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="breaktime" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">회사복지</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="summernote" name="wage" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">채용기간</label>
							<div class="col-md-4">
								<div>
									<table>
										<tr>
											<td>
												<input type="text" class="form-control" name="gooinweekstart" id="gooinweekstart" style="text-align: left;" readonly="readonly">
											</td>
											<td>
												&nbsp;~&nbsp;
											</td>
											<td>
												<input type="text" class="form-control" name="gooinweekend" id="gooinweekend" style="text-align: left;" readonly="readonly">										
											</td>
											<td style="width: 30px;">
												&nbsp;까지
											</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">접수방법</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="gooinhow" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">필요서류</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="gooindocument" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">담당자</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="gooinman" style="text-align: left;" value="${loginData.keymanname }">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">연락처</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="goointel" style="text-align: left;" value="${loginData.keymantel }">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-3 control-label" style="text-align: right">이메일</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="gooinmail" style="text-align: left;" value="${loginData.keymanmail }">
								</div>
							</div>
						</div>
					</div>

				</div>
				
	
				
				<div class="panel-body no-padding">
					<div style="text-align: left; height: 100%;">
					<textarea rows="100" cols="20" id="content" name="content"  class="summernote">추가 입력 사항<p><br><br><br><br><br><br><br><br><br><br><br></p>
					</textarea>
					</div>
				</div>
				
				<div class="panel-footer">
					<div class="pull-right">
						<div class="btn-group">
							<button class="btn btn-default" type="submit"><i class="fa fa-edit"></i> 글 등록</button>
							<button class="btn btn-default" type="button" onclick="location.href='/gooin.do'">
								<i class="fa fa-refresh"></i> 목록으로
							</button>
						</div>
					</div>
					<br>
					<br>
				</div>
			</div>
		</div>
	</div>
	</form>				

</div>

