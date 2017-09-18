<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  
	작성자	: 이상원, 김주희
	작성일	: 2016-11-21
	목 적  	: 자유게시판 리스트 view
-->
<!-- 
<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="hpanel">
		<div class="panel-body">
			<h2 class="font-light m-b-xs">자유 게시판</h2>
		</div>
	</div>
</div>
 -->
<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">

		<div class="col-lg-12">
			<div class="hpanel">
				<div class="panel-heading">
					총 개시글 수 : <font color="coral">${totalcount}</font> 개
				</div>

				<div class="panel-body">
					<div class="row text-right">
						<div class="col-md-6">
							<form name="list">
								<select name="pagesize" onchange="submit()"
									class="form-control input-sm" style="width: 20%;">
									<c:forEach var="i" begin="5" end="25" step="5">
										<c:choose>
											<c:when test="${pgsize == i}">
												<option value='${i}' selected>${i}건</option>
											</c:when>
											<c:otherwise>
												<option value='${i}'>${i}건</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</form>
						</div>
						<form action="" class="form-inline">
							<div class="col-md-2">
								<div class="form-group">
									<select class="form-control input-sm" name="f">
										<option value="title">제목</option>
										<option value="emp_name">작성자</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<div class="input-group">
										<input type="text" class="form-control input-sm" name="q" />
										<span class="input-group-btn">
											<button class="btn btn-default input-sm" type="submit"
												style="color: #f05050">
												<span class="fa fa-search"></span>
											</button>
										</span>
									</div>
								</div>
							</div>
						</form>
					</div>
					<br>
					<hr style="border: 1px solid gray; margin-bottom: 0px">
					<div class="table-responsive">
						<table cellpadding="1" cellspacing="1" class="table  table-hover"
							style="text-align: left">
							<thead>
								<tr style="background-color: #f6f6f6;">
									<th style="text-align: center">번호</th>
									<th style="width: 40%;">제목</th>
									<th>아이디</th>
									<th>작성일시</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${list}">
									<tr>
										<td style="text-align: center">${list.free_no}</td>
										<td><c:forEach begin="0" end="${list.depth}" step="1">
                        				&nbsp;&nbsp;&nbsp;
                       			 </c:forEach> 
                       			 	<a href="free_board_view.do?free_no=${list.free_no}&currentpage=${cpage}&pagesize=${pgsize}">${list.title}</a><c:if test="${list.re_count ne 0 }">[${list.re_count }]</c:if>
											&nbsp;&nbsp;&nbsp; 
										<c:if test="${list.filename != null}">
												<img alt="file" src="images/fileimg.PNG">
										</c:if>
										</td>
										<td>${list.userid}</td>
										<td>${list.regdate}</td>
										<td>${list.hit}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="row" style="text-align: right; margin-right: 5px;">
							<button type="button" class="btn w-xs btn-success"
								onclick="location.href='writefreeboard.do?&currentpage=${cpage}&pagesize=${pgsize}'">글등록</button>
						</div>
					</div>

				</div>
				<div class="panel-footer" style="text-align: center;">
					<div class="btn-group">
						<c:if test="${cpage > 1}">
							<button type="button" class="btn btn-default"
								onclick="location.href='freeboard.do?currentpage=${cpage-1}&pagesize=${pgsize}'">
								&nbsp;<i class="fa fa-chevron-left"></i>
							</button>
						</c:if>
						<c:forEach var="i" begin="1" end="${pagecount}" step="1">
							<c:choose>
								<c:when test="${cpage==i}">
									<button class="btn btn-default active" style="background-color: #DAD9FF">
										<b>${i}</b>
									</button>
								</c:when>
								<c:otherwise>
									<button class="btn btn-default"
										onclick="location.href='freeboard.do?currentpage=${i}&pagesize=${pgsize}'">${i}</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${cpage < pagecount}">
							<button type="button" class="btn btn-default"
								onclick="location.href='freeboard.do?currentpage=${cpage+1}&pagesize=${pgsize}'">
								&nbsp;<i class="fa fa-chevron-right"></i>
							</button>
						</c:if>

					</div>
				</div>
			</div>


		</div>
	</div>
</div>