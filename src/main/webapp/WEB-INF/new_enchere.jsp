<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mise en ligne d'un produit aux ench�res</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="enchere.css">
</head>
<body>

<div class="container mt-5">
    <h2>Mise en ligne d'un produit aux ench�res</h2>
    <form action="process-upload" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="productName">Nom du produit</label>
            <input type="text" class="form-control" id="productName" name="productName" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
        </div>
        <div class="form-group">
            <label for="date_debut">date_debut</label>
            <input type="date" class="form-control" id="date_debut" name="date_debut" required>
        </div>
        <div class="form-group">
            <label for="date_fin">date_fin</label>
            <input type="date" class="form-control" id="date_fin" name="date_fin" required>
        </div>
        <div class="form-group">
            <label for="Prix de d�part">Prix de d�part</label>
            <input type="number" class="form-control" id="Prix de d�part" name="Prix de d�part" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="Cat�gorie">Cat�gorie</label>
            <input type="text" class="form-control" id="Cat�gorie" name="Cat�gorie" required>
        </div>
        <div class="form-group">
            <label for="image">Image du produit</label>
            <input type="file" class="form-control-file" id="image" name="image" accept="image/*" required>
        </div>
        <button type="submit" class="btn btn-success">Mettre en ligne</button>
    </form>
</div>
</body>
</html>