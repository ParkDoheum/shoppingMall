<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%@ page import="java.util.*" %>
<%
	List<ProductVO> importList = (List<ProductVO>)request.getAttribute("importList");
	List<ProductVO> productList = (List<ProductVO>)request.getAttribute("productList");
%>   
<div>
	<h1>상품 입고</h1>
	<form id="frm" method="post" onsubmit="return submit()">
		<div>상품 : 
			<select name="i_product">
				<option value="">--선택--</option>
				<% for(ProductVO vo : productList)  { %>
				<option value="<%=vo.getI_product()%>"><%=vo.getNm() %></option>
				<% } %>
			</select>			
		</div>		
		<div><label>수량 : <input type="number" name="qty"></label></div>
		<input type="submit" value="입고">
	</form>
	<hr>
	<h1>입고 리스트</h1>
	<table style="width:100%;">
		<tr>
			<th style="width:70px">입고 번호</th>
			<th>상품명</th>			
			<th>금액</th>
			<th>수량</th>			
		</tr>
		<% for(ProductVO vo : importList) { %>
		<tr>
			<td><%=vo.getI_pi() %></td>			
			<td><%=vo.getNm() %></td>
			<td><%=vo.getPrice() %>원</td>
			<td><%=vo.getQty() %>개</td>			
		</tr>
		<% } %>
	</table>
</div>
<script>
	function submit() {
		if(frm.i_product.value.length == 0) {
			alert('제품을 선택해 주세요.')
			return false;
		}
		return true;
	}
</script>