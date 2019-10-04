<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.shoppingmall.model.*" %>    
<%
	AdminVO loginAdmin = (AdminVO)session.getAttribute("loginAdmin");
	String css = (String) request.getAttribute("css");
	String view = (String) request.getAttribute("view");
	
	if(view == null) {
		response.sendRedirect("/ShoppingMall/err.jsp");
	}
	
	view += ".jsp";
	
	System.out.println("view : " + view);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<%
	if(css != null && !css.equals("")) {
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/" + css + ".css\">");
	}
%>
<script type="text/javascript" src="../js/common.js"></script>

</head>
<body>
	<div id="container">
		<header>
			<ul>				
				<% if(loginAdmin != null)  { %>
				<li><a href="pReg">상품 등록</a></li>
				<li><a href="pList">상품 리스트</a></li>
				<li><a href="pImport">상품 입고</a></li>
				<li><a href="pSaleDay">판매 현황(day)</a></li>
				<li><a href="pSaleMon">판매 현황(mon)</a></li>
				<li><a href="pSaleYear">판매 현황(year)</a></li>
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
	<script>
	Date.prototype.toDateInputValue = (function() {
	    var local = new Date(this);
	    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
	    return local.toJSON().slice(0,10);
	});
	</script>
</body>
</html>