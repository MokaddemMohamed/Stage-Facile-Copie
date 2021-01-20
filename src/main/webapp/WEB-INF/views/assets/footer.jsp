
<div id="copyleft" class="text-center">Stage Facile - Aix Marseille Université 2020</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>

<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" />

<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#data').DataTable({
			"language": {
                "url": "dataTables.french.lang"
			}
		} );
	});
</script>
<script>
	$(document).ready(function() {

		$('#w-input-search').autocomplete({
			serviceUrl : '${pageContext.request.contextPath}/getTags',
			paramName : "tagName",
			delimiter : ",",
			transformResult : function(response) {

				return {
					//must convert json to javascript object before process
					suggestions : $.map($.parseJSON(response), function(item) {

						return {
							value : item.tagName,
							data : item.id
						};
					})

				};

			}

		});

	});
</script>

</body>
</html>