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
		<div class="fname">
		<form:label path="firstName">
			<form:input path="firstName" id="firstName" type="text" placeholder="First Name"
			cssStyle="font-size:18px; padding: 10px 20px 10px 5px; width:325px; border:none; outline:none; background:none;"
			></form:input>
		
		</form:label>
		</div>
		<div class="lname">
		<form:label path="lastName">
			<form:input path="lastName" id="lastName" type="text" placeholder="Last Name"
			cssStyle="font-size:18px; padding: 10px 20px 10px 5px; width:325px; border:none; outline:none; background:none;"
			></form:input>
		
		</form:label>
		</div>
		
		<div class="dob">
		<form:label path="dob">
			<form:input path="dob" id="dob" type="int" placeholder="Date of Birth"
			cssStyle="font-size:18px; padding: 10px 20px 10px 5px; width:325px; border:none; outline:none; background:none;"
			></form:input>
		
		</form:label>
		</div>
		
		<div class="email">
		<form:label path="email">
			<form:input path="email" id="email" type="text" placeholder="Email"
			cssStyle="font-size:18px; padding: 10px 20px 10px 5px; width:325px; border:none; outline:none; background:none;"
			></form:input>
		
		</form:label>
		</div>
		
		<div class="phone">
		<form:label path="phoneNumber">
			<form:input path="phoneNumber" id="phoneNumber" type="text" placeholder="Phone Number"
			cssStyle="font-size:18px; padding: 10px 20px 10px 5px; width:325px; border:none; outline:none; background:none;"
			></form:input>
		
		</form:label>
		</div>
			<button class="signup-btn" type="submit">Sign Up</button>
		</form:form>
		<div class="sign-in">
			<a href="/">Already have a Novus Bank Account? Login Here</a>
		</div>
		
		
	</div>
</body>
</body>
</html>