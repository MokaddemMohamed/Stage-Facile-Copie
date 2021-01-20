<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<h2> Archives :</h2>
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
		<c:forEach var="listStagesArchive" items="${listStagesArchive}">
			<tr>
				<c:set var="stageId" value="${listStagesArchive.getId()}"  />
				<td>${listStagesArchive.getSubject() }</td>
				<td>${listStagesArchive.getCompanyName() }</td>
				<td>${listStagesArchive.getCountry() }, ${listStagesArchive.getCity() } </td>
				<td>${listStagesArchive.getTrainingRequired() }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="/WEB-INF/views/assets/footer.jsp"%>


