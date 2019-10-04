<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.shoppingmall.model.*" %>    
<%
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
	String css = (String) request.getAttribute("css");
	String view = (String) request.getAttribute("view");
	
	if(view == null) {
		response.sendRedirect("err.jsp");
	}
	
	view += ".jsp";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<%
	if(css != null && !css.equals("")) {
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/" + css + ".css\">");
	}
%>
<script type="text/javascript" src="js/common.js"></script>

</head>
<body>
	<div id="container">
		<header>
			<ul>
				<% if(loginMember == null)  { %>
				<li><a href="login">로그인</a></li>
				<% } else { %>
				<li><a href="pList">상품리스트</a></li>
				<li><a href="purchaseList">구매리스트</a></li>
				<li><a href="basket">마이페이지</a></li>				
				<li><a href="logout">로그아웃</a></li>
				<% }  %>				
			</ul>
		</header>
		<section>
			<jsp:include page="<%=view %>"></jsp:include>
		</section>
		<footer>
			Copyright&copy; 한국쇼핑몰에 오신걸 환영합니다.
		</footer>
	</div>
</body>
</html>