<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:choose>
	<c:when test="${pageContext.request.userPrincipal.name == pageContext.request.userPrincipal.name}">
<form:form method="POST" modelAttribute="userForm" class="form-signin">
	<h2 class="form-signin-heading">update your account</h2>
	<spring:bind path="username">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="username" class="form-control"
				placeholder="Username" autofocus="true"></form:input>
			<form:errors path="username"></form:errors>
		</div>
	</spring:bind>
<spring:bind path="firstName">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="firstName" class="control-label">Prenom</form:label>
			<form:input type="firstName" path="firstName" class="form-control"
				placeholder="First Name"></form:input>
			<form:errors path="firstName"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="lastName">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="lastName" class="control-label">Nom</form:label>
			<form:input type="lastName" path="lastName" class="form-control"
				placeholder="last Name"></form:input>
			<form:errors path="lastName"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="mail">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="mail" class="control-label">Mail</form:label>
			<form:input type="mail" path="mail" class="form-control"
				placeholder="Mail"></form:input>
			<form:errors path="mail"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="tel">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="tel" class="control-label">Numéro de téléphone</form:label>
			<form:input type="tel" path="tel" class="form-control"
				placeholder="Tel"></form:input>
			<form:errors path="tel"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="birthday">
		<div
			class="form-group ${status.error ? 'has-error' : ''} label-floating">
			<form:label path="birthday" class="control-label">Date de naissance</form:label>
			<form:input type="date" path="birthday"
				class="form-control datetimepicker"></form:input>
			<form:errors path="birthday"></form:errors>
		</div>
	</spring:bind>

	<button class="btn btn-lg btn-primary btn-block" type="submit">Envoyer</button>
</form:form>
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/views/assets/footer.jsp"%>