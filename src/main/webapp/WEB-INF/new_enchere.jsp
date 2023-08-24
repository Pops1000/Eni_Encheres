<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mise en ligne d'un produit aux enchères</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="enchere.css">
</head>
<body>

<div class="container mt-5">
    <h2>Mise en ligne d'un produit aux enchères</h2>
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
            <label for="startingPrice">Prix de départ</label>
            <input type="number" class="form-control" id="startingPrice" name="startingPrice" step="0.01" required>
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