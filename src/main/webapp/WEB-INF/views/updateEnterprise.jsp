<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form:form method="POST" modelAttribute="enterpriseForm"
	class="form-signin">
	<h2 class="form-signin-heading">Update your enterprise</h2>

	<spring:bind path="name">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="name" class="form-control"
				placeholder="name" autofocus="true"></form:input>
			<form:errors path="name"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="adress">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="adress" class="form-control"
				placeholder="adress" autofocus="true"></form:input>
			<form:errors path="adress"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="postalCode">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="postalCode" class="form-control"
				placeholder="postalCode" autofocus="true"></form:input>
			<form:errors path="postalCode"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="town">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="town" class="form-control"
				placeholder="town" autofocus="true"></form:input>
			<form:errors path="town"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="activity">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="activity" class="form-control"
				placeholder="Activite" autofocus="true"></form:input>
			<form:errors path="activity"></form:errors>
		</div>
	</spring:bind>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Envoyer</button>
</form:form>
<%@ include file="/WEB-INF/views/assets/footer.jsp"%>