<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<table id="data" class="table table-striped table-bordered" style="width:100%">
	<thead>
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Mail</th>
			<th>Numero de telephone</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="listTutors" items="${listTutors}">
			<tr>
				<td>${listTutors.getLastName() }</td>
				<td>${listTutors.getFirstName() }</td>
				<td>${listTutors.getMail() }</td>
				<td>${listTutors.getPhoneNumber() }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>