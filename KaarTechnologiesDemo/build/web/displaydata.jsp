<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home Page</title>



    </head>

    <body>




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
        <table align="center" width="80%">
            <%Iterator itr;  %>
            <%List data = (List) request.getAttribute("eData");
                for (itr = data.iterator(); itr.hasNext();) {
            %>
            <tr>
                <% String s = (String) itr.next();%>
                <th>Serial No</th>
           
                <td><%=s%></td>
           
              <th>From</th>
                  <td><%=itr.next()%></td>
                <th>To</th>
                <td><%=itr.next()%></td>
                <th>Description</th>
                <td><%=itr.next()%></td>
                <th>Role</th>
                <td><%=itr.next()%></td>
                <th>Technology</th>
                <td><%=itr.next()%></td>
                <td><input type="submit" value="Edit" name="edit" onclick="editRecord(<%=s%>);" /></td>
                <td><input type="submit" value="Delete" name="delete" onclick="deleteRecord(<%=s%>);" /></td>

            </tr>
            <tr></tr>
            <tr></tr>
           
    </form>

</tr>
<%}%>
 <td>
                
            <form action="ReportServlet" >
                <input type="submit" value="Generate PDF report">
            </form>
        </td>
</table>

        <%@include file="footer.jsp" %>
</body>
</html>