<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Search Page</title>
        <script type="text/javascript">

            function editRecord(num) {
                url = "EditRecord";
                window.location.href = "http://localhost:8080/KaarTechnologiesDemo/" + url + "?num=" + num;

            }
            function deleteRecord(num) {
                url = "DeleteRecord";
                window.location.href = "http://localhost:8080/KaarTechnologiesDemo/" + url + "?num=" + num;

            }
        </script> 

    </head>
    <body>



        <table align="center" width="80%">

            <%

                ResultSet res = (ResultSet) request.getAttribute("searchData");%>
            <% if (res.next()) {
            %>
            <th><hr>Search Result
            <hr>
            </th> 

            <tr>
                <td>Number</td><td>:</td>
                <td><%=res.getString("num")%></td>
            </tr>
            <tr>
                <td>From</td><td>:</td>
                <td><%=res.getString("fromdate")%></td>
            </tr>
            <tr>
                <td>To</td><td>:</td>
                <td><%=res.getString("todate")%></td>
            </tr>
            <tr>
                <td>Description</td><td>:</td>
                <td><%=res.getString("des")%></td>
            </tr>
            <tr>
                <td>Role</td><td>:</td>
                <td><%=res.getString("role")%></td>
            </tr>
            <tr>
                <td>Technology</td><td>:</td>   
                <td><%=res.getString("tech")%></td>
            </tr>
            <tr>

                <%
                }%>
</tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr>
    <td></td>
                <td><input type="submit" value="Edit" name="edit" onclick="editRecord(<%=res.getString("num")%>);" /></td>
                <td><input type="submit" value="Delete" name="delete" onclick="deleteRecord(<%=res.getString("num")%>);" /></td>
            
</tr>

        </table>


        <%@include file="footer.jsp" %>
    </body>
</html>