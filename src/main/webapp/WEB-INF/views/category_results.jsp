<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Search</title>
    </head>
    <body>
        <h1>Search Results</h1>
        
        <c:forEach var="match" items='${requestScope.matches}'>
        	<b><a href='../../places/<c:out value="${match.getLocationId()}" />/<c:out value="${match.getPublicId()}" />'><c:out value="${match.getName()}" /></a></b><br />
        	<c:out value="${match.getCategories()}" /><br />
        	<c:out value="${match.getAddress().toString()}" /><br /><br />
        </c:forEach>
        
        <p><i>(total pages: <c:out value="${totalPages}"></c:out> total matches: <c:out value="${totalMatches}"></c:out>)</i></p>
    </body>
</html>
