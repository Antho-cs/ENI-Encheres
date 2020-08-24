package fr.eni.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.ConnectionProvider;
import fr.eni.dal.DALException;
import fr.eni.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SQL_INSERT = "insert into utilisateurs (pseudo,nom, prenom, email, telephone, rue, code_postal,ville,mot_de_passe) "
			+ " values (?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "update utilisateurs set pseudo = ?,nom= ?, prenom= ?, email= ?, telephone= ?, rue= ?, code_postal= ?,ville= ?,mot_de_passe= ?, credit =?, administrateur=? where no_utilisateur = ?";
	private static final String SQL_DELETE = "delete pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe from utilisateurs where no_utilisateur = ?";
	private static final String SQL_SELECTBYID = "select * from utilisateurs where no_utilisateur = ?";
	private static final String SQL_SELECTBYPSEUDO = "select * from utilisateurs where pseudo = ?";
	private static final String SQL_SELECTBYMAIL = "select * from utilisateurs where email = ?";

	/*
	 * (non-Javadoc) permet de créer un nouvel utilisateur dans la BDD
	 */
	@Override
	public Utilisateur insertNewUser(Utilisateur user) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, user.getPseudo());
			pStmt.setString(2, user.getNom());
			pStmt.setString(3, user.getPrenom());
			pStmt.setString(4, user.getEmail());
			pStmt.setString(5, user.getTelephone());
			pStmt.setString(6, user.getRue());
			pStmt.setString(7, user.getCode_postal());
			pStmt.setString(8, user.getVille());
			pStmt.setString(9, user.getMot_de_passe());

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				user.setNo_utilisateur(rs.getInt(1));

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
	 * permet de MAJ les données de l'utilisateur
	 */
	@Override
	public void updateUser(Utilisateur data) throws DALException {
		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_UPDATE);
			pStmt.setString(1, data.getPseudo());
			pStmt.setString(2, data.getNom());
			pStmt.setString(3, data.getPrenom());
			pStmt.setString(4, data.getEmail());
			pStmt.setString(5, data.getTelephone());
			pStmt.setString(6, data.getRue());
			pStmt.setString(7, data.getCode_postal());
			pStmt.setString(8, data.getVille());
			pStmt.setString(9, data.getMot_de_passe());
			pStmt.setInt(10, data.getCredit());
			pStmt.setByte(11, data.getAdministrateur());
			pStmt.setInt(12, data.getNo_utilisateur());

			pStmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update utilisateur a échoué - " + data, e);
		}

	}

	/**
	 * permet de supprimer l'utilisateur
	 */
	@Override
	public void deleteUser(int no_utilisateur) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_DELETE);
			pStmt.setInt(1, no_utilisateur);

			pStmt.executeUpdate();

		} catch (SQLException e) {

			throw new DALException("Suppression de l'utilisateur a échoué" + no_utilisateur, e);
		}

	}

	/**
	 * permet d'afficher les infos de l'utilisateur
	 * 
	 * @return
	 */

	@Override
	public Utilisateur selectById(int no_utilisateur) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Utilisateur user = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_SELECTBYID);

			pStmt.setInt(1, no_utilisateur);

			rs = pStmt.executeQuery();
			rs.next();
			user = new Utilisateur(no_utilisateur, rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
					rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"),
					rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"),
					rs.getByte("administrateur"));
		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + no_utilisateur, e);
		}

		return user;

	}

	@Override
	public Utilisateur selectByPseudo(String Pseudo) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Utilisateur user = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_SELECTBYPSEUDO);

			pStmt.setString(1, Pseudo);

			rs = pStmt.executeQuery();
			rs.next();

			user = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
					rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
					rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
					rs.getInt("credit"), rs.getByte("administrateur"));

		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + Pseudo, e);
		}

		return user;

	}

	@Override
	public Utilisateur selectByMail(String Pseudo) throws DALException {

		Connection cnx = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Utilisateur user = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_SELECTBYMAIL);

			pStmt.setString(1, Pseudo);

			rs = pStmt.executeQuery();
			rs.next();

			user = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
					rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
					rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
					rs.getInt("credit"), rs.getByte("administrateur"));

		} catch (SQLException e) {
			throw new DALException("selectByMail failed - id = " + Pseudo, e);
		}

		return user;

	}

}
