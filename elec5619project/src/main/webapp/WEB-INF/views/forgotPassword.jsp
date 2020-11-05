<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include_login.jsp" %>
<html>
	<head>
	<style>
		#error,#error1,#error2,#error3,#error4,#errorreg {
			color:red;
			}
	</style>
	<script type="text/javascript">
	window.onload=function() {
		var password = document.getElementById("passid");
		password.onblur = function() {
			if (password.value == "" || password.value == " ") {
				var div = document.getElementById("error3")
				while( div.firstChild ) {
				    div.removeChild(div.firstChild);
				}
				div.appendChild( document.createTextNode("Please enter password") );
			}
		}
		password.onfocus = function() {
			if (password.value != "" || password.value != " ") {
				var div = document.getElementById("error3")
				while( div.firstChild ) {
				    div.removeChild(div.firstChild);
				}	
			}
		}
		
		var confirmpass = document.getElementById("confirmid");
		confirmpass.onblur = function() {
			if (confirmpass.value == "" || confirmpass.value == " " || confirmpass.value != password.value) {
				var div = document.getElementById("error4")
				while( div.firstChild ) {
				    div.removeChild(div.firstChild);
				}
				div.appendChild( document.createTextNode("password not matched") );
			}
		}
		confirmpass.onfocus = function() {
			if (confirmpass.value != "" || confirmpass.value != " " || confirmpass.value != password.value) {
				var div = document.getElementById("error4")
				while( div.firstChild ) {
				    div.removeChild(div.firstChild);
				}	
			}
		}
		}
	function reg()
	{
		var password = document.getElementById("passid");
		var confirmpass = document.getElementById("confirmid");
		var div= document.getElementById("errorreg")

		
		
		if (password.value == "" || password.value == " " || confirmpass.value=="" || confirmpass.value==" ") {
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild(document.createTextNode("Please enter details properly") );
			return false;
		} else {
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			return true;
		}
	}
	</script>
	</head>
	<body>
		<div class="container">
			<div style="margin-top: 90px;">
			<h1>Forgot Password</h1>
			<form action="/elec5619/resetPassowrd" onsubmit="return reg();" method="post"> 
				<div class="form-group">
				<label for="password">Password</label>
				<input type="password" class="form-control" style="width:240px" name="passwd" id="passid" minlength="8" placeholder="Enter Password">
				</div>
				<div id="error3"></div>
				<div class="form-group">
				<label for="ConfirmPassword">Confirm Password</label>
				<input type="password" class="form-control" style="width:240px" name="confirmpassword" id="confirmid" minlength="8" placeholder="Enter Confirm Password">
				</div>
				<div id="error4"></div>
			    <input type="submit" class="btn btn-outline-dark" value="Submit"> 
			    <div id="errorreg"></div>
			  </form>
			</div>
		</div>
	</body>
</html>