package fr.eni.bll;

import fr.eni.bo.Enchere;
import fr.eni.dal.DALException;
import fr.eni.dal.EnchereDAO;

public class EnchereManager {

	private EnchereDAO daoEnchere;

	public void insertNewEnchere(Enchere enchere) throws BLLException {
		if (enchere.getNoEnchere() != 0) {
			throw new BLLException("Enchere déjà créée");
		}
		try {
			this.daoEnchere.insertNewEnchere(enchere);
			System.out.println("Enchere inséré dans la BDD");
		} catch (DALException e) {
			System.out.println(e.getStackTrace());
			throw new BLLException("Echec création utilisateur");

		}

	}

	public Enchere selectByIdEnchere(int no_enchere) throws BLLException {

		try {
			return this.daoEnchere.selectByIdEnchere(no_enchere);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la rÃ©cupÃ©ration des donnÃ©s " + no_enchere, e);
		}
	}

	// public void updateEnchere(Enchere enchere) throws BLLException {
	// try {
	// this.daoEnchere.updateEnchere(enchere);
	// } catch (DALException e) {
	// throw new BLLException("Echec dans la mise Ã  jour des données d'enchère " +
	// enchere, e);
	// }
	// }
}
