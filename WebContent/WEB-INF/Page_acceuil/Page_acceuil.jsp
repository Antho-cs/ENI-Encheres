<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>ENI-Enchères</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

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
	.row.content {
		height: auto;
	}
}
.form-group{
	margin-top:5%;
}

ul, #myUL {
	list-style-type: none;
}

#myUL {
	margin: 0;
	padding: 0;
}

.nested {
	display: none;
}

.active {
	display: block;
}
</style>
</head>
<body>
	<jsp:include page="navBar.jsp" />



	<div class="jumbotron text-center">
		<h1>Liste des enchères</h1>
	</div>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Filtres:</h4>
				<form>
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Le nom de l'article contient">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>

				<label for="Categorie">Catégorie: </label> <select id="Categorie"
					class="form-control form-control-lg">
					<option>Toutes</option>
					<option>Informatique</option>
					<option>Ameublement</option>
					<option>Vetement</option>
					<option>Sport&Loisirs</option>
				</select>

				<c:choose>
					<c:when test="${isConnected}">
						<fieldset class="form-group">
							<ul id="myUL">
								<li>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="choix" onclick="myFunction()"
											id="achats" value="Achats"> <label
											class="form-check-label" for="achats"> Achats </label>
									</div>
								</li>
								<ul class="nested" id="listeAchats">
									<li>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="defaultCheck1"> <label class="form-check-label"
												for="defaultCheck1"> Enchères ouvertes </label>
										</div>
									</li>
									<li><div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="defaultCheck2"> <label class="form-check-label"
												for="defaultCheck2"> Mes enchères </label>
										</div></li>
									<li><div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="defaultCheck2"> <label class="form-check-label"
												for="defaultCheck2"> Mes enchères raportées </label>
										</div></li>
								</ul>
								<li>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="choix" onclick="affichageListeMesVentes()"
											id="mesVentes" value="Mes ventes"> <label
											class="form-check-label" for="mesVentes"> Mes ventes
										</label>
									</div>
								</li>
								<ul class="nested" id="listeMesVentes">
									<li>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="defaultCheck1"> <label class="form-check-label"
												for="defaultCheck1"> Mes ventes en cours </label>
										</div>
									</li>
									<li><div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="defaultCheck2"> <label class="form-check-label"
												for="defaultCheck2"> Mes enchères </label>
										</div></li>
									<li><div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="defaultCheck2"> <label class="form-check-label"
												for="defaultCheck2"> Mes enchères raportées </label>
										</div></li>
								</ul>
							</ul>
						</fieldset>
					</c:when>
				</c:choose>
			</div>
			<div class="col-sm-3" style="width: 18rem;">
				<div class="w3-card-4">
					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYAHZ0lpBtlP8lXebTIEtnA5-gDxLrPaL-CA&usqp=CAU"
						alt="Alps" width="240">
					<div class="w3-container w3-center">
						<h5>Card title</h5>
						<p>Some quick example text to build on the card title and make
							up the bulk of the card's content.</p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Prix : 150</li>
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
					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYAHZ0lpBtlP8lXebTIEtnA5-gDxLrPaL-CA&usqp=CAU"
						alt="Alps" width="240">
					<div class="w3-container w3-center">
						<h5>Card title</h5>
						<p>Some quick example text to build on the card title and make
							up the bulk of the card's content.</p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Prix : 150</li>
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
					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYAHZ0lpBtlP8lXebTIEtnA5-gDxLrPaL-CA&usqp=CAU"
						alt="Alps" width="240">
					<div class="w3-container w3-center">
						<h5>Card title</h5>
						<p>Some quick example text to build on the card title and make
							up the bulk of the card's content.</p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Prix : 150</li>
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
<script>
function myFunction() {
	  var listeAchats = document.getElementById("listeAchats");
	  var listeMesVentes = document.getElementById("listeMesVentes");
	  listeAchats.classList.remove("nested");
	  listeAchats.classList.add("active");
	  listeMesVentes.classList.remove("active");
		listeMesVentes.classList.add("nested");
	}
function affichageListeMesVentes(){
	var listeMesVentes = document.getElementById("listeMesVentes");
	var listeAchats = document.getElementById("listeAchats");
	listeMesVentes.classList.remove("nested");
	listeMesVentes.classList.add("active");
	listeAchats.classList.remove("active");
	listeAchats.classList.add("nested");
}
/*
var radios = document.getElementsByTagName('choix');
var value;
for (var i = 0; i < radios.length; i++) {
    if (radios[i].type === 'radio' && radios[i].checked) {
    	alert("Hello");
    	document.getElementsByClassName('nested').classList.toggle("active");
    	this.parentElement.querySelector(".nested").classList.toggle("active");
        value = radios[i].value;       
    }
}
*/
</script>
</body>
</html>