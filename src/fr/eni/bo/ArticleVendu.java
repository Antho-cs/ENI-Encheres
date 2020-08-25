package fr.eni.bo;

import java.sql.Date;

public class ArticleVendu {

	private int no_article;
	private String nom_article;
	private String description;
	private Date date_debut_encheres;
	private Date date_fin_encheres;
	private int prix_initial;
	private int prix_vente;
	private String etatVente;
	private int no_categorie;
	private String categorie;
	private int no_utilisateur;
	
	public ArticleVendu() {
		super();
	}
	
	public ArticleVendu(int no_article, String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, int prix_initial, int prix_vente, String etatVente, int no_categorie,
			String categorie, int no_utilisateur) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etatVente = etatVente;
		this.no_categorie = no_categorie;
		this.categorie = categorie;
		this.no_utilisateur = no_utilisateur;
	}

	public ArticleVendu(int no_article, String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, int prix_initial, int prix_vente, int no_categorie, int no_utilisateur) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_categorie = no_categorie;
		this.no_utilisateur = no_utilisateur;
	}

	public ArticleVendu(String nom_article, String description, Date date_debut_encheres, Date date_fin_encheres,
			int prix_initial, int no_categorie, int no_utilisateur) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.no_categorie = no_categorie;
		this.no_utilisateur = no_utilisateur;
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

	public Date getDateDebutEncheres() {
		return date_debut_encheres;
	}

	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.date_debut_encheres = dateDebutEncheres;
	}

	public Date getDateFinEncheres() {
		return date_fin_encheres;
	}

	public void setDateFinEncheres(Date dateFinEncheres) {
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

	public void setPrixVente(int Prix) {
		this.prix_vente = Prix;
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

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public void setVille(String ville) {

	}

}
