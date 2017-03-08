<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Créer utilisateur</title>
</head>
<body>
<div class="container">
		<form action="creerUtilisateur" method="post">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
			Nom: <input type="text" name="name" /> </br>
			Prenom: <input type="text" name="firstname" /> </br>
			Login: <input type="text" name="login" /> </br>
			Mdp:<input type="password" name="mdp" /> </br>
			Age: <input type="text" name="age" /> </br>
			Profession:<input type="text" name="profession" /> </br>
			<input type="submit" value="Creer" class="button"/>
		</form>

	</div>

</body>
</html>