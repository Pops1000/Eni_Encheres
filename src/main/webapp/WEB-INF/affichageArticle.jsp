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
	<% Article articleToDisplay = (Article) request.getAttribute("articleToDisplay"); %>

	<!--TODO : s'occuper des photo -->
	<div>
		PHOTO 
	
	</div>

	<div>
		  <h2><c:out value="${articleToDisplay.nom}" /></h2>
        <p>Prix initial: <c:out value="${articleToDisplay.prix_initial}" /> €</p>
        <p>Prix de vente:<c:out value="${articleToDisplay.prix_vente}" /> €</p>
        <p>Date de fin d'enchère: <c:out value="${articleToDisplay.fin_enchere}" /></p>
        <p>Vendeur:<c:out value="${articleToDisplay.nomVendeur}" /> <c:out value="${articleToDisplay.prenomVendeur}" /></p>
	</div>
</body>
</html>