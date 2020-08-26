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
	// private static final String SQL_UPDATE = "update encheres set no_enchere =
	// ?,date_enchere = ?, montant_enchere = ?, no_article = ? ,no_utilisateur = ?";
	private static final String SQL_SELECTBYID = "select * from encheres where no_enchere = ?";

	public Enchere insertNewEnchere(Enchere enchere) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setInt(1, enchere.getNoEnchere());
			pStmt.setDate(2, enchere.getDateEnchere());
			pStmt.setInt(3, enchere.getMontantEnchere());
			pStmt.setInt(4, enchere.getNoArticle());
			pStmt.setInt(5, enchere.getNoUtilisateur());

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				enchere.setNoEnchere(rs.getInt(1));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur à l'ajout de l'utilisateur : " + enchere, e);

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

	public Enchere selectByIdEnchere(int no_Enchere) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Enchere enchere = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_SELECTBYID);

			pStmt.setInt(1, no_Enchere);

			rs = pStmt.executeQuery();
			rs.next();
			enchere = new Enchere(no_Enchere, rs.getDate("date_enchere"), rs.getInt("montant_enchere"),
					rs.getInt("no_article"), rs.getInt("no_utilisateur"));

		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + no_Enchere, e);
		}

		return enchere;

	}

}
