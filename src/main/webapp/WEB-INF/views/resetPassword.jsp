<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form:form method="POST" modelAttribute="newPasswordUser"
	class="form-signin">
	<h3 class="text-center">Rentrez votre nouveau mot de passe</h3>
	<spring:bind path="mail">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="mail" path="mail" class="form-control"
				placeholder="Mail" readonly="true" />
		</div>
	</spring:bind>
	<spring:bind path="password">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="password" path="password" class="form-control"
				placeholder="Mot de passe"></form:input>
		</div>
	</spring:bind>
	<spring:bind path="passwordConfirm">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="password" path="passwordConfirm"
				class="form-control" placeholder="Confirmez le mot de passe"></form:input>
			<span class="text-danger">${error}</span> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</div>
	</spring:bind>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Valider</button>
</form:form>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>