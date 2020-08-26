package fr.eni.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.bo.Enchere;
import fr.eni.dal.ConnectionProvider;
import fr.eni.dal.DALException;
import fr.eni.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String SQL_INSERT = "insert into encheres (no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur) values (?,?,?,?,?)";
	private static final String SQL_UPDATE = "update encheres set no_enchere = ?,date_enchere = ?, montant_enchere = ?, no_article = ? ,no_utilisateur = ?";

	// private static final String SQL_DELETE = "delete
	// pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe from
	// utilisateurs where no_utilisateur = ?";
	// private static final String SQL_SELECTBYID = "select * from utilisateurs
	// where no_utilisateur = ?";

	public Enchere insertNewEnchere(Enchere enchere) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setInt(1, enchere.getNoEnchere());
			pStmt.setLocalDate(2, enchere.getDateEnchere());
			pStmt.setInt(3, enchere.getMontantEnchere());
			pStmt.setArticleVendu(4, enchere.getNoArticle());
			pStmt.setUtlilisateur(5, enchere.getNoUtilisateur());

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				enchere.setNoEnchere(rs.getInt(1));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur Ã  l'ajout de l'utilisateur : " + enchere, e);

		} finally {

			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return enchere;

	}

	public void updateEnchere(Enchere enchere) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_UPDATE);

			pStmt.setInt(1, enchere.getNoEnchere());
			pStmt.setLocalDateTime(2, enchere.getDateEnchere());
			pStmt.setInt(3, enchere.getMontantEnchere());
			pStmt.setArticleVendu(4, enchere.getNoArticle());
			pStmt.setUtlilisateur(5, enchere.getNoUtilisateur());

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				enchere.setNoEnchere(rs.getInt(1));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur lors de la mise à jour de l'enchère : " + enchere, e);

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
}
