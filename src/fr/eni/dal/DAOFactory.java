package fr.eni.dal;

import fr.eni.dal.Jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO () {
		return new UtilisateurDAOJdbcImpl ();
	}
	
}
