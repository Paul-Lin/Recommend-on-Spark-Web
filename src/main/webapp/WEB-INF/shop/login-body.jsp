<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String host = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<style>
.notice {
	position: absolute;
	z-index: 1000px;
	width: 380px;
	display: none;
	margin-top: -100px;
}

.shop-login {
	width: 400px;
	margin-top: 100px;
}

.login-info-btn {
	float: right;
	margin-left:20px;
}
</style>
<div class="container shop-login">
	<form action="<%=host+"/shop/menu-manage.action" %>">
		<div class="form-group">
			<label for="inputNickname">昵称</label> <input type="text"
				class="form-control" name="nickname" id="inputNickname" placeholder="昵称">
		</div>
		<div class="form-group">
			<label for="inputPass">密码</label> <input type="password"
				class="form-control" name="password" id="inputPass" placeholder="密码">
		</div>
		
		<button type="submit" class="btn btn-default login-info-btn"
			>登陆</button>
		<button type="button" onclick=""class="btn btn-default login-info-btn"
			>注册</button>
	</form>

</div>
<script>
	function registerPage(){
		
	}
</script>