<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assests/css/transferstyle.css">
<link rel="preconnect" href="https://fonts.gstatic.com">

<link
	href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400&amp;display=swap"
	rel="stylesheet">
</head>
<body>

<div class="banner-area">
	<header>
		<form action="/homepage" method="GET">
		<button class="logo" type="submit" name="backToHome" value = <% out.println((String)request.getAttribute("user")); %>>
		Novus	Back to Account Page
		</button>
		</form>
		<a href="/" class="logout">Log Out</a>
		
	</header>
</div>
<div class="banner-text">
	<h2>Novus Banking</h2>
	<p>Account: <% out.println((long)request.getAttribute("accountNum")); %></p>
	<div class="container">
  
    <div class="item">
    	<h2>Transfer</h2>
    	<form method="POST" action="/transferSubmit">
    	<div class="account">
			<input class="ac" name="accountNum" type="text" placeholder="Account Number"/>

		</div>
			
    	<div class="amount">
			<input class="am" name="amount" type="text" placeholder="Amount"/>

		</div>
			
			<input type="hidden" name="accountSender" value = <% out.println((long)request.getAttribute("accountNum")); %>/>
			<button class="submit-btn" type="submit">Submit</button>
		</form>
    </div>
  </div>
</div>



</body>
</html>