<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%
	List<ProductVO> pList = (List<ProductVO>)request.getAttribute("pList");
	List<StatisticsVO> dataList = (List<StatisticsVO>)request.getAttribute("dataList");

	int selYear = (int)(request.getAttribute("selYear") == null ? 2019 : request.getAttribute("selYear"));
	int selMon = (int)(request.getAttribute("selMon") == null ? 1 : request.getAttribute("selMon"));		
	int i_product = (int)(request.getAttribute("i_product") == null ? 0 : request.getAttribute("i_product")); 
	
	int sYear = 2019;	
%>   
<div>
	<h1>월별 상품 판매 현황</h1>
	<div>
		<form id="frm" action="pSaleMon" method="get">
			연도 : <select name="selYear">
			<% for(int i=sYear; i<(sYear + 5); i++)  { %>
				<option value="<%=i%>" <%= selYear == i ? "selected" : "" %>><%=i%>년</option>
			<% } %>
			</select>
			
			월 : <select name="selMon">
			<% for(int i=1; i<=12; i++)  { %>
				<option value="<%=i%>" <%= selMon == i ? "selected" : "" %>><%=i%>월</option>
			<% } %>		
			</select>		
			
			상품 : <select name="i_product">
					<option value="0">-- 전체 -- </option>
				<% for(ProductVO item : pList)  { %>
					<option value="<%=item.getI_product()%>" <%= item.getI_product() == i_product ? "selected" : "" %>><%=item.getNm() %></option>
				<% } %>		
			</select>
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
		<% if(dataList != null && dataList.size() > 0) { %>
			<% for(StatisticsVO vo : dataList) { %>	
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