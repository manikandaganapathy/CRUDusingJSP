

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h3>Error:<%=(String) request.getAttribute("Error")%> </h3>
        <h3><a href="search.jsp">Search Again</a></h3>
        <%@include file="footer.jsp" %>
    </body>
</html>
