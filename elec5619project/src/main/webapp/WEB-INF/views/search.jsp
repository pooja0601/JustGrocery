<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
	<title>JustGrocery</title>
</head>
<body>
	<div class="container">
		<h3 style="margin-top: 90px;">Search Result</h3>
		<div class="card-deck">
			<c:forEach items="${model.products}" var="prod">
			<form action="add" method="post">
			  <div class="card" style="min-width: 350px; max-width: 350px; min-height: 550px; max-height: 600px; margin-bottom: 5px;">
			    <img src="${prod.product_image}" style="width: 99%; margin-left:1px;" class="card-img-top" alt="...">
			    <div class="card-body">
			      <h3 class="card-title"><c:out value="${prod.product_name}"/></h3>
			      <input type="hidden" name="productName" value="${prod.product_name}">
			      <h5>Price: $<c:out value="${prod.price}"/> </h5>
			      <c:choose>
					   <c:when test="${prod.retailer.name.equals('Woolworths')}"><p style="color: green"><c:out value="${prod.retailer.name}"/> </p></c:when>
					   <c:when test="${prod.retailer.name.equals('Coles')}"><p style="color: red"><c:out value="${prod.retailer.name}"/> </p></c:when>
					   <c:when test="${prod.retailer.name.equals('Aldi')}"><p style="color: blue"><c:out value="${prod.retailer.name}"/> </p></c:when>
				  </c:choose>
			    </div>
			    <div class="card-footer">
			      <small>Location: <c:out value="${prod.retailer.location}"/> </small>
			      <select name="wishlistSelected" class="btn btn-outline-dark" class="form-control" id="exampleFormControlSelect1">
					   <option value="Select">Select WishList</option>
					  <c:forEach items="${model.wishlists}" var="wishItem">
					    <option value="${wishItem.wishlist_name}">${wishItem.wishlist_name}</option>
					</c:forEach>  
					</select >
			      <button style="float:right;" type="submit" class="btn btn-outline-dark"><span class="fa fa-plus"></span></button>
			    </div>
			  </div>
			</form>
			<%-- <c:out value="${prod.price_date}"/><i>||||<c:out value="${prod.product_id}"/></i><i>||||<c:out value="${prod.retailer_id}"/></i><i>||||<c:out value="${prod.product_name}"/></i><i>||||<c:out value="${prod.price}"/></i><br><br> --%>
			</c:forEach>
		</div>
	</div>
</body>
</html>

