<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h2>Public</h2>
            <p><% out.print(request.getAttribute("pukey")); %></p>
            <h2>Private:</h2>
            <p><% out.print(request.getAttribute("prkey")); %></p>
            <h3>COPY THIS DOWN</h3>
            <form action="createWallet" method="POST">
                <p><input type="submit" value="Continue"></p>
                <input type="hidden" name="publicKey" value="<% request.getAttribute("pukey"); %>">
                <input type="hidden" name="privateKey" value="<% request.getAttribute("prkey"); %>">
                <input type="hidden" name="publicAddress" value="<% request.getAttribute("puadd"); %>">
            </form>
        </div>
    </body>
</html>