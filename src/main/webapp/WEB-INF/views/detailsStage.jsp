
<%@ include file="/WEB-INF/views/assets/header.jsp"%>
<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="username" value="${pageContext.request.userPrincipal.name}" />
<c:set var="valitaded" value="${1}" />
<!-- Page Content -->
<div class="container">
	<div class="row">


		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div class="card mt-4">

				<div class="card-body">

					<h3 class="card-title">${stage.getSubject()}</h3>
					<br>
					<h2>Stage :</h2>


					<p class="card-text">
						<b>Description :</b> ${stage.getDescription()}
					</p>
					<p class="card-text">
						<b>Date début :</b> ${stage.getStartDate()}
					</p>
					<p class="card-text">
						<b>Date Fin :</b> ${stage.getEndDate()}
					</p>
					<p class="card-text">
						<b>Gratification :</b> ${stage.getGratification()} €/mois
					</p>
					<p class="card-text">
						<b>Niveau :</b>${stage.getTrainingRequired()}</p>
					<p class="card-text">
						<b>Gestionnaire : </b> ${stage.getAdministrator()}
					</p>
					<h2>Entreprise :</h2>
					<p class="card-text">
						<b>Nom de la compagnie :</b> ${stage.getCompanyName()}
					</p>
					<p class="card-text">
						<b>Activité :</b> ${stage.getEnterprise().getActivity()}
					</p>
					<p class="card-text">
						<b>Adresse :</b> ${stage.getEnterprise().getAdress()}
					</p>
					<p class="card-text">
						<b>Code postal :</b> ${stage.getEnterprise().getPostalCode()}
					</p>
					<p class="card-text">
						<b>Ville :</b> ${stage.getEnterprise().getTown()}
					</p>
					<h2>Tuteur:</h2>
					<p class="card-text">
						<b>Prénom :</b> ${stage.getTutor().getFirstName()}
					</p>
					<p class="card-text">
						<b>Nom :</b> ${stage.getTutor().getLastName()}
					</p>
					<p class="card-text">
						<b>Mail :</b> ${stage.getTutor().getMail()}
					</p>
					<p class="card-text">
						<b>n° :</b> ${stage.getTutor().getPhoneNumber()}
					</p>
					<p class="card-text" style="float: right">
						<c:if test="${stage.validated() > 0 }">
							<p class="card-text" style="text-align: right">
								Validée <i class="material-icons" style="color: green">check_circle</i>
							</p>
						</c:if>
						<c:if test="${stage.validated() < 0 }">
							<p class="card-text" style="text-align: right">
								Non validée <i class="material-icons" style="color: red">check_circle</i>
							</p>
						</c:if>
						<c:if test="${stage.validated() == 0 }">
							<p class="card-text" style="text-align: right">
								En cours de validation<i class="material-icons"
									style="color: orange">check_circle</i>
							</p>
						</c:if>

					</p>
				</div>
			</div>
			<!-- /.card -->
			<c:if test="${stage.getComment() != null}">
				<div class="card card-outline-secondary">
					<div class="card-body">
						<h4>Commentaires</h4>
						<div class="row align-items-center"
							style="box-shadow: 0 7px 8px -6px rgba(0, 0, 0, .2);">
							<div class="col-sm-12">
								<p class="card-text">${stage.getComment().getComments()}</p>
								<small class="text-muted">Posté par
									${stage.getUser().getUsername()} </small><br>
								<c:if test="${stage.getComment().getNote() == 0}">
									<span class="text-warning">&#9734; &#9734; &#9734;
										&#9734; &#9734;</span> 0.0 étoile
								</c:if>
								<c:if test="${stage.getComment().getNote() == 1}">
									<span class="text-warning">&#9733; &#9734; &#9734;
										&#9734; &#9734;</span> 1.0 étoile
								</c:if>
								<c:if test="${stage.getComment().getNote() == 2}">
									<span class="text-warning">&#9733; &#9733; &#9734;
										&#9734; &#9734;</span> 2.0 étoiles
								</c:if>
								<c:if test="${stage.getComment().getNote() == 3}">
									<span class="text-warning">&#9733; &#9733; &#9733;
										&#9734; &#9734;</span> 3.0 étoiles
								</c:if>
								<c:if test="${stage.getComment().getNote() == 4}">
									<span class="text-warning">&#9733; &#9733; &#9733;
										&#9733; &#9734;</span> 4.0 étoiles
								</c:if>
								<c:if test="${stage.getComment().getNote() == 5}">
									<span class="text-warning">&#9733; &#9733; &#9733;
										&#9733; &#9733;</span> 5.0 étoiles
								</c:if>
							</div>
						</div>
						<br>
						<c:if test="${listReplies != null}">
							<c:forEach var="listReplies" items="${listReplies}">
								<div class="row align-items-center"
									style="box-shadow: 0 7px 3px -6px rgba(0, 0, 0, .2);">
									<div class="col-sm-9">
										<small class="text-muted">Posté par
											${listReplies.getUsername()} le
											${listReplies.getFormatedDate()} </small><br>
										<p class="card-text">${listReplies.getReply()}</p>
									</div>

									<div class="col-sm-3 align-self-center">
										<div style="text-align: right; vertical-align: middle;">
											<span id="test"></span>
											<c:if test="${listReplies.getUsername() == username }">
												<a href="/reply/delete/${listReplies.getId()}"><i
													class="material-icons">delete</i></a>
											</c:if>

											<form style="display: inline;">
												<c:choose>
													<c:when test="${listReplies.isUpvotedByUser(username)}">
														<button class="btn" style="margin: 0px; padding: 5px"
															onclick="removeUpvote('${listReplies.getId()}','${username}')">
															<i class="material-icons" style="color: #009688">keyboard_arrow_up</i>
														</button>
													</c:when>
													<c:when
														test="${!listReplies.isUpvotedByUser(username) && !listReplies.isDownvotedByUser(username)}">
														<button class="btn" style="margin: 0px; padding: 5px"
															onclick="upvote('${listReplies.getId()}','${username}')">
															<i class="material-icons" style="color: #C1BFB1">keyboard_arrow_up</i>
														</button>
													</c:when>
													<c:when
														test="${!listReplies.isUpvotedByUser(username) && listReplies.isDownvotedByUser(username)}">
														<button class="btn" style="margin: 0px; padding: 5px"
															disabled>
															<i class="material-icons" style="color: #C1BFB1">keyboard_arrow_up</i>
														</button>
													</c:when>
												</c:choose>
												<c:choose>
													<c:when test="${listReplies.getVote() < 0}">
														<span id="${listReplies.getId()}" style="color: red">${listReplies.getVote()}</span>
													</c:when>
													<c:when test="${listReplies.getVote() > 0}">
														<span id="${listReplies.getId()}" style="color: #009688">${listReplies.getVote()}</span>
													</c:when>
													<c:otherwise>
														<span id="${listReplies.getId()}">${listReplies.getVote()}</span>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${listReplies.isDownvotedByUser(username)}">
														<button class="btn" style="margin: 0px; padding: 5px"
															onclick="removeDownvote('${listReplies.getId()}','${username}')">
															<i class="material-icons" style="color: red">keyboard_arrow_down</i>
														</button>
													</c:when>
													<c:when
														test="${!listReplies.isDownvotedByUser(username) && !listReplies.isUpvotedByUser(username)}">
														<button class="btn" style="margin: 0px; padding: 5px"
															onclick="downvote('${listReplies.getId()}','${username}')">
															<i class="material-icons" style="color: #C1BFB1">keyboard_arrow_down</i>
														</button>
													</c:when>
													<c:when
														test="${!listReplies.isDownvotedByUser(username) && listReplies.isUpvotedByUser(username)}">
														<button class="btn" style="margin: 0px; padding: 5px"
															disabled>
															<i class="material-icons" style="color: #C1BFB1">keyboard_arrow_down</i>
														</button>
													</c:when>
												</c:choose>
											</form>

										</div>
									</div>
									<!-- upvote/downvote -->
								</div>
								<br>
							</c:forEach>
						</c:if>
						<br>
						<form:form method="POST" action="/reply/add/${stage.getId()}"
							modelAttribute="newReply">
							<spring:bind path="reply">
								<form:input class="form-control" type="text" path="reply"
									placeholder="Laissez une réponse à cet avis"></form:input>
							</spring:bind>
						</form:form>
					</div>
				</div>

			</c:if>

			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->

