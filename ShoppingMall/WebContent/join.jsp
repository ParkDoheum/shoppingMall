<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
<form id="frm" action="join" method="post" onsubmit="return join()">
	<div id="wrap">
		<h1 class="member">User Join</h1>
		<div class="form">
			<div class="form2">
				<div class="form3">
					<label for="id">아이디</label><input type="text" id="id" name="mid">
					<div class="clear"></div>
					<label for="pw">비밀번호</label><input type="password" id="pw" name="mpw">
					<div class="clear"></div>
					<label for="repw">비밀번호 확인</label><input type="password" id="repw">
					<div class="clear"></div>
					<label for="nm">이름</label><input type="text" id="nm", name="nm">
					<div class="clear"></div>
					<label for="sex">성별</label>
					여<input type="radio" id="nm" name="sex" value="1" selected>
					남<input type="radio" id="nm" name="sex" value="2">
					<div class="clear"></div>
					<br>
					<input type="submit" value="회원가입">
				</div>				
			</div>			
		</div>
	</div>
</form>
</div>
<script>
	function join() {
		var arrayEle = [frm.mid, frm.pw, frm.repw, frm.nm]
		var arrayMsg = ['아이디', '비밀번호', '확인비밀번호', '이름']		
		for(var i=0; i<arrayEle.length; i++) {
			if(arrayEle[i].value.length == 0) {
				alert(arrayMsg[i] + '을(를) 입력해 주세요')
				return false
			}
		}	
		
		if(frm.pw.value !== frm.repw.value) {
			alert('비밀번호를 확인해 주세요')
			return false;
		}
		return true		
	}	
</script>