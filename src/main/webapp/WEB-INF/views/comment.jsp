<%@ include file="/WEB-INF/views/assets/header.jsp"%>

<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form:form method="POST" modelAttribute="commentForm"
	class="form-signin">
	<spring:bind path="comments">
	<form:textarea path="comments" class="control-label" rows="5" cols="50"></form:textarea>
	</spring:bind>
	
	<spring:bind path="note">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<label for=note>Note : (de 0 à 5)</label>
			<form:select type="text" path="note" class="form-control"
				autofocus="true">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</form:select>
			<form:errors path="note"></form:errors>
		</div>
	</spring:bind>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Envoyer</button>

</form:form>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>