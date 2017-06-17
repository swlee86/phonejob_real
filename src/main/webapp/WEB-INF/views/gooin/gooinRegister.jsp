<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  
	작성자	: 이상원
	작성일	: 2017-03-17
	목 적  	: 자유게시판 글쓰기 view
-->	
<div class="normalheader transition animated fadeIn">
	<div class="hpanel">
		<div class="panel-body" style="text-align: left;">
			<h2 class="font-light m-b-xs">구인 등록</h2>
		</div>
	</div>
</div>
<div class="content">

	<div class="row">
		<div class="col-md-12">
			<div class="hpanel email-compose">
				<form method="post" class="form-horizontal" enctype="multipart/form-data">
				<div class="panel-heading hbuilt">
					<div class="p-xs">
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">광고방법</label>
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
							<label class="col-sm-1 control-label text-left" style="text-align: center"> 제목 </label>
							<div class="col-sm-7">
								<input type="text" class="form-control input-sm" placeholder="제목" name="title">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label text-left" style="text-align: center">회사사진</label>
								<div class="col-sm-7">
									<div>
										<input type="file" class="btn btn-default" name="uploadfile" style="text-align: left;">
									</div>
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-1 control-label text-left" style="text-align: center">통신사</label>
								<div class="col-sm-7" style="text-align: left;">
									<input type="checkbox" class="i-checks approveCheck" value="sk" id="skhistory" name="skhistory">SK
									<input type="checkbox" class="i-checks approveCheck" value="lg" id="lghistory" name="lghistory">LG
									<input type="checkbox" class="i-checks approveCheck" value="kt" id="kthistory" name="kthistory">KT
								</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label text-left" style="text-align: center">모집부문</label>
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
						<label class="col-sm-1 control-label text-left" style="text-align: center">근무형태</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="job" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">학력</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="school" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">모집인원</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="wantnum" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">성별</label>
							<div class="col-sm-7">
								<select class="form-control" name="wantgender" id="wantgender">
										<option>선택</option>
										<option value="male">남</option>
										<option value="female">여</option>
										<option value="allgender">성별 무관</option>
								</select>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">근무지</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="location" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">급여</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="salary" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">근무 시간</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="worktimes" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">휴무</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="breaktimes" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">복리후생</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="bonus" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">채용기간</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="jobweeks" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">접수방법</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="howjob" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">필요서류</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="needdocument" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">담당자</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="keyman" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">연락처</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="phone" style="text-align: left;">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label text-left" style="text-align: center">이메일</label>
							<div class="col-sm-7">
								<div>
									<input type="text" class="form-control" name="email" style="text-align: left;">
								</div>
							</div>
						</div>
					</div>

				</div>
				
	
				
				<div class="panel-body no-padding">
					<div style="text-align: left; height: 100%;">
					<textarea rows="100" cols="20" id="content" name="content"  class="summernote"><p><br><br><br><br><br><br><br><br><br><br><br></p></textarea>
					</div>
				</div>
				
				<div class="panel-footer">
					<div class="pull-right">
						<div class="btn-group">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-edit"></i> 글 등록
							</button>
							<button class="btn btn-default" type="button" onclick="location.href='freeboard.do?&currentpage=${currentpage}&pagesize=${pagesize}'">
								<i class="fa fa-refresh"></i> 목록으로
							</button>
						</div>
					</div>
					<br>
					<br>
				</div>
			</form>				
			</div>
		</div>
	</div>

</div>

