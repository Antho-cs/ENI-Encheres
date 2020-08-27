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

	private static final String SQL_INSERT = "insert into encheres (date_enchere, montant_enchere, no_article, no_utilisateur) values (?,?,?,?)";
	private static final String SQL_UPDATE = "update encheres set date_enchere = ?, montant_enchere = ?, no_article = ? ,no_utilisateur = ?";
	private static final String SQL_SELECTBYNOARTICLE = "select * from encheres where no_article = ?";

	/**
	 * @see
	 */

	public Enchere insertNewEnchere(Enchere enchere) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			System.out.println(enchere.toString());
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setDate(1, enchere.getDateEnchere());
			pStmt.setInt(2, enchere.getMontantEnchere());
			pStmt.setInt(3, enchere.getNoArticle());
			pStmt.setInt(4, enchere.getNoUtilisateur());

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				enchere.setNoEnchere(rs.getInt(1));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur à l'ajout de l'enchere : " + enchere, e);

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

			pStmt.setDate(1, enchere.getDateEnchere());
			pStmt.setInt(2, enchere.getMontantEnchere());
			pStmt.setInt(3, enchere.getNoArticle());
			pStmt.setInt(4, enchere.getNoUtilisateur());

			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur lors de la mise � jour de l'ench�re : " + enchere, e);

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

	@Override
	public Enchere selectByNoArticle(int no_article) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Enchere enchere;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_SELECTBYNOARTICLE);

			pStmt.setInt(1, no_article);

			rs = pStmt.executeQuery();
			rs.next();
			enchere = new Enchere(no_article, rs.getDate("date_enchere"), rs.getInt("montant_enchere"),
					rs.getInt("no_utilisateur"), rs.getInt("no_enchere"));

		} catch (SQLException e) {
			throw new DALException("selectByNo failed - No = " + no_article, e);
		}

		return enchere;
	}

}
