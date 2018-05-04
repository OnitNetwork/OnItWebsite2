<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Onit Network - Send</title>
        <link href="css/send.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <link rel="shortcut icon" type="image/png" href="img/favicon.ico"/>
    </head>
    <body class="text-center">
        <form class="form-signin" action="send" method="POST">
            <img class="mb-4" src="img/OnitLogo.png" alt="" width="200" height="200">
            <h1 name="balance" class="h3 mb-3 font-weight-normal">Balance: <% out.print(request.getAttribute("balance")); %> oni</h1>
            <label for="inputAddress" class="sr-only">Recipient's Address</label>
            <input type="text" id="inputAddress" class="form-control" name="sendAddress" placeholder="Recipient's Address" required autofocus>
            <label for="inputAmount" class="sr-only">Amount (ONI)</label>
            <input type="text" id="inputAmount" class="form-control" name="sendAmount" placeholder="Amount (ONI)" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Send</button>
            <div class="mt-5 mb-3 text-muted"><% out.print(request.getAttribute("notify")); %></div>
        </form>
    </body>
</html>