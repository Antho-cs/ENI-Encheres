package fr.eni.dal;

import java.util.List;

import fr.eni.bo.ArticleVendu;

public interface ArticleVenduDAO {

	/**
	 * // Insertion d'un Article //
	 */
	public ArticleVendu insertNewArt(ArticleVendu articleVendu) throws DALException;

	/**
	 * // Mise � jour d'un Article //
	 */
	public void updateArt(ArticleVendu data) throws DALException;

	/**
	 * // Suppression d'un Article //
	 */
	public void deleteArt(int noArticle) throws DALException;

	/**
	 * // Selection de tous les Articles //
	 */
	public List<ArticleVendu> selectAll() throws DALException;

	/**
	 * // Selection d'un Article par num�ro //
	 */
	public ArticleVendu selectByNo(int noArticle) throws DALException;

	/**
	 * // Selection par categorie //
	 */
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DALException;

	/**
	 * // Selection par nom //
	 */
	public List<ArticleVendu> selectByName(String no_article) throws DALException;

	/**
	 * // Selection par num�ro utilisateur //
	 */
	public List<ArticleVendu> selectByNoUtilisateur(int no_utilisateur) throws DALException;

}
