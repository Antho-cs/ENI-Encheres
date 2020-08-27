<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page d'accueil</title>
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
	height: 1500px;
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 25%;
}

.col-sm-3 {
	margin-bottom: 1%;
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
<body onload="document.form1.submit()">

	<jsp:include page="navBar.jsp" />



	<div class="jumbotron text-center">
		<h1>Liste des enchères</h1>
	</div>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Filtres:</h4>
				<form action="Servlet" method="POST">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Nom exact de l'article" name="selectByName">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
					<input type="hidden" name="formName" value="selectByName">
				</form>
				<form action="Servlet" method="POST" id="form1">
					<label for="Categorie">Catégorie: </label> <select id="Categorie"
						class="form-control form-control-lg" name="categorie">
						<option id="select" value="select" disabled="" selected="">Please
							Select</option>
						<c:choose>
							<c:when test="${categories.size() > 0}">
								<c:forEach items = "${categories}" var="i">
									<option value="${i.getNoCategorie()}"><c:out
											value="${i.getLibelle()}" /></option>
								</c:forEach>
							</c:when>
						</c:choose>
					</select> <input type="hidden" name="formName" value="selectByCategorie">
				</form>
				<form action="Servlet" method="POST">
					<c:choose>
						<c:when test="${user != null}">
							<fieldset class="form-group">
								<ul id="myUL">
									<li>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="choix"
												onclick="affichageListeAchats()" id="achats" value="Achats">
											<label class="form-check-label" for="achats"> Achats
											</label>
										</div>
									</li>
									<ul class="nested" id="listeAchats">
										<li>
											<div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="checkbox" value="EncheresOuvertes" id="defaultCheck1"
													onChange="this.form.submit()"> <label
													class="form-check-label" for="defaultCheck1">
													Enchères ouvertes </label>
											</div>
										</li>
										<li><div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="checkbox" value="MesEncheres" id="defaultCheck2"
													onChange="this.form.submit()"> <label
													class="form-check-label" for="defaultCheck2"> Mes
													enchères </label>
											</div></li>
										<li><div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="checkbox" value="MesEncheresRaportees"
													id="defaultCheck2" onChange="this.form.submit()"> <label
													class="form-check-label" for="defaultCheck2"> Mes
													enchères raportées </label>
											</div></li>
									</ul>
									<li>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="choix"
												onclick="affichageListeMesVentes()" id="mesVentes"
												value="mesVentes"> <label class="form-check-label"
												for="mesVentes"> Mes ventes </label>
										</div>
									</li>
									<ul class="nested" id="listeMesVentes">
										<li>
											<div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="checkbox" value="MesVentesEnCours" id="defaultCheck1"
													onChange="this.form.submit()"> <label
													class="form-check-label" for="defaultCheck1"> Mes
													ventes en cours </label>
											</div>
										</li>
										<li><div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="checkbox" value="MesEncheres" id="defaultCheck2"
													onChange="this.form.submit()"> <label
													class="form-check-label" for="defaultCheck2"> Mes
													enchères </label>
											</div></li>
										<li><div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="checkbox" value="MesEncheresRaportees"
													id="defaultCheck2" onChange="this.form.submit()"> <label
													class="form-check-label" for="defaultCheck2"> Mes
													enchères raportées </label>
											</div></li>
									</ul>
								</ul>
							</fieldset>
						</c:when>
					</c:choose>
					<input type="hidden" name="formName" value="selectByNoUtilisateur">
				</form>
			</div>
			<div class="col-sm-9">
				<c:choose>
					<c:when test="${articles.size() == 0}">
						<div class="text-center">
							<img alt="rien"
								src="https://unsa-developpement-durable.fr/images/Photos_articles/2017-03/ddi_rien_voir2.jpg">
						</div>

					</c:when>
					<c:otherwise>
						<c:forEach items = "${articles}" var="i">
							<div class="col-sm-3">
								<div class="w3-card-4">
									<img
										src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYAHZ0lpBtlP8lXebTIEtnA5-gDxLrPaL-CA&usqp=CAU"
										alt="Alps" style="width: 100%; height: 100%" />
									<div class="w3-container w3-center">
										<h3>
											<c:out value="${i.getNomArticle()}" />
										</h3>
										<p>
											<c:out value="${i.getDescription()}" />
										</p>
									</div>
									<ul class="list-group list-group-flush">
										<li class="list-group-item"><c:out
												value="Prix : ${i.getMiseAPrix()}" /></li>
										<li class="list-group-item"><c:out
												value="Fin de l'enchères : ${i.getDateFinEncheres()}" />
										</li>
										<li class="list-group-item"><c:out
												value="Vendeur: ${i.getNomDeVendeur()}" /></li>
									</ul>
									<form action="ServletArticleVente" method="POST">
										<input class="hidden" name="NoArticle"
											value="<c:out value = "${i.getNoArticle()}"/>">
										<input class="hidden" name="NoUtilisateur"
											value="<c:out value = "${i.getNo_utilisateur()}"/>">
										<div class="card-body">
											<button class="btn btn-primary btn-block" type="submit">Détails</button>
										</div>
									</form>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<footer class="container-fluid text-center">
	<p>ⓒ AnFiLa 2020</p>
	</footer>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		document.getElementById('Categorie').onchange = function() {
			localStorage.setItem('selectedtem', document
					.getElementById('Categorie').value);
			this.form.submit();
		};
		if (localStorage.getItem('selectedtem')) {
			document.getElementById('Categorie').options[localStorage
					.getItem('selectedtem')].selected = true;
		};
		
		document.getElementById("vendreUnArticle").classList.remove("active");
		document.getElementById("pageAcceuil").classList.add("active");

		
		function affichageListeAchats() {
			var listeAchats = document.getElementById("listeAchats");
			var listeMesVentes = document.getElementById("listeMesVentes");
			listeAchats.classList.remove("nested");
			listeAchats.classList.add("active");
			listeMesVentes.classList.remove("active");
			listeMesVentes.classList.add("nested");
		}
		function affichageListeMesVentes() {
			var listeMesVentes = document.getElementById("listeMesVentes");
			var listeAchats = document.getElementById("listeAchats");
			listeMesVentes.classList.remove("nested");
			listeMesVentes.classList.add("active");
			listeAchats.classList.remove("active");
			listeAchats.classList.add("nested");
		}
	</script>
</body>
</html>