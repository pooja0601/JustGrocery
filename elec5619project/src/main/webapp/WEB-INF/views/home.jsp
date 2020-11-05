<%@ include file="/WEB-INF/views/include.jsp" %>
<html>   
<head>
<title>Home</title>
<style>
		#error,#error1,#errorlogin {
		color: red;
		}
		
	</style>
	<script>
	window.onload = function() {
		var searchInput = document.getElementById("usid");
		var passInput= document.getElementById("passid");
		searchInput.onblur = function() {
			if (searchInput.value == "" || searchInput.value == " ") {
				var div = document.getElementById("error")
				while( div.firstChild ) {
				    div.removeChild( div.firstChild );
				}
				div.appendChild( document.createTextNode("Please enter username") );
			}
		}
		passInput.onblur = function() {
			if (passInput.value == "" || passInput.value == " ") {
				var divp = document.getElementById("error1")
				while( divp.firstChild ) {
				    divp.removeChild( divp.firstChild );
				}
				divp.appendChild( document.createTextNode("Please enter password") );
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
		passInput.onfocus = function() {
			if (passInput.value != "" || passInput.value != " ") {
				var divp = document.getElementById("error1")
				while( divp.firstChild ) {
				    divp.removeChild( divp.firstChild );
				}	
			}
		}
	}
	function sub()
	{
		var searchInput = document.getElementById("usid");
		var passInput= document.getElementById("passid");
		var div = document.getElementById("errorlogin");

		if (passInput.value == "" || passInput.value == " " || searchInput.value == "" || searchInput.value == " ") {
			console.log("invalid");
			while( div.firstChild ) {
			    div.removeChild( div.firstChild );
			}
			div.appendChild( document.createTextNode("Please enter username/password") );
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

<div class="container">


<h1>Login</h1>
<form action="/elec5619/home/login" onsubmit="return sub();" method="post">  
    Email:<input type="email" name="email_id" id="usid" />
    <div id="error"> </div>
    <br/>  
    Password:<input type="password" name="passwd" id="passid"/>
    <div id="error1"> </div>
    <br/>  
    <input type="submit" value="login"/> 
    <div id="errorlogin"></div> 
</form>
<p> ${model}</p>
 <form action="/elec5619/home/register/" method="post">
 	<input type="submit" value="register"/>
 </form>
 


</div>
</body> 
</html> 
