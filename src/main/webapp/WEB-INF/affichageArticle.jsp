<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher Article</title>
</head>
<body>

	<div>
		<img src="${article.photoUrl}" alt="Photo de l'article">
	</div>

	<div>
		<h2>${article.nom}</h2>
		<p>Prix initial: ${article.prix_initial} €</p>
		<p>Prix de vente: ${article.prix_vente} €</p>
		<p>Date de fin d'enchère: ${article.dateFinEnchere}</p>
		<p>Vendeur: ${article.} ${article.vendeur}</p>
	</div>
</body>
</html>