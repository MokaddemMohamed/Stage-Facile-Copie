<%@ include file="/WEB-INF/views/assets/header.jsp"%>

<%@ include file="/WEB-INF/views/assets/navbar.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<h1>Nombre de stages proposés par entreprise</h1>
<canvas id="pieChart" width="400" height="400"></canvas>
<c:set var="totalCount" value="0" />
<c:set var="countEnterprise" value="0" />
<c:forEach var="listEnterprise" items="${listEnterprise}">
	<c:forEach var="listStages" items="${listStages}">
		<c:choose>
			<c:when
				test="${listEnterprise.getName() == listStages.getCompanyName()}">
				<c:set var="countEnterprise" value="${countEnterprise + 1}" />
			</c:when>
		</c:choose>
	</c:forEach>
	<option id="${totalCount}" value="${listEnterprise.getName()}"></option>
	<option id="${listEnterprise.getName()}" value="${countEnterprise}"></option>
	<c:set var="totalCount" value="${totalCount + 1}" />
	<c:set var="countEnterprise" value="0" />
</c:forEach>
<option id="totalCount" value="${totalCount}"></option>


<script>
Chart.defaults.global.legend.display = false;
var ctx = document.getElementById("pieChart");
var pieChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: [],
        datasets: [{
			      backgroundColor:[getRandomColor()], 
            label: '',
            data: []
            }]
		},
		 options: {
	            responsive: true,
	            legend: {
	                position: 'bottom',
	                labels: {
	                    fontColor: "black",
	                    boxWidth: 20,
	                    padding: 20
	                }
	            }
	        }});



function addData(chart, label, data) {

    chart.data.labels.push(label);
    chart.data.datasets.forEach((dataset) => {
    	dataset.backgroundColor.push(getRandomColor());
        dataset.data.push(data);

    });

    chart.update();
}
function pullData(){
	
	length = document.getElementById("totalCount").value;
	for (let i = 0; i < length; i++) {
		nameEnterprise = document.getElementById(i).value;
		numberEnterprise = document.getElementById(nameEnterprise).value;
		addData(pieChart,nameEnterprise ,[numberEnterprise])
		}
}

setTimeout(function() {
	var description = '${enterpriseName}';

	var chart = pieChart;
	pullData();
	
}, 3);

function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}
</script>


<%@ include file="/WEB-INF/views/assets/footer.jsp"%>