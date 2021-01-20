<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<form:form method="POST" modelAttribute="tutorForm" class="form-signin">
	<h2 class="form-signin-heading">Ajouter un tuteur de stage</h2>
	
	<spring:bind path="lastName">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="lastName" class="control-label">Nom de famille</form:label>
			<form:input type="text" path="lastName" class="form-control"
				placeholder="Nom" autofocus="true"></form:input>
			<form:errors path="lastName"></form:errors>
		</div>
	</spring:bind>
	
		<spring:bind path="firstName">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="firstName" class="control-label">Prenom</form:label>
			<form:input type="text" path="firstName" class="form-control"
				placeholder="Prenom" autofocus="true"></form:input>
			<form:errors path="firstName"></form:errors>
		</div>
	</spring:bind>
	
		<spring:bind path="phoneNumber">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="phoneNumber" class="control-label">Numero de telephone</form:label>
			<form:input type="phoneNumber" path="phoneNumber" class="form-control"
			placeholder="+33"></form:input>
			<form:errors path="phoneNumber"></form:errors>
		</div>
	</spring:bind>
	
		<spring:bind path="mail">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="mail" class="control-label">Mail</form:label>
			<form:input type="mail" path="mail" class="form-control"
				placeholder="mail" autofocus="true"></form:input>
			<form:errors path="mail"></form:errors>
		</div>
	</spring:bind>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
</form:form>
<%@ include file="/WEB-INF/views/assets/footer.jsp"%>