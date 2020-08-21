package fr.eni.bll;

import fr.eni.bo.ArticleVendu;
import fr.eni.dal.ArticleVenduDAO;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;

public class ArticleManager {
	private ArticleVenduDAO daoArticle;

	public ArticleManager() {
		this.daoArticle = DAOFactory.getArticleVenduDAO();
	}

	/**
	 * Ajoute un utilisateur dans la BDD
	 * 
	 * @param newUser
	 * @throws BLLException
	 */
	public void insertNewArt(ArticleVendu Article) throws BLLException {

		if (Article.getNoArticle() != 0) {
			throw new BLLException("Utilisateur déjà créé");
		}
		try {
			this.daoArticle.insertNewArt(Article);
			System.out.println("utilisateur inséré dans la BDD");
		} catch (DALException e) {
			System.out.println(e.getStackTrace());
			throw new BLLException("Echec création utilisateur");

		}

	}

	/**
	 * MAJ des données de l'utilisateur
	 * 
	 * @throws BLLException
	 */
	public void updateArt(ArticleVendu Article) throws BLLException {
		try {
			this.daoArticle.updateArt(Article);
		} catch (DALException e) {
			throw new BLLException("Echec dans la mise à jour des données utilisateur " + Article, e);
		}
	}

	/**
	 * supprime l'utilisateur
	 * 
	 * @throws BLLException
	 */
	public void deleteArt(int no_Article) throws BLLException {

		try {
			this.daoArticle.deleteArt(no_Article);
		} catch (DALException e) {
			throw new BLLException("Echec dans la suppression de l'utilisateur " + no_Article, e);
		}
	}

	/**
	 * Affiche les données de l'utilisateur pour modification
	 * 
	 * @throws BLLException
	 */

	public ArticleVendu selectAll() throws BLLException {

		try {
			return this.daoArticle.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des donnés " + e);
		}

	}

	public ArticleVendu selectByNo(int noArticle) throws BLLException {

		try {
			return this.daoArticle.selectByNo(noArticle);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des donnés " + noArticle, e);
		}
	}

	public ArticleVendu selectByCategorie(String categorie) throws BLLException {

		try {
			return this.daoArticle.selectByCategorie(categorie);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des donnés " + categorie, e);
		}
	}

}
