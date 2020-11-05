<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
  <head>
    <title>User-Profile</title>
    <style media="screen">
    th, td {
      padding: 15px;
      text-align: left;
    }
    table {
    }
    </style>
  </head>
  <body>
  <div class="container" style="max-width: 550px;">
  <div style="margin-top: 90px;">
  <h2 style="margin-left: -19px;">User Details</h2>
 <c:forEach items="${model.user}" var="prod">
<form class="needs-validation" novalidate action="user_details" method="post">
  
    <div class="form-group row">
      <label for="validationCustom01">First name</label>
      <input type="text" class="form-control" name="first_name" id="validationCustom01" placeholder="First name" value="<c:out value="${prod.first_name}"/>" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="form-group row">
      <label for="validationCustom02">Last name</label>
      <input type="text" class="form-control" name="last_name" id="validationCustom02" placeholder="Last name" value="<c:out value="${prod.last_name}"/>" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="form-group row">
      <label for="validationCustomUsername">Email</label>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend"></span>
        </div>
        <input type="text" class="form-control" name="email_id" id="validationCustomUsername"value="<c:out value="${prod.email_id}"/>" required>
        <div class="invalid-feedback">
          Please choose a username.
        </div>
      </div>
    </div>
    <div class="form-group row">
      <label for="validationCustom03">Password</label>
      <input type="password" class="form-control" name="passwd" id="validationCustom03" placeholder="Password" aria-describedby="passwordHelpBlock" value="<c:out value="${prod.passwd}"/>" required>
       <small id="passwordHelpBlock" class="form-text text-muted">
  Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
	</small>
      <div class="invalid-feedback">
        Please provide a valid password.
      </div>
    </div>
    	
    <div class="form-group row">
      <label for="validationCustom04">Postcode</label>
      <input type="text" class="form-control" name="post_code" id="validationCustom04" placeholder="Postcode"  value="<c:out value="${prod.post_code}"/>" required>
     
      <div class="invalid-feedback">
        Please provide a valid postcode.
      </div>
    </div>
    <div class="form-group row">
      <label for="validationCustom05">Mobile Number</label>
      <input type="text" class="form-control" name="mobile_no" id="validationCustom05" placeholder="Mobile Number" value="<c:out value="${prod.mobile_no}"/>" required>
      <div class="invalid-feedback">
        Please provide a valid mobile number.
      </div>
    </div>
  <button style="margin-left: -14px;" class="btn btn-outline-dark" type="submit" name="submit" value="Edit Profile">Submit </button>
</form>
</c:forEach>
<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
</div>
</div>
</body>
</html>