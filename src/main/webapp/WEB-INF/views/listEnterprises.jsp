<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<table id="data" class="table table-striped table-bordered" style="width:100%">
	<thead>
		<tr>
			<th>Nom</th>
			<th>Adresse</th>
			<th>Code postal</th>
			<th>Ville</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="listEnterprises" items="${listEnterprises}">
			<tr>
				<c:set var="nameEnterprise" value="${listEnterprises.getName()}"  />
				<td><a href="${pageContext.request.contextPath}/enterprise/${listEnterprises.getId()}/ListStages"> ${listEnterprises.getName() } </a> </td>
				<td>${listEnterprises.getAdress() }</td>
				<td>${listEnterprises.getPostalCode() }</td>
				<td>${listEnterprises.getTown() }</td>

			</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="/WEB-INF/views/assets/footer.jsp"%>