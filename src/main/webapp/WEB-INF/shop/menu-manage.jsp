<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.moon.enums.ShopMenu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String host = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="keywords" content="美食社交,美食商店,Moon Plan,收藏,精选" />
<meta name="description" content="Moon Plan 是一款专注于美食发现,分享,购买的软件产品." />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<title>${title}</title>
<link
	href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/img/index.png"
	rel="shortcut icon" type="image/vnd.microsoft.icon">

<script
	src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/fileinput.js"
	type="text/javascript"></script>
<script
	src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
<link
	href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<link
	href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/fileinput.css"
	type="text/css" rel="stylesheet" />
<link
	href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/fileinput.min.css"
	type="text/css" rel="stylesheet" />
</head>
<input type="hidden" id="host" value="<%=host%>" />
<style>
.menu-insert {
	width: 600px;
	margin: 0 auto;
	display: none;
}

.btn-insert {
	float: right;
}

.menu-list {
	margin-top: 30px;
}

.menu-search {
	width: 300px;
}
</style>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=host%>"> <img alt="Brand"
					src="<%=host + "/img/index.png"%>" width="50px" height="50px"
					style="margin: -10px;">
				</a>
			</div>
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=host%>">Moon Plan</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="<%=host%>/shop/index.action?menu=6">菜式 <span
							class="sr-only">(current)</span></a></li>
					<li><a href="<%=host%>/shop/index.action?menu=5">账单 </a></li>
					<li><a href="<%=host%>/shop/index.action?menu=3">图片墙</a></li>
					<li><a href="<%=host%>/shop/index.action?menu=2">评论墙</a></li>
					<li><a href="<%=host%>/shop/index.action?menu=4">公告</a></li>
					<li><a href="<%=host%>/shop/index.action?menu=7">设置 <span
							class="sr-only">(current)</span></a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="美食">
					</div>
					<button type="submit" class="btn btn-default">奔月</button>
				</form>

			</div>
		</div>
	</nav>
	<div class="container">
		<div>
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#myModal">增加菜单</button>
			<form action="<%=host + "/shopmenu/list.action"%>"
				class="form-horizontal" style="float: right;">
				<div class="form-group">
					<div class="col-sm-10 menu-search">
						<input type="text" class="form-control" id="inputMenuSearch"
							placeholder="菜单名">
					</div>
					<button type="button" class="btn btn-info">查询菜单</button>

				</div>
			</form>
		</div>
		<c:forEach var="shopmenu" items="${shopMenuDto}">
			<div class="menu-list">
				<input type="text" style="display: none;"></input>
				<div class="form-group">
					<img src="${shopmenu.illustration}" class="img-thumbnail"
						style="height: 140px;"></img>
					<h2>${shopmenu.name}</h2>
				</div>
				<p>${shopmenu.intro}</p>
				<div style="float: right;">
					<button type="button" class="btn btn-info" data-toggle="modal"
						data-target="#updateModal" onclick="queryModal(${shopmenu.id})">修改</button>
					<button type="button" class="btn btn-info" data-toggle="modal"
						data-target="#deleteModal" onclick="queryModal(${shopmenu.id })">删除</button>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
<!-- insert modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">增加菜单</h4>
			</div>
			<form action="<%=host%>/shop/menu-insert.action" method="post"
				enctype="multipart/form-data">
				<div class="modal-body">
					<div class="form-group">
						<label for="inputMenuName">菜单名称</label> <input type="text"
							class="form-control" name="inputMenuName" id="inputMenuName"
							placeholder="菜单名称">
					</div>
					<div class="form-group">
						<label for="inputMenuIntro">菜单介绍</label>
						<textarea class="form-control" name="inputMenuIntro"
							id="inputMenuIntro" placeholder="菜单介绍" rows="3"></textarea>
					</div>
					<div class="form-group">
						<label for="inputFileUpload">图片上传</label> <input type="file"
							name="file">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">关闭
					</button>
					<input type="submit" class="btn btn-info btn-insert" value="增加菜单" />
				</div>
			</form>
		</div>
	</div>
</div>
<!-- delete modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">删除菜单</h4>
			</div>
			<div class="modal-body">
				<input type="text" id="deleteModalId" style="display: none;"></input>
				<p>
					你确定要删除菜单名为
					<mark id="deleteModalMark"></mark>
					吗？
				</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭
				</button>
				<input type="submit" class="btn btn-info btn-insert" value="确定"
					onclick="deleteModal()" />
			</div>
		</div>
	</div>
</div>
<!--  update modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">修改菜单</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<input type="text" id="updateModalId" style="display: none;"></input>
					<input type="text" id="updateModalShopId" style="display: none;"></input>
					<label for="updateMenu">菜单名称</label> <input type="text"
						id="updateModalName" class="form-control"></input>
				</div>
				<div class="form-group">
					<label for="updateIntro">菜单介绍</label>
					<textarea class="form-control" rows="3" id="updateIntro"></textarea>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭
				</button>
				<input type="submit" class="btn btn-info btn-insert" value="修改"
					onclick="updateModal()" />
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function queryModal(menuId){
		$.ajax({
			type:'post',
			url:$('#host').val()+'/shop/menu-query.action',
			data:{
				id:parseInt(menuId),
			},
			success:function(data){
				$('#updateModalName').val(data.object.name);
				$('#updateIntro').val(data.object.intro);
				$('#updateModalId').val(data.object.id);
				$('#updateModalShopId').val(data.object.shopId);
				$('#deleteModalId').val(data.object.id);
				$('#deleteModalMark').html(data.object.name);
			}
		});
	}
	function updateModal(){
		$.ajax({
			type:'post',
			url:$('#host').val()+'/shop/menu-update.action',
			data:{
				shopId:$('#updateModalShopId').val(),
				id:$('#updateModalId').val(),
				name:$('#updateModalName').val(),
				intro:$('#updateIntro').val()
			},
			success:function(data){
				if(data.success){
					$('#updateModal').modal('hide');
					window.location=$('#host').val()+'/shop/menu-manage.action';
				}
			}
		});
	}
	function deleteModal(){
		$.ajax({
			type:'post',
			url:$('#host').val()+'/shop/menu-delete.action',
			data:{
				id:$('#deleteModalId').val(),
			},
			success:function(data){
				if(data.success){
					$('#updateModal').modal('hide');
					window.location=$('#host').val()+'/shop/menu-manage.action';
				}
			}
		});
	}
</script>