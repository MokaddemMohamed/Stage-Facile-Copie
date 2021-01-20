<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form:form method="POST" modelAttribute="stageForm" class="form-signin">
	<h2 class="form-signin-heading">Modification du stage</h2>


	<spring:bind path="title">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="title" class="control-label">Domaine</form:label>
			<form:select type="title" path="title" class="form-control" autofocus="true">
				<c:forEach var="listField" items="${listField}">
					<option value=${listField.getId() }>${listField.getTitle() }</option>
				</c:forEach>
			</form:select>
			<form:errors path="title"></form:errors>
		</div>
	</spring:bind>
	
		<spring:bind path="idTutor">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="idTutor" class="control-label">idTutor</form:label>
			<form:select type="idTutor" path="idTutor" class="form-control" autofocus="true">
				<c:forEach var="listTutor" items="${listTutor}">
					<option value=${listTutor.getId() }>${listTutor.getFirstName() }</option>
				</c:forEach>
			</form:select>
			<form:errors path="idTutor"></form:errors>
		</div>
	</spring:bind>
	
	<spring:bind path="companyName">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="companyName" class="control-label">Entreprise</form:label>
			<form:select type="companyName" path="companyName" class="form-control" autofocus="true">
				<c:forEach var="listEnterprise" items="${listEnterprise}">
					<option value=${listEnterprise.getId() }>${listEnterprise.getName() }</option>
				</c:forEach>
			</form:select>
			<form:errors path="companyName"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="subject">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="subject" class="form-control"
				placeholder="Sujet du stage" autofocus="true"></form:input>
			<form:errors path="subject"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="startDate">
		<div
			class="form-group ${status.error ? 'has-error' : ''} label-floating">
			<form:label path="startDate" class="control-label">Date de debut</form:label>
			<form:input type="date" path="startDate"
				class="form-control datetimepicker"></form:input>
			<form:errors path="startDate"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="endDate">
		<div
			class="form-group ${status.error ? 'has-error' : ''} label-floating">
			<form:label path="endDate" class="control-label">Date de fin</form:label>
			<form:input type="date" path="endDate"
				class="form-control datetimepicker"></form:input>
			<form:errors path="endDate"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="description">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="textarea" path="description" class="form-control"
				placeholder="description" autofocus="true"></form:input>
			<form:errors path="description"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="gratification">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<label for=gratification>Gratification (€)/Mois: </label>
			<form:input type="number" min="0" path="gratification"
				class="form-control" placeholder="Gratification" autofocus="true"></form:input>
			<form:errors path="gratification"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="trainingRequired">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<label for=trainingRequired>Niveau requis : </label>
			<form:select type="text" path="trainingRequired" class="form-control"
				autofocus="true">
				<option value="M2 Informatique ILD">M2 Informatique ILD</option>
				<option value="M2 Informatique GIG">M2 Informatique GIG</option>
				<option value="M2 Informatique FSI">M2 Informatique FSI</option>
				<option value="M2 Informatique IMD">M2 Informatique IMD</option>
				<option value="M1 Informatique">M1 Informatique</option>
				<option value="Licence 3 Informatique">Licence 3 Informatique</option>
				<option value="Licence 2 Informatique">Licence 2 Informatique</option>
			</form:select>
			<form:errors path="trainingRequired"></form:errors>
		</div>
	</spring:bind>

	<spring:bind path="city">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="city" class="form-control"
				placeholder="Ville" autofocus="true"></form:input>
			<form:errors path="city"></form:errors>
		</div>
	</spring:bind>
	<spring:bind path="country">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input type="text" path="country" class="form-control"
				placeholder="Pays" autofocus="true"></form:input>
			<form:errors path="country"></form:errors>
		</div>
	</spring:bind>
	<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="administrator" class="control-label">Gestionnaire</form:label>
			<form:select type="text" path="administrator" class="form-control"
				autofocus="true">
				<option value="SELLAMI Sana">SELLAMI Sana</option>
				<option value="Luc">MASSAT Jean-Luc</option>
				<option value="Madame SELLAMI">JEANSON Emilie</option>
				<option value="CHEVALIER Brigitte">CHEVALIER Brigitte</option>
				<option value="VEDRENNE Ophelie">VEDRENNE Ophelie</option>
				<option value="DUBOURDIEU RAYROT Nathalie">DUBOURDIEU RAYROT Nathalie</option>
				<option value="ajouter">Ajouter des options</option>
			</form:select>
			<form:errors path="administrator"></form:errors>
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Envoyer</button>
</form:form>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>