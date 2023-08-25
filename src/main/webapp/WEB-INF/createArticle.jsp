<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<h2>Créer un nouvel article</h2>
    <form action="ServletCreateArticle" method="POST">
        <label for="nom_article">Nom de l'article:</label><br>
        <input type="text" id="nom_article" name="nom" required><br>
        
        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea><br>
        
        <label for="date_debut_enchere">Date de début d'enchères:</label><br>
        <input type="date" id="date_debut_enchere" name="debutEnchere" required value="<%= LocalDate.now().toString() %>"><br>
        
        <label for="date_fin_enchere">Date de fin d'enchères:</label><br>
        <input type="date" id="date_fin_enchere" name="finEnchere" required value="<%= LocalDate.now().toString() %>"><br>
        
        <label for="prix_initial">Prix initial:</label><br>
        <input type="number" id="prix_initial" name="prixInitial"><br>
        
        <label for="no_utilisateur">Numéro de l'utilisateur:</label><br>
        <input type="number" id="no_utilisateur" name="noUtilisateur" required><br>
        
        <label for="no_categorie">Numéro de la catégorie:</label><br>
        <input type="number" id="no_categorie" name="noCategorie" required><br>
        
         <label for="categorie">Sélectionnez une catégorie :</label>
        <select id="categorie" name="categorie">
            <option value="alimentation">Alimentation</option>
            <option value="electronique">Électronique</option>
            <option value="mode">Mode</option>
            <option value="maison">Maison</option>
            <option value="sport">Sport</option>
        </select>
        
        <button type="submit" class="btn btn-success">Créer</button>
    </form>
</body>
</html>