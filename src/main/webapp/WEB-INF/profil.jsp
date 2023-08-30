<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<title>Profil</title>
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
	<div class="container">
		<div class="row justify-content-center">
    		<div class="col-md-5">
				<h2>Mon Profil</h2>
   					<p><strong>Pseudo:</strong> ${sessionScope.pseudo}</p>
    				<p><strong>Nom:</strong> ${sessionScope.nom}</p>
    				<p><strong>Prénom:</strong> ${sessionScope.prenom}</p>
    				<p><strong>Email:</strong> ${sessionScope.email}</p>
    				<p><strong>Téléphone:</strong> ${sessionScope.tel}</p>
    				<p><strong>Rue:</strong> ${sessionScope.rue}</p>
    				<p><strong>Code Postal:</strong> ${sessionScope.codePostal}</p>
    				<p><strong>Ville:</strong> ${sessionScope.ville}</p>
    				<form action="ServletModify" method="POST">
    				<button  type="submit" class="btn btn-success">Modifier</button></form>
    		</div>
    	</div>
    </div>
    <footer>
		<section class="container mt-5">
			<p>&copy; 2023 Oscar, Peio, Romain, Erwan. Tous droits réservés.</p>
		</section>
	</footer>
</body>
</html>
