<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String host = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<style>
.recommend-container {
	margin-top: 20px;
}

.left-menu {
	width: 280px;
	height: 400px;
	margin-top: -30px;
	margin-left: 100px;
}

.right-menu {
	background: green;
	width: 400px;
	height: 400px;
	margin-top: -580px;
	margin-left: 100px;
	display: inline-block;
}

.menu-intro {
	padding: 20px;
}

.shop-name {
	margin-top: -20px;
}

.page-title {
	font-size: 28px;
	margin: 0px 0px 14px;
	line-height: 1.2;
	font-weight: 400;
	word-break: break-all;
}

.main-panel .block-has-padding {
	padding-left: 28px;
	padding-right: 28px;
}

.recipe-show {
	padding-bottom: 56px;
	padding-top: 0px;
	margin: 0px;
	padding-top: 0px;
}

.white-bg {
	background-color: #FFF;
}

.menu-img {
	padding: 20px;
}

.pos-r {
	position: relative;
}

.stats {
	margin-top: 28px;
	float: left;
	font-size: 12px;
	color: #909090;
	color: black;
}

.liked {
	margin-top: -40px;
	margin-left: 20px;
	text-align: center
}

.overview {
	display: inline-block;
	vertical-align: top;
	width: 112px;
	text-align: center;
}

.number {
	font-size: 30px;
	line-height: 1.5;
	color: #922;
}

.title {
	margin-top: -5px;
}

.link {
	margin: -40px -449.96px 0px 480px;
	word-break: break-all;
	font-size: 16px;
}

.red-link {
	color: #FFF;
	background-color: #B24422;
}

.collect {
	position: absolute;
	background: #333;
	width: 500px;
	height: 400px;
	margin-top: -395px;
	margin-left: 630px;
}
</style>
<div class="recommend-container container ">
	<h2 class="page-title">
		<a href="#">${shopmenu.name }</a>
	</h2>
	<div class="block block-has-padding white-bg recipe-show img-rounded">
		<div class="cover image expandable block-negative-margin expanded"
			style="background: tansparent; height: 413px;">
			<img width="620px" height="413px" alt="${shopmenu.name }"
				src="${shopmenu.illustration }" class="img-rounded menu-img" />
			<div class="collect img-rounded">
				<h2>菜单简介</h2>
				<p class="lead">${fn:substring(shopmenu.intro,0,240)}...</p>
			</div>
		</div>
		<div class="pos-r">
			<div class="stats">
				<div class="liked">
					<div class="overview">
						<span class="number">23</span>
					</div>
					<div class="title">人喜欢这道菜</div>
					<div class="link">
						<a class="red-link" rel="nofollow"
							href="<%=host+"/common/show-shop.action?shopId="%>${shopmenu.shopId}">店铺传送门</a>
					</div>
				</div>
			</div>


		</div>
	</div>
	<div class="menu-intro">
		<h2>菜单简介</h2>
		<p class="lead">${shopmenu.intro }</p>
	</div>
</div>