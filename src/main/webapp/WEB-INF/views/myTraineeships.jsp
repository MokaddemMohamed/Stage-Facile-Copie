<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<table id="data" class="table table-striped table-bordered" style="width:100%">
	<thead>
		<tr>
			<th>Sujet du stage</th>
			<th>Description</th>
			<th>Nom de la compagnie d'accueil</th>
			<th>Zone géographique</th>
			<th>Date de début</th>
			<th>Date de fin</th>
			<th>Tuteur de stage</th>
			<th> # </th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="listStages" items="${listStages}">
			<tr>
				<c:set var="stageId" value="${listStages.getId()}"  />
				<td>
				<a href="/stage/details/${stageId}">${listStages.getSubject() }</a></td>
				<td>${listStages.getDescription() }</td>
				<td>${listStages.getCompanyName() }</td>
				<td>${listStages.getCountry() }, ${listStages.getCity() } </td>
				<td>${listStages.getStartDate() }</td>
				<td>${listStages.getEndDate() }</td>
				<td>${listStages.getTutor().getLastName() }</td>
				<td>
				<a href="/comment/add/${stageId}"><i class="material-icons">add_comment</i></a>
				<a href="/stage/update/${stageId}"><i class="material-icons">edit</i></a>
				<a href="/stage/delete/${stageId}"><i class="material-icons">delete</i></a></td>
			
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="btn btn-primary" href="${pageContext.request.contextPath}/addStage" role="button">Ajouter</a>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>