<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2017-10-26
  Time: 오전 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="content animate-panel" style="width: 1200px; text-align:left; display:inline-block">
    <div class="row">
        <div class="col-lg-12">
            <div class="hpanel">
                <form action="" id="volunteerE" name="volunteerE" method="post">
                    <c:forEach var="gooinDetail" items="${volunteerData}">
                        <div class="panel-body">
                            <b style="font-size: 18px;">지원하신 내역입니다.</b>
                            <hr style="border: 1px solid #ddd;">
                            <table style="border: 1px solid #ddd;">
                                <tr style="border: 1px solid #ddd;">
                                    <td rowspan="3" style="border: 1px solid #ddd; width: 270px;">
                                        <img src="updata/picture/gooin/${gooinDetail.userpicture}" alt="매장 사진">
                                        <input type="hidden" value="${gooinDetail.userpicture}" id="userpicture" name="userpicture">
                                    </td>
                                    <td colspan="2" style="border: 1px solid #ddd; width: 270px; height: 60px;">회사명 : ${gooinDetail.comname }</td>
                                    <td style="border: 1px solid #ddd; width: 270px; height: 60px; text-align: center;">
                                        <c:if test="${gooinDetail.wanttel eq 'A001'}">
                                            <img src="images/kt1.jpg">
                                        </c:if>
                                        <c:if test="${gooinDetail.wanttel eq 'A002'}">
                                            <img src="images/sk1.jpg">
                                        </c:if>
                                        <c:if test="${gooinDetail.wanttel eq 'A003'}">
                                            <img src="images/lg1.jpg">
                                        </c:if>
                                        <input type="hidden" id="wanttel" class="form-control" name="wanttel" value="${gooinDetail.wanttel}" readonly="readonly">
                                    </td>
                                </tr>
                                <tr style="border: 1px solid #ddd;">
                                    <td style="border: 1px solid #ddd; width: 270px; height: 60px;">사업자번호 : ${gooinDetail.comidfyno }</td>
                                    <td style="border: 1px solid #ddd; width: 270px; height: 60px;">대표 번호 : ${gooinDetail.phone }</td>
                                    <td style="border: 1px solid #ddd; width: 270px; height: 60px;">
                                        <c:choose>
                                            <c:when test="${gooinDetail.homepage eq 'non' }">
                                                홈페이지 없음
                                            </c:when>
                                            <c:otherwise>
                                                홈페이지 :${gooinDetail.homepage }
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr style="border: 1px solid #ddd;">
                                    <td colspan="3" style="border: 1px solid #ddd; width: 270px; height: 60px;">회사 주소 : ${gooinDetail.adress }</td>
                                </tr>
                            </table>

                            <br/>
                            <table style="border: 1px solid #ddd; text-align: center;">
                                <tr style="border: 1px solid #ddd;">
                                    <td style="border: 1px solid #ddd; width: 204px;">모집 구분</td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">자격요건</td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">경력구분</td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">모집인원</td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">성별</td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">근무지</td>
                                </tr>
                                <tr style="border: 1px solid #ddd;">
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        <c:choose>
                                            <c:when test="${gooinDetail.wantjob eq 'cs'}">
                                                CS
                                                <input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="CS" readonly="readonly">
                                            </c:when>
                                            <c:when test="${gooinDetail.wantjob eq 'seller'}">
                                                판매사
                                                <input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="판매사" readonly="readonly">
                                            </c:when>
                                            <c:when test="${gooinDetail.wantjob eq 'csseller'}">
                                                판매사 / CS
                                                <input type="hidden" class="form-control"  name="wantjob" id="wantjob" value="판매사 / CS" readonly="readonly">
                                            </c:when>
                                        </c:choose>
                                    </td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        고용형태 : ${gooinDetail.jobstatus}<br/>
                                        학력 : ${gooinDetail.school}
                                        <input type="hidden" class="form-control" name="jobstatus" id="jobstatus" value="${gooinDetail.jobstatus }" readonly="readonly">
                                        <input type="hidden" class="form-control" name=school id="school" value="${gooinDetail.school}" readonly="readonly">

                                    </td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        <c:choose>
                                            <c:when test="${gooinDetail.wantstatus eq '01'}">신입</c:when>
                                            <c:when test="${gooinDetail.wantstatus eq '02'}">경력</c:when>
                                            <c:when test="${gooinDetail.wantstatus eq '03'}">무관</c:when>
                                            <c:otherwise>-</c:otherwise>
                                        </c:choose>

                                    </td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                            ${gooinDetail.wanthuman}명
                                        <input type="hidden" class="form-control" name="wanthuman" id="wanthuman" value="${gooinDetail.wanthuman}" readonly="readonly">
                                    </td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        <c:choose>
                                            <c:when test="${gooinDetail.gender eq 'male'}">
                                                남성
                                                <input type="hidden" class="form-control"  name="gender" id="gender" value="${gooinDetail.gender }" readonly="readonly">
                                            </c:when>
                                            <c:when test="${gooinDetail.gender eq 'female'}">
                                                여성
                                                <input type="hidden" class="form-control"  name="gender" id="gender" value="${gooinDetail.gender }" readonly="readonly">
                                            </c:when>
                                            <c:when test="${gooinDetail.gender eq 'allgender'}">
                                                남녀 무관
                                                <input type="hidden" class="form-control"  name="gender" id="gender" value="${gooinDetail.gender }" readonly="readonly">
                                            </c:when>
                                        </c:choose>
                                    </td>
                                    <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                            ${gooinDetail.location_addr1 } ${gooinDetail.location_addr2 }
                                        <input type="hidden" class="form-control"  name="location_addr1" id="location" value="${gooinDetail.location_addr1 }" readonly="readonly">
                                        <input type="hidden" class="form-control"  name="location_addr2" id="location" value="${gooinDetail.location_addr1 }" readonly="readonly">
                                    </td>
                                </tr>
                            </table>

                            <br/>

                            <table style="border: 1px solid #ddd; text-align: center;">
                            <tr style="border: 1px solid #ddd;">
                                <td style="border: 1px solid #ddd; width: 204px;">급여</td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">회사복지</td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">채용기간</td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">필요서류</td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">담당자</td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">담당자 연락처</td>
                            </tr>
                            <tr style="border: 1px solid #ddd;">
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                    <c:if test="${gooinDetail.salary_detail ne null }">
                                        <c:if test="${gooinDetail.salary_detail eq '01' }">연</c:if>
                                        <c:if test="${gooinDetail.salary_detail eq '02' }">월</c:if>
                                        ${gooinDetail.salary_min } ~ ${gooinDetail.salary_max }
                                    </c:if>
                                    <c:if test="${best.salary_detail eq null }">
                                        추후협의
                                    </c:if>
                                </td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        ${gooinDetail.wage }
                                </td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        ${gooinDetail.gooinweekstart } ~ ${gooinDetail.gooinweekend }
                                </td>

                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        ${gooinDetail.gooindocument }
                                </td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        ${gooinDetail.gooinman }
                                </td>
                                <td style="border: 1px solid #ddd; width: 204px; height: 60px;">
                                        ${gooinDetail.gooinmail }
                                </td>
                            </tr>
                        </table>

                            <br/>
                            ㅁ매장 위치
                            <hr style="border: 1px solid #ddd;">
                            !!다음맵 지도 API로 세팅 예정!!

                        </div>
                        <br/><br/><br/><br/>
                        <div class="text-center">
                            <input type="button" class="btn btn-default" onclick="javascript:goPage()" value="목록으로">
                        </div>
                    </c:forEach>
                </form>
            </div>
        </div>
    </div>
</div>
