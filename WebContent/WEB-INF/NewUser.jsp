<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Inscritpion Utilisateur</title>


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
		<h2>Création d'un profil</h2>
	</div>

	<form action="ServletCreationCompte" method="POST">
		<div id="contenu">
			<div class="row">
			
<p> <i> <font color = "#FF0000" >${msg} </font></i></p>

				<div class="form-group col-md-6">
					<label for="Pseudo">Pseudo :</label> <input type="text"
						class="form-control" name="Pseudo" value = "${user.getPseudo()}" placeholder="Pseudo" required>
					</div>
					
				<div class="form-group col-md-6">
					<label for="inputAddress2">Email :</label> <input type="text"
						class="form-control" name="Mail"  value = "${user.getEmail()}" pattern=".+@.+.com"  title = "adresse mail valide type adresse@hebergeur.com/fr" placeholder="Mail" required>
						</div>
					
				</div>
				<div class="row">
					<div class="form-group col-md-6">
						<label for="inputZip">Mot de passe :</label> <input
							type="password" class="form-control" name="Mdp"
							value = "${user.getMot_de_passe()}" placeholder="8 Caractères Alphanumériques minimum. Contient au moins 1 Majuscule et 1 chiffre"  pattern ="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
							 required>

					</div>

					<div class="form-group col-md-6">
						<label for="inputZip">Confirmation :</label> <input
							type="password" class="form-control" name="ConfirmMdp" placeholder="Confirmez votre mot de passe" 
							required>
							
					</div>
							
				</div>
			<div class="row">
		
		<div class="form-group col-md-6">
			<label for="Nom">Nom :</label> <input type="text"
				class="form-control" name="Nom" value = "${user.getNom()}" pattern="[a-z]"  maxlength = "20"  placeholder="Nom" required>
	
		</div>

		<div class="form-group col-md-6">
			<label for="inputAddress">Prénom :</label> <input type="text"
				class="form-control" name="Prenom"  value = "${user.getPrenom()}" pattern="[a-z]"  maxlength = "20"  placeholder="Nom" required>

		</div>

</div>
		<div class="row">

			<div class="form-group col-md-6">
				<label for="inputCity">Teléphone :</label> <input type="tel"
					class="form-control" name="Telephone" placeholder="Telephone" value = "${user.getTelephone()}" title="ex: 0102030405"
					required>

			</div>

			<div class="form-group col-md-6">
				<label for="inputState">Rue :</label> <input type="text"
					class="form-control" name="Rue"  value = "${user.getRue()}" placeholder="Rue" required>

			</div>

		</div>

		<div class="row">

			<div class="form-group col-md-6">
				<label for="inputZip">Code postal :</label> <input type="text" 
					class="form-control" name="Cdp"  value = "${user.getCode_postal()}" pattern="[0-9]{5}"  title = "France métropolitaine : 01000 à 95750" placeholder="Code postal" required>

			</div>

			<div class="form-group col-md-6">
				<label for="inputZip">Ville :</label> <input type="text"
					class="form-control" name="Ville"  value = "${user.getVille()}"  placeholder="Ville" required>

			</div>
			
		</div>


		<div class="form-group focused text-center">
			<button class="btn btn-success " name="btn" value="enregistrer"
				type="submit">Créer</button>
			<button class="btn btn-danger " name="btn" value="supprimer"
				type="submit">Annuler</button>
		</div>
		
		</div>
	</form>
<footer class="container-fluid text-center">
		<p>ⓒ AnFiLa 2020</p>
	</footer>
</body>

</html>