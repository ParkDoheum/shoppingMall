<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.shoppingmall.model.*"  %>   
<div>
	<h1>상품 등록</h1>
	<form id="frm" action="pReg" method="post" onsubmit="return submit()">
		<div>상품번호 : <input type="number" name="i_product" value="${i_product}" readonly></div>
		<div><label>제품명 : <input type="text" name="nm" value=""></label></div>
		<div><label>금액 : <input type="number" name="price" value=""></label></div>
		<div><label>사진 : <input type="text" name="pic" value=""></label>
		(이미지 업로드 X, 웹 이미지 주소)
		</div>
		<div><label>설명
					<textarea name="info"></textarea>
			</label>			
		</div>
		<input type="submit" value="등록">
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