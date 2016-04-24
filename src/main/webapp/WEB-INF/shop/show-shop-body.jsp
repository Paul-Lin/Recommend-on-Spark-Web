<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="moon"%>
<%
	String host = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<style>
.tshop-pbsm-shop-self-defined {
	position: relative;
	z-index: 10;
	font-family: arial, "微软雅黑", "宋体";
	border: 0px none;
	margin-bottom: 0px;
	background: transparent none repeat scroll 0% 0%;
}

.tshop-um-zp {
	position: relative;
	z-index: 11;
	font-family: arial, "微软雅黑", "宋体";
	width: 100%;
	height: auto;
}

.skin-box-bd {
	position: static;
	overflow: visible;
}

.show-shop-product {
	hieght: auto;
	display: block;
}

.zp {
	width: 990px;
	margin: auto;
}

.shop {
	padding-left: 70px;
	margin-top: 20px;
	background: white;
	border-radius: 10px;
}

.show-shop-new-product {
	padding-bottom: 20px;
}

#hd {
	max-height: 150px;
	overflow: hidden;
	padding-bottom: 0px;
	position: relative;
	background: white;
	border-radius: 10px;
}

.layout {
	width: 990px;
	margin-left: auto;
	margin-right: auto;
}

.col-main {
	float: left;
	width: 100%;
	min-height: 1px;
}

.zp-nav {
	height: 150px;
	width: 990px;
	left: 0px;
}

.zp-logo {
	overflow: hidden;
	width: 100%;
	height: auto;
	position: absolute;
	left: 0px;
	top: 0px;
	z-index: 2;
}

.dh {
	overflow: hidden;
	position: absolute;
	z-index: 5;
}

.section {
	width: 100%;
	position: absolute;
	left: 0px;
	top: 0px;
	color: black;
	float: left;
	height: auto;
	overflow: hidden;
}

.nav-title {
	font-size: 16px;
	color: black;
}

li a {
	height: auto;
	display: block;
	text-align: center;
	position: relative;
	overflow: hidden;
}

.item5line1 {
	margin-bottom: 11px !important;
	width: 100%;
}

.photo {
	width: auto;
	height: auto;
}

.product-img {
	height: 199px;
	width: 196px;
	padding: 10px;
}

.product-items {
	padding: 20px;
	padding-bottom: 30px;
	padding-left: 80px;
}
</style>
<div class="container">
	<div class="shop">
		<div class="skin-box-bt"></div>
		<div class="skin-box tshop-pbsm-shop-self-defined">
			<div class="skib-box-bd clear-fix">
				<p>
					<a target="_blank" href=""><img
						src="<%=host + "/img/check_more.png"%>"></a>
				</p>
			</div>
		</div>
		<div class="skin-box-bt"></div>
		<div id="" class="show-shop-product">
			<div
				class="skin-box tb-module tshop-pbsm tshop-pbsm-shop-self-defined">
				<div class="skin-box-tp"></div>
				<div class="skin-box-bd clear-fix show-shop-new-product">
					<table style="width: 990px;">
						<tbody>
							<tr>
								<td><a target="_blank" href=""><img
										src="<%=host + "/img/jay.jpg"%>"
										class="product-img img-rounded"></img></a></td>
								<td><a target="_blank" href=""><img
										src="<%=host + "/img/jay.jpg"%>"
										class="product-img img-rounded"></img></a></td>
								<td><a target="_blank" href=""><img
										src="<%=host + "/img/jay.jpg"%>"
										class="product-img img-rounded"></img></a></td>
								<td><a target="_blank" href=""><img
										src="<%=host + "/img/jay.jpg"%>"
										class="product-img img-rounded"></img></a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div
		class="skin-box tb-module tshop-pbsm tshop-pbsm-shop-self-defined product-items">
		<div class="skin-box-tp"></div>
		<div class="skin-box-bd clear-fix">
			<table style="width: 990px;">
				<tbody>
					<tr>
						<td><a target="_blank" href="#"><img
								class="product-img img-rounded" src="<%=host + "/img/jay.jpg"%>"></img></a></td>
						<td><a target="_blank" href="#"><img class="product-img"
								src="<%=host + "/img/jay.jpg"%>"></img></a></td>
						<td><a target="_blank" href="#"><img class="product-img"
								src="<%=host + "/img/jay.jpg"%>"></img></a></td>
						<td><a target="_blank" href="#"><img class="product-img"
								src="<%=host + "/img/jay.jpg"%>"></img></a></td>
						<td><a target="_blank" href="#"><img class="product-img"
								src="<%=host + "/img/jay.jpg"%>"></img></a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>