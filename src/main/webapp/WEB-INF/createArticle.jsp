<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>
<header>
<h1></h1>
</header>
<body>
<div class="container">
<div class="row justify-content-center">
    		<div class="col-md-4">
	<h2>Créer un nouvel article</h2>
    <form action="ServletCreateArticle" method="POST">
        <label for="nom">Nom de l'article :</label><br>
        <input type="text" class="form-control" id="nom" name="nom" required><br>
        
        <label for="description">Description :</label><br>
        <textarea class="form-control" id="description" name="description" rows="4" cols="50" 
        required></textarea><br>
        
        <label for="debutEnchere">Date de début d'enchères :</label><br>
        <input type="date" class="form-control" id="debutEnchere" name="debutEnchere" 
        required value="<%= LocalDate.now().toString() %>"><br>
        
        <label for="finEnchere">Date de fin d'enchères :</label><br>
        <input type="date" class="form-control" id="finEnchere" name="finEnchere" 
        required value="<%= LocalDate.now().toString() %>"><br>
        
        <label for="prixInitial">Prix initial:</label><br>
        <input type="number" class="form-control" id="prixInitial" name="prixInitial"><br>
        
        <label for="noUtilisateur">Numéro de l'utilisateur :</label><br>
        <input type="number" class="form-control" id="noUtilisateur" name="noUtilisateur" 
        value="<c:out value='${noUtilisateur}'/>"disabled><br>
        
        <label for="categorie">Sélectionnez une catégorie :</label>
        <select class="form-control" id="categorie" name="noCategorie">
    	<option value="Informatique">Informatique</option>
    	<option value="Ameublement">Ameublement</option>
   		<option value="Vêtement">Vêtement</option>
    	<option value="Sport & Loisirs">Sport & Loisirs</option>
		</select>
        
        
        
		<%-- <label for="categorie">Sélectionnez une catégorie :</label>
		<select class="form-control" id="categorie" name="noCategorie">
    	<option value="">-- Sélectionner une catégorie --</option>
    	<c:forEach var="categorie" items="${categories}">
        <option value="${categorie.no_categorie}">${categorie.libelle}</option>
    	</c:forEach>
		</select> --%>

        <label for="rue">Rue :</label><br>
        <input type="text" class="form-control" id="rue" name="rue" value="<c:out 
        value='${rue}'/>"disabled><br>
        <label for="codePostal">Code Postal :</label><br>
        <input type="text" class="form-control" id="codePostal" name="codePostal" 
        value="<c:out value='${codePostal}'/>"disabled><br>
        <label for="ville">Rue :</label><br>
        <input type="text" class="form-control" id="ville" name="ville" 
        value="<c:out value='${ville}'/>"disabled><br>
       

        
        <button type="submit" class="btn btn-success" >Créer</button>
    </form>
    	<a href="<c:url value='/IndexServlet' />" type="submit" class="btn btn-success"> Annuler </a>
</div>
</div>
</div>
</body>
</html>