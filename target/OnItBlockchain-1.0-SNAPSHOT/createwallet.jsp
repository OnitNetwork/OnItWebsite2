<%-- 
    Document   : createwallet
    Created on : Feb 24, 2018, 3:59:01 PM
    Author     : sejal
--%>

<%@page import="com.onitbc.SignupHandler.keysAccessor"%>
<%@page import="com.onitbc.KeyGen" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>OnIt - Create New Wallet</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <%
            keysAccessor keyAcc = (keysAccessor) request.getAttribute("keys");
            %>
                
        <div class="login-box">
            <img src="img/wallet1.png" class="logo">            
                      
            <form action="transaction.jsp" method="POST">
                <p>Public:</p><br>
                <label><c:keyAcc.pubKey></label><br><br>
                <p>Private:</p><br>
                <label>SzavMBLoXU6kDrqtUVmffv</label><br><br>
                <h2>COPY THIS DOWN</h2>
                <p><input type="submit" value="Continue"></p>           
            </form>
        </div>
    </body>
</html>
