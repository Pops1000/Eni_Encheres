<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/enchere.css">

</head>
<header>
	<div class="container mt-5">
		<h1>Les objets sont nos amis</h1>
	</div>
</header>
	<div class="container mt-5">
		<jsp:include page="navbarConnecter.jsp"></jsp:include>
	</div>
<body>
	<section>
		<div class="container mt-5">
    <c:forEach items="${listArticle}" var="article">
        <div class="card mb-3">
            <div class="card-header">
            	<div class="d-flex justify-content-between">
                <h5 class="card-title">${article.nom}</h5>
                	<div>
                		<form action="ServletCreateArticle" method="post">
    					<label for="enchere">Montant de l'enchère :</label>
    					<input type="number" id="enchere" name="enchere" min="0" required>
    					<button type="submit" class="btn btn-secondary">Enchérir</button>
						</form>
					</div>
                </div>
            </div>
            <div class="card-body">
                <p class="card-text">Description : ${article.description}</p>
                <p class="card-text">Date de début des enchères : ${article.debut_enchere}</p>
                <p class="card-text">Date de fin des enchères : ${article.fin_enchere}</p>
                <p class="card-text">Mise à prix : ${article.prix_initial}</p>
                <p class="card-text">Meilleure offre : ${article.prix_vente}</p>
                <p class="card-text">Adresse pour le retrait : ${article.utilisateur.rue} ${article.utilisateur.codePostal} ${article.utilisateur.ville}</p>
                <p class="card-text">Vendeur : ${article.utilisateur.pseudo}</p>
            </div>
            <img src="<c:url value='/uploads/${fileName}' />" alt="Uploaded Image">
        </div>
    </c:forEach>
	</section>
		
	

	<footer>
		<section class="container mt-5">
			<p>&copy; 2023 Oscar, Peio, Romain, Erwan. Tous droits réservés.</p>
		</section>
	</footer>
</body>
</html>