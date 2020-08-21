package fr.eni.dal;

import fr.eni.bo.Utilisateur;

public interface UtilisateurDAO {

	public Utilisateur insertNewUser(Utilisateur user) throws DALException;

	public void updateUser(Utilisateur data) throws DALException;

	public void deleteUser(int no_utilisateur) throws DALException;

	public Utilisateur selectById(int no_utilisateur) throws DALException;

	public Utilisateur selectByPseudo(String Pseudo) throws DALException;

	public Utilisateur selectByMail(String Pseudo) throws DALException;

}
