<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<table id="data" class="table table-striped table-bordered" style="width:100%">
	<thead>
		<tr>
			<th>Sujet du stage</th>

			<th>Nom de la compagnie d'accueil</th>
			<th>Zone géographique</th>
			<th>Date de début</th>
			<th>Date de fin</th>
			<th>Validation</th>
			<th>Edit</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="listStages" items="${listStages}">
			<tr>
				<c:set var="stageId" value="${listStages.getId()}" />

				<td><a href="/stage/details/${stageId}">
						${listStages.getSubject() } </a></td>

				<td>${listStages.getCompanyName() }</td>
				<td>${listStages.getCountry() },${listStages.getCity() }</td>
				<td>${listStages.getStartDate() }</td>
				<td>${listStages.getEndDate() }</td>


				<c:if test="${listStages.validated() > 0 }">
					<td>Validée <i class="material-icons" style="color: green">check_circle</i>
					</td>
				</c:if>
				<c:if test="${listStages.validated() < 0 }">
					<td>Non validée <i class="material-icons" style="color: red">check_circle</i>
					</td>
				</c:if>
				<c:if test="${listStages.validated() == 0 }">
					<td>En cours de validation<i class="material-icons"
						style="color: orange">check_circle</i>
					</td>
				</c:if>
				<td><a href="/stage/updateTeacher/${stageId}"><i
						class="material-icons">edit</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="/WEB-INF/views/assets/footer.jsp"%>