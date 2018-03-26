<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  
	작성자	: 이상원
	작성일	: 2017-08-23
	목 적  	: 자유게시판 수정 view
-->
<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">

	<div class="row">
		<div class="col-md-12">
			<div class="hpanel email-compose">
				<form method="POST" class="form-horizontal" enctype="multipart/form-data" action="../notice/noticeModifyComple.do">
				<div class="panel-heading hbuilt">
					<div class="p-xs">
							<div class="form-group">
								<label class="col-sm-1 control-label text-left">제 목</label>
								<div class="col-sm-11">
									<input type="text" class="form-control input-sm" placeholder="제목" name="title" value="${noticeboard.title }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-1 control-label text-left">첨부파일</label>
								<div class="col-sm-11">
									<div>
										<input type="file" class="btn btn-default" name="uploadfile" style="text-align: left;">
									</div>
								</div>
							</div>
					</div>
				</div>
				<div class="panel-body no-padding">
					<div style="text-align: left; height: 100%;">
					<textarea rows="100" cols="20" id="content" name="content"  class="summernote">${noticeboard.content }</textarea>
					</div>
				</div>
				
				<div class="panel-footer">
					<div class="pull-right">
						<div class="btn-group">
							<button class="btn btn-default" type="submit"><i class="fa fa-edit"></i> 글 수정</button>
							<button class="btn btn-default" type="button" onclick="location.href='../notice/noticeBoaradMain.do?&currentpage=${currentpage}&pagesize=${pagesize}'">
								<i class="fa fa-refresh"></i> 목록으로
							</button>
						</div>
					</div>
					<br>
					<br>
				</div>
				<input type="hidden" value="${noticeboard.notice_no }" name="notice_no">
				<input type="hidden" value="${noticeboard.filename }" name="filename">
				<input type="hidden" value="${currentpage }" name="currentpage">
				<input type="hidden" value="${pagesize }" name="pagesize">
			</form>			
			</div>
		</div>
	</div>

</div>
