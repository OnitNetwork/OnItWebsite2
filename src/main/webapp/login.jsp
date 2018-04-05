<%-- 
    Document   : login
    Created on : Feb 24, 2018, 3:58:46 PM
    Author     : sejal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>OnIt - Login</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <div class="login-box">
            <img src="img/login.png" class="logo">
            
            <form action="transaction.jsp" method="POST">
                <p>Private Key:</p>
                <input type="text" name="public">                
                <p><input type="submit" value="Login"></p>            
            </form>
        </div>
    </body>
</html>
