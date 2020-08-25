package fr.eni.dal.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Categorie;
import fr.eni.dal.CategorieDAO;
import fr.eni.dal.ConnectionProvider;
import fr.eni.dal.DALException;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	private static final String SQL_SELECTALL = "select * from CATEGORIES";

	public List<Categorie> selectAll() throws DALException {
		List<Categorie> listCategorie = new ArrayList<Categorie>();
		Connection cnx = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try {
			cnx = ConnectionProvider.getConnection();

			pStmt = cnx.prepareStatement(SQL_SELECTALL);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				Categorie cat = new Categorie(rs.getInt("no_categorie"),rs.getString("libelle"));
				listCategorie.add(cat);
			}
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("Erreur lors de l'affichage des Categories :", e);

		} finally {

			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listCategorie;
	}

	// public Categorie insertNewCat(Categorie categorie) throws DALException {
	//
	// }
	//
	// public void updateCat(Categorie libelle) throws DALException {
	//
	// }
	//
	// public void deleteCat(int no_categorie) throws DALException{
	//
	// }
	//
	// public Categorie selectByIdCat(int no_categorie) throws DALException{
	//
	// }
}