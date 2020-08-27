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
	 * Ajoute un article à vendre dans la BDD
	 * 
	 * @param
	 * @throws BLLException
	 */
	public void insertNewArt(ArticleVendu Article) throws BLLException {

		if (Article.getNoArticle() != 0) {
			throw new BLLException("Article déjà créé");
		}
		try {
			this.daoArticle.insertNewArt(Article);
		} catch (DALException e) {
			throw new BLLException("Echec de la création Article ");

		}

	}

	/**
	 * MAJ des données de l'article
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
	 * supprime l'article
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
	 * Affiche les données de l'article pour modification
	 * 
	 * @see
	 * 
	 */

	public List<ArticleVendu> selectAll() throws BLLException {

		try {
			return this.daoArticle.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des données " + e);
		}

	}

	/**
	 * @see
	 * @param noArticle
	 * @return
	 * @throws BLLException
	 */

	public ArticleVendu selectByNo(int noArticle) throws BLLException {

		try {
			return this.daoArticle.selectByNo(noArticle);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des données " + noArticle, e);
		}
	}

	/**
	 * 
	 * @param no_categorie
	 * @return
	 * @throws BLLException
	 */
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws BLLException {

		try {
			return this.daoArticle.selectByCategorie(no_categorie);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des données " + no_categorie, e);
		}
	}

	/**
	 * @see
	 * @param no_article
	 * @return
	 * @throws BLLException
	 */

	public List<ArticleVendu> selectByName(String no_article) throws BLLException {

		try {
			return this.daoArticle.selectByName(no_article);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des données " + no_article, e);
		}
	}

	/**
	 * @see
	 * @param no_utilisateur
	 * @return
	 * @throws BLLException
	 */
	public List<ArticleVendu> selectByNoUtilisateur(int no_utilisateur) throws BLLException {

		try {
			return this.daoArticle.selectByNoUtilisateur(no_utilisateur);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des données " + no_utilisateur, e);
		}
	}

}
