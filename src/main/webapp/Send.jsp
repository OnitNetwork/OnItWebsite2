<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Onit Network - Send</title>
        <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/send.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <link rel="shortcut icon" type="image/png" href="img/favicon.ico"/>
    </head>

    <body class="text-center">
        <form class="form-signin">
            <img class="mb-4" src="img/OnitLogo.png" alt="" width="200" height="200">
            <h1 class="h3 mb-3 font-weight-normal">Balance: <% out.print(request.getAttribute("balance")); %> oni</h1>
            <label for="inputEmail" class="sr-only">Recipient's Address</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Recipient's Address" required autofocus>
            <label for="inputPassword" class="sr-only">Amount (ONI)</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Amount (ONI)" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Send</button>
            <div class="mt-5 mb-3 text-muted"></div>
        </form>
    </body>
</html>