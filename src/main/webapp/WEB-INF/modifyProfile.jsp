<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<title>Mon Profil</title>
</head>
<header>
<h1> Mon Profil</h1>
</header>
<body>

<div class="container">
        <h2>Mon Profil</h2>
        <form action="ServletMonProfil" method="POST">
            <div class="mb-3">
                <label for="pseudo"  class="form-label">Pseudo</label>
                <input type="text" value="${sessionScope.pseudo}" class="form-control" id="pseudo" name="pseudo" required>
            </div>
            <div class="mb-3">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" value="${sessionScope.nom}" class="form-control" id="nom" name="nom" required>
            </div>
            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom</label>
                <input type="text"value="${sessionScope.prenom}" class="form-control" id="prenom" name="prenom" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" value="${sessionScope.email}"class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="tel" class="form-label">Téléphone</label>
                <input type="tel" value="${sessionScope.tel}" class="form-control" id="tel" name="tel">
            </div>
            <div class="mb-3">
                <label for="rue" class="form-label">Rue</label>
                <input type="text" value="${sessionScope.rue}"class="form-control" id="rue" name="rue">
            </div>
            <div class="mb-3">
                <label for="codePostal" class="form-label">Code Postal</label>
                <input type="text" value="${sessionScope.codePostal}"class="form-control" id="codePostal" name="codePostal">
            </div>
            <div class="mb-3">
                <label for="ville" class="form-label">Ville</label>
                <input type="text" value="${sessionScope.ville}"class="form-control" id="ville" name="ville">
            </div>
            <div class="mb-3">
                <label for="mdp" class="form-label">Mot de passe actuel</label>
                <input type="password" value="${sessionScope.mdp}"class="form-control" id="mdp" name="mdp" required>
            </div>
            <div class="mb-3">
                <label for="mdp" class="form-label">Nouveau mot de passe</label>
                <input type="password" class="form-control" id="mdp" name="new_pwd" >
            </div>
            <div class="mb-3">
                <label for="confirmationMotDePasse" class="form-label">Confirmer le nouveau mot de passe</label>
                <input type="password" class="form-control" id="confirmationMotDePasse" name="confirm_pwd" >
            </div>
            <button type="submit" class="btn btn-success">Enregister</button>
            <a href="IndexServlet" class="btn btn-secondary">Supprimer mon compte</a>
        </form>
    </div>
    <a href="<%=request.getContextPath()%>/IndexServlet" type="submit" class="btn btn-success"> Annuler </a>

</body>
</html>