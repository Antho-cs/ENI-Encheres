package fr.eni.bo;

import java.time.LocalDateTime;

public class Enchere {

	// Attributs
	protected ArticleVendu noArticle;
	protected LocalDateTime dateEnchere;
	protected int montantEnchere;
	protected Utilisateur noUtilisateur;
	protected int noEnchere;

	public Enchere(ArticleVendu noArticle, LocalDateTime dateEnchere, int montantEnchere, Utilisateur noUtilisateur,
			int noEnchere) {
		super();
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noUtilisateur = noUtilisateur;
		this.noEnchere = noEnchere;
	}

	public Enchere() {
		super();
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public ArticleVendu getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(ArticleVendu noArticle) {
		this.noArticle = noArticle;
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [noArticle=" + noArticle + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noUtilisateur=" + noUtilisateur + ", noEnchere=" + noEnchere + "]";
	}

}
