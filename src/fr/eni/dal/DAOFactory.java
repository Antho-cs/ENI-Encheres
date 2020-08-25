package fr.eni.dal;

import fr.eni.dal.Jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.dal.Jdbc.CategorieDAOJdbcImpl;
import fr.eni.dal.Jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();

	}

	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();

	}

}
