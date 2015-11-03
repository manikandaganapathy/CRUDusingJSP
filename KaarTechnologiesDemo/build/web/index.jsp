
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
 <script type="text/javascript">
        function validate()
        {



            if ((document.myForm.user.value === "") && (document.myForm.pass.value === "")) {
                alert("Please enter username and password!");
                document.myForm.user.focus();
                document.myForm.pass.focus();
                return false;
            }

            if (document.myForm.user.value === "")
            {
                alert("Please enter username!");
                document.myForm.user.focus();
                return false;
            }

            if (document.myForm.pass.value === "")
            {
                alert("Please enter a password!");
                document.myForm.pass.focus();
                return false;
            }


            return(true);
        }

    </script>
    </head>
   
    <body>



        <form name="myForm" onsubmit="return validate()" action="ValidateLogin" method="POST">
            <table border="0" width="200" align="center">
                <thead>
                    <tr>
                        <th>Login</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="user"  id="username" onblur="validateUsername();" /></td>
                        <td><label id="errorusername"></label></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" id="password" onblur="validatePassword();" /></td>
                        <td><label id="errorpassword"></label></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit" /></td>
                        <td></td>
                    </tr>
                <br><br><br/>
                
                </tbody>
            </table>

        </form>

    </body>
</html>
