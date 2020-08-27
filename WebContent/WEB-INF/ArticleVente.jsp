<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<div class="container">
	<div class="container-fluid">
		<div class="row">
			<form action="ServletEncherir" method="POST" onsubmit="return checkForm(this);">
				<div class="col-sm-4 sidenav">

					<div class="">
						<h4>Infos du vendeur</h4>
						<input name="noUtilisateur" class="hidden" value="${vendeur.getNo_utilisateur()}">
						<label for="Pseudo"> Vendeur </label>
						<p>${vendeur.getPseudo()}</p>
						<h4>Retrait</h4>
						<label>Adresse</label>
						<p>${vendeur.getRue()}</p>
						<label>Ville :</label>
						<p>${vendeur.getVille()}</p>
						
						<label>Code Postal</label>
						<p>${vendeur.getCode_postal()}</p>
						<img alt="Article à vendre"
							src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/funny-cat-captions-1563551842.jpg"
							width="300" height="200" style="text-align: center" />
					</div>
				</div>
				<div class="col-sm-8">
					<div class="well">
						<div class="row">
							<label for="Article" >Article :</label>
							<p class="modifier">${article.getNomArticle()}</p>
							<input type="text" class="form-control modifier hidden"
								name="nomArticle" value="${article.getNomArticle()}" size="">
						</div>
						<div class="row description">
							<label for="Description">Description :</label>
							<p class="modifier">${article.getDescription()}</p>
							<input type="text" class="form-control modifier hidden"
								name="description" value="${article.getDescription()}" size="">
						</div>
					</div>
					<div class="well">
						<div class="row">
							<label for="Prix">Mise à prix :</label>
							<p class="modifier">${article.getMiseAPrix()}</p>
							<input type="text" class="form-control modifier hidden"
								name="prixInitial" value="${article.getMiseAPrix()}" size="">
							<input type="number" class="form-control hidden" name="noArticle"
								value="${article.getNoArticle()}" size="">
							<p></p>
						</div>
						<div class="row">
							<label for="Prix">Début de l'enchère : </label>
							<p class="modifier">${article.getDateDebutEncheres()}</p>
							<input type="date" class="form-control modifier hidden"
								name="debutDeEnchere" value="${article.getDateDebutEncheres()}"
								size="">
							<p></p>
							<label for="Prix">Fin de l'enchère :</label>
							<p class="modifier">${article.getDateFinEncheres()}</p>
							<input type="date" class="form-control modifier hidden"
								name="finDeEnchere" value="${article.getDateFinEncheres()}"
								size="">
							<p></p>
							<label for="Article" name="encherir">Enchére :</label>
							<p class="modifier">${enchere.getMontantEnchere()}</p>
							<c:choose>
								<c:when
									test="${user.getNo_utilisateur() != vendeur.getNo_utilisateur()}">
									<div class="form-group row">
										<div class="col-xs-2">
											<c:choose>
												<c:when
													test="${user.getCredit() < article.getMiseAPrix()}">
													<div class="alert alert-warning alert-dismissible fade in">
														<a href="#" class="close" data-dismiss="alert"
															aria-label="close">&times;</a> <strong>Oops!</strong>
														Credit insuffisant.
													</div>
												</c:when>
											</c:choose>
											<label for="Proposition">Proposition :</label> <input
												name="proposition" class="form-control" id="Proposition"
												type="number" placeholder="${enchere.getMontantEnchere()}"
												min="${enchere.getMontantEnchere()}" required>
										</div>
										<input type="number" class="form-control hidden"
								name="userCredit" id="userCredit" value="${user.getCredit()}"
								size="">
									</div>
									<button class="btn btn-success" type="submit" name="btn"
										value="encherir">Enchérir</button>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${article.getDateDebutEncheres() > now}">
											<a class="btn btn-primary" id="modifier" onClick="modifier()">Modifier</a>
											<a class="btn btn-danger hidden" id="annuler"
												onClick="modifier()">Annuler</a>
											<button class="btn btn-success hidden" type="submit"
												id="enregistrer" name="btn" value="enregistrer">"Enregistrer"</button>
										</c:when>
										<c:otherwise>

										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>
	<footer class="container-fluid text-center">
		<p></p>
	</footer>

</body>
<script type="text/javascript">

	function checkForm(form){
		
		var credit = parseInt(form.userCredit.value);
		var proposition = parseInt(form.Proposition.value);
		if( credit < proposition){
			alert("Pas assez de credit! haha");
			return false;
		}
		
		return true;
	}

	function modifier() {
		var btnModifier = document.getElementById("modifier");
		var btnAnnuler = document.getElementById("annuler");
		var btnEnregistrer = document.getElementById("enregistrer");
		var modeModification = document.querySelectorAll(".modifier");

		btnModifier.classList.toggle("hidden");
		btnAnnuler.classList.toggle("hidden");
		btnEnregistrer.classList.toggle("hidden");
		var i;
		for (i = 0; i < modeModification.length; ++i) {
			modeModification[i].classList.toggle("hidden");
		}

	}
</script>

</html>