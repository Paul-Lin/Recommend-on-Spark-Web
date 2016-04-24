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
<moon:common title="Moon Plan 不知美好-${customer.nickname }重置密码">
	<jsp:attribute name="head">
	<jsp:include page="/WEB-INF/search/index.jsp" />
	</jsp:attribute>
	<jsp:attribute name="navbar">
	</jsp:attribute>
	<jsp:attribute name="body" >
		<jsp:include page="/WEB-INF/customer/reset-password-body.jsp"/>
	</jsp:attribute>
	<jsp:attribute name="foot">
	</jsp:attribute>
</moon:common>