<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <li>
                        <span>회원 정보 관리</span>
                    </li>
                    <li class="active">
                        <span>내 정보 수정</span>
                    </li>
                </ol>
            </div>
            <h2 class="font-light m-b-xs">
                	내 정보 수정
            </h2>
            <small>내 정보를 수정 할 수 있습니다</small>
        </div>
    </div>
</div>


<div class="content animate-panel">
	<div class="row">
		<div class="col-lg-12">
			<div class="hpanel">
				<div class="panel-body">
					<form class="form-horizontal" method="POST" id="modifyForm">
 						<div class="row">
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">사번</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" readonly="readonly" id="emp_no" name="emp_no" value="${emp.emp_no}">
								</div>
							</div>

							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">부서</label>
								<div class="col-sm-7">
									<input type="text" readonly="readonly" class="form-control" name="dept_name" value="${emp.dept_name}">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">이름</label>
								<div class="col-sm-7">
									<input type="text" class="form-control"  readonly="readonly" name="emp_name" value="${emp.emp_name}">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">아이디</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" readonly="readonly" name="id" value="${emp.id}">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">비밀번호</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" name="pwd" id="pwd">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">비밀번호확인</label>
								<div class="col-sm-7">
									<input type="password" class="form-control"  value="" id="repwd">
								</div>
								<span id="chkpass" style="color: blue;"></span>	
							</div>
							
							
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">주소</label>
								<div class="col-sm-7">
									<div class="input-group">
										<input type="text" id="sample6_postcode" class="form-control" placeholder="" name="postcode">
										<span class="input-group-btn">
											<input type="button" onclick="sample6_execDaumPostcode()" class="btn btn-success "  value="우편번호 찾기">
										</span> 			
									</div>							
								</div>
								<br/>
								<div class="col-sm-3"></div>
								<div class=" col-sm-4">
									<input type="text" id="sample6_address"  class="form-control"  placeholder="기본주소" name="addr">
								</div>
								<div class=" col-sm-3">
									<input type="text" id="sample6_address2"  class="form-control"  placeholder="상세주소" name="addr_detail">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">연락처</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="cell_phone" id="cell_phone">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">이메일</label>
								<div class="col-sm-7">
									<input type="email" class="form-control"  placeholder="example@gmail.com" name="email" id="email">
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">은행</label>
								<div class="col-sm-7">
									<select class="form-control" name="bank" id="bank">
											<option>선택</option>
											<option>국민</option>
											<option>신한</option>
											<option>기업</option>
											<option>SC은행</option>
											<option>우체국</option>
											<option>농협</option>
									</select>
								</div>
							</div>
							
							<div class="form-group col-lg-12">
								<label class="col-sm-3 control-label" style="text-align: right;">계좌번호</label>
								<div class="col-sm-7">
									<input type="text" class="form-control"  placeholder="123456-22-123456" name="account" id="account">
								</div>
							</div>
							
						</div>
						
						<div class="text-center">
								<button class="btn btn-success">수정하기</button>
								<button class="btn btn-default">취소하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="heading-image animate-panel" data-child="img-animate" data-effect="fadeInRight" style="height: 100%;"></div>
