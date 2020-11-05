<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
	<title>Insert Products</title>
</head>
<body>
<div class="container" style= "width:300px">
<div style="margin-top: 90px">
<form class="needs-validation" novalidate action="add_retailer" method="post">
  	
    <div class="form-row">
      <label for="validationCustom01">Unique ID</label>
      <input type="text" class="form-control" name="id" id="validationCustom01" placeholder="ID" value="" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="form-row">
      <label for="validationCustom02">Name</label>
      <input type="text" class="form-control" name="name" id="validationCustom02" placeholder="Name" value="" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="form-row">
      <label for="validationCustomUsername">Contact</label>
      <div class="input-group">
        <input type="text" class="form-control" name="contact" id="validationCustomUsername" placeholder="contact" value="" required>
        <div class="invalid-feedback">
          Please choose a product ID.
        </div>
      </div>
    </div>
    


    <div class="form-row">
      <label for="validationCustom03">Tag</label>
      <input type="text" class="form-control" name="tag" id="validationCustom03" placeholder="tag"  value="" required>
       
      <div class="invalid-feedback">
        Please provide a valid ID.
      </div>
    </div>
    	
    <div class="form-row">
      <label for="validationCustom04">Location</label>
      <input type="text" class="form-control" name="location" id="validationCustom04" placeholder="location"  value="" required>
     
      <div class="invalid-feedback">
        Please provide a valid name.
      </div>
    </div>
    <div class="form-row">
      <label for="validationCustom05">Postcode</label>
      <input type="text" class="form-control" name="postcode" id="validationCustom05" placeholder="postcode"  value="" required>
      <div class="invalid-feedback">
        Please provide a valid price.
      </div>
    </div>
  
  <input class="btn btn-primary" type="submit" value="Add Retailer" name="submit" />
</form>
</div>
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

</body>