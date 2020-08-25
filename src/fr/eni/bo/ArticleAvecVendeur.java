package fr.eni.bo;

import java.sql.Date;

public class ArticleAvecVendeur extends ArticleVendu{
	private String nomDeVendeur;

	public ArticleAvecVendeur(int no_article,String nom_article, String description,Date date_fin_encheres,
			int prix_initial,String nomDeVendeur) {
		super(no_article,nom_article,description,date_fin_encheres,prix_initial);
		this.nomDeVendeur = nomDeVendeur;
	}

	public String getNomDeVendeur() {
		return nomDeVendeur;
	}

	public void setNomDeVendeur(String nomDeVendeur) {
		this.nomDeVendeur = nomDeVendeur;
	}
	

}
