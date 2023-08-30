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
<body>
	<header>
		<div class="container mt-5">
			<h1>Les objets sont nos amis</h1>
		</div>

	</header>
	<div class="container mt-5">
		<c:choose>
			<c:when test="${empty sessionScope.pseudo}">
				<jsp:include page="navbarAccueil.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<h2>Bienvenue, ${sessionScope.pseudo}!</h2>
				<!-- Autres éléments à afficher pour un utilisateur connecté -->
				<jsp:include page="navbarConnecter.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</div>
	<section class="container mt-5">
		<div class="row">
        	<div class="col-md-6">
				<p>L'association "Les objets sont nos amis" aspire à créer une
				plateforme web novatrice permettant la transmission d'objets de
				seconde main, sans qu'il y ait de transactions financières
				impliquées. La valeur des articles sera définie selon un système
				d'enchères basé sur une unité de points. Ces points seront gagnés
				par la vente d'objets et pourront ensuite être utilisés pour
				acquérir d'autres articles.</p>
			</div>
		 <div class="col-md-6">
            <div class="form-group">
                <h3>Recherche d'article</h3>
                <form action="RechercheServlet" method="post">
                    <label for="motcle">Mot clé :</label>
                    <input type="text" class="form-control" id="motcle" name="motcle" placeholder="Entrez un mot clé">
                </div>
                <div class="form-group">
                    <label for="categorie">Sélectionnez une catégorie :</label>
                    <select class="form-control" id="categorie" name="categorie">
                        <option value="Informatique">Informatique</option>
                        <option value="Ameublement">Ameublement</option>
                        <option value="Vêtement">Vêtement</option>
                        <option value="Sport & Loisirs">Sport Loisirs</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Rechercher</button>
                </form>
            </div>
        </div>
	</section>
	<section>
		<div class="container mt-5">
    		<c:forEach items="${listArticle}" var="article">
        		<div class="card mb-3">
            		<div class="card-header">
                		<h5 class="card-title">${article.nom}</h5>
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
        		</div>
    		</c:forEach>
    	</div>
	</section>

	<footer>
		<section class="container mt-5">
			<p>&copy; 2023 Oscar, Peio, Romain, Erwan. Tous droits réservés.</p>
		</section>
	</footer>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>