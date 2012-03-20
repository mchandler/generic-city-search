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
        
        <h4><c:out value="${locationName}"></c:out> (<c:out value="${publicId}"></c:out>)</h4>
        
        <%
        	List<Review> reviews = (ArrayList<Review>) request.getAttribute("reviews");
        %>
        
        <p><%= reviews.get(0).getTitle() %></p>
    </body>
</html>
