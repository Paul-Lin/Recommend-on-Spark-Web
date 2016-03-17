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
	<div class="container">
		<div>
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#myModal">增加菜单</button>
			<form class="form-horizontal" style="float: right;">
				<div class="form-group">
					<div class="col-sm-10 menu-search">
						<input type="text" class="form-control" id="inputMenuSearch"
							placeholder="菜单名">
					</div>
					<button type="button" class="btn btn-info">查询菜单</button>

				</div>
			</form>
		</div>
		<div class="menu-list">
			<div class="form-group">
				<img src="<%=host + "/img/jay.jpg"%>" class="img-thumbnail"
					style="height: 140px;"></img>
				<h2>周杰伦</h2>
			</div>
			<p>周杰伦（Jay
				Chou），1979年1月18日出生在台湾新北市，身兼华语男歌手、词曲创作人、制作人、导演、编剧、监制等[1] 。
				2000年发行首张专辑《Jay》出道，2002年在中国、新加坡、马来西亚、美国等地举办首场世界巡回演唱会。2003年登美国《时代周刊》封面人物[2-3]
				。曾四次获得世界音乐大奖中国最畅销艺人奖[4-5]
				，并凭借专辑《Jay》《范特西》《叶惠美》《跨时代》四次获金曲奖最佳国语专辑奖，又通过《魔杰座》《跨时代》两度获得金曲奖最佳男歌手奖。2014年、2015年两度获得QQ音乐年度盛典最佳全能艺人奖[6-7]
				。2015年获得全球华语榜中榜亚洲最受欢迎全能艺人奖[8] ；同年担任《中国好声音第四季》导师[9] 。
				2005年以电影《头文字D》获台湾电影金马奖及香港电影金像奖最佳新人奖</p>
			<div style="float: right;">
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#updateModal">修改</button>
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#deleteModal">删除</button>
			</div>
		</div>
		<!-- list -->
		<div class="menu-list">
			<div class="form-group">
				<img src="<%=host + "/img/jay.jpg"%>" class="img-thumbnail"
					style="height: 140px;"></img>
				<h2>周杰伦</h2>
			</div>
			<p>周杰伦（Jay
				Chou），1979年1月18日出生在台湾新北市，身兼华语男歌手、词曲创作人、制作人、导演、编剧、监制等[1] 。
				2000年发行首张专辑《Jay》出道，2002年在中国、新加坡、马来西亚、美国等地举办首场世界巡回演唱会。2003年登美国《时代周刊》封面人物[2-3]
				。曾四次获得世界音乐大奖中国最畅销艺人奖[4-5]
				，并凭借专辑《Jay》《范特西》《叶惠美》《跨时代》四次获金曲奖最佳国语专辑奖，又通过《魔杰座》《跨时代》两度获得金曲奖最佳男歌手奖。2014年、2015年两度获得QQ音乐年度盛典最佳全能艺人奖[6-7]
				。2015年获得全球华语榜中榜亚洲最受欢迎全能艺人奖[8] ；同年担任《中国好声音第四季》导师[9] 。
				2005年以电影《头文字D》获台湾电影金马奖及香港电影金像奖最佳新人奖</p>
			<div style="float: right;">
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#updateModal">修改</button>
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#deleteModal">删除</button>
			</div>
		</div>
		<div class="menu-list">
			<div class="form-group">
				<img src="<%=host + "/img/jay.jpg"%>" class="img-thumbnail"
					style="height: 140px;"></img>
				<h2>周杰伦</h2>
			</div>
			<p>周杰伦（Jay
				Chou），1979年1月18日出生在台湾新北市，身兼华语男歌手、词曲创作人、制作人、导演、编剧、监制等[1] 。
				2000年发行首张专辑《Jay》出道，2002年在中国、新加坡、马来西亚、美国等地举办首场世界巡回演唱会。2003年登美国《时代周刊》封面人物[2-3]
				。曾四次获得世界音乐大奖中国最畅销艺人奖[4-5]
				，并凭借专辑《Jay》《范特西》《叶惠美》《跨时代》四次获金曲奖最佳国语专辑奖，又通过《魔杰座》《跨时代》两度获得金曲奖最佳男歌手奖。2014年、2015年两度获得QQ音乐年度盛典最佳全能艺人奖[6-7]
				。2015年获得全球华语榜中榜亚洲最受欢迎全能艺人奖[8] ；同年担任《中国好声音第四季》导师[9] 。
				2005年以电影《头文字D》获台湾电影金马奖及香港电影金像奖最佳新人奖</p>
			<div style="float: right;">
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#updateModal">修改</button>
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#deleteModal">删除</button>
			</div>
		</div>
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
			<div class="modal-body">
				<form action="#" method="post" enctype="multipart/form-data">
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
							name="">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭
				</button>
				<input type="submit" class="btn btn-info btn-insert" value="增加菜单" />
			</div>
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
				<p>
					你确定要删除菜单名为
					<mark>周杰伦</mark>
					吗？
				</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭
				</button>
				<input type="submit" class="btn btn-info btn-insert" value="确定" />
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
					<label for="updateMenu">菜单名称</label> <input type="text"
						class="form-control" value="周杰伦"></input>
				</div>
				<div class="form-group">
					<label for="updateIntro">菜单介绍</label>
					<textarea class="form-control" rows="3" id="updateIntro">周杰伦（JayChou），1979年1月18日出生在台湾新北市，身兼华语男歌手、词曲创作人、制作人、导演、编剧、监制等[1] 。
				2000年发行首张专辑《Jay》出道，2002年在中国、新加坡、马来西亚、美国等地举办首场世界巡回演唱会。2003年登美国《时代周刊》封面人物[2-3]
				。曾四次获得世界音乐大奖中国最畅销艺人奖[4-5]，并凭借专辑《Jay》《范特西》《叶惠美》《跨时代》四次获金曲奖最佳国语专辑奖，又通过《魔杰座》《跨时代》两度获得金曲奖最佳男歌手奖。2014年、2015年两度获得QQ音乐年度盛典最佳全能艺人奖[6-7]
				。2015年获得全球华语榜中榜亚洲最受欢迎全能艺人奖[8] ；同年担任《中国好声音第四季》导师[9] 。
				2005年以电影《头文字D》获台湾电影金马奖及香港电影金像奖最佳新人奖</textarea>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">关闭
				</button>
				<input type="submit" class="btn btn-info btn-insert" value="修改" />
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	
</script>