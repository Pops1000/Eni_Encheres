<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
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
	<nav></nav>
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
		
	<section class="container mt-5 d-flex">
		<div class="row gx-5">
		    <div class="col ">
		
    	<form action="UtilisateurServlet" method="POST">
        	<button type="submit" class="btn btn-success">Se connecter</button>
    	</form>
    	</div>
    	<div class="row">
    	    <div class="col">
    	
    	<form action="ServletInscription" method="POST">
        	<button type="submit" class="btn btn-success">S'inscrire</button>
    	</form>
    	</div>
	</section>
		
	<footer>
		<section class="container mt-5">
			<p>&copy; 2023 Oscar, Peio, Romain, Erwan. Tous droits réservés.</p>
		</section>
	</footer>
</body>
</html>