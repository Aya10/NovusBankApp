<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="assests/css/signupstyle.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400&amp;display=swap"
	rel="stylesheet">
</head>
<body>
<body>
	<div class="signup-div">
		<div class="logo">
			<img src="assests/img/novuslogo.jpg" alt="" >
		</div>
		
		<div class="title">Novus Bank</div>
		<div class="subtitle">Banking with Novus</div>
		<form:form method="POST" modelAttribute="userForm" action="/formSubmitted">
		
		<form:label path="firstName">
			<form:input path="firstName" id="firstName" type="text" placeholder="First Name"></form:input>
		<label for="firstName"> First Name </label>
		</form:label>
		<form:label path="lastName">
			<form:input path="lastName" id="lastName" type="text" placeholder="Last Name"></form:input>
		<label for="lastName"> Last Name </label>
		</form:label>
		<form:label path="dob">
			<form:input path="dob" id="dob" type="int" placeholder="Date of Birth"></form:input>
		<label for="dob"> Date of Birth </label>
		</form:label>
		<form:label path="email">
			<form:input path="email" id="email" type="text" placeholder="Email"></form:input>
		<label for="email"> Email </label>
		</form:label>
		<form:label path="phoneNumber">
			<form:input path="phoneNumber" id="phoneNumber" type="text" placeholder="Phone Number"></form:input>
		<label for="phoneNumber"> Phone Number</label>
		</form:label>

			<button class="signup-btn" type="submit">Sign Up</button>
		</form:form>
		<div class="sign-in">
			<a href="/">Already have a Novus Bank Account? Login Here</a>
		</div>
		
		
	</div>
</body>
</body>
</html>