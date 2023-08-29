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
	<nav>
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

	</nav>
	<section class="container mt-5">
		<div>
			<p>L'association "Les objets sont nos amis" aspire à créer une
				plateforme web novatrice permettant la transmission d'objets de
				seconde main, sans qu'il y ait de transactions financières
				impliquées. La valeur des articles sera définie selon un système
				d'enchères basé sur une unité de points. Ces points seront gagnés
				par la vente d'objets et pourront ensuite être utilisés pour
				acquérir d'autres articles.</p>
		</div>

		<div>
			<p></p>
		</div>
	</section>



	<footer>
		<section class="container mt-5">
			<p>&copy; 2023 Oscar, Peio, Romain, Erwan. Tous droits réservés.</p>
		</section>
	</footer>
</body>
</html>