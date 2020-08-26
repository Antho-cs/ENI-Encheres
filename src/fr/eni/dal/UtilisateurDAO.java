package fr.eni.dal;

import fr.eni.bo.Utilisateur;

public interface UtilisateurDAO {

	// Méthodes d'insertion d'un nouvelle utilisateur //

	public Utilisateur insertNewUser(Utilisateur user) throws DALException;

	// Méthodes de mise à jour d'utilisateur //

	public void updateUser(Utilisateur data) throws DALException;

	// Méthodes de suppression d'un utilisateur //

	public void deleteUser(int no_utilisateur) throws DALException;

	// Méthodes de selection par numéro d'Identifiant //

	public Utilisateur selectById(int no_utilisateur) throws DALException;

	// Méthodes de selection par Pseudo //

	public Utilisateur selectByPseudo(String Pseudo) throws DALException;

	// Méthodes de selection par mail //

	public Utilisateur selectByMail(String Pseudo) throws DALException;

}
