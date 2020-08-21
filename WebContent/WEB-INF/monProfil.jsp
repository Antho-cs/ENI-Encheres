<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<jsp:include page="/WEB-INF/Page_acceuil/navBar.jsp" />

  <div class="container">
   <div class="col-xl-8">
          <div class="card bg-secondary shadow">
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
              <div class="col-sm-3">
                <div class="well">
                  <h4 class="mb-0">Credit disponible</h4>
                  <p>${user.getCredit()}</p>
                </div>
                </div>
                <div class="col-4 text-right">
                  <a id="modifier" class="btn btn-sm btn-primary" onClick="modifier()">Modifier</a>
                  <a href="ServletMonProfil" id="annuler" class="btn btn-sm btn-warning hidden">Annuler</a>
                </div>
              </div>
            </div>
            <div class="card-body">
              <form action="ServletMonProfil" method="post" id="profilForm" onsubmit="return checkForm(this);">
                <h6 class="heading-small text-muted mb-4">User information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-pseudo">Pseudo</label>
                        <input type="text" id="input-pseudo" name="pseudo" class="form-control form-control-alternative readonly" placeholder="Pseudo" value="${user.getPseudo()}" readonly>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-email">Email address</label>
                        <input type="email" id="input-email" name="email" class="form-control form-control-alternative readonly" placeholder="example@example.com" value="${user.getEmail()}" readonly>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-first-name">Nom</label>
                        <input type="text" id="input-first-name" name="nom" class="form-control form-control-alternative readonly" placeholder="Nom" value="${user.getNom()}" readonly>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-last-name">Prenom</label>
                        <input type="text" id="input-last-name" name="prenom" class="form-control form-control-alternative readonly" placeholder="Prenom" value="${user.getPrenom()}" readonly>
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4">
                <!-- Address -->
                <h6 class="heading-small text-muted mb-4">Contact information</h6>
                
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-address">Rue</label>
                        <input id="input-address" name="rue" class="form-control form-control-alternative readonly" placeholder="Rue" value="${user.getRue()}" readonly>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-city">Ville</label>
                        <input type="text" id="input-city" name="ville" class="form-control form-control-alternative readonly" placeholder="Ville" value="${user.getVille()}" readonly>
                      </div>
                    </div>
                  </div>
                    <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-country">Code postal</label>
                        <input type="number" id="input-postal-code" name="codePostal" class="form-control form-control-alternative readonly" placeholder="Code postal" value="${user.getCode_postal()}" readonly>
                      </div>
                    </div> 
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-country">Telephone</label>
                        <input type="number" id="input-telephone" name="telephone" class="form-control form-control-alternative readonly" placeholder="Tel" value="${user.getTelephone()}" readonly>
                      </div>
                    </div>
                  </div>
                <hr class="my-4">
                <h6 class="heading-small text-muted mb-4">Sécurité</h6>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="motDePasse">Mot de passe</label>
                        <input type="password" id="motDePasse" name="motDePasse" class="form-control form-control-alternative readonly" placeholder="votre mdp" readonly>
                      </div>
                      </div>
                   </div>
                <div class="hidden" id="modeModification">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="nouveauMotDePasse">nouveau mot de passe</label>
                        <input type="password" id="nouveauMotDePasse" name="nouveauMotDePasse" class="form-control form-control-alternative" placeholder="votre nouveau mdp">
                        <label class="form-control-label" for="confirmerMotDePasse">Confirmer votre mot de passe</label>
                        <input type="password" id="confirmerMotDePasse" name="confirmerMotDePasse" class="form-control form-control-alternative" placeholder="Confirmer votre mdp">
                        <input type="password" id="motDePasseDBB" name="motDePasseDBB" class="hidden" value="${user.getMot_de_passe()}">
                        
                      </div>
                      </div>
                   </div>
                   <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                      <button class="btn btn-success" name="btn" value="enregistrer" type="submit">Enregistrer</button>
                      <button class="btn btn-danger" name="btn" value="supprimer" type="submit">Supprimer mon compte</button>
                      </div>
                    </div>
                   
                </div>
                </div>
              </form>
            </div>
          </div>
          </div>
  </div>
  <script>
  function modifier() {
	  var btnModifier = document.getElementById("modifier");
	  var btnAnnuler = document.getElementById("annuler");
	  var modeModification = document.getElementById("modeModification");
	  var readonly = document.querySelectorAll(".readonly");
	  
	  btnModifier.classList.add("hidden");
	  btnAnnuler.classList.remove("hidden");
	  modeModification.classList.remove("hidden");
	  var i;
	  for(i=0; i< readonly.length;++i){
		  readonly[i].readOnly = false;
	  }
	  	  
	}
  function checkForm(form)
  {
	if(form.pseudo.value ==""){
		alert("Erreur: Le Pseudo est obligatoire ptn!");
	      form.pseudo.focus();
	      return false;
	}
	if(form.email.value ==""){
		alert("Erreur: L'email est obligatoire ptn!");
	      form.email.focus();
	      return false;	  
		  }
	if(form.nom.value ==""){
		alert("Erreur: Le nom est obligatoire ptn!");
	      form.nom.focus();
	      return false;  
	}
	if(form.prenom.value ==""){
		alert("Erreur: Le prenom est obligatoire ptn!");
	      form.prenom.focus();
	      return false;  
	}
	if(form.rue.value ==""){
		alert("Erreur: Le nom de la rue est obligatoire ptn!");
	      form.rue.focus();
	      return false;  
	}
	if(form.ville.value ==""){
		alert("Erreur: Le nom de la ville est obligatoire ptn!");
	      form.ville.focus();
	      return false;  
	}
	if(form.codePostal.value ==""){
		alert("Erreur: Le code postal est obligatoire ptn!");
	      form.codePostal.focus();
	      return false;	  
	}
	if(form.telephone.value ==""){
	  alert("Erreur: Le numero de telephone est obligatoire ptn!");
      form.telephone.focus();
      return false;  
	}
    if(form.motDePasse.value == "") {
      alert("Erreur: Le mot de passe est obligatoire ptn!");
      form.motDePasse.focus();
      return false;
    }
    if(form.motDePasseDBB.value != form.motDePasse.value) {
      alert("Erreur: Mot de passe incorrect");
      form.motDePasse.focus();
      return false;
    }

    if(form.nouveauMotDePasse.value != "" && form.nouveauMotDePasse.value == form.confirmerMotDePasse.value) {
      if(form.nouveauMotDePasse.value.length < 6) {
        alert("Erreur: le mot de passe doit contenir au moins 6 caractères conard!");
        form.nouveauMotDePasse.focus();
        return false;
      }
      if(form.nouveauMotDePasse.value == form.motDePasse.value) {
        alert("Erreur: L'utilisateur est un con");
        form.nouveauMotDePasse.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.nouveauMotDePasse.value)) {
        alert("Erreur: Votre mot de passe doit comporter au moins 8 caractères (32 au maximum) et au moins un chiffre (0-9)!");
        form.nouveauMotDePasse.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.nouveauMotDePasse.value)) {
        alert("Erreur: password must contain at least one lowercase letter (a-z)!");
        form.nouveauMotDePasse.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.nouveauMotDePasse.value)) {
        alert("Erreur: Un bon mot de passe contient des majuscules (A-Z)!");
        form.nouveauMotDePasse.focus();
        return false;
      }
    } else {
      return true;
    }
	
    alert("You entered a valid password: " + form.nouveauMotDePasse.value);
    return true;
  }
  </script>
</body>
</html>