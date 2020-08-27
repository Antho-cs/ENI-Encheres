<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon Article</title>

<style type="text/css">
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
.description *{
	vertical-align: top;
}
.row{
	margin-top: 5px;
}


</style>
</head>
<body>

	<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />



	<div class="jumbotron text-center">
		<h2> mon article</h2>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 sidenav">
				<div class="">
					<img alt="Article"
						src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/funny-cat-captions-1563551842.jpg"
						style="width: 100%" />
				</div>
			</div>

			<div class="col-sm-6">
				<form action="POST">
					<div class="well">
						<div class="row">
							<label for="Article">Article :</label> 
							<input type="text" class="form-control" name="article" required>
						</div>
						
						<div class="row description">
							<label for="Description">Description :</label>
							<textarea name="description" required></textarea>
						</div>

						<div class="row">
							<label for="Categorie">Catégorie :</label> <select
								name="categorie" id="Categorie-select">

								<option>Toutes</option>
								<option>Informatique</option>
								<option>Ameublement</option>
								<option>Vetement</option>
								<option>Sport & Loisirs</option>

							</select>
						</div>

						<div class="row">
							<label for="Img">Photo de l'article :</label> <input type="file"
								name="Photo" accept="image/png, image/jpeg">

						</div>
					</div>
					<div class="well">
						<div class="row">
							<label for="Prix">Mise à prix :</label> <input type="number"
								name="Prix" min="10" max="10000000" size="20" required>
						</div>

						<div class="row">
							<label for="DateDebut">Début de l'enchère :</label> <input
								type="Date" name="DateDebut" size="20" required>
						</div>

						<div class="row">
							<label for="DateDebut">Fin de l'enchère :</label> 
							<input type="Date" name="DateFin" size="20" required>
						</div>
					</div>
					<div class="well">
						<div class="row">
							<fieldset>
								<legend>Retrait</legend>

								<label for="Rue">Rue :</label> <input type="text"
									class="form-control" name="Rue" value="${user.getRue()}" size="20" required>

								<label for="CodePostal">Code Postal :</label> 
								<input type="text" class="form-control" name="CodePostal" value="${user.getCode_postal()}" size="20"
									required>
								<label for="Ville">Ville :</label> 
								<input type="text" class="form-control" name="Ville" value="${user.getVille()}"
									size="20" required>

							</fieldset>

						</div>
					</div>
					<div class="well">
					<div class="row">
						<input class="btn btn-success" type="button" value="Enregistrer"> 
						<input class="btn btn-danger" type="button" value="Annuler">
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
</html>