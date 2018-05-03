<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Onit - Transaction</title>
        <link rel="stylesheet" href="css/dashboard.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="shortcut icon" type="image/png" href="img/favicon.ico"/>
    </head>
    <body>
        <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
            <div class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">
                <img id="logoimg" src="img/OnitTitle.png">
            </div>
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="#">Sign out</a>
                </li>
            </ul>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
                                    <span data-feather="home"></span>
                                    Dashboard <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span data-feather="shopping-cart"></span>
                                    View Transactions
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span data-feather="file"></span>
                                    View Your Keys
                                </a>
                            </li>                            
                        </ul>

                        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                            <span>Resources</span>
                        </h6>
                        <ul class="nav flex-column mb-2">
                            <li class="nav-item">
                                <a class="nav-link" href="http://www.coinbase.com" target="_blank">
                                    Coinbase
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://cryptowat.ch" target="_blank">
                                    Cryptowat.ch
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="https://www.affordbitcoin.com/" target="_blank">
                                    Bitcoin Advisor
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                        <h1 class="h2">Dashboard</h1>
                        <h1 class="h2">Balance: <% out.print(request.getAttribute("balance")); %></h1>
                    </div>

                    <div id="body" class="pb-5 mb-5">
                        <div id="send" class="bodyCats">
                            <div class="sectionHead">Send</div>
                            <div id="sendBody">
                                <input type="text" name="address" placeholder="Address" style="width: 300px;"><br>
                                <input type="text" name="amnt" placeholder="Amount (ONI)" style="width: 200px;"><br>
                                <input type="submit" name="send" value="Send" class="btn btn-primary">
                            </div>
                        </div>

                        <div id="receive" class="bodyCats">
                            <div>
                                <div class="sectionHead">Receive</div>
                                <div id="mobiRecBody"><a href='#'>Click to copy Public Key</a></div>
                                <div id="dsktpRecBody"><a href="#" title="Click to copy"><% out.print(request.getAttribute("publicAddress")); %></a></div>
                            </div>
                        </div>
                    </div>


                    <h2>Latest Blocks</h2>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead>
                                <tr>
                                    <th>Height</th>
                                    <th>Age</th>
                                    <th>Transactions</th>
                                    <th>Total Sent</th>
                                    <th>Size (kB)</th>
                                    <th>Hash</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Genesis</td>
                                    <td>1d</td>
                                    <td>0</td>
                                    <td>0 ONI</td>
                                    <td>0</td>
                                    <td><a href="#">view</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </main>
            </div>
        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha256-3edrmyuQ0w65f8gfBsqowzjJe2iM6n0nKciPUp8y+7E=" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js"></script>

        <!-- Icons -->
        <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
        <script>
            feather.replace()
        </script>
    </body>
</html>