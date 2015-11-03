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

  <h1>Welcome <%
        try{
     HttpSession hs=request.getSession(true);
     String n=(String)hs.getAttribute("useme");
           out.print(n);
           hs.setAttribute("useme",n);
        }catch(Exception e){
            
        }
    %>
         !</h1>
         <ul type="disc">
             <li><a href="adddata.jsp">Add New Project</a></li>
             <li><a href="DisplayData">View Existing Projects</a></li>
             
         </ul>

        
       
        <%@include file="footer.jsp" %>


    </body>
</html>