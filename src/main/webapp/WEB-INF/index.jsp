<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
				<form action="UtilisateurServlet" method="GET">
					<button type="submit" class="btn btn-success">Se connecter</button>
				</form>

				<form action="ServletInscription" method="GET">
					<button type="submit" class="btn btn-success">S'inscrire</button>
				</form>
			</c:when>
			<c:otherwise>
				<h2>Bienvenue, ${sessionScope.pseudo}!</h2>
				<!-- Autres �l�ments � afficher pour un utilisateur connect� -->
				<form action="ServletCreateArticle" method="GET">
					<button type="submit" class="btn btn-success">Ench�res</button>
				</form>
				<form action="ServletCreateArticle" method="GET">
					<button type="submit" class="btn btn-success">Vendre un
						article</button>
				</form>
				<form action="ServletMonProfil" method="GET">
					<button type="submit" class="btn btn-success">Mon profil</button>
				</form>

				<form action="ServletDisconectUser" method="GET">
					<button type="submit" class="btn btn-success">Se
						d�connecter</button>
				</form>
				<div>
					<h2>Articles</h2>
					<ul>
						<%-- Supposons que vous ayez une liste d'articles dans la session --%>
						<c:forEach var="article" items="${sessionScope.listeArticles}"
							varStatus="status">
							<c:if test="${status.index < 6}">
								<li><a
									href="affichageArticle.jsp?no_article=${article.no_article}">${article.nom}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>

			</c:otherwise>
		</c:choose>

	</nav>
	<section class="container mt-5">
		<div>
			<p>L'association "Les objets sont nos amis" aspire � cr�er une
				plateforme web novatrice permettant la transmission d'objets de
				seconde main, sans qu'il y ait de transactions financi�res
				impliqu�es. La valeur des articles sera d�finie selon un syst�me
				d'ench�res bas� sur une unit� de points. Ces points seront gagn�s
				par la vente d'objets et pourront ensuite �tre utilis�s pour
				acqu�rir d'autres articles.</p>
		</div>


		<p></p>
	</section>



	<footer>
		<section class="container mt-5">
			<p>&copy; 2023 Oscar, Peio, Romain, Erwan. Tous droits r�serv�s.</p>
		</section>
	</footer>
</body>
</html>