<%@page import="java.util.List"%>
<%@page import="Entities.Article"%>
<%@page import="Entities.Utilisateur"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Mickypédia</title>
</head>
<body>
	<header class="header">
		<a class="logo"><img
			src="https://raw.githubusercontent.com/reactjs/redux/master/logo/logo.png"></a>
		<nav class="menu">
			<a href="/Wiki/auth.do">Accueil</a> <a href="/Wiki/articles">Articles</a> <a href="#">Administration</a> <a
				href="/Wiki/logout">Deconnexion</a>
		</nav>
	</header>

	<div>
		<br /> <br /> <br />
		<h1>Bonjour ${ utilisateurConnecte.prenom }
		</h1>

		<form action="creerUtilisateur" method="get">
			<input type="submit" value="Creer utilisateur" class="button" />
		</form>
	</div>
</body>
</html>