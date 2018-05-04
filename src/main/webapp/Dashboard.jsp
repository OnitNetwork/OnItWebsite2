<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Onit - Transaction</title>
        <link rel="stylesheet" href="css/dashboard.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="shortcut icon" type="image/png" href="img/favicon.ico"/>
    </head>
    <body>

        <div class="modal fade" id="keys" tabindex="-1" role="dialog" aria-labelledby="keys" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Your Keys and Address</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p style="word-wrap: break-word;">Private Key: <% out.print(request.getAttribute("privateKey")); %></p>
                        <p style="word-wrap: break-word;">Public Key: <% out.print(request.getAttribute("publicKey")); %></p>
                        <p style="word-wrap: break-word;">Public Address: <% out.print(request.getAttribute("publicAddress")); %></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
            <div class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">
                <img id="logoimg" src="img/OnitTitle.png">
            </div>
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="logout">Sign out</a>
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
                                <a class="nav-link" href="#" data-toggle="modal" data-target="#keys">
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
                        <h1 class="h2">Balance: <% out.print(request.getAttribute("balance")); %> oni</h1>
                    </div>

                    <div id="body" class="pb-5 mb-5">
                        <div id="send" class="bodyCats">
                            <div class="sectionHead">Send</div>
                            <div id="sendBody">
                                <a name="send" href="send" class="btn btn-primary">Click Here to go to Transaction Page</a>
                            </div>
                        </div>

                        <div id="receive" class="bodyCats">
                            <div>
                                <div class="sectionHead">Receive</div>
                                <div id="mobiRecBody"><a href='#'>Click to copy Public Key</a></div>
                                <div id="dsktpRecBody"><a href="#" title="Click to copy"><% out.print(request.getAttribute("publicAddress"));%></a></div>
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
                                    <th>Total Sent</th>
                                    <th>Hash</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${tableData}" var="tableData">
                                    <tr>
                                        <td>${tableData.row}</td>
                                    </tr>
                                </c:forEach>
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