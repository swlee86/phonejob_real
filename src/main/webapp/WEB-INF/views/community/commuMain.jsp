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
    <c:choose>]
        <c:when test="${noticelist ne null}">
            <c:forEach var="noticeList" items="${noticelist}">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-10 forum-heading">
                            <span class="label label-success pull-left">Special</span>
                            <a href="../notice/noticeDetail.do?free_no=${noticelist.free_no}" >
                                <h4>${noticelist.title}</h4>
                            </a>
                        </div>
                        <div class="col-md-1 forum-info">
                            <span class="number">  ${noticelist.hit} </span>
                            <small>Views</small>
                        </div>
                        <div class="col-md-1 forum-info">
                            <span class="number"> ${noticelist.re_count} </span>
                            <small>Posts</small>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-10 forum-heading">
                        <span class="label label-success pull-left">Special</span>
                            <h4>등록된 공지사항이 없습니다.</h4>
                        </a>
                    </div>
                    <div class="col-md-1 forum-info">
                        <span class="number">  ${noticelist.hit} </span>
                        <small>Views</small>
                    </div>
                    <div class="col-md-1 forum-info">
                        <span class="number"> ${noticelist.re_count} </span>
                        <small>Posts</small>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>

</div>

<div class="hpanel forum-box">

    <div class="panel-heading">
                <span class="pull-right">
                    <i class="fa fa-clock-o"> </i> 마지막게시글: 11.10.2015, 08:10 am
                </span>
        <a href="../free/freeboardMain.do"> 자유게시판</a>
    </div>

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
</div>

<div class="hpanel forum-box">

    <div class="panel-heading">
                <span class="pull-right">
                    <i class="fa fa-clock-o"> </i> Last modification: 01.03.2015, 11:10 am
                </span>
        Aenean vitae
    </div>

    <div class="panel-body">
        <div class="row">
            <div class="col-md-10 forum-heading">
                <a href="forum_details.html" >
                <h4>Pellentesque rhoncus </h4>
                </a>
                <div class="desc">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. </div>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 1200 </span>
                <small>Views</small>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 457 </span>
                <small>Posts</small>
            </div>
        </div>
    </div>

    <div class="panel-body">
        <div class="row">
            <div class="col-md-10 forum-heading">
                <a href="forum_details.html" ><h4>Sed iaculis vel libero</h4></a>
                <div class="desc">Nam sollicitudin quam non arcu faucibus, id mattis lacus interdum. Nam eleifend sodales ante sed pharetra. Integer cursus dapibus fringilla. Maecenas volutpat dapibus vestibulum. Mauris ullamcorper nibh nec consectetur fermentum. </div>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 460 </span>
                <small>Views</small>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 280 </span>
                <small>Posts</small>
            </div>
        </div>
    </div>

    <div class="panel-body">
        <div class="row">
            <div class="col-md-10 forum-heading">
                <span class="label label-info pull-left">Latest</span>
                <a href="forum_details.html" ><h4>Mauris fermentum </h4></a>
                <div class="desc">Aenean ornare lacus quis blandit posuere. Nulla porta lectus facilisis justo pharetra, nec varius felis sollicitudin.</div>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 870 </span>
                <small>Views</small>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 621 </span>
                <small>Posts</small>
            </div>
        </div>
    </div>

    <div class="panel-body">
        <div class="row">
            <div class="col-md-10 forum-heading">
                <a href="forum_details.html" ><h4>Vivamus non lacus diam.</h4></a>
                <div class="desc">Aenean quis nulla finibus, lobortis nunc sit amet, tempor ligula. Nunc pharetra, mauris aliquet mollis semper, libero eros mattis eros, sit amet semper elit libero in leo. In porttitor quam sit amet felis congue aliquam. Ut commodo aliquam consectetur. In hac habitasse platea dictumst.</div>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 278 </span>
                <small>Views</small>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 455 </span>
                <small>Posts</small>
            </div>
        </div>
    </div>

    <div class="panel-body">
        <div class="row">
            <div class="col-md-10 forum-heading">
                <a href="forum_details.html" ><h4>Donec lacus dolor</h4></a>
                <div class="desc">Nullam ipsum diam, tempus at pretium id, posuere rutrum urna. Sed et eros vitae magna condimentum semper sed vel enim. </div>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 780 </span>
                <small>Views</small>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 120 </span>
                <small>Posts</small>
            </div>
        </div>
    </div>

    <div class="panel-body">
        <div class="row">
            <div class="col-md-10 forum-heading">
                <a href="forum_details.html" ><h4>Fusce sagittis</h4></a>
                <div class="desc">Duis sed enim velit. In auctor porta lorem, nec viverra risus faucibus at. Nulla sagittis eros id nibh vulputate, id malesuada nunc ultrices.</div>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 824 </span>
                <small>Views</small>
            </div>
            <div class="col-md-1 forum-info">
                <span class="number"> 266 </span>
                <small>Posts</small>
            </div>
        </div>
    </div>

</div>