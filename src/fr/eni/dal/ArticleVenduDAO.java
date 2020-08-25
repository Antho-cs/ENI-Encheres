package fr.eni.dal;

import java.util.List;

import fr.eni.bo.ArticleVendu;

public interface ArticleVenduDAO {

	public ArticleVendu insertNewArt(ArticleVendu articleVendu) throws DALException;

	public void updateArt(ArticleVendu data) throws DALException;

	public void deleteArt(int noArticle) throws DALException;

	public List<ArticleVendu> selectAll() throws DALException;

	public ArticleVendu selectByNo(int noArticle) throws DALException;

	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DALException;

}
