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