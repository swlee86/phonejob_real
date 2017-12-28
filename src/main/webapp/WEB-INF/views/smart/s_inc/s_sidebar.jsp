<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2017-11-05
  Time: 오후 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside id="menu">
    <div id="navigation">
        <ul class="nav" id="side-menu">
            <li>
                <a href="../s_Main.do"> <span class="nav-label">메인으로</span></a>
            </li>
            <li>
                <a href="#"><span class="nav-label">구인관련</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="../gooin/gooinMain.do">구인정보</a></li>
                    <li><a href="../gooin/gooinRegister.do">구인등록</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><span class="nav-label">구직관련</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="../googic/googicMain.do">구직정보</a></li>
                    <li><a href="../googic/googicRegister.do">구직등록</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><span class="nav-label">커뮤니티</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="../commu/s_commuMain.do">커뮤니티메인</a></li>
                    <li><a href="../notice/noticeBoardMain.do">공지사항</a></li>
                    <li><a href="../free/freeBoardMain.do">자유게시판</a></li>
                </ul>
            </li>
            <li>
                <a href="../shop/s_shopMain.do"> <span class="nav-label">샵</span></a>
            </li>
            <li>
                <a href="#"><span class="nav-label">마이메뉴</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="#">나의정보</a></li>
                    <li><a href="#">구직신청리스트</a></li>
                </ul>
            </li>
            <li>
                <a href="#"> <span class="nav-label">서비스안내</span></a>
            </li>
        </ul>
    </div>
</aside>