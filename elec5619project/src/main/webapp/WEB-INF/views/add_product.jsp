<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
  <head>
    <title>Add-product</title>
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
  <div class="container" style= "width:300px">

<form class="needs-validation" novalidate action="add_product" method="post">
  
    <div class="form-row">
      <label for="validationCustom01">Category</label>
      <input type="text" class="form-control" name="category" id="validationCustom01" placeholder="category" value="" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="form-row">
      <label for="validationCustom02">Price Date</label>
      <input type="text" class="form-control" name="price_date" id="validationCustom02" placeholder="price-date" value="" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    <div class="form-row">
      <label for="validationCustomUsername">Product ID</label>
      <div class="input-group">
        <input type="text" class="form-control" name="product_id" id="validationCustomUsername" placeholder="Product ID" value="" required>
        <div class="invalid-feedback">
          Please choose a product ID.
        </div>
      </div>
    </div>
    


    <div class="form-row">
      <label for="validationCustom03">Retailer ID</label>
      <input type="text" class="form-control" name="retailer_id" id="validationCustom03" placeholder="Retailer ID"  value="" required>
       
      <div class="invalid-feedback">
        Please provide a valid ID.
      </div>
    </div>
    	
    <div class="form-row">
      <label for="validationCustom04">Product Name</label>
      <input type="text" class="form-control" name="product_name" id="validationCustom04" placeholder="Product Name"  value="" required>
     
      <div class="invalid-feedback">
        Please provide a valid name.
      </div>
    </div>
    <div class="form-row">
      <label for="validationCustom05">Price</label>
      <input type="text" class="form-control" name="price" id="validationCustom05" placeholder="Price"  value="" required>
      <div class="invalid-feedback">
        Please provide a valid price.
      </div>
    </div>
  
  <input class="btn btn-primary" type="submit" value="Add" name="submit" />
</form>
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
</html>