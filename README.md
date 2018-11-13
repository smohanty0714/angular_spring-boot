# angular_spring-boot
Prerequisites: Java 8, Maven

<h2>Getting Started</h2>
To install and test this spring boot application, run the following commands:

<p>This will get a copy of the project installed locally.</p>

<code>git clone https://github.com/smohanty0714/angular_spring-boot.git</code></br>

To install all of its dependencies and start each app, follow the instructions below.

To run the server, cd into the server folder and run:

<code>cd angular_spring-boot\tradingview</code></br>
<code>mvn spring-boot:run</code></br>


<p> You can test the API by below URL and Parameter : </p>

<h3>GET, Path /market/orderbook</h3>
<code>http://localhost:8080/market/orderbook</code> 

<p> It will return the order list JSON</p>
<br>

<h3>POST, Path /market/placeOrder</h3>
<code>http://localhost:8080/market/placeOrder
payload: {"side": "BUY", "price": 15, "volume": 10}  or {"side": "SELL", "price": 10, "volume": 8}
</code> 
<p> It will Save the order details and return success message</p>
<br>
<br>
