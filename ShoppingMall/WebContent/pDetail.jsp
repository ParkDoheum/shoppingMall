<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%
	ProductVO vo = (ProductVO)request.getAttribute("vo");
%>   
<div id="pDetailContainer">
	<h1>상품 정보</h1>
	<div>제품명 : <%=vo.getNm() %></div>
	<div><img src="<%=vo.getPic() %>"></div>
	
	<div>금액 : <%=vo.getPrice() %></div>
	<div>수량 : <%=vo.getQty() %></div>
	<div>정보 : <%=vo.getInfo() %></div>
	<hr>	
	<div>
		수량: 
		<button class="btn" onclick="clkQtyDi(1)">
		&nbsp;&nbsp;-&nbsp;&nbsp;
		</button>&nbsp;&nbsp;
		<input type="text" id="qty" name="qty" value="0" style="width:50px;">
		&nbsp;&nbsp;
		<button class="btn" onclick="clkQtyDi(2)">
		&nbsp;&nbsp;+&nbsp;&nbsp;
		</button>
		<br>
		<button onclick="proc(1)">장바구니에 담기</button>
		<button onclick="proc(2)">바로 구매</button>
		<form id="frm" method="post" action="pDetail">
			<input type="hidden" name="i_product" value="<%= vo.getI_product() %>">
			<input type="hidden" name="type">
			<input type="hidden" name="qty" value="0">
			<input type="hidden" name="price" value="0">
		</form>
	</div>
</div>
<script>
	function proc(type) {
		var inputQty = document.getElementById('qty');
		var qty = parseInt(inputQty.value)
		var price = parseInt('<%=vo.getPrice()%>');
		
		
		if(qty < 1) {
			alert('제품 수량은 0 이상이어야 합니다.')
			return
		}
		
		frm.type.value = type
		frm.qty.value = qty
		frm.price.value = qty * price
		frm.submit()
	}
	
	function clkQtyDi(type) {
		var inputQty = document.getElementById('qty');
		var qty = parseInt(inputQty.value)
		
		if(type == 1) { //감소
			if(qty != 0) {
				qty -= 1;
				inputQty.value = qty
			}
		} else if(type == 2) {
			qty += 1
			inputQty.value = qty
		}		
	}
</script>