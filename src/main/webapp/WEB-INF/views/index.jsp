<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="systemdate" />

<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
	<div class="row">
		<div class="col-lg-12 text-center m-t-md">
			<h3>
				<span style="font-family: Arial">Welcome to <b>Phone & Job</b></span>
			</h3>
			<p>
				이동통신 관련 <strong>구직, 구인, 노하우</strong> 그 모든 것을 위한 사이트

			</p>
		</div>
	</div>

	<div class="row">&nbsp;</div>

	<img src="./images/best_pro.png" alt="베스트 채용공고">
	<hr style="border: 1px solid #ddd;">
	<div class="row">
			<c:forEach items="${gooinbest}" var="best">
			<a href="gooinDetail.do?gooin_no=${best.gooin_no }">
			<div style="width: 227px;display:inline-block; padding-left: 15px; padding-right: 15px;">
			<div class="hpanel hblue">
				<div class="panel-heading hbuilt" style="text-align: center;">
					<c:if test="${best.wanttel eq 'sk'}">
						<img src="images/sk1.jpg">
					</c:if>
					<c:if test="${best.wanttel eq 'lg'}">
						<img src="images/lg1.jpg">
					</c:if>
					<c:if test="${best.wanttel eq 'kt'}">
						<img src="images/kt1.jpg">
					</c:if>
					
				</div>
				<div class="panel-body" style="height: 220px;">
					<p>제목 : ${best.title}</p>
					<p>모집분야 : <c:if test="${best.wantjob eq 'cs' }"> CS 직원</c:if>
							   <c:if test="${best.wantjob eq 'seller' }"> 판매 직원</c:if>
							   <c:if test="${best.wantjob eq 'csseller' }"> CS/판매 직원</c:if>
							   <c:if test="${best.wantjob eq 'etc' }"> 기타 직원</c:if>
					</p>
					<p>모집인원 : ${best.wanthuman }명</p>
				</div>
				<div class="panel-footer">등록자 : ${best.userid }</div>
			</div>
			</div>
			</a>
		</c:forEach>
		
	</div>

	<br/>

	<img src="./images/lux_pro.png" alt="럭셔리 채용공고">
	<hr style="border: 1px solid #ddd;">
	<div class="row">
		<c:forEach items="${gooinluxury}" var="luxury">
			<a href="gooinDetail.do?gooin_no=${luxury.gooin_no }">
			<div style="width: 227px;display:inline-block; padding-left: 15px; padding-right: 15px;">
			<div class="hpanel hblue">
				<div class="panel-heading hbuilt" style="text-align: center;">
					<c:if test="${luxury.wanttel eq 'sk'}">
						<img src="images/sk1.jpg">
					</c:if>
					<c:if test="${luxury.wanttel eq 'lg'}">
						<img src="images/lg1.jpg">
					</c:if>
					<c:if test="${luxury.wanttel eq 'kt'}">
						<img src="images/kt1.jpg">
					</c:if>
					
				</div>
				<div class="panel-body" style="height: 220px;">
					<p>제목 : ${luxury.title}</p>
					<p>모집분야 : <c:if test="${luxury.wantjob eq 'cs' }"> CS 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'seller' }"> 판매 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'csseller' }"> CS/판매 직원</c:if>
							   <c:if test="${luxury.wantjob eq 'etc' }"> 기타 직원</c:if>
					</p>
					<p>모집인원 : ${luxury.wanthuman }명</p>
				</div>
				<div class="panel-footer">등록자 : ${luxury.userid }</div>
			</div>
			</div>
			</a>
		</c:forEach>
		
	</div>
	

	<br/>

	<img src="./images/pe_pro.png" alt="인재 List">
	<hr style="border: 1px solid #ddd;">
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


<div id="popDiv" style="background-color: white; text-align: left;">
 <!-- 팝업내용 및 이미지 -->
	<h5 style="color: blue;">1. 현재 작업 진행 상황</h5>
	 &nbsp;&nbsp;&nbsp;-구인글 등록 / 읽기(수정 / 삭제 불가)<br/>
	 &nbsp;&nbsp;&nbsp;-구직글 등록 / 읽기 / 수정 (삭제 불가)<br/>
	 &nbsp;&nbsp;&nbsp;-회원 가입(개인) / 회사 가입 불가<br/>
	 &nbsp;&nbsp;&nbsp;-커뮤니티 글쓰기 / 수정 / 삭제 가능<br/><br> 
	
	<h5 style="color: blue;">2. 2017-07-09 반영 사항</h5>
	 &nbsp;&nbsp;&nbsp;-커뮤니티 글 삭제 기능 추가<br/><br/>
	 
	  ※로그인 세션에서 불러오는 데이터가 있으므로 회원 가입 후 로그인 후 테스트 진행 필요<br/><br/>
	 
	 <b>※테스트 데이터는 많을 수록 좋으므로 수시로 등록 부탁드립니다. <br/>
	 오류 발생시 커뮤니티 게시글에 사항 남겨 주시면 확인 하겠습니다.<br/>
	 (추후 오픈전까지 고객센터 메뉴를 통해 해당 내용 접수할 수 있도록 조치 예정)</b><br/><br/>
  <span class="" style="font-size: 13px; text-align: left; color:#6a6c6f">
  <input type="checkbox" onClick="javascript:controlCOOKIE();" style="text-align: left;">오늘은 그만보기
  </span>
  <br>
  <span class="close" style="font-size: 13px;">
  <a href="#" onclick="closePopup('popDiv')" >닫기</a>
 </span>
</div>




	<script>

    $(function () {

        // Initialize Example 1
        $('#example1').dataTable( {
            "ajax": 'api/datatables.json',
            dom: "<'row'<'col-sm-4'l><'col-sm-4 text-center'B><'col-sm-4'f>>tp",
            "lengthMenu": [ [10, 25, 50, -1], [10, 25, 50, "All"] ],
            buttons: [
                {extend: 'copy',className: 'btn-sm'},
                {extend: 'csv',title: 'ExampleFile', className: 'btn-sm'},
                {extend: 'pdf', title: 'ExampleFile', className: 'btn-sm'},
                {extend: 'print',className: 'btn-sm'}
            ]
        });

        // Initialize Example 2
        $('#example2').dataTable();

    });

</script>