<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<hr style="border: 1px solid #ddd;">
	<div class="col-lg-12">
	<div class="row">
		<div style="float:right">
    			<a href="googicRegister.do" style="float: rignt" class="btn btn-default next" id="googic">구직자등록</a>
    	</div>
		<div class="hpanel">
			<div class="panel-heading">
				구직자
			</div>
			<div class="panel-body">
				<table id="example2" class="table table-striped table-bordered table-hover" style="text-align: center;">
					<thead>
						<tr style="text-align: center;">
							<th>이름</th>
							<th>경력</th>
							<th>선호 근무지역</th>
							<th>나이</th>
							<th>선호 직종</th>
							<th>출근가능일자</th>
						</tr>
					</thead>
					<tbody>
						
					<c:forEach var="resultData" items="${result}">
						<tr>
							<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">${resultData.username}</a></td>
							<c:choose>
								<c:when test="${resultData.history eq 0}">
									<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">1년 미만</a></td>		
								</c:when>
								<c:when test="${resultData.history eq 1}">
									<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">1~2년</a></td>		
								</c:when>
								<c:when test="${resultData.history eq 2}">
									<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">2~3년</a></td>		
								</c:when>
								<c:when test="${resultData.history eq 3}">
									<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">3~4년</a></td>		
								</c:when>
								<c:when test="${resultData.history eq 4}">
									<td>4년 초과</td>		
								</c:when>
							</c:choose>
							
							<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">${resultData.location}</a></td>
							<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">${resultData.age}</a></td>
							<c:choose>
								<c:when test="${resultData.wantjob eq 'seller'}">
									<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">판매사</a></td>
								</c:when>
								<c:when test="${resultData.wantjob eq 'cs'}">
									<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">CS</a></td>
								</c:when>
								<c:when test="${resultData.wantjob eq 'csseller'}">
									<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">판매사 / CS</a></td>
								</c:when>
							</c:choose>
							<td><a href="googicDetail.do?googic_no=${resultData.googic_no}">${resultData.possibledate}</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>


	</div>