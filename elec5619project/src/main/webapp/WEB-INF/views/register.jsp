<%@ include file="/WEB-INF/views/include_login.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>   
<head>
<title>Register</title></head>
<style>
	#error,#error1,#error2,#error3,#error4,#errorreg {
	color:red;
	}
	body {
		background-image: url("https://www.nycfoodpolicy.org/wp-content/uploads/2018/05/shutterstock_418522381-2.jpg");
        background-repeat:no-repeat;
        background-size:cover;
} 
</style>
<script>
	window.onload=function() {
	var firstname = document.getElementById("firstid");
	firstname.onblur = function() {
		if (firstname.value == "" || firstname.value == " ") {
			var div = document.getElementById("error")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild( document.createTextNode("Please enter firstname") );
		}
	}
	firstname.onfocus = function() {
		if (firstname.value != "" || firstname.value != " ") {
			var div = document.getElementById("error")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}	
		}
	}
	
	var lastname = document.getElementById("lastid");
	lastname.onblur = function() {
		if (lastname.value == "" || lastname.value == " ") {
			var div = document.getElementById("error1")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild( document.createTextNode("Please enter lastname") );
		}
	}
	lastname.onfocus = function() {
		if (lastname.value != "" || lastname.value != " ") {
			var div = document.getElementById("error1")
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}	
		}
	}
	
	var email = document.getElementById("emailid");
	email.onblur = function() {
		if (email.value == "" || email.value == " ") {
			var div = document.getElementById("error2")
			while( div.firstChild ) {
			    div.removeChild(div.firstChild);
			}
			div.appendChild( document.createTextNode("Please enter email") );
		}
	}
	email.onfocus = function() {
		if (email.value != "" || email.value != " ") {
			var div = document.getElementById("error2")
			while( div.firstChild ) {
			    div.removeChild(div.firstChild);
			}	
		}
	}
	
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
		var firstname = document.getElementById("firstid");
		var lastname= document.getElementById("lastid");
		var email = document.getElementById("emailid");
		var password = document.getElementById("passid");
		var confirmpass = document.getElementById("confirmid");
		var div= document.getElementById("errorreg")

		
		
		if (firstname.value == "" || firstname.value == " " || lastname.value == "" || lastname.value == " " || email.value == "" || email.value == " "
				|| password.value == "" || password.value == " " || confirmpass.value=="" || confirmpass.value==" ") {
			console.log("invalid");
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild(document.createTextNode("Please enter details properly") );
			return false;
		} else {
			console.log("valid");
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			return true;
		}
	}
	
</script>

</head>
<body>
<!-- <div class="container" style="margin: 100px 500px 100px 500px"> -->
<div class="container" style="margin-left:465px;margin-top:10px; max-width:750px">
<h1>Register</h1>

<form action="/elec5619/register" onsubmit="return reg();" method="post">
	<div class="form-group" >
	<label for="firstname">FirstName</label>
	<input type="text" class="form-control" style="width:240px" name="first_name" id="firstid"  placeholder="Enter Firstname">
	</div>
	<div id="error"></div>
	<div class="form-group">
	<label for="lastname">LastName</label>
	<input type="text" class="form-control" style="width:240px" name="last_name" id="lastid"  placeholder="Enter Lastname">
	</div>
	<div id="error1"></div>
	<div class="form-group">
	<label for="email id">Email Address</label>
	<input type="email" class="form-control" style="width:240px" name="email_id" id="emailid"  placeholder="Enter Email Address">
	</div>
	<div id="error2"></div>
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
</body>

</html>