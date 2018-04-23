<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Onit - Transaction</title>
        <link rel="stylesheet" href="css/dashboard.css">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="shortcut icon" type="image/png" href="img/favicon.ico"/>
    </head>
    <body>
        <div id="container">
            <div id="headerContainer"><div id="header">
                    <div id="title">
                        <div><img id="img" src="img/Blockchain.png"></div>
                        <div id="headText"><h1>Onit Blockchain</h1></div>
                    </div>

                    <div id="logout">
                        <a href="logout"><h3>Logout</h3></a>
                    </div>
                </div></div>

            <div id="wallet">
                <h2>Wallet Balance: <strong>100 ONI</strong></h2>
            </div>

            <div id="body">
                <div id="send" class="bodyCats">
                    <div class="sectionHead">Send</div>
                    <div id="sendBody">
                        <input type="text" name="address" placeholder="Address" style="width: 300px;"><br>
                        <input type="text" name="amnt" placeholder="Amount (ONI)" style="width: 200px;"><br>
                        <input type="submit" name="send" value="Send">
                    </div>
                </div>

                <div id="receive" class="bodyCats">
                    <div>
                        <div class="sectionHead">Receive</div>
                        <div id="mobiRecBody"><a href='#'>Click to copy Public Key</a></div>
                        <div id="dsktpRecBody"><a href="#" title="Click to copy">02a1633cafcc01ebfb6d78e39f687a1f0995c62fc95f51ead10a02ee0be551b5dc</a></div>
                    </div>
                </div>
            </div>

            <div id="ledger">
                <h2>Latest Blocks</h2>

                <table>
                    <tr>
                        <th>Height</th>
                        <th>Age</th>
                        <th>Transactions</th>
                        <th>Total Sent</th>

                        <th>Size (kB)</th>
                        <th>Hash</th>
                    </tr>
                    <tr>
                        <td><a href="#">Genesis</a></td>
                        <td>1d</td>
                        <td>0</td>
                        <td>0 ONI</td>

                        <td>0</td>
                        <td><a href="#">view</a></td>
                    </tr>
                </table>

            </div>
        </div>
    </body>
</html>
