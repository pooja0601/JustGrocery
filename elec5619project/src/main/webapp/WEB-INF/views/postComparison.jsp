<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<title>JustGrocery</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.angularjs.org/1.4.12/angular.js"></script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<!-- <style>
.wow_price {
	border: 1px solid darkgreen;
}
</style> -->
<!-- <script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script> -->
<script type="text/javascript">
window.onload = function() { 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	exportEnabled: false,
	animationEnabled: true,
	width: 330,
	height:260,
	title: {
		text: "Woolworths",
		fontSize: 18
	},
	data: [{
		type: "pie",
		toolTipContent: "<b>{label}</b>: {y}$",
		indexLabel: "{label} - {y}$",
		dataPoints: ${model.wow}}]
});
var chart2 = new CanvasJS.Chart("chartContainer2", {
	theme: "light2", // "light1", "dark1", "dark2"
	exportEnabled: false,
	animationEnabled: true,
	width: 330,
	height:260,
	title: {
		text: "Coles",
		fontSize: 18
	},
	data: [{
		type: "pie",
		toolTipContent: "<b>{label}</b>: {y}$",
		indexLabel: "{label} - {y}$",
		dataPoints: ${model.col}}]
});
var chart3 = new CanvasJS.Chart("chartContainer3", {
	theme: "light2", // "light1", "dark1", "dark2"
	exportEnabled: false,
	animationEnabled: true,
	width: 330,
	height:260,
	title: {
		text: "Aldi",
		fontSize: 18
	},
	data: [{
		type: "pie",
		toolTipContent: "<b>{label}</b>: {y}$",
		indexLabel: "{label} - {y}$",
		dataPoints: ${model.ald}}]
});
chart.render();
chart2.render();
chart3.render();
} 
 </script>
 </head>
<body>
<div style="margin-top: 90px">
<h1 style="text-align:center;font-size:24px">WishList Products Comparison</h1>
<div class="container">
<form action="/elec5619/wishListComparison" method="post">
    Select Wishlist:&nbsp;
    <select name="wishlist">
        <c:forEach items="${model.WLnames}" var="wishlist">
            <option value="${wishlist}">${wishlist}</option>
        </c:forEach>
    </select>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select Location:&nbsp;
    <select name="loc">
        <c:forEach items="${model.location}" var="location">
            <option value="${location}">${location}</option>
        </c:forEach>
    </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" class="btn btn-outline-dark" value="Fetch" />
</form>
<p style="display:inline">Comparison being shown for WishList named </p><b><i><p style="display:inline">"${model.selected_wl}"</p></i></b><p style="display:inline"> and for location</p><b><i><p  style="display:inline"> "${model.selected_loc}" </p></i></b><br><br>
	<table class="table">
	  <thead class="thead-light">
	    <tr>
	      <th scope="col" style="width:40%">Product Name</th>
	      <th scope="col"style="width:20%">Woolworths</th>
	      <th scope="col"style="width:20%">Aldi</th>
	      <th scope="col"style="width:20%">Coles</th>
	    </tr>
	  </thead>
	  <tbody>
	<c:forEach var="row" items="${model.retailers}">
	    <tr>
		<c:forEach var="col" items="${row}">
			 <c:set var="col_parts" value="${fn:split(col, '=')}" /> 
	        <td class="${col_parts[0]}" style="font-size:14px">${col_parts[1]}</td>       
	</c:forEach>
	    </tr>  
	</c:forEach>
	</tbody>
	</table>
	
	<div style="width: 100%; display: table;">
	    <div style="display: table-row">
	        <div id="chartContainer" style="display: table-cell;"></div>
	        <div id="chartContainer3" style="display: table-cell;"></div>
	        <div id="chartContainer2" style="display: table-cell;"></div>
	    </div>
	</div>
	</div>
</div>

</body>

</html>

