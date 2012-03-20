<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="com.rmwebfx.citygridsearch.resources.PlacesSearchMatch" %>
<%@ page import="com.rmwebfx.citygridsearch.resources.PlacesSearch" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h1>Search Results</h1>
        
        <% 
        	ArrayList<PlacesSearchMatch> matches = (ArrayList<PlacesSearchMatch>) request.getAttribute("matches");
        	for (int i = 0; i < matches.size(); i++) {
        		PlacesSearchMatch match = matches.get(i);
        		%> <a href="places/<%= match.getLocationId() %>/<%= match.getPublicId() %>"><%= match.getName() %></a><br/> <%
        	}
        %>
    </body>
</html>
