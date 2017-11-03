<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  
	작성자	: 이상원
	작성일	: 2017-09-18
	목 적  	: 자유게시판 답변 view
-->	

<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">

	<div class="row">
		<div class="col-md-12">
			<div class="hpanel email-compose">
				<form method="post" class="form-horizontal" enctype="multipart/form-data">
				<div class="panel-heading hbuilt">
					<div class="p-xs h4"></div>
			
				<input type="hidden" value="${list.refer}" name="refer">
				<input type="hidden" value="${list.step}" name="step">
				<input type="hidden" value="${list.depth}" name="depth">
				<div class="panel-heading hbuilt">
					<div class="p-xs">
							<div class="form-group">
								<label class="col-sm-1 control-label text-left">제 목</label>
								<div class="col-sm-11">
									<input type="text" class="form-control input-sm" placeholder="제목" name="title" value="${list.title }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-1 control-label text-left">첨부파일
								</label>
								<div class="col-sm-11">
									<div>
										<input type="file" class="btn btn-default" name="uploadfile" style="text-align: left;">
									</div>
								</div>
							</div>
					</div>
				</div>
				</div>
				<div class="panel-body no-padding">
					<div style="text-align: left; height: 100%;">
					<textarea rows="100" cols="20" id="content" name="content"  class="summernote">${list.content }</textarea>
					</div>
				</div>
				</div>
				
				<div class="panel-footer">
					<div class="pull-right">
						<div class="btn-group">
							<button class="btn btn-default" type="submit"><i class="fa fa-edit"></i> 공지사항 등록</button>
							<a href="../notice/noticeBoardMain.do?&currentpage=${currentpage}&pagesize=${pagesize}"><input type="button" class="btn btn-default" value="목록으로"></a>
						</div>
					</div>
					<br>
					<br>
				</div>
			</form>				
			</div>
		</div>
	</div>


