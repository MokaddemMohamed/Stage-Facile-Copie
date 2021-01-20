<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form:form method="POST" modelAttribute="userForm" class="form-signin">
	<h2 class="form-signin-heading">Creer son compte</h2>
	<spring:bind path="username">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="username" class="form-control"
				placeholder="Pseudo" autofocus="true"></form:input>
			<form:errors path="username"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="firstName">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="firstName" class="control-label">Prénom</form:label>
			<form:input type="firstName" path="firstName" class="form-control"
				placeholder="Prénom"></form:input>
			<form:errors path="firstName"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="lastName">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="lastName" class="control-label">Nom</form:label>
			<form:input type="lastName" path="lastName" class="form-control"
				placeholder="Nom"></form:input>
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
			<form:label path="tel" class="control-label">Tel</form:label>
			<form:input type="tel" path="tel" class="form-control"
			placeholder="+33"></form:input>
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

	<spring:bind path="password">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="password" class="control-label">Mot de passe</form:label>
			<form:input type="password" path="password" class="form-control"
				placeholder="Mot de passe"></form:input>
			<form:errors path="password"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="passwordConfirm">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="passwordConfirm" class="control-label">Confirmation de mot de passe</form:label>
			<form:input type="password" path="passwordConfirm"
				class="form-control" placeholder="Confirmation de mot de passe"></form:input>
			<form:errors path="passwordConfirm"></form:errors>
		</div>
	</spring:bind>

	<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>