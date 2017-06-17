<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  
	작성자	: 이상원, 김주희
	작성일	: 2016-11-21
	목 적  	: 자유게시판 답변 view
-->	
<div class="normalheader transition animated fadeIn">
	<div class="hpanel">
		<div class="panel-body">
			<a class="small-header-action" href="">
				<div class="clip-header">
					<i class="fa fa-arrow-up"></i>
				</div>
			</a>

			<div id="hbreadcrumb" class="pull-right m-t-lg">
				<ol class="hbreadcrumb breadcrumb">
					<li><a href="index.html">홈</a></li>
					<li><span>게시판</span></li>
					<li class="active"><span>자유게시판</span></li>
				</ol>
			</div>
			<h2 class="font-light m-b-xs">자유게시판</h2>
			<small>회사내 자유 게시판입니다</small>
		</div>
	</div>
</div>
<div class="content animate-panel">

	<div class="row">
		<div class="col-md-12">
			<div class="hpanel email-compose">
				<div class="panel-heading hbuilt">
					<div class="p-xs h4">글쓰기</div>
				</div>
				<form method="post" class="form-horizontal" enctype="multipart/form-data">
				<input type="hidden" value="${list.refer}" name="refer">
				<input type="hidden" value="${list.step}" name="step">
				<input type="hidden" value="${list.depth}" name="depth">
				<div class="panel-heading hbuilt">
					<div class="p-xs">
							<div class="form-group">
								<label class="col-sm-1 control-label text-left"> 제 목 </label>
								<div class="col-sm-11">
									<input type="text" class="form-control input-sm" placeholder="제목" name="title" value="Re : ${list.title}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-1 control-label text-left"> 첨부 파일
								</label>
								<div class="col-sm-11">
									<div>
										<input type="file" name="uploadfile" class="btn btn-default">
									</div>
								</div>
							</div>
					</div>
				</div>
				<div class="panel-body no-padding" style="text-align: left;" >
					<div>
					<textarea rows="1000" cols="1000" id="content" name="content"  class="summernote">
						${list.content}
					</textarea>
					</div>
				</div>
				
				<input type="hidden" value="{list.refer}" name="refer">
				
				<div class="panel-footer">
					<div class="pull-right">
						<div class="btn-group">
							<input type="submit" class="btn btn-default fa fa-edit" value="글쓰기">
							<a href="freeboard.do?&currentpage=${currentpage}&pagesize=${pagesize}"><input type="button" class="btn btn-default" value="목록으로"></a>
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

