<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>
<%
	ProductVO vo = (ProductVO)request.getAttribute("vo");
%>   
<div>
	<h1>상품 수정</h1>
	<form id="frm" method="post" onsubmit="return submit()">
		<div><input type="hidden" name="i_product" value="<%=vo.getI_product() %>"></div>
		<div><label>제품명 : <input type="text" name="nm" value="<%=vo.getNm() %>"></label></div>
		<div><label>금액 : <input type="number" name="price" value="<%=vo.getPrice() %>"></label></div>
		<div><label>사진 : <input type="text" name="pic" value="<%=vo.getPic() %>"></label>
		(이미지 업로드 X, 웹 이미지 주소)
		</div>
		<div><label>판매여부 : 
					<select name="yn_sale">
						<option value="0" <%= vo.getYn_sale() == 0 ? "selected" : "" %>>판매정지</option>
						<option value="1" <%= vo.getYn_sale() == 1 ? "selected" : "" %>>판매중</option>
					</select> 
			 </label>
		</div>
		<div>
			<label>설명 :
					<textarea name="info"><%=vo.getInfo() %></textarea>
			</label>
		</div>
		<input type="submit" value="수정">
	</form>
</div>
<script>
	function submit() {
		if(frm.nm.value.length == 0) {
			alert('제품명을 입력해 주세요.')
			return false;
		}
		return true;
	}
</script>