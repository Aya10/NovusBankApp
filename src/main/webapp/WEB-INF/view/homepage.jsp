<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assests/css/homestyle.css">
<link rel="preconnect" href="https://fonts.gstatic.com">

<link
	href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400&amp;display=swap"
	rel="stylesheet">
</head>
<body>

<div class="banner-area">
	<header>
		<a href="#" class="logo">novus</a>
		<a href="/" class="logout">Log Out</a>
		
	</header>
</div>
<div class="banner-text">
	<h2>Novus Banking</h2>
	<p>Banking at Novus</p>
	<div class="container">
    <div class="item">
    	<h2>Welcome</h2>
    	<h5>Accounts:</h5>
    	<%
    	int length = (int)request.getAttribute("lengthAcc"); 
    	
		for (int i=0; i<length; i++){

		   	String tempAcc = "accNum" + i;
	    	String tempBal = "accBal" + i;
	    	
		   	long tempAccountNumber = (long)request.getAttribute(tempAcc);
		   	int tempBalance = (int)request.getAttribute(tempBal);
		   	
	    	System.out.println(tempAccountNumber);
	    	System.out.println(tempBalance);	   	    		
		
    	%>  
    	<a href="/">
	    	<button type="button" class = "amount">
	    	
	    	Account Number : <% out.println(tempAccountNumber); %>
	    	<br>
	    	Balance : <% out.println(tempBalance); %>
	    	
	    	</button>
	    </a>
    		<%
		}
    		%>
    				
    </div>

  </div>
</div>



</body>
</html>
