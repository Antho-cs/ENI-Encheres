package fr.eni.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.dal.ArticleVenduDAO;
import fr.eni.dal.ConnectionProvider;
import fr.eni.dal.DALException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String SQL_INSERT = "insert into articles_vendus (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_categorie,no_utilisateur)"
			+ "values (?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "update articles_vendus set nom_article= ?,set description= ?,set date_debut_encheres= ?,set date_fin_encheres= ?,set prix_initial= ?,set prix_vente= ?,set no_categorie= ?,set categorie= ?";

	private static final String SQL_DELETE = "delete from articles_vendus where no_article =?";

	private static final String SQL_SELECTALL = "select * from ARTICLES_VENDUS";

	private static final String SQL_SELECTBYNO = "select nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_categorie"
			+ "from articles_vendus where no_article = ?";

	private static final String SQL_SELECTBYCATEGORIE = "select nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente"
			+ "from articles_vendus where no_categorie = ?";

	/**
	 * permet de créer un nouvel article par l'utilisateur (vendeur)
	 * 
	 * @return
	 */
	@Override
	public ArticleVendu insertNewArt(ArticleVendu articleVendu) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, articleVendu.getNomArticle());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setDate(3, articleVendu.getDateDebutEncheres());
			pStmt.setDate(4, articleVendu.getDateFinEncheres());
			pStmt.setInt(5, articleVendu.getMiseAPrix());
			pStmt.setInt(6, articleVendu.getNoCategotie());
			pStmt.setInt(7, articleVendu.getNo_utilisateur());

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				articleVendu.setNoArticle(rs.getInt(1));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur lors de l'ajout de l'article : " + articleVendu, e);

		} finally {

			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return articleVendu;
	}

	/**
	 * permet de mettre à jour les données d'un article par l'utilisateur (vendeur)
	 */
	@Override
	public void updateArt(ArticleVendu articleVendu) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, articleVendu.getNomArticle());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setDate(3, articleVendu.getDateDebutEncheres());
			pStmt.setDate(4, articleVendu.getDateFinEncheres());
			pStmt.setInt(5, articleVendu.getMiseAPrix());
			pStmt.setInt(6, articleVendu.getPrixVente());
			pStmt.setInt(7, articleVendu.getNoCategotie());
			pStmt.setInt(8, articleVendu.getNo_utilisateur());

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				articleVendu.setNoArticle(rs.getInt(1));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur de la mise àࠪ jour de : " + articleVendu, e);

		} finally {

			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * permet de supprimer l'article par l'utilisateur (vendeur/administrateur)
	 */
	@Override
	public void deleteArt(int noArticle) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_DELETE);

			pStmt.setInt(1, noArticle);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur lors de la suppression de l'article : " + noArticle, e);

		} finally {

			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * permet à l'utilisateur de visualiser un article (acquéreur)
	 */
	@Override
	public ArticleVendu selectByNo(int noArticle) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArticleVendu Article = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_SELECTBYNO);

			pStmt.setInt(1, noArticle);

			rs = pStmt.executeQuery();
			rs.next();
			Article = new ArticleVendu(noArticle, rs.getString("nom_article"), rs.getString("description"),
					rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"),
					rs.getInt("prix_vente"), rs.getInt("no_categorie"), rs.getInt("no_utilisateur"));

		} catch (SQLException e) {
			throw new DALException("selectByNo failed - No = " + noArticle, e);
		}

		return Article;

	}

	/**
	 * permet à l'utilisateur (acquéreur) de visualiser tous les articles d'une
	 * catégorie
	 */
	@Override
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DALException {

		List<ArticleVendu> listArticle = new ArrayList<ArticleVendu>();

		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();
			pStmt = cnx.prepareStatement(SQL_SELECTBYCATEGORIE);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur lors de l'affichage des articles :", e);

		} finally {

			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listArticle;
	}

	/**
	 * permet à l'utilisateur (acquéreur) de visualiser tous les articles
	 */
	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		List<ArticleVendu> listArticle = new ArrayList<ArticleVendu>();
		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_SELECTALL);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur lors de l'affichage des articles :", e);

		} finally {

			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listArticle;
	}

}