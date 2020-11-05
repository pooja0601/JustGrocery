<%@ include file="/WEB-INF/views/include.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
<div class="container">
<div style="margin-top: 90px">
<c:choose>
    <c:when test="${model.message!=null}">
        <p>"${model.message}"</p>
        <input type="button" onClick="window.history.go(-1)" value="Edit Wishlist" >
    </c:when>
    <c:otherwise>
        <p>Saved Successfully</p>
        
    </c:otherwise>
</c:choose>


</div>
</div>

</body>
</html>