<script>
	function upvote(replyId, username) {
		var value = document.getElementById(replyId).innerHTML;
		value = parseFloat(value) + 1;
		document.getElementById(replyId).textContent = value;
		$.ajax({
			url : "/reply/upvote/" + replyId + "/" + username,
			type : "GET",
			success : function(response) {
				console.log("success");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
		return false;
	}

	function removeUpvote(replyId, username) {
		var value = document.getElementById(replyId).innerHTML;
		value -= 1;
		document.getElementById(replyId).textContent = value;
		$.ajax({
			url : "/reply/upvote/" + replyId + "/" + username + "/remove",
			type : "GET",
			success : function(response) {
				console.log("success");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
		return false;
	}

	function downvote(replyId, username) {
		var value = document.getElementById(replyId).innerHTML;
		value -= 1;
		document.getElementById(replyId).textContent = value;
		$.ajax({
			url : "/reply/downvote/" + replyId + "/" + username,
			type : "GET",
			success : function(response) {
				console.log("success");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
		return false;
	}

	function removeDownvote(replyId, username) {
		var value = document.getElementById(replyId).innerHTML;
		value = parseFloat(value) + 1;
		document.getElementById(replyId).textContent = value;
		$.ajax({
			url : "/reply/downvote/" + replyId + "/" + username + "/remove",
			type : "GET",
			success : function(response) {
				console.log("success");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
		return false;
	}
</script>

<%@ include file="/WEB-INF/views/assets/footer.jsp"%>