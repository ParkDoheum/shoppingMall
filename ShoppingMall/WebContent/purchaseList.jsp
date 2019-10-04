<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%
	List<ProductVO> list = (List<ProductVO>)request.getAttribute("list");
%>  
<style>
	#purchaseList {
		padding: 15px;
	}
</style>
 
<div id="purchaseList">
	<h1>구매 리스트</h1>
	<table style="width:100%;">
		<tr>
			<th style="width:70px">구매<br>번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>금액</th>
			<th>수량</th>			
			<th>구매일</th>
			<th>비고</th>
		</tr>
		<% for(ProductVO vo : list) { %>
		<tr>
			<td><%=vo.getI_purchase() %></td>
			<td><img src="<%=vo.getPic() %>" style="width:100px"></td>
			<td><%=vo.getNm() %></td>
			<td>단가 <%=vo.getPrice() %><br>
				구매 금액 <%=vo.getPurchase_price() %>원
			</td>
			<td>현재고 <%=vo.getQty() %>개<br>
				구매수량 <%=vo.getPurchase_qty() %> 개
			</td>			
			<td><%=vo.getR_dt() %></td>
			<td>
			<% if(vo.getYn_sale() == 1 && vo.getQty() > 0) { %>
				<a href="pDetail?i_product=<%=vo.getI_product()%>"><button>상품보기</button></a>
			<% } %>
			</td>
		</tr>
		<% } %>
	</table>		
</div>