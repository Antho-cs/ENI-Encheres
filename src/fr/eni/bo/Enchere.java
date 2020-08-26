package fr.eni.bo;

import java.sql.Date;

public class Enchere {

	// Attributs
	protected int noArticle;
	protected Date dateEnchere;
	protected int montantEnchere;
	protected int noUtilisateur;
	protected int noEnchere;

	public Enchere(int noArticle, Date dateEnchere, int montantEnchere, int noUtilisateur, int noEnchere) {
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

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
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
