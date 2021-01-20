<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<table id="data" class="table table-striped table-bordered" style="width:100%">
	<thead>
		<tr>
			<th>Sujet du stage</th>
			<th>Nom de la compagnie d'accueil</th>
			<th>Zone geographique</th>
			<th>Niveau</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="listStages" items="${listStages}">
			<tr>
				<c:set var="stageId" value="${listStages.getId()}"  />
				<td><a href="${pageContext.request.contextPath}/stage/details/${stageId}">${listStages.getSubject() }</a></td>
				<td>${listStages.getCompanyName() }</td>
				<td>${listStages.getCountry() }, ${listStages.getCity() } </td>
				<td>${listStages.getTrainingRequired() }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>