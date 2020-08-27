package fr.eni.bo;

public class Retrait {

	// Variables //

	protected Utilisateur rue;
	protected Utilisateur codePostal;
	protected Utilisateur ville;
	protected ArticleVendu noArticle;

	// Constructeurs //

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

	// Getter Setter //

	public Utilisateur getRue() {
		return rue;
	}

	public void setRue(Utilisateur rue) {
		this.rue = rue;
	}

	public Utilisateur getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Utilisateur codePostal) {
		this.codePostal = codePostal;
	}

	public Utilisateur getVille() {
		return ville;
	}

	public void setVille(Utilisateur ville) {
		this.ville = ville;
	}

	public ArticleVendu getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(ArticleVendu noArticle) {
		this.noArticle = noArticle;
	}

	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", noArticle=" + noArticle
				+ "]";
	}

}
