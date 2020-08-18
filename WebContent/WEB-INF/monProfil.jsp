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
                  <p>2586</p>
                </div>
                </div>
                <div class="col-4 text-right">
                  <a id="modifier" class="btn btn-sm btn-primary" onClick="modifier()">Modifier</a>
                  <a id="annuler" class="btn btn-sm btn-warning hidden" onClick="annuler()">Annuler</a>
                </div>
              </div>
            </div>
            <div class="card-body">
              <form>
                <h6 class="heading-small text-muted mb-4">User information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-username">Pseudo</label>
                        <input type="text" id="input-username" class="form-control form-control-alternative" placeholder="Pseudo" value="Anfila ohlala">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-email">Email address</label>
                        <input type="email" id="input-email" class="form-control form-control-alternative" placeholder="example@example.com">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-first-name">Nom</label>
                        <input type="text" id="input-first-name" class="form-control form-control-alternative" placeholder="Nom" value="AnFiLa">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-last-name">Prenom</label>
                        <input type="text" id="input-last-name" class="form-control form-control-alternative" placeholder="Prenom" value="Eni">
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4">
                <!-- Address -->
                <h6 class="heading-small text-muted mb-4">Contact information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-address">Rue</label>
                        <input id="input-address" class="form-control form-control-alternative" placeholder="Rue" value="81 Rue d'allonville" type="text">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-city">Ville</label>
                        <input type="text" id="input-city" class="form-control form-control-alternative" placeholder="Ville" value="Nantes">
                      </div>
                    </div>
                    </div>
                    <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group">
                        <label class="form-control-label" for="input-country">Code postal</label>
                        <input type="number" id="input-postal-code" class="form-control form-control-alternative" placeholder="Code postal" value="44100">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group">
                        <label class="form-control-label" for="input-country">Telephone</label>
                        <input type="number" id="input-postal-code" class="form-control form-control-alternative" placeholder="Numero de telephone">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="hidden" id="modeModification">
                <h6 class="heading-small text-muted mb-4">Mot de passe</h6>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="motDePasse">Mot de passe actuel</label>
                        <input type="password" id="motDePasse" class="form-control form-control-alternative" placeholder="*********">
                        <label class="form-control-label" for="motDePasse">nouveau mot de passe</label>
                        <input type="password" id="motDePasse" class="form-control form-control-alternative" placeholder="*********">
                        <label class="form-control-label" for="confirmerMotDePasse">Confirmer votre mot de passe</label>
                        <input type="password" id="confirmerMotDePasse" class="form-control form-control-alternative" placeholder="*********">
                      </div>
                      </div>
                   </div>
                   <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                      <button class="btn btn-success">Enregistrer</button>
                      <button class="btn btn-danger">Supprimer mon compte</button>
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
	  btnModifier.classList.add("hidden");
	  btnAnnuler.classList.remove("hidden");
	  modeModification.classList.remove("hidden");
	}
  function annuler() {
	  var btnModifier = document.getElementById("modifier");
	  var btnAnnuler = document.getElementById("annuler");
	  var modeModification = document.getElementById("modeModification");
	  btnModifier.classList.remove("hidden");
	  btnAnnuler.classList.add("hidden");
	  modeModification.classList.add("hidden");
	}
  </script>
</body>
</html>