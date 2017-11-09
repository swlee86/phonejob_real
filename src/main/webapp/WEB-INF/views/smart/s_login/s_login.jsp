<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="login-container">
    <div class="row">
        <div class="col-md-12-pc">
            <div class="text-center m-b-md">
                <h3>PhoneJob 고객 로그인</h3>
                <small>아이디가 없으신 경우 회원 가입을 진행해 주세요!</small>
            </div>
            <div class="hpanel" style="text-align:left">
                <div class="panel-body-mobile">
                        <form id="loginForm" method="post" action="${pageContext.request.contextPath}/smart/loginprocess">
                            <div class="form-group">
                                <%--@declare id="id"--%><label class="control-label" for="ID">ID</label>
                                <input type="text" placeholder="ID 입력" title="Please enter you ID" required="" value="" name="userid" id=userid class="form-control">
                                <span class="help-block small">Your unique ID to Phone&Job</span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="password">Password</label>
                                <input type="password" title="Please enter your password" placeholder="******" required="" value="" name="password" id="password" class="form-control">
                                <span class="help-block small">Yur strong password</span>
                            </div>
                            <button class="btn btn-success btn-block">회원 로그인</button>
                            <a class="btn btn-default btn-block" href="../smart/s_privateRegister.do">구직자 회원 가입</a>
                            <a class="btn btn-default btn-block" href="../smart/s_comRegister.do">기업 회원 가입</a>
                            <a class="btn btn-default btn-block" href="../s_Main.do">PhoneJob 메인으로 돌아가기</a>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
