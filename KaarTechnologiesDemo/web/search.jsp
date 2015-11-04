<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h3>Search our DB</h3>
        <form name="mySearch" action="SearchRecord" method="POST">
            Search Index<br/><input type="text" name="num" value="" />
            <input type="submit" value="Search" />
        </form>
          <%@include file="footer.jsp" %>
    </body>
</html>
