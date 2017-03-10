<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Mickypédia</title>
</head>
<body>
	<header class="header"> <a class="logo"><img
		src="https://raw.githubusercontent.com/reactjs/redux/master/logo/logo.png"></a>
	<nav class="menu"> <a href="/Wiki/auth.do">Accueil</a> <a
		href="#">Articles</a> <a href="#">Administration</a> <a
		href="/Wiki/logout">Deconnexion</a> </nav> </header>
	<br />
	<br />
	<br />
	<br />

	<div>
		<br />
		<form action="creerUtilisateur" method="post">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
			Nom: <input type="text" name="name" /> </br> Prenom: <input type="text"
				name="firstname" /> </br> Login: <input type="text" name="login" /> </br>
			Mdp:<input type="password" name="mdp" /> </br> <br /> <input
				type="submit" value="Creer" class="button" />
		</form>

	</div>

</body>
</html>