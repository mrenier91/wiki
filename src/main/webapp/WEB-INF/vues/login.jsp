<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Mickypédia</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" type="text/css">

</head>

<body>


	<div>
		<form action="auth.do" method="post">
			<p>
				<font color="red">${errorMessage}</font> <br/>
			</p>
			Name: <input type="text" name="login" /> <br/>
			Password:<input type="password" name="mdp" /> <br/>
			<input type="submit" value="Login" class="button"/>
		</form>

	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>