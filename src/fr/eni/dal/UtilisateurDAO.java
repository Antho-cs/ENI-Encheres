package fr.eni.dal;

import fr.eni.bo.Utilisateur;

public interface UtilisateurDAO {

	public void insertNewUser(Utilisateur user) throws DALException;

	public void updateUser(Utilisateur data) throws DALException;

	public void deleteUser(int no_utilisateur) throws DALException;

	public Utilisateur selectById(int no_utilisateur) throws DALException;

}
