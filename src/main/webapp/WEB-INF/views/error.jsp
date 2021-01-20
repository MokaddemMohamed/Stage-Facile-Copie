<%@ include file="/WEB-INF/views/assets/header.jsp"%>

<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="text-center">
	<c:choose>
		<c:when test="${error.equals('404')}">
			<h1>La page demandée est introuvable !</h1>
		</c:when>
		<c:when test="${error.equals('403')}">
			<h1>Accès restreint !</h1>
		</c:when>
		<c:otherwise>
			<h1>Oups ! Il y a eu une erreur...</h1>
		</c:otherwise>
	</c:choose>
	<h1>${message}</h1>
	<h3><a href="/">Accueil</a></h3>
	
</div>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>