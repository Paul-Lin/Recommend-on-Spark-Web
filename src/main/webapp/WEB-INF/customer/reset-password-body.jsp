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
	margin-top:-100px;
	
}

.reset-password {
	width: 400px;
	margin-top:100px;
}

.update-info-btn {
	float: right;
}
</style>
<div class="container reset-password">
	<div id="updateSuccessNotice"
		class="alert alert-warning text-center notice">
		<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>修改成功</strong>
	</div>
	<div id="updateFailedNotice"
		class="alert alert-warning text-center notice">
		<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>修改失败</strong>
	</div>
	<div id="passwordNotice"
		class="alert alert-warning text-center notice">
		<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>两次输入密码必须一致</strong>
	</div>
	<div class="form-group">
		<label for="inputNewPass">新密码</label> <input type="password"
			class="form-control" id="inputNewPass" placeholder="新密码">
	</div>
	<div class="form-group">
		<label for="inputNewPassAgain">再次输入新密码</label> <input type="password"
			class="form-control" id="inputNewPassAgain" placeholder="再次输入新密码">
	</div>
	<button type="button" class="btn btn-default update-info-btn"
		onclick="resetPassword()">更改密码</button>
</div>
<script>
	function closeUpdateNotice() {
		$('#updateSuccessNotice').hide();
		$('#updateFailedNotice').hide();
		$('#passwordNotice').hide();
	}
	function resetPassword() {
		if($('#inputNewPass').val()==$('#inputNewPassAgain').val()){
			$.ajax({
				type : 'post',
				url : $('#host').val() + '/user/update-password.action',
				data : {
					pass : $('#inputNewPass').val()
				},
				success : function(data) {
					if (data.success) {
						$('#updateSuccessNotice').show();
						setTimeout('closeUpdateNotice()', 3000);
					} else {
						$('#updateFailedNotice').show();
						setTimeout('closeUpdateNotice()', 3000);
					}
				}
			})
		}else{
			$('#passwordNotice').show();
			setTimeout('closeUpdateNotice()', 3000);

		}
		
	}
</script>