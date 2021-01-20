<%@ include file="/WEB-INF/views/assets/header.jsp"%>

<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form class="form-signin">
<h1>Commentaire</h1>

<textarea cols="60" rows="20" wrap="hard" disabled="yes">${comment.getComments()}</textarea>
<td>${comment.getNote()}/5</td>
</form:form>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>