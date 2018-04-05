<%-- 
    Document   : index
    Created on : Feb 24, 2018, 4:02:23 PM
    Author     : sejal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>OnIt Blockchain</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <div class="login-box">
            <img src="img/Blockchain.png" class="logo">
            <h1>OnIt Blockchain</h1>
            
            <form action="UserHandler" method="POST">
            
                <p><input type="submit" value="Create New Wallet" name="action1"></p>
                
                <p><input type="submit" value="Login" name="action2"></p>
                
            
            </form>
        </div>
    </body>
</html>
