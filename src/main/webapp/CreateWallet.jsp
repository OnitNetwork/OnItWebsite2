<%-- 
    Document   : CreateWallet
    Created on : Apr 16, 2018, 2:20:31 PM
    Author     : bryce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Onit - Create New Wallet</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/png" href="img/favicon.ico"/>
    </head>
    <body>
        <div class="login-box">
        <img src="img/wallet1.png" class="logo">
            <form action="createWalletHandler" method="POST">
                <% out.print(request.getAttribute("display data")); %>
                <h2>COPY THIS DOWN</h2>
                <p><input type="submit" value="Continue"></p>
            </form>
        </div>
    </body>
</html>