<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article en vente</title>
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

.form-group {
	margin-top: 5%;
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
	<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />

	<header>
		<div class="jumbotron text-center">
			<h1>Article en vente</h1>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 sidenav">
				<div class="">
					<h4>Infos du vendeur</h4>

					<label for="Pseudo"> Vendeur </label>
					<p>${vendeur.getPseudo() }</p>
					<!-- <input type ="text" class="form-control" name ="Pseudo" value ="${user.getPseudo() }"> -->

					<h4>Retrait</h4>
					<label for="CodePostal">Code Postal</label>
					<p>${vendeur.getCode_postal()}</p>
					<!--<input type="text"	class="form-control"  name ="Rue" value="${user.getRue()}" size="" >-->
					<label for="Ville">Ville :</label>
					<p>${vendeur.getVille()}</p>
					<!--<input type="text" class="form-control" name="Ville" value="${user.getVille()}" size="" >  -->

					<img alt="Article à vendre"
						src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/funny-cat-captions-1563551842.jpg"
						width="300" height="200" style="text-align: center" />
					
				</div>
			</div>

		<div class="col-sm-6">
			<div class="well">
				<div class="row">
					<label for ="Article"  name ="Article">Article :</label> 
					<p>${article.getNomArticle()}</p>
					<!--ce label devra être supprimé lors de la mise en prod de l'appli (NoARticle = hidden)	-->
				<label for="NoArticle">NoArticle :</label> 
					<p>${article.getNoArticle()}</p>
				</div>		
					<div class="row description">
					<label for="Description">Description :</label>
					<p>${article.getDescription()}</p>
				</div>

				
			
			</div>
			
		
			<div class="well">
			<div class="row">	
				<label for="Prix">Mise à prix :</label>
				<p>${article.getMiseAPrix()}</p>
				<p></p>
				</div>
				<div class="row">
				<label for="Prix">Début de l'enchère : </label>
				<p>${article.getDateDebutEncheres()}</p>
				<p></p>
				<label for="Prix">Fin de l'enchère :</label>
				<p>${article.getDateFinEncheres()}</p>
				<p></p>
				<input class="btn btn-success" type="button" value="Enchérir"> 
						</div>
			</div>
		</div>
		</div>	
</div>	
	<footer class="container-fluid text-center">
		<p></p>
	</footer>
	
</body>


</html>