<%@page import="java.util.List"%>
<%@page import="Entities.Article"%>
<%@page import="Entities.Utilisateur"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Mickypédia</title>
</head>
<body>
	<header class="header">
		<a class="logo"><img
			src="https://raw.githubusercontent.com/reactjs/redux/master/logo/logo.png"></a>
		<nav class="menu">
			<a href="/Wiki/auth.do">Acceuil</a> <a href="#">Articles</a> <a href="#">Administration</a> <a
				href="/Wiki/logout">Deconnexion</a>
		</nav>
	</header>

	<div>
		<br /> <br /> <br />
		<h1>Bonjour ${ utilisateurConnecte.nom } ${ utilisateurConnecte.prenom }
		</h1>

		<br /> <br /> articles : <br /> <br />

		<table>
			<thead>
				<tr>
					<td><B>Titre</B></td>
				</tr>

			</thead>
			<c:forEach items="${articles}" var="item">
				<tr>
					<td><c:out value="${item.titre}" /></td>
				</tr>
			</c:forEach>
		</table>

		<form action="creerUtilisateur" method="get">
			<input type="submit" value="Creer utilisateur" class="button" />
		</form>
	</div>
</body>
</html>