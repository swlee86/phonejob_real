<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content animate-panel"
	style="width: 1200px; text-align: left; display: inline-block">
	<div class="text-center m-b-md" id="wizardControl">
		<a class="btn btn-primary" href="#step1" data-toggle="tab">럭셔리 광고</a>
		<a class="btn btn-default" href="#step2" data-toggle="tab">베스트 광고</a>
		<a class="btn btn-default" href="#step3" data-toggle="tab">일반 광고</a>
	</div>
	<div class="row">
		<div style="float: right">
			<a href="gooinRegister.do" style="float: rignt"
				class="btn btn-default next" id="gooin">구인등록</a>
		</div>
		<div class="tab-content">
			<div id="step1" class="p-m tab-pane active">
				<img src="./images/lux_pro.png" alt="럭셔리 채용공고">
				<hr style="border: 1px solid #ddd;">
				<div class="row">
					<c:forEach items="${gooinluxury}" var="luxury">
						<a href="gooinDetail.do?gooin_no=${luxury.gooin_no }">
							<div style="width: 227px; display: inline-block; padding-left: 15px; padding-right: 15px;">
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
										<p>
											모집분야 :
											<c:if test="${luxury.wantjob eq 'cs' }"> CS 직원</c:if>
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
			</div>

			<div id="step2" class="p-m tab-pane">

				<img src="./images/best_pro.png" alt="베스트 채용공고">
				<hr style="border: 1px solid #ddd;">
				<div class="row">
					<c:forEach items="${gooinbest}" var="best">
						<a href="gooinDetail.do?gooin_no=${best.gooin_no }">
							<div style="width: 227px; display: inline-block; padding-left: 15px; padding-right: 15px;">
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
										<p>
											모집분야 :
											<c:if test="${best.wantjob eq 'cs' }"> CS 직원</c:if>
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
			</div>
			<div id="step3" class="p-m tab-pane">

				<img src="./images/best_pro.png" alt="베스트 채용공고">
				<hr style="border: 1px solid #ddd;">
				<div class="row">
					<c:forEach items="${gooinbest}" var="best">
						<a href="gooinDetail.do?gooin_no=${best.gooin_no }">
							<div
								style="width: 227px; display: inline-block; padding-left: 15px; padding-right: 15px;">
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
										<p>
											모집분야 :
											<c:if test="${best.wantjob eq 'cs' }"> CS 직원</c:if>
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

			</div>
		</div>



	</div>
</div>

