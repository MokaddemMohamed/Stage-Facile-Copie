<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<center>
	<span>${message}</span> <br />
	<br />
	<br /> <h4><a href="/login">Se connecter</a></h4>
</center>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>