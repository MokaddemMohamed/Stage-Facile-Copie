<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<form method="POST" action="${contextPath}/login" class="form-signin">
	<h2 class="form-heading">Connexion</h2>

	<div class="form-group ${error != null ? 'has-error' : ''}">
		<span>${message}</span> <input name="username" type="text"
			class="form-control" placeholder="Pseudo" autofocus="true" /> <input
			name="password" type="password" class="form-control"
			placeholder="Mot de passe" /> <span>${error}</span> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />

		<button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
		<h4 class="text-center">
			<a href="${contextPath}/registration">Creer un compte</a>
		</h4>
		<br>
		<h6 class="text-center">
			<a href="${contextPath}/forgotPassword">Mot de passe oublié ?</a>
		</h6>
	</div>

</form>



<%@ include file="/WEB-INF/views/assets/footer.jsp"%>