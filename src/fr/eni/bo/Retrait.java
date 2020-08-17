package fr.eni.bo;

public class Retrait {
	
	protected Utilisateur rue;
	protected Utilisateur codePostal;
	protected Utilisateur ville;
	protected ArticleVendu noArticle;
	
		
public Retrait() {
		super();
	}


	public Retrait(Utilisateur rue, Utilisateur codePostal, Utilisateur ville, ArticleVendu noArticle) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.noArticle = noArticle;
	}


	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", noArticle=" + noArticle
				+ "]";
	}
	
	
}
