package fr.eni.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import fr.eni.bo.ArticleVendu;
import fr.eni.dal.ArticleVenduDAO;
import fr.eni.dal.ConnectionProvider;
import fr.eni.dal.DALException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String SQL_INSERT = "insert into articles_vendus (no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_categorie,categorie)"
			+ "values (?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "update articles_vendus set = no_article?,set nom_article= ?,set description= ?,set date_debut_encheres= ?,set date_fin_encheres= ?,set prix_initial= ?,set prix_vente= ?,set no_categorie= ?,set categorie= ?";

	private static final String SQL_DELETE = "delete from articles_vendus where no_article =?";

	private static final String SQL_SELECTALL = "select no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_categorie,categorie"
			+ "from articles_vendus";

	private static final String SQL_SELECTBYNO = "select nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_categorie,categorie"
			+ "from articles_vendus where no_article = ?";

	private static final String SQL_SELECTBYCATEGORIE = "select nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente"
			+ "from articles_vendus where categorie = ?";

	/**
	 * permet de créer un nouvel article par l'utilisateur (vendeur)
	 */
	@Override
	public void insertNewArt(ArticleVendu articleVendu) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setInt(1, articleVendu.getNoArticle());
			pStmt.setString(2, articleVendu.getNomArticle());
			pStmt.setString(3, articleVendu.getDescription());
			pStmt.setTimestamp(4, Timestamp.valueOf(articleVendu.getDateDebutEncheres()));
			pStmt.setTimestamp(5, Timestamp.valueOf(articleVendu.getDateFinEncheres()));
			pStmt.setInt(6, articleVendu.getMiseAPrix());
			pStmt.setInt(7, articleVendu.getPrixVente());
			pStmt.setInt(8, articleVendu.getNoCategotie());
			pStmt.setInt(9, articleVendu.get);

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				user.setNo_utilisateur(rs.getInt(1));
				// user.setCredit(0); //créditer à 0
				// user.setAdministrateur(0); //mettre utilisateur par défaut
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur à l'ajout de l'utilisateur : " + user, e);

		} finally {

			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * permet de mettre à jour les données d'un article par l'utilisateur
	 * (vendeur)
	 */
	@Override
	public void updateArt(ArticleVendu data) throws DALException {
		// TODO Auto-generated method stub

	}

	/**
	 * permet de supprimer l'article par l'utilisateur (vendeur/administrateur)
	 */
	@Override
	public void deleteArt(int noArticle) throws DALException {
		// TODO Auto-generated method stub

	}

	/**
	 * permet à l'utilisateur de visualiser un article (acquéreur)
	 */
	@Override
	public ArticleVendu selectByNo(int noArticle) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * permet à l'utilisateur (acquéreur) de visualiser tous les articles d'une
	 * catégorie
	 */
	@Override
	public List<ArticleVendu> selectByCategorie(String categorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * permet à l'utilisateur (acquéreur) de visualiser tous les articles
	 */
	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
