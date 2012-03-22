<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Place</title>
    </head>
    <body>
        <h1>Place Details</h1>
        
        <h4><c:out value="${place.getName()}"></c:out></h4>
        
        <p><c:out value="${place.getAddress().getStreet()}" /><br/>
        <c:out value="${place.getAddress().getCity()}" />, <c:out value="${place.getAddress().getState()}" /> <c:out value="${place.getAddress().getPostal()}" /><br />
        <c:out value="${place.getPhone()}" /></p>
        
        <h5>Reviews</h5>
        
        <c:forEach var="review" items="${place.getReviews()}">
        	<b><c:out value="${review.getTitle()}" /></b><br />
        	<c:out value="${review.getText()}"></c:out><br /><br />
        </c:forEach>
    </body>
</html>
