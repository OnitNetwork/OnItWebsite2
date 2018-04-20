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
            <h2>Public Key:</h2>
            <p id="pukey" style="word-wrap: break-word; font-size: 15px;"><% out.print(request.getAttribute("pukey")); %></p>
            <h2>Private:</h2>
            <p style="word-wrap: break-word; font-size: 15px;"><% out.print(request.getAttribute("prkey")); %></p>
            <h2 style="color: red;">Copy this now, there's no way to get it back later.</h2>
            <form action="createWallet" method="POST">                
                <p style="text-align: center;"><input type="submit" value="Continue to Login Page"></p>
                <input type="hidden" name="publicKey" value="<% out.print(request.getAttribute("pukey")); %>">
                <input type="hidden" name="privateKey" value="<% out.print(request.getAttribute("prkey")); %>">
                <input type="hidden" name="publicAddress" value="<% out.print(request.getAttribute("puadd")); %>">
            </form>
        </div>
    </body>
</html>