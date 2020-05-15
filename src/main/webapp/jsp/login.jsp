<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login-login</title>
</head>
<body>
<h1 align="center">Login Form</h1>
</hr>
<script type="text/javascript">
	 function validateForm() {
		
		var un = document.loginForm.username.value;
		var pw = document.loginForm.password.value;
		//alert('un '+un +'pw '+pw);
		
		if ((un == "") && (pw == "")) {
			//alert('un '+un );
			alert("Login was unsuccessful, please Enter your username and password");
			return false;
		}		
		else if ((un == "") ) {
			alert("Login was unsuccessful, please Enter your username");			
			return false;
		}else if ((pw == "") ) {
					
			alert("Login was unsuccessful, please Enter your password");
			return false;
		}  
		else if((un!=null) && (pw!=null)) {
			//alert('un '+un );onsubmit="return validateForm();""
			//alert("Login was unsuccessful, please Enter your username and password");
			return true;
		} 
		else {
			alert("Login was unsuccessful, please check your username and password");
		}
	};
</script>

	<form name="loginForm" action="authenticateUser" method="post" onsubmit="return validateForm();" >
	<div align="center">
	<table style="with: 50%">
	<tr>
		<td>UserName</td>
		<td><input type="text" name="username" /></td>
		
		</tr>
		 <tr><td>Password</td><td><input type="password" name="password" /></td>
		 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
		 </tr>
		 </table>
		<input type="submit" value="Submit" >
		<a href="register">RegisterUser?</a>  
		</div>
	</form>
	
</body>
</html>