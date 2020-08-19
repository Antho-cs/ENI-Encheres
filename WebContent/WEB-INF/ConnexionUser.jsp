<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>ENI Encheres</title>

</head>

<body>
<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />



<form  action="${pageContext.request.contextPath}/Connection" method ="POST" >

	<div>
		<label for="uname">Identifiant :</label>
		<input type="text" id="Identifiant" name="Identifiant" >
	</div>
	
	<div>
		<label for="Mdp">Mot de passe :</label>
		<input type="password" id="Mdp" name="Mdp"  >
	</div>
	
	<div>
		<button name="button_Connexion" type ="submit" >Connexion</button>
	</div>
	
	<div>
  		<input type="checkbox" id="SaveMe" name="SaveMe"
         checked>
  		<label for="SaveMe">Se souvenir de moi</label>
  		<br>
  		
  		<a href=//Lien-vers-Mdp-oubliez >Mot de passe oublié</a>
  		
	</div>
	
	<p>${Erreur} </p>

	
</form>

</body>

</html>