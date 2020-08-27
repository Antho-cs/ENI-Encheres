package fr.eni.dal;

import fr.eni.bo.Utilisateur;

public interface UtilisateurDAO {

	/**
	 * // Méthode d'insertion d'un nouvel utilisateur //
	 */
	public Utilisateur insertNewUser(Utilisateur user) throws DALException;

	/**
	 * // Méthode de mise à jour d'utilisateur //
	 */
	public void updateUser(Utilisateur data) throws DALException;

	/**
	 * // Méthode de suppression d'un utilisateur //
	 */
	public void deleteUser(int no_utilisateur) throws DALException;

	/**
	 * // Méthode de selection par numéro d'Identifiant //
	 */
	public Utilisateur selectById(int no_utilisateur) throws DALException;

	/**
	 * // Méthode de selection par Pseudo //
	 */
	public Utilisateur selectByPseudo(String Pseudo) throws DALException;

	/**
	 * // Méthode de selection par mail //
	 */
	public Utilisateur selectByMail(String Pseudo) throws DALException;

}
