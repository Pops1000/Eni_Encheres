<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher Article</title>
</head>
<body>

 <h1>Données du formulaire</h1>
    <table>
        <tr>
            <th>Champ</th>
            <th>Valeur</th>
        </tr>
        <tr>
            <td>Nom de l'article</td>
            <td>${article.nom}</td>
        </tr>
         <tr>
            <td>Description</td>
            <td>${article.description}</td>
        </tr>
    </table>

</body>
</html>