<%--
  Created by IntelliJ IDEA.
  User: 이상원
  Date: 2017-11-03
  Time: 오후 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="hpanel forum-box">

    <div class="panel-heading">
                <span class="pull-right">
                    <i class="fa fa-clock-o"> </i> Last modification: 10.12.2015, 10:22 am
                </span>
        <a href="../notice/noticeBoardMain.do"> 공지사항</a>
    </div>
    <%--
    <c:choose>
            <c:when test="${noticelist ne null}">--%>
            <c:forEach var="noticeList" items="${noticelist}">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10 forum-heading">
                            <span class="label label-success pull-left">Special</span>
                            <a href="../notice/noticeDetail.do?notice_no=${noticeList.notice_no}" >
                                <h4>${noticeList.title}</h4>
                            </a>
                        </div>
                        <div class="col-md-1 forum-info">
                            <span class="number">  ${noticeList.hit} </span>
                            <small>Views</small>
                        </div>
                        <div class="col-md-1 forum-info">
                            <span class="number"> ${noticeList.re_count} </span>
                            <small>Posts</small>
                        </div>
                    </div>
                </div>
            </c:forEach>
   <%--
        </c:when>
        <c:otherwise>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-10 forum-heading">
                        <span class="label label-success pull-left">Special</span>
                            <h4>등록된 공지사항이 없습니다.</h4>
                        </a>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
--%>
</div>

<div class="hpanel forum-box">

    <div class="panel-heading">
                <span class="pull-right">
                    <i class="fa fa-clock-o"> </i> 마지막게시글: 11.10.2015, 08:10 am
                </span>
        <a href="../free/freeboardMain.do"> 자유게시판</a>
    </div>
    <%--
    <c:choose>
        <c:when test="${list ne null}">
     --%>
            <c:forEach var="freelist" items="${list}">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10 forum-heading">
                            <span class="label label-warning pull-left">New</span>
                            <a href="../free/freeDetail.do?free_no=${freelist.free_no}" >
                                <h4>${freelist.title}</h4>
                            </a>
                        </div>
                        <div class="col-md-1 forum-info">
                            <span class="number"> ${freelist.hit} </span>
                            <small>Views</small>
                        </div>
                        <div class="col-md-1 forum-info">
                            <span class="number"> ${freelist.re_count} </span>
                            <small>Comments</small>
                        </div>
                    </div>
                </div>
            </c:forEach>
<%--
        </c:when>
        <c:otherwise>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-10 forum-heading">
                        <span class="label label-success pull-left">Special</span>
                        <h4>등록된 글이 없습니다.</h4>
                        </a>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
--%>

</div>