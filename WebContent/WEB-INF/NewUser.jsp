<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Latest compiled and minified CSS -->
<title>ENI Encheres</title>


<style>

	#contenu {align:center; padding: 10px 50px 20px;}
	#bouton { margin-left: auto; margin-right: auto;}
	/*.titre {text-align:center;}*/
</style>


</head>

<body>

<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />

<div class="jumbotron text-center">
    <h2>Mon profil</h2>
  </div>

<form action="POST">
<div id ="contenu"  >
  <div class="row">
  
    <div class="form-group col-md-6">
      <label for="Pseudo">Pseudo :</label>
      <input type="text" class="form-control" id="Pseudo" placeholder="Pseudo" required>
    </div>
    
     <div class="form-group col-md-6">
      <label for="Nom">Nom :</label>
      <input type="text" class="form-control" id="Nom" placeholder="Nom" required>
    </div>
  
  </div>
  
  
<div class="row">
  
  <div class="form-group col-md-6">
    <label for="inputAddress">Prénom :</label>
    <input type="text" class="form-control" id="Prenom" placeholder="Nom" required>
  </div>
  
    <div class="form-group col-md-6">
      <label for="inputCity">Teléphone :</label>
      <input type="tel" class="form-control" id="Telephone" placeholder="Telephone" required>
    </div>
    
    </div>
    
    <div class="row">
    
    <div class="form-group col-md-6">
      <label for="inputZip">Code postal :</label>
      <input type="number" class="form-control" id="Cdp" placeholder="Code postal" required>
    </div>
    
  
  
	<div class="form-group col-md-6">
      <label for="inputZip">Mot de passe :</label>
      <input type="password" class="form-control" id="Mdp" placeholder="Mot de passe" required>
    </div>
  
  </div>
  
  
 
 <div class="row">
  
  <div class="form-group col-md-6">
    <label for="inputAddress2">Email :</label>
    <input type="text" class="form-control" id="Mail" placeholder="Mail" required>
  </div>
  
  
    <div class="form-group col-md-6">
      <label for="inputState">Rue :</label>
      <input type="text" class="form-control" id="Rue" placeholder="Rue" required>
      
    </div>
    
    </div>
    
    <div class="row">
    
    
  <div class="form-group col-md-6">
      <label for="inputZip">Ville :</label>
      <input type="text" class="form-control" id="Ville" placeholder="Ville" required>
    </div>
    
	
  <div class="form-group col-md-6">
      <label for="inputZip">Confirmation :</label>
      <input type="password" class="form-control" id="ConfirmMdp" placeholder="Confirme petit Con !" required>
    </div>
  
</div>

</div>

</form>

 
<div class ="bouton text-center">

  <a href ="WEB-INF/Page_acceuil.jsp" class="btn btn-primary">Créer</a>
  <a href ="WEB-INF/Page_acceuil.jsp" class="btn btn-primary">Annuler</a>
</div>


</body>

</html>