<%-- 
    Document   : transaction
    Created on : Feb 26, 2018, 12:08:57 PM
    Author     : sejal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
	<title>OnIt - Transaction</title>
	<link rel="stylesheet" href="css/transaction.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">
				<img src="img/Blockchain.png">
			</div>
			<div id="title">
				<p>OnIt Blockchain</p>
			</div>

			<div id="wallet">
				<p>Wallet Balance <strong>3.57 ONI</strong></p>
			</div>
		</div>

		<div id="body">
			<div id="send">
				<h2>Send</h2>
				<input type="text" name="address" placeholder="Address"><br>
				<input type="text" name="amnt" placeholder="Amount (ONI)"><br>
				<input type="submit" name="send" value="Send">
			</div>

			<div id="receive">
                            <div>
				<h2>Receive</h2>
                                <a href='#'>02a1633cafcc01ebfb6d78e39f687a1f0995c62fc95f51ead10a02ee0be551b5dc</a>
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
					<td><a href="#">54821</a></td>
					<td>&lt;1m</td>
					<td>892</td>
					<td>650.45 ONI</td>
					
					<td>87.42</td>
					<td><a href="#">view</a></td>
				</tr>
				<tr>
					<td><a href="#">54820</a></td>
					<td>3m</td>
					<td>427</td>
					<td>8724.67 ONI</td>
					
					<td>1024.89</td>
					<td><a href="#">view</a></td>
				</tr>
				<tr>
					<td><a href="#">54819</a></td>
					<td>7m</td>
					<td>89</td>
					<td>9247.77 ONI</td>
				
					<td>347.24</td>
					<td><a href="#">view</a></td>
				</tr>
				<tr>
					<td><a href="#">54818</a></td>
					<td>12m</td>
					<td>1127</td>
					<td>784.32 ONI</td>
					
					<td>932.44</td>
					<td><a href="#">view</a></td>
				</tr>
				<tr>
					<td><a href="#">54817</a></td>
					<td>20m</td>
					<td>624</td>
					<td>29.64 ONI</td>
					
					<td>1008.19</td>
					<td><a href="#">view</a></td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>
