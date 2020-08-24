<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />



	<div class="jumbotron text-center">
		<h2>Nouvelle Vente</h2>
	</div>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">

				<div class=photo>
					<img alt="Article" src="/assets_tutorials/img/image.jpg" />
				</div>

			</div>
			<div class="col-sm-9 text-center">

				<form action="POST">

					<div class = Article>
						<label for="Article">Article :</label> <input type="text"
							class="form-control" id="Article"  size="10" required>
					</div>

					<div>

						<label for="Description">Description :</label>
						<textarea id="story" name="story" rows="5" cols="33" required>		</textarea>

					</div>

					<div>
						<label for="Categorie">Catégorie :</label> 
						<select name="Categorie" id="Categorie-select">

							<option>Toutes</option>
							<option>Informatique</option>
							<option>Ameublement</option>
							<option>Vetement</option>
							<option>Sport & Loisirs</option>

						</select>
					</div>

					<div class = UploadPhoto>
						<label for="Img">Photo de l'article :</label>
						<input type="file" id="Photo" name="Photo" accept="image/png, image/jpeg">

					</div>


					<div>
						<label for="Prix">Mise à prix :</label> <input type="number"
							id="Prix" name="Prix" min="10" max="10000000" size="20" required>
					</div>

					<div>
						<label for="DateDebut">Début de l'enchère :</label> <input
							type="Date" name="DateDebut" size="20" required>
					</div>

					<div>
						<label for="DateDebut">Fin de l'enchère :</label> <input
							type="Date" name="DateFin" size="20" required>
					</div>

					<div class = Retrait>
						<fieldset>
							<legend>Retrait</legend>

							<label for="Rue">Rue :</label> 
							<input type="text" class="form-control" id="Rue" value="<%%>" size="20" required> 
							
							<label for="CodePostal">Code Postal :</label> 
							<input type="text" class="form-control" id="CodePostal" value="<%%>" size="20" required> 
							
							<label for="Ville">Ville :</label> 
							<input type="text" class="form-control" id="Ville" value="<%%>" size="20" required>

						</fieldset>

					</div>

					<div class = button>
						<input type="button" value="Enregistrer"> 
						<input type="button" value="Annuler">
					</div>
				</form>


			</div>
		</div>
	</div>
	<footer class="container-fluid">
	<p>Footer Text</p>
	</footer>
	<script type="text/javascript">
	 var inputFile = document.createElement('input');
		inputFile.type = 'file';
		inputFile.accept = 'image/*';
		document.getElementsByTagName('body')[0].appendChild(inputFile);
		var reader = new FileReader();
		reader.readAsDataURL(inputFile.files[0]);
	</script>

</body>
</html>