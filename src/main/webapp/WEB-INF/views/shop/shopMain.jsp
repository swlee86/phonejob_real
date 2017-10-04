<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content animate-panel"	style="width: 1200px; text-align: left; display: inline-block">
		<div class="row">&nbsp;</div>

		<h3>
			<span style="font-family: Arial"><b>추천하는 단말기</b></span>
		</h3>
		<hr style="border: 1px solid #ddd;">
		<div class="row">
			<c:forEach items="${result}" var="phone">
				<a href="goShop.do?phone_seq=${phone.phone_seq}">
					<div style="width: 283px; display: inline-block; padding-left: 15px; padding-right: 15px;">
						<div class="hpanel hred">
							<div class="panel-heading hbuilt" style="text-align: center;">
								<strong>${phone.phone_name}</strong>(${phone.phone_model})
							</div>
							<div class="panel-body" style="height: 440px; width: 506px;">
								<img src="updata/phone_img/${phone.phone_img}" alt="폰이미지">
							</div>
							<div class="panel-footer">-</div>
						</div>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</div>

