<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home Page</title>
        
        
    </head>
    <body>
   

          <form action="UpdateData" method="POST">
        <table border="1px" width="80%">
 
            <%ResultSet res = (ResultSet) request.getAttribute("editData");%>
            <% if (res.next()) {
            %>
             
            <tr>
                <td>Number</td>
                <td><input type="text" readonly name="number" value="<%=res.getString("num")%>"/></td>
            </tr>
            <tr>
                <td>From</td>
                <td><input type="text" name="from" value="<%=res.getString("fromdate")%>"/></td>
            </tr>
            <tr>
                <td>To</td>
                <td><input type="text" name="to" value="<%=res.getString("todate")%>"/></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="des" value="<%=res.getString("des")%>"/></td>
            </tr>
            <tr>
                <td>Role</td>
                <td><input type="text" name="role" value="<%=res.getString("role")%>"/></td>
            </tr>
            <tr>
                <td>Technology</td>
                <td><input type="text" name="tech" value="<%=res.getString("tech")%>"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update" /></td>
            <%
            }%>


            </tr>
            
        </table>
        </form>

        <%@include file="footer.jsp" %>
    </body>
</html>