package fr.eni.bll;

import java.util.List;

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
			throw new BLLException("Article dÈj‡† crÈÈe");
		}
		try {
			this.daoArticle.insertNewArt(Article);
			System.out.println("Article insÈrÈ dans la BDD");
		} catch (DALException e) {
			System.out.println(e.getStackTrace());
			throw new BLLException("Echec crÈation Article ");

		}

	}

	/**
	 * MAJ des donn√©es de l'utilisateur
	 * 
	 * @throws BLLException
	 */
	public void updateArt(ArticleVendu Article) throws BLLException {
		try {
			this.daoArticle.updateArt(Article);
		} catch (DALException e) {
			throw new BLLException("Echec dans la mise ‡ jour des donnÈes utilisateur " + Article, e);
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
	 * Affiche les donn√©es de l'utilisateur pour modification
	 * 
	 * @throws BLLException
	 */

	public List<ArticleVendu> selectAll() throws BLLException {

		try {
			return this.daoArticle.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la rÈcupÈration des donnÈes " + e);
		}

	}

	public ArticleVendu selectByNo(int noArticle) throws BLLException {

		try {
			return this.daoArticle.selectByNo(noArticle);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la r√©cup√©ration des donn√©s " + noArticle, e);
		}
	}

	public List<ArticleVendu> selectByCategorie(int no_categorie) throws BLLException {

		try {
			return this.daoArticle.selectByCategorie(no_categorie);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la r√©cup√©ration des donn√©s " + no_categorie, e);
		}
	}

	public List<ArticleVendu> selectByName(String no_article) throws BLLException {

		try {
			return this.daoArticle.selectByName(no_article);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la r√©cup√©ration des donn√©s " + no_article, e);
		}
	}

	public List<ArticleVendu> selectByNoUtilisateur(int no_utilisateur) throws BLLException {

		try {
			return this.daoArticle.selectByNoUtilisateur(no_utilisateur);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la r√©cup√©ration des donn√©s " + no_utilisateur, e);
		}
	}

}
