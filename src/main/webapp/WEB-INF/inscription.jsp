<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<header>
	<div class="container mt-5">
		<h1>Les objets sont nos amis</h1>
	</div>
</header>
	<div class="container mt-5">
		<jsp:include page="navbarAccueil.jsp"></jsp:include>
	</div>
<body>
    <div class="container">
    <div class="row justify-content-center">
    	<div class="col-md-4">
        <h2>Inscription</h2>
        <form action="ServletInscription" method="POST">
            <div class="mb-3">
                <label for="pseudo" class="form-label">Pseudo</label>
                <input type="text" class="form-control" id="pseudo" name="pseudo" required>
            </div>
            <div class="mb-3">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>
            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom</label>
                <input type="text" class="form-control" id="prenom" name="prenom" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="tel" class="form-label">Téléphone</label>
                <input type="tel" class="form-control" id="tel" name="tel">
            </div>
            <div class="mb-3">
                <label for="rue" class="form-label">Rue</label>
                <input type="text" class="form-control" id="rue" name="rue">
            </div>
            <div class="mb-3">
                <label for="codePostal" class="form-label">Code Postal</label>
                <input type="text" class="form-control" id="codePostal" name="codePostal">
            </div>
            <div class="mb-3">
                <label for="ville" class="form-label">Ville</label>
                <input type="text" class="form-control" id="ville" name="ville">
            </div>
            <div class="mb-3">
                <label for="mdp" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" id="mdp" name="mdp" required>
            </div>
            <div class="mb-3">
                <label for="confirmationMotDePasse" class="form-label">Confirmer le mot de passe</label>
                <input type="password" class="form-control" id="confirmationMotDePasse" name="confirmationMotDePasse" required>
            </div>
            <button type="submit" class="btn btn-success">Créer</button>
            <a href="IndexServlet" class="btn btn-secondary">Annuler</a>
        </form>
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