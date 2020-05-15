<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>

<p align="right">
<a href="logout">Logout</a><br>
</p>
<h1 align="center">Register The User Here...</h1>
<body>
<script type="text/javascript">
	 function validateForm() {
		var un = document.regForm.username.value;
		var pw = document.regForm.password.value;
		var fn = document.regForm.firstname.value;
		var ln = document.regForm.lastname.value;
		var em = document.regForm.email.value;
		var ad = document.regForm.address.value;
		var phone = document.regForm.phone.value;
		var role = document.regForm.role.value;
		//var phoneno = "/^\d{10}$/";
		//var res=phone.match(phoneno);
		//alert('res '+res +'  pw '+pw);
		
		if (un == "") {
			//alert('un '+un );
			alert("Please Enter your username ");
			return false;
		}	
		else if (pw == "") {
			//alert('un '+un );
			alert("Please Enter your password ");
			return false;
		}
		else if (fn == "") {
			
			alert("Please Enter your FirstName ");
			return false;
		}else if (ln == "") {
			
			alert("Please Enter your LastName ");
			return false;
		}else if (em == "") {
			
			alert("Please Enter your email ");
			return false;
		}else if (ad == "") {
			
			alert("Please Enter your Address ");
			return false;
		}
		
		else if(isNaN(phone))
		        {
			alert("Phone Number should be in numeric  ");
		      return false;
		        }
		
		else if (phone == "") {
			
			alert("Please Enter your Phone Number ");
			return false;
		}else if (role == "Select") {
			//alert('role '+role );
			alert("Please Select the Role ");
			return false;
		}
		};
		</script>
	<form id="regForm" name="regForm" action="registerProcess" method="GET"  onsubmit="return validateForm();" >

		<table align="center">
			<tr>
				<td><label for="username">Username</label></td>
				<td><input id="username" name="username" name="username" type="text" /></td>
			</tr>
			<tr>
				<td><label for="password">Password</label></td>
				<td><input id="password" name="password" name="password" type="password" /></td>
				
			</tr>
			<tr>
				<td><label for="firstname">FirstName</label></td>
				<td><input id="firstname" name="firstname" name="firstname" type="text"/></td>
			</tr>
			<tr>
				<td><label for="lastname">LastName</label></td>
				<td><input id="lastname" name="lastname" name="lastname" type="text" /></td>
			</tr>
			<tr>
				<td><label for="email">Email</label></td>
				<td><input id="email" name="email" name="email" type="text" /></td>
			</tr>
			<tr>
				<td><label for="address">Address</label></td>
				<td><input  id="address" name="address" name="address" type="text" /></td>
			</tr>
			<tr>
				<td><label  for="phone">Phone</label></td>
				<td><input id="phone" name="phone" name="phone" type="text" /></td>
			</tr>
			<tr>
			<td><label>User Type</label></td>
			<td>			
			<select name="role" style="margin-left: 30px;">
			<option>Select</option>
			<option>admin</option>
			<option>agent</option>
			<option>manager</option>
			<option>customer</option>
			</select></td>
			</tr>
			<br>
			<tr>
				<td></td>
				<td><button id="register" name="register" type="submit" value="Submit">Register</button></td>
			</tr>
			<tr></tr>
		</table>
	</form>

</body>
</html>