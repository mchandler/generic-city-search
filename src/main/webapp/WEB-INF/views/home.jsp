<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h1>Hello world!</h1>
        
        <h4><c:out value="${locationName}"></c:out></h4>
    </body>
</html>
