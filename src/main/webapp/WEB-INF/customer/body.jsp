<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String host = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<style>
.update-info-btn {
	float: right;
}

.left-personal {
	width: 200px;
	height: 400px;
	float: left;
	margin-left: 60px;
	margin-top: 20px;
}

.right-personal {
	width: 400px;
	height: 400px;
	float: right;
	margin-right: 200px;
	margin-top: 20px;
}

.notice {
	position: absolute;
	z-index: 1000px;
	width: 500px;
	margin-left: 300px;
	display: none;
}
</style>
<div class="container">
	<div id="updateSuccessNotice"
		class="alert alert-warning text-center notice">
		<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>修改成功</strong>
	</div>
	<div id="updateFailedNotice"
		class="alert alert-warning text-center notice">
		<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>修改失败</strong>
	</div>
	<div class="left-personal">
		<img src="${customer.avatar }" class="img-rounded">
	</div>
	<div class="right-personal">
		<form>
			<div class="form-group">
				<label for="inputEmail">邮箱</label> <input type="email"
					class="form-control" id="inputEmail"
					placeholder="${customer.email }">
			</div>
			<div class="form-group">
				<label for="inputNickname">昵称</label> <input type="text"
					class="form-control" id="inputNickname"
					placeholder="${customer.nickname }">
			</div>
			<div class="form-group">
				<label for="inputSignnature">个性签名</label> <input type="text"
					class="form-control" id="inputSignnature"
					placeholder="${customer.signnature }">
			</div>
			<div class="form-group">
				<label for="inputLiveaddress">居住地</label> <input type="text"
					class="form-control" id="inputLiveaddress"
					placeholder="${customer.liveAddress }">
			</div>
			<div class="form-group">
				<label for="selectSex">性别</label> <select class="form-control"
					id="selectSex">
					<option value="0">女</option>
					<option selected="selected" value="1">男</option>
					<option value="2">未知</option>
				</select>
			</div>
			<a href="<%=host+"/user/reset-password.action" %>" class="btn btn-default">修改密码</a>
			<button type="button" class="btn btn-default update-info-btn"
				onclick="updateCustomerInfo()">修改</button>
		</form>

	</div>
</div>

<script>
	function closeUpdateNotice() {
		$('#updateSuccessNotice').hide();
		$('#updateFailedNotice').hide();
	}
	function updateCustomerInfo() {
		$.ajax({
			type : 'post',
			url : $('#host').val() + '/user/update.action',
			data : {
				nickname : $('#inputNickname').val(),
				email : $('#inputEmail').val(),
				signnature : $('#inputSignnature').val(),
				liveAddress : $('#inputLiveaddress').val(),
				sex : $('#selectSex option:selected').val()
			},
			success : function(data) {
				if (data.success) {
					$('#updateSuccessNotice').show();
					setTimeout('closeUpdateNotice()', 3000);
				}else{
					$('#updateFailedNotice').show();
					setTimeout('closeUpdateNotice()', 3000);
				}
			}
		});
	}
	function toRecommend(){
		$.ajax({
			type:'post',
			url:$('#host').val+'',
			data:{
				id:$('#').val()
			},
			success:function(data){
				
			}
		});
	}
</script>