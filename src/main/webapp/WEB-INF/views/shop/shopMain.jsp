<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content animate-panel"	style="width: 1200px; text-align: left; display: inline-block">
		<div class="row">&nbsp;</div>

		<h3>
			<span style="font-family: Arial"><b>추천하는 단말기</b></span>
		</h3>
		<hr style="border: 1px solid #ddd;">
		<div class="row" style="text-align: center">
			<c:forEach items="${result}" var="phone">
				<a href="goShop.do?phone_seq=${phone.phone_seq}">
					<div style="display: inline-block; padding-left: 5px; padding-right: 5px;">
						<div class="hpanel hred">
							<div class="panel-heading hbuilt" style="text-align: center; width: 350px;">
                                <strong>${phone.phone_name}</strong><small>(${phone.phone_model})</small>
							</div>
							<div class="panel-body" style="height: 440px; width: 350px; padding: 0px; text-align: center;">
								<img src="updata/phone_img/${phone.phone_img}" alt="폰이미지">
							</div>
							<div class="panel-footer" style="width: 350px;">
                                출고가 : ${phone.phone_price}원<br/>
                                공시지원금 : -${phone.publicsubsidy}원<br/>
                                추가지원금 : -${phone.privatesubsidy}원<br/>
                                단말대금 : <c:out value="${phone.phone_price-phone.publicsubsidy-phone.privatesubsidy}" />원
                            </div>
						</div>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</div>

