<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%
	List<ProductVO> list = (List<ProductVO>)request.getAttribute("list");
%>   
<div id="subMenuContainer">
	<jsp:include page="subMenuMypage.jsp"></jsp:include>
	<div id="section2">
		<h1>장바구니</h1>
		<table style="width:100%;">
		<tr>
			<th style="width:70px">장바구니 번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>금액</th>
			<th>수량</th>			
			<th>비고</th>
		</tr>
		<% for(ProductVO vo : list) { %>
		<tr>
			<td><%=vo.getI_basket() %></td>
			<td><img src="<%=vo.getPic() %>" style="width:100px"></td>
			<td><%=vo.getNm() %></td>
			<td>단가 <%=vo.getPrice() %><br>
				구매 금액 <%=vo.getPurchase_price() %>원
			</td>
			<td>현재고 <%=vo.getQty() %>개<br>
				구매수량 <%=vo.getPurchase_qty() %> 개
			</td>			
			<td>&nbsp;</td>
		</tr>
		<% } %>
	</table>		
	</div>
</div>

