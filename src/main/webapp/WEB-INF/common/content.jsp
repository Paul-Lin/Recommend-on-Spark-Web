<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String host = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<style>
.productitem .productitem-logo {
	width: 290px;
	height: 230px;
	display: block;
	margin-left: auto;
	marigin-right: auto;
}

.menu-name {
	font-size: 18px;
}
</style>
<div class="container">
	<div class="row" id="recommendShopMenuImg">
		<c:forEach items="${list }" var="menu">
			<div class="col-sm-4 col-xs-12 highlight productitem workstation">
				<a href="<%=host+"/shopmenu/show-recommend.action?shopMenuId=" %>${menu.id}" class="productitem-logo"> <img src="${menu.illustration}"
					class="h-caption color img-rounded" />
				</a>
				<div class="h-body top-margin text-center menu-name">
					<a href="#">${menu.name }</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<script>
	
</script>