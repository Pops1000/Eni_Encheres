<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.enchere.message.LecteurMessage"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<title>Login</title>
<header>
<h1>Les objets sont nos amis</h1>
</header>
</head>
	<div class="container mt-5">
		<jsp:include page="navbarAccueil.jsp"></jsp:include>
	</div>
<body>
	 <div class="container">
	 <div class="row justify-content-center">
    		<div class="col-md-4">
        <h2>Connexion</h2>
        <form action="UtilisateurServlet" method="POST">
        <c:if test="${!empty listeCodesErreur}">
			<div class="alert alert-danger" role="alert">
				<strong>ERREUR !</strong>
				<ul>
					<c:forEach var="code" items="${listeCodesErreur}">
						<li>${LecteurMessage.getMessageErreur(code)}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
            <div class="mb-3">
                <label for="username" class="form-label">Nom d'utilisateur</label>
                <input type="text" class="form-control" id="username" name="id" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mot de passe</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
                <label class="form-check-label" for="rememberMe">Se souvenir de moi</label>
            </div>
            <button type="submit" class="btn btn-success">Se connecter</button>
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