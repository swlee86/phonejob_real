<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  
	작성자	: 이상원
	작성일	: 2017-03-17
	목 적  	: 공지사항 글쓰기 view
-->	

<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">

	<div class="row">
		<div class="col-md-12">
			<div class="hpanel email-compose">
				<form method="POST" class="form-horizontal"> <%--enctype="multipart/form-data"--%>
				<div class="panel-heading hbuilt">
					<div class="p-xs">
						<div class="form-group">
							<label class="col-sm-1 control-label text-left">제 목</label>
							<div class="col-sm-11">
								<input type="text" class="form-control input-sm" placeholder="제목" name="title">
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body no-padding">
					<div style="text-align: left; height: 100%;">
					<textarea rows="100" cols="20" id="content" name="content"  class="summernote"></textarea>
					</div>
				</div>
				
				<div class="panel-footer">
					<div class="pull-right">
						<div class="btn-group">
							<button type="button" class="btn btn-default article-register"><i class="fa fa-edit"></i> 공지사항 등록</button>
							<button class="btn btn-default" type="button" onclick="location.href='../notice/noticeBoardMain.do?currentpage=${currentpage}&pagesize=${pagesize}'">
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

