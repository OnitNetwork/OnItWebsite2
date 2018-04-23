<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Onit - Login</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/png" href="img/favicon.ico"/>
    </head>
    <body>
        <div class="login-box">
        <img src="img/login.png" class="logo">
            <form action="login" method="POST">
                <p>Private Key:</p>
                <input type="text" name="privateKey">
                <p><input type="submit" value="Login"></p>
            </form>
        </div>
    </body>
</html>