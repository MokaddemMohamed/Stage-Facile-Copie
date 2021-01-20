<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<table style="width: 100%">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Site Web</th>
			<th>Groupe</th>
			<c:choose>
				<c:when test="${pageContext.request.userPrincipal.name != null}">
					<th>Mail</th>
					<th>Birthday</th>

				</c:when>
			</c:choose>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="listUsers" items="${listUsers}">
			<tr>
				<td>${listUsers.getFirstName() }</td>
				<td>${listUsers.getLastName() }</td>
				<td>${listUsers.getSite()}</td>
				<c:choose>
					<c:when test="${pageContext.request.userPrincipal.name != null}">
						<td>${listPerson.getMail() }</td>
						<td>${listPerson.getBirthday() }</td>

					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>