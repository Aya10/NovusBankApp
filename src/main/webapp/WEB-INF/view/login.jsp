<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="assests/css/style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400&amp;display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="login-div">
		<div class="logo">
			<img src="assests/img/novuslogo.jpg"alt="" >
		</div>

		<div class="title">Novus Bank</div>
		<div class="subtitle">Banking with Novus</div>
		<form:form method="POST" modelAttribute="userLogin" action="/login">

			<div class="email">
				<form:label path="email">
					<form:input path="email" id="email" type="text" placeholder="Email"
						cssStyle="font-size:18px; padding: 10px 20px 10px 5px; width:325px; border:none; outline:none; background:none;" />
				</form:label>
			</div>

			<div class="password">
				<form:input path="password" id="password" type="password" placeholder="Password"
					cssStyle="font-size:18px; padding: 10px 20px 10px 5px; width:325px; border:none; outline:none; background:none;" />
			</div>
			<div class="options">
				<div class="remember-me">
					<input id="remember-me" type="checkbox"> <label
						for="remember-me">Remember Me</label>
				</div>
				<div class="forgot-password">
					<a href="/test">Forgot Password</a>
				</div>
			</div>

		<button class="signin-btn" type="submit">LOGIN</button>
		</form:form>
		
		
		<div class="sign-up">
			<a href="/SignUp">New to Novus Bank? Sign Up Here</a>
		</div>


	</div>



</body>
</html>
