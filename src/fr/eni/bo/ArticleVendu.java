package fr.eni.bo;

import java.time.LocalDateTime;

public class ArticleVendu {
	
	private int no_article;
	private String nom_article;
	private String description;
	private LocalDateTime date_debut_encheres;
	private LocalDateTime date_fin_encheres;
	private int prix_initial;
	private int prix_vente;
	private String etatVente;
	private int no_categorie;
	private String categorie;
	
	
	
	
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, int noCategotie, String categorie) {
		super();
		this.no_article = noArticle;
		nom_article = nomArticle;
		this.description = description;
		this.date_debut_encheres = dateDebutEncheres;
		this.date_fin_encheres = dateFinEncheres;
		this.prix_initial = miseAPrix;
		this.prix_vente = prixVente;
		this.no_categorie = noCategotie;
		this.categorie = categorie;
	}


	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, String etatVente, int noCategotie,
			String categorie) {
		super();
		this.no_article = noArticle;
		nom_article = nomArticle;
		this.description = description;
		this.date_debut_encheres = dateDebutEncheres;
		this.date_fin_encheres = dateFinEncheres;
		this.prix_initial = miseAPrix;
		this.prix_vente = prixVente;
		this.etatVente = etatVente;
		this.no_categorie = noCategotie;
		this.categorie = categorie;
	}


	public int getNoArticle() {
		return no_article;
	}


	public void setNoArticle(int noArticle) {
		this.no_article = noArticle;
	}


	public String getNomArticle() {
		return nom_article;
	}


	public void setNomArticle(String nomArticle) {
		nom_article = nomArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getDateDebutEncheres() {
		return date_debut_encheres;
	}


	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.date_debut_encheres = dateDebutEncheres;
	}


	public LocalDateTime getDateFinEncheres() {
		return date_fin_encheres;
	}


	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
		this.date_fin_encheres = dateFinEncheres;
	}


	public int getMiseAPrix() {
		return prix_initial;
	}


	public void setMiseAPrix(int miseAPrix) {
		this.prix_initial = miseAPrix;
	}


	public int getPrixVente() {
		return prix_vente;
	}


	public void setPrixVente(int prixVente) {
		this.prix_vente = prixVente;
	}


	public String getEtatVente() {
		return etatVente;
	}


	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}


	public int getNoCategotie() {
		return no_categorie;
	}


	public void setNoCategotie(int noCategotie) {
		this.no_categorie = noCategotie;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
}
