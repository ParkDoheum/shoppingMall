<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%
	List<ProductVO> list = (List<ProductVO>)request.getAttribute("list");	
	int currentPage = (int)request.getAttribute("currentPage");
	int totalPages = (int)request.getAttribute("totalPages");
	String search = (String)request.getAttribute("search");
%>   
<style>
	.currentPage {
		font-weight: bold;
		color: red;
	}
</style>
<div>
	<h1>상품 리스트</h1>
	<br>
	<div style="height:80px;">
		<form action="pList" method="get">
			상품명 검색 <input type="text" name="search" value="<%=search %>">
			<input type="hidden" name="currentPage" value="1">
			<input type="submit" value="검색">
		</form>
	</div>
	<table style="width:100%;">
		<tr>
			<th style="width:70px">상품 번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>금액</th>
			<th>수량</th>
			<th>판매여부</th>
			<th>비고</th>
		</tr>
		<% for(ProductVO vo : list) { %>
		<tr>
			<td><%=vo.getI_product() %></td>
			<td><img src="<%=vo.getPic() %>" style="width:100px"></td>
			<td><%=vo.getNm() %></td>
			<td><%=vo.getPrice() %>원</td>
			<td><%=vo.getQty() %>개</td>
			<td><%=vo.getYn_sale() == 1 ? "판매중" : "판매정지" %></td>
			<td><a href="pMod?i_product=<%=vo.getI_product()%>"><button>수정</button></a></td>
		</tr>
		<% } %>
	</table>
	<div>
		<% for(int i=1; i<=totalPages; i++) { %>
			<a href="pList?currentPage=<%=i %>&search=<%=search %>">				
				<span class=" <%= i == currentPage ? "currentPage" : "" %>">
					<%=i %>			
				</span>			
			</a>&nbsp;&nbsp;
		<% } %>
	</div>
</div>