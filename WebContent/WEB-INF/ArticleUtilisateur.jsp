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
	<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />

<section>
<div class="jumbotron text-center">
		<h3>Détails de l'article</h3>
	</div>
<aside>
<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Vendeur</h4>
			

<div>pseudo de l'utilisateur ${user.getPseudo() }</div>
<br>
<div>${user.getCode_Postal() }  ${user.getVille() } </div>

</div>

	</div>
</div>

</aside>
</section>
<section>
<div class="jumbotron text-center">
		<h3>Autres articles du vendeur</h3>
	<br> <br>
<div class="card" style="width: 18rem;">
				<div class="d-flex justify-content-center">
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
						<li class="list-group-item">Vendeur: Firas :P</li>
					</ul>
					<div class="card-body">
						<a href="ServletArticleUtilisateur" class="btn btn-primary">Détails</a>
					</div>
				</div>
			</div>

					</div>

</section>


</body>


</html>