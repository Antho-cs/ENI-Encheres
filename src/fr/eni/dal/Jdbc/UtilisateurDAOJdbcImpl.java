package fr.eni.dal.Jdbc;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.DALException;
import fr.eni.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SQL_INSERT = "insert into Utilisateur (pseudo,nom, prenom, email, telephone, rue, codePostal,ville,motDePasse) "
			+ " values (?,?,?,?,?,?,?,?,?,?)";

	// faire les override sur les méthodes

	@Override
	public void insert(Utilisateur user) throws DALException {

	}

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Utilisateur noUtilisateur) throws DALException {
		// TODO Auto-generated method stub

	}

}
