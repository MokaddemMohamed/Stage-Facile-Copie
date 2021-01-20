<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<table id="data" class="table table-striped table-bordered" style="width:100%">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mail</th>
			<th>Birthday</th>
			<th>Tel</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="listUsers" items="${listUsers}">
			<tr>
				<td>${listUsers.getFirstName() }</td>
				<td>${listUsers.getLastName() }</td>
				<td>${listUsers.getMail() }</td>
				<td>${listUsers.getBirthday() }</td>
				<td>${listUsers.getTel() }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>