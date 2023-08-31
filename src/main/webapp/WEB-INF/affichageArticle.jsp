<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.enchere.bo.Article"%>
<%@ page import="fr.eni.enchere.bll.ArticleManager"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher Article</title>
</head>
<body>
	<% Article article = (Article) request.getAttribute("article"); %>

	<!--TODO : s'occuper des photo -->
	<div>
		PHOTO 
	
	</div>

	<div>
		  <h2><c:out value="${article.nom}" /></h2>
        <p>Prix initial: ${article.prix_initial}" /> €</p>
        <p>Prix de vente:<c:out value="${article.prix_vente}" /> €</p>
        <p>Date de fin d'enchère: <c:out value="${article.fin_enchere}" /></p>
        <p>Vendeur:<c:out value="${article.nomVendeur}" /> <c:out value="${article.prenomVendeur}" /></p>
	</div>
</body>
</html>