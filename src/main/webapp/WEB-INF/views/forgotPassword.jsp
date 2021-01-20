<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form:form method="POST" modelAttribute="mailForm" class="form-signin">
	<h3 class="text-center">Rentrez votre adresse mail</h3>
	<spring:bind path="mail">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="mail" path="mail" class="form-control"
				placeholder="Mail" />
			<span class="text-danger">${error}</span> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</div>
	</spring:bind>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Réinitialiser</button>
</form:form>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>