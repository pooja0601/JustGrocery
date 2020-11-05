<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

	<script type="text/javascript" 
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" 
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style>
		#error {
		color: red;
		}
	</style>
	<script>
	function validateSearch() {
		var searchInput = document.getElementById("search");
		var productList = ["milk","bread","tomato","tim tam","potato","smiths thinly cut","kitkat","ccs doritos","cheese"];
		if (productList.indexOf(searchInput.value.toLowerCase()) > -1) {
			return true;
		} else {
			var div = document.getElementById("error")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild( document.createTextNode("Sorry, we do not have any details about the product") );
			return false;
		}
	}
	
	window.onload = function() {
		var searchInput = document.getElementById("search");
		searchInput.onblur = function() {
			if (searchInput.value == "" || searchInput.value == " ") {
				var div = document.getElementById("error")
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}
				div.appendChild( document.createTextNode("Please enter a product") );
			}
		}
		searchInput.onfocus = function() {
			if (searchInput.value != "" || searchInput.value != " ") {
				var div = document.getElementById("error")
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}	
			}
		}
	}
	</script>
<title>JustGrocery</title>
</head>
	<body>
	<div class="container">
	<div style="margin-top: 90px">
		<div class="form-group">
			<h2 style="text-align: center; margin-top: 55px;">Search Products</h2>
		</div>
		<form action="search" method="post" onsubmit="return validateSearch()" class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" name="search" id="search" placeholder="Search" aria-label="Search"/>
	      <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
	      <br/>
	    </form>
	    <div id="error"> </div>
	    </div>
	</div>
	<script type="text/javascript">
	$( function() {
	    var availableProducts = [
	      "Milk",
	      "Bread",
	      "Tomato",
	      "Tim Tam",
	      "Potato",
	      "Smiths Thinly Cut",
	      "KitKat",
	      "CCs Doritos",
	      "Cheese",
	    ];
	    $( "#search" ).autocomplete({
	      source: availableProducts
	    });
	  } );
	</script>
	
	
	</body>
</html>