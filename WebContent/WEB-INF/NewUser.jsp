<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Latest compiled and minified CSS -->
<title>ENI Encheres</title>


<style>
#contenu {
	align: center;
	padding: 10px 50px 20px;
}

#bouton {
	margin-left: auto;
	margin-right: auto;
}
/*.titre {text-align:center;}*/
</style>


</head>

<body>

	<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />

	<div class="jumbotron text-center">
		<h2>Mon profil</h2>
	</div>

	<form action="ServletCreationCompte" method="POST">
		<div id="contenu">
			<div class="row">
			
<p> <i> <font color = "#FF0000" >${msg} </font></i></p>

				<div class="form-group col-md-6">
					<label for="Pseudo">Pseudo :</label> <input type="text"
						class="form-control" name="Pseudo" placeholder="Pseudo" required>
					<p> <i> <font color = "#FF0000" >${msgPseudo} </font></i></p>
				</div>
					
				<div class="form-group col-md-6">
					<label for="inputAddress2">Email :</label> <input type="text"
						class="form-control" name="Mail" placeholder="Mail" required>
						<p> <i> <font color = "#FF0000" >${msgEmail} </font></i></p>
				</div>
					
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label for="inputZip">Mot de passe :</label> <input
							type="password" class="form-control" name="Mdp"
							placeholder="Mot de passe" pattern ="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
							title="8 Caractères Alphanumériques minimum. Contient au moins 1 Majuscule et 1 chiffre" required>
						<p> </p>
					</div>
<<<<<<< HEAD
							
=======
					
					
				

>>>>>>> e43c91395909a963ed1ce28d0eb779f70947b384
					<div class="form-group col-md-6">
						<label for="inputZip">Confirmation :</label> <input
							type="password" class="form-control" name="ConfirmMdp"
							placeholder="Confirmez votre mot de passe" 
							required>
							<p> <i> <font color = "#FF0000" >${msgMdp} </font></i></p>
					</div>
							
				</div>
			<div class="row">
		
		<div class="form-group col-md-6">
			<label for="Nom">Nom :</label> <input type="text"
				class="form-control" name="Nom" placeholder="Nom" required>
		<p> </p>
		</div>

		<div class="form-group col-md-6">
			<label for="inputAddress">Prénom :</label> <input type="text"
				class="form-control" name="Prenom" placeholder="Nom" required>
		<p> </p>
		</div>

</div>
		<div class="row">

			<div class="form-group col-md-6">
				<label for="inputCity">Teléphone :</label> <input type="tel"
					class="form-control" name="Telephone" placeholder="Telephone" title="10 chiffres ex: 0102030405"
					required>
					<p> </p>
			</div>

			<div class="form-group col-md-6">
				<label for="inputState">Rue :</label> <input type="text"
					class="form-control" name="Rue" placeholder="Rue" required>
			<p> </p>
			</div>

		</div>

		<div class="row">

			<div class="form-group col-md-6">
				<label for="inputZip">Code postal :</label> <input type="number"
					class="form-control" name="Cdp" placeholder="Code postal" required>
				<p> </p>		
			</div>

			<div class="form-group col-md-6">
				<label for="inputZip">Ville :</label> <input type="text"
					class="form-control" name="Ville" placeholder="Ville" required>
			<p> </p>
			</div>
			
		</div>


		<div class="form-group focused text-center">
			<button class="btn btn-success " name="btn" value="enregistrer"
				type="submit">Créer</button>
			<button class="btn btn-danger " name="btn" value="supprimer"
				type="submit">Annuler</button>
		</div>
	</form>
</body>

</html>