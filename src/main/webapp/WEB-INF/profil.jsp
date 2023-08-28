<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<h1>Mon Profil</h1>
   <p><strong>Pseudo:</strong> ${sessionScope.pseudo}</p>
    <p><strong>Nom:</strong> ${sessionScope.nom}</p>
    <p><strong>Prénom:</strong> ${sessionScope.prenom}</p>
    <p><strong>Email:</strong> ${sessionScope.email}</p>
    <p><strong>Téléphone:</strong> ${sessionScope.tel}</p>
    <p><strong>Rue:</strong> ${sessionScope.rue}</p>
    <p><strong>Code Postal:</strong> ${sessionScope.codePostal}</p>
    <p><strong>Ville:</strong> ${sessionScope.ville}</p>
    <form action="ServletModify" method="GET">
    <button  type="submit" class="btn btn-success">Modifier</button></form>
</body>
</html>
