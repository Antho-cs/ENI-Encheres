<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>ENI-Enchères</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
	<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />
  <div class="jumbotron text-center">
    <h2>Liste des enchères</h2>
  </div>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Filtres:</h4>
      <form>
  <div class="input-group">
    <input type="text" class="form-control" placeholder="Le nom de l'article contient">
    <div class="input-group-btn">
      <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </div>
  </div>
</form>
<div class="mx-auto">

<select class="form-control form-control-lg">
  <option>Large select</option>
  <option>Large select</option>
  <option>Large select</option>
  <option>Large select</option>
</select>
</div>
    </div>
     <div class="col-sm-3" style="width: 18rem;">
    <div class="w3-card-4">
  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYAHZ0lpBtlP8lXebTIEtnA5-gDxLrPaL-CA&usqp=CAU" alt="Alps" width="240">
  <div class="w3-container w3-center">
    <h5>Card title</h5>
    <p>Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Prix : 150E</li>
    <li class="list-group-item">Fin de l'enchères : 22/08/2020</li>
    <li class="list-group-item">Vendeur: Firas :p</li>
  </ul>
  <div class="card-body">
    <a href="#" class="btn btn-primary">Bouton</a>
  </div>
</div>
  </div>
   <div class="col-sm-3" style="width: 18rem;">
    <div class="w3-card-4">
  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYAHZ0lpBtlP8lXebTIEtnA5-gDxLrPaL-CA&usqp=CAU" alt="Alps" width="240">
  <div class="w3-container w3-center">
    <h5>Card title</h5>
    <p>Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Prix : 150E</li>
    <li class="list-group-item">Fin de l'enchères : 22/08/2020</li>
    <li class="list-group-item">Vendeur: Firas :p</li>
  </ul>
  <div class="card-body">
    <a href="#" class="btn btn-primary">Bouton</a>
  </div>
</div>
  </div>
   <div class="col-sm-3" style="width: 18rem;">
    <div class="w3-card-4">
  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYAHZ0lpBtlP8lXebTIEtnA5-gDxLrPaL-CA&usqp=CAU" alt="Alps" width="240">
  <div class="w3-container w3-center">
    <h5>Card title</h5>
    <p>Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Prix : 150E</li>
    <li class="list-group-item">Fin de l'enchères : 22/08/2020</li>
    <li class="list-group-item">Vendeur: Firas :p</li>
  </ul>
  <div class="card-body">
    <a href="#" class="btn btn-primary">Bouton</a>
  </div>
</div>
  </div>
</div>
</div>
<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>