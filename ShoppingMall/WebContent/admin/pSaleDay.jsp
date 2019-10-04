<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%
	
	List<StatisticsVO> list = (List<StatisticsVO>)request.getAttribute("list");

	String s_dt = (String)request.getAttribute("s_dt");
	String e_dt = (String)request.getAttribute("e_dt");
	
	if(s_dt == null) {
		s_dt = "";
	}
	
	if(e_dt == null) {
		e_dt = "";
	}
%>   
<div>
	<h1>일별 판매 현황</h1>
	<div>
		<form id="frm" action="pSaleDay" method="get" onsubmit="return chkSubmit()">
			날짜 : <input type="date" name="s_dt" value="<%=s_dt%>"> ~ <input type="date" name="e_dt" value="<%=e_dt%>"> 
			<input type="submit" value="검색">
		</form>
	</div>
	<br><br>
	<table style="width:100%;">
		<tr>
			<th>날짜</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>단가</th>			
			<th>총 수량</th>
				
			<th>총 금액</th>		
			
		</tr>
		<% if(list != null && list.size() > 0) { %>
		
			<% for(StatisticsVO vo : list) { %>
			<tr>
				<td><%=vo.getR_dt() %></td>
				<td><img src="<%=vo.getPic() %>" style="width:100px"></td>
				<td><%=vo.getNm() %></td>
				<td><%=vo.getPrice() %>원</td>
				<td><%=vo.getQty() %>개</td>
				
				<td><%=vo.getTotalPrice() %>원</td>				
			</tr>
			<% } %>
		<% } else { %>
			<tr>
				<td colspan="7">내용 없음</td>
			</tr>
		<% }  %>
	</table>
</div>
<script>
	window.onload = function() {
		if(frm.s_dt.value == '') {
			var today = new Date()
			frm.s_dt.value = today.toDateInputValue();
			frm.e_dt.value = today.toDateInputValue();	
		}
	}
	
	function chkSubmit() {
		if(frm.e_dt.value < frm.s_dt.value) {
			alert('시작 날짜가 마지막 날짜보다 늦을 수 없습니다.')
			return false
		} else if(frm.e_dt.value == '' || frm.s_dt.value == '') {
			alert('날짜를 입력해 주세요.')
			return false
		}
		return true
	}
</script>