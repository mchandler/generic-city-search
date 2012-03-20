<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="com.rmwebfx.citygridsearch.resources.Review" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head>
        <title>Place</title>
    </head>
    <body>
        <h1>Place Details</h1>
        
        <h4><c:out value="${locationName}"></c:out></h4>
        
        <%
        	List<Review> reviews = (ArrayList<Review>) request.getAttribute("reviews");
        %>
        
        <p><b><%= reviews.get(0).getTitle() %></b><br/><%= reviews.get(0).getText() %></p>
    </body>
</html>
