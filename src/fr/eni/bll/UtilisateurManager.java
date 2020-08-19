package fr.eni.bll;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO daoUtilisateur;

	public UtilisateurManager() {
		this.daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}

	/**
	 * Ajoute un utilisateur dans la BDD
	 * 
	 * @param newUser
	 * @throws BLLException
	 */
	public void addUser(Utilisateur user) throws BLLException {

		if (user.getNo_utilisateur() != 0) {
			throw new BLLException("Utilisateur déjà créé");
		}
		try {
			this.daoUtilisateur.insertNewUser(user);
			System.out.println("utilisateur inséré dans la BDD");
		} catch (DALException e) {
			throw new BLLException("Echec création utilisateur");

		}

	}

	/**
	 * MAJ des données de l'utilisateur
	 * 
	 * @throws BLLException
	 */
	public void updateUser(Utilisateur user) throws BLLException {
		try {
			this.daoUtilisateur.updateUser(user);
		} catch (DALException e) {
			throw new BLLException("Echec dans la mise à jour des données utilisateur " + user, e);
		}
	}

	/**
	 * supprime l'utilisateur
	 * 
	 * @throws BLLException
	 */
	public void deleteUser(int no_utilisateur) throws BLLException {

		try {
			this.daoUtilisateur.deleteUser(no_utilisateur);
		} catch (DALException e) {
			throw new BLLException("Echec dans la suppression de l'utilisateur " + no_utilisateur, e);
		}
	}

	/**
	 * Affiche les données de l'utilisateur pour modification
	 * 
	 * @throws BLLException
	 */

	public void selectById(int no_utilisateur) throws BLLException {

		try {
			this.daoUtilisateur.selectById(no_utilisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des donnés " + no_utilisateur, e);
		}
	}

	public Utilisateur selectByPseudo(String Pseudo) throws BLLException {

		try {
			return this.daoUtilisateur.selectByPseudo(Pseudo);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des donnés " + Pseudo, e);
		}
	}

	public Utilisateur selectByMail(String Pseudo) throws BLLException {

		try {
			return this.daoUtilisateur.selectByMail(Pseudo);

		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des donnés " + Pseudo, e);
		}
	}

}
