<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
       
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
       

  

  <form action="InsertData" method="POST">
            <table>
                 <tr>
                    <td>Number</td>
                    <td><input type="text" name="num" value="" /></td>
                </tr>
                <tr>
                    <td>From</td>
                    <td><input type="text" name="from" value="" /></td>
                </tr>
                <tr>
                    <td>To</td>
                    <td><input type="text" name="to" value="" /></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="des" value="" /></td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td><input type="text" name="role" value="" /></td>
                </tr>
                <tr>
                    <td>Technology</td>
                    <td><input type="text" name="technology" value="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add new" /></td>
                </tr>
            </table>
        </form>

        <%@include file="footer.jsp" %>
    </body>
</html>