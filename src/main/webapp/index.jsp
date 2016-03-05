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
<input type="hidden" id="host" value="<%=host%>" />
<style>
.row {
	margin-left: -15px;
	margin-right: -15px;
}

.highlight {
	margin-top: 40px;
}

.productitem .productitem-logo {
	width: 230px;
	height: 230px;
	display: block;
	margin-left: auto;
	marigin-right: auto;
}

.h-body {
	margin-left: 50px;
	margin-right: 50px;
	margin-bottom: 20px;
}

.top-margin {
	margin-top: 20px;
}

.text-justify {
	text-align: justify
}

.color {
	width: 230px;
	height: 230px;
	background-size: cover;
	position: absolute;
}

.h-caption {
	text-align: center;
}
</style>
<moon:index title="Moon Plan首页-不止美好">
	<jsp:attribute name="search">
        <jsp:include page="WEB-INF/search/index.jsp" />
    </jsp:attribute>
	<jsp:attribute name="navbar">

    </jsp:attribute>
	<jsp:attribute name="recommend">
		<div class="container">
	    	<div class="row">
				<div class="col-sm-4 col-xs-12 highlight productitem workstation">
					<a href="#" class="productitem-logo">
						<img src="" class="h-caption color" />
					</a>
					<div class="h-body text-justfy top-margin ">
						<p>text</p>
						<p class="visible-xs text-center uppercase">
							<a class="btn btn-edition" role="button" href="#"></a>
						</p>
					</div>
				</div>
			</div>
    	</div>
    </jsp:attribute>

</moon:index>
