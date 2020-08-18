<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nouvelle Vente</title>

</head>

<body>
<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />

<div class="jumbotron text-center">
    <h2>Nouvelle vente</h2>
  </div>
  
  
  <div class="row">
  
  <div class="column">
  	 	<div class= photo>
  		/* Photo */
 		 <a href = /Lien/de/la/photo.jpg >
  		</div>
  
  </div>
  
  <div class="column">
  
  <form action="POST">
  
    <div>
      <label for="Article">Article :</label>
      <input type="text" class="form-control" id="Article" placeholder="Article" required>
    </div>
    
     <div>
      <label for="Description">Description :</label>
      <input type="text" class="form-control" id="Descritpion" placeholder="Description" required>
    </div>
  </form>
  </div>
  
  <div>
  <textarea id="story" name="story" rows="5" cols="33">		</textarea>
  </div>
  
  
 
  
  <div class="column">
  
  </div>
  </div>
</div>
 
  
  
  
  



</body>
</html>