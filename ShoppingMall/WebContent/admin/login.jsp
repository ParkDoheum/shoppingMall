<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>	
<div>
<form id="frm" action="login" method="post" onsubmit="return login()">
	<div id="wrap">
		<h1 class="member">Admin Login</h1>
		<div class="form">
			<div class="form2">
				<div class="form3">
					<label for="id">아이디</label><input type="text" id="id" name="mid" value="${mid}">
					<div class="clear"></div>
					<label for="pw">비밀번호</label><input type="password" id="pw" name="mpw" value="1212">
				</div>
				<input type="submit" value="관리자 로그인">
				<div class="clear"></div>				
			</div>
		</div>
	</div>	
	<% if(msg != null)  { %>
		<div>
			<%=msg %>
		</div>
	<% } %>
</form>
</div>
<script>
	function login() {
		if(frm.id.value.length == 0) {
			alert('아이디를 입력해 주세요.')
			frm.id.focus();
			return false;
		}
		if(frm.pw.value.length == 0) {
			alert('비밀번호를 입력해 주세요.')
			frm.id.focus();
			return false;
		}
		return true;
	}
</script>