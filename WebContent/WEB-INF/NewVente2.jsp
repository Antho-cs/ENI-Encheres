<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création d'un article</title>

<style type="text/css">
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

.description * {
	vertical-align: top;
}

.row {
	margin-top: 5px;
}
</style>
</head>

<body>
	 <jsp:useBean id="now" class="java.util.Date" />
	<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />



	<div class="jumbotron text-center">
		<h2>Création d'un article</h2>
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
				<form method="POST" action="NewArticle">
				
				
					<div class="well">
						<div class="row">
						<p> <i> <font color = "#FF0000" >${msg} </font></i></p>
						</div>
						<div class="row">
							<label for="Article">Article :</label> <input type="text"
								class="form-control" name="Article" id="Article"  value ="${article.getNomArticle()}" required>
						</div>

						<div class="row description">
							<label for="Description">Description :</label>
							<textarea id="Description" name="Description"  value="${article.getDescription()}" required></textarea>
						</div>

						<div class="row">
							<label for="Categorie">Catégorie :</label> <select
								name="Categorie" id="Categorie-select">
								<c:forEach var = "i" begin = "0" end = "${categories.size()-1}">
									<option value="${i+1}"><c:out value = "${categories.get(i).getLibelle()}"/></option>
								</c:forEach>
							</select>
						</div>

						<div class="row">
							<label for="Img">Photo de l'article :</label> <input type="file"
								id="Photo" name="Photo" accept="image/png, image/jpeg">

						</div>
					</div>
					<div class="well">
						<div class="row">
							<label for="Prix">Mise à prix :</label> <input type="number"
								id="Prix" name="Prix" min="10" max="10000000" size="20" value = "${article.getMiseAPrix()}"required>
						</div>

						<div class="row">
							<label for="DateDebut">Début de l'enchère :</label> 
								<input type="date" name="DateDebut"  min='<fmt:formatDate  pattern="yyyy-MM-dd" value="${now}" />' size = "20" required/>
						</div>

						<div class="row">
							<label for="DateDebut">Fin de l'enchère :</label> 
								<input type="date" name="DateFin"  min='<fmt:formatDate  pattern="yyyy-MM-dd" value="${now}" />' size = "20" required/>
							
						</div>
						
					</div>
					<div class="well">
						<div class="row">
							<fieldset>
								<legend>Retrait</legend>
								<label for="Rue">Rue :</label> <input type="text"
									class="form-control" id="Rue" value="${user.getRue()}"
									size="20" required> <label for="CodePostal">Code
									Postal :</label> <input type="text" class="form-control"
									id="CodePostal" value="${user.getCode_postal()}" size="20"
									required> <label for="Ville">Ville :</label> <input
									type="text" class="form-control" id="Ville"
									value="${user.getVille()}" size="20" required> <input
									type="text" name="noUtilisateur" class="form-control hidden"
									id="Ville" value="${user.getNo_utilisateur()}" size="20"
									required>
							</fieldset>
						</div>
					</div>
					<div class="well">
						<div class="row">
							<input class="btn btn-success" type="submit" value="Enregistrer">
							<input class="btn btn-danger" type="reset" value="Annuler">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>
</body>
</html>