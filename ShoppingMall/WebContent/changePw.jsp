<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>    
<div id="subMenuContainer">
	<jsp:include page="subMenuMypage.jsp"></jsp:include>
	<div id="section2">		
		<form id="frm" action="changePw" method="post" onsubmit="return change()">
		<div id="wrap">
			<h1 class="member">비밀번호 변경</h1>
			<div class="form">
				<div class="form2">
					<div class="form3">
						<label for="currentPw">현재 비밀번호</label><input type="password" name="currentPw">
						<div class="clear"></div>
						<label for="newPw">변경 비밀번호</label><input type="password" name="newPw">
						<div class="clear"></div>
						<label for="newPwRe">변경 비밀번호 확인</label><input type="password" name="newPwRe">
						<div class="clear"></div>
					</div>
					<input type="submit" value="비밀번호 수정">
					<div class="clear"></div>
				</div>
			</div>
		</div>
		</form>
		<% if(msg != null)  { %>
			<div>
				<%=msg %>
			</div>
		<% } %>
	
	</div>
</div>
<script>
	function change() {
		if(frm.currentPw.value.length == 0) {
			alert('현재 비밀번호를 작성해 주세요.')
			return false
		} else if(frm.newPw.value.length == 0) {
			alert('변경 비밀번호를 작성해 주세요.')
			return false
		} else if(frm.newPwRe.value.length == 0) {
			alert('변경 비밀번호 확인을 작성해 주세요.')
			return false
		} else if(frm.newPw.value != frm.newPwRe.value) {
			alert('변경 비밀번호와 변경 비밀번호 확인 값이 다릅니다.')
			return false
		}
		return true;
	}
</script>