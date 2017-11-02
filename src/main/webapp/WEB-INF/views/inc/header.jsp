<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Header -->
<div id="">
	<div class="container-fluid">
	<table width="1200" height="10" align="center";>
		<tr>
			<td>
			<c:choose>
				<c:when test="${username eq null}">
					<p style="float:right;"><a href=../login.do>로그인</a></p>
					<p style="float:right;" > | </p>
					<p style="float:right;" ><a href="../login.do">회원가입</a></p>
				</c:when>
				<c:otherwise>
					<p style="float:right;"><a href=../logout>&nbsp;&nbsp;로그아웃</a></p>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${username ne null}">
					<p style="float:right;" >&nbsp;&nbsp;|</p>
					<p style="float:right;">${username }님 반갑습니다</p>
				</c:when>
			</c:choose>
			</td>
		</tr>
	</table>
    <table width="100%" height="30" bgcolor="#999999"></table>
                
    <table width="1200" height="100" align="center">
    	<tr>
        	<td width="300" align="left"><a href="../Main.do"><img src="../images/main_logo.png" /></a></td>
            <td width="600" align="center">
				<form role="search" class="" method="post" action="#">
					<div class="form-group" style="float: left">
						<table>
							<tr>
								<td style="width : 600px;">
									<input type="text" placeholder="검색어 입력" class="form-control" name="search">
								</td>
								<td>
									<input type="button" class="btn btn-default next" id="searchdata" value="Search">
								</td>
							</tr>
						</table>
					</div>
				</form>
				
			</td>
            <td width="300" align="right">
            	<div style="width: 120px; text-align: left;">
				채용정보 : ${gooinCount }개<br/>
				인재정보 : ${googicCount }명<br/>
				채용마감 : ${gooinEndCount}개
				</div>
			</td>
		</tr>
	</table>                    
	<table width="" align="center"  cellpadding="0" cellspacing="0" border="0">
		<tr>
        	<td width="" height=""><img src="../images/0_m_01.png" onMouseOver='this.src="../images/0_m_01.png"' onMouseOut='this.src="../images/0_m_01.png"' width="" height="" border="0"></td>
            <td width="" height=""><a href="../gooin/gooinMain.do"><img src="../images/m_02.png" onMouseOver='this.src="../images/m_up_02.png"' onMouseOut='this.src="../images/m_02.png"' width="" height="" border="0"></a></td>
            <td width="" height=""><a href="../googic/googicMain.do"><img src="../images/m_03.png" onMouseOver='this.src="../images/m_up_03.png"' onMouseOut='this.src="../images/m_03.png"' width="" height="" border="0"></a></td>
            <td width="" height=""><a href="../free/freeboardMain.do"><img src="../images/m_04.png" onMouseOver='this.src="../images/m_up_04.png"' onMouseOut='this.src="../images/m_04.png"' width="" height="" border="0"></a></td>
            <td width="" height=""><a href="../shop/shopMain.do"><img src="../images/m_05.png" onMouseOver='this.src="../images/m_up_05.png"' onMouseOut='this.src="../images/m_05.png"' width="" height="" border="0"></a></td>
            <td width="" height=""><a href="../gooin/gooinRegister.do"><img src="../images/m_06.png" onMouseOver='this.src="../images/m_up_06.png"' onMouseOut='this.src="../images/m_06.png"' width="" height="" border="0"></a></td>
            <td width="" height=""><a href="../googic/googicRegister.do"><img src="../images/m_07.png" onMouseOver='this.src="../images/m_up_07.png"' onMouseOut='this.src="../images/m_07.png"' width="" height="" border="0"></a></td>
            <td width="" height=""><a href="#"><img src="../images/m_08.png" onMouseOver='this.src="../images/m_up_08.png"' onMouseOut='this.src="../images/m_08.png"' width="" height="" border="0"></a></td>
            <td width="" height=""><a href="#"><img src="../images/m_09.png" onMouseOver='this.src="../images/m_up_09.png"' onMouseOut='this.src="../images/m_09.png"' width="" height="" border="0"></a></td>
            <td width="" height=""><img src="../images/0_m_01.png" onMouseOver='this.src="../images/0_m_01.png"' onMouseOut='this.src="../images/0_m_01.png"' width="" height="" border="0"></td>
		</tr>            
	</table>
  </div><!-- /.container-fluid -->
		

	
<!-- 		<div class="small-logo">
			<span class="text-primary">Phone & Job APP</span>
		</div>
		 -->
 
		

	</nav>
</div>
