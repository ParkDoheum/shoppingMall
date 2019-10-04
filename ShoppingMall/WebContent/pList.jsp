<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%
	List<ProductVO> list = (List<ProductVO>)request.getAttribute("list");

%>  
<h1>상품 리스트</h1> 
<div id="pListContainer">
	<% for(ProductVO vo : list) { %>
	<a href="pDetail?i_product=<%=vo.getI_product()%>">
	<div class="item">
		<div>
			<img src="<%=vo.getPic() %>">
		</div>
		<div class="content">
			<div class="title"><%=vo.getNm() %></div>
			<div class="price"><%=vo.getPrice() %>원</div>
		</div>
	</div>
	</a>
	<% } %>	
</div>