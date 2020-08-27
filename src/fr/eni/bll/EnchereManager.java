package fr.eni.bll;

import fr.eni.bo.Enchere;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.EnchereDAO;

public class EnchereManager {

	private EnchereDAO daoEnchere;

	public EnchereManager() {
		this.daoEnchere = DAOFactory.getEnchereDAO();
	}

	/**
	 * 
	 * @param enchere
	 * @throws BLLException
	 */
	public void insertNewEnchere(Enchere enchere) throws BLLException {
		if (enchere.getNoEnchere() != 0) {
			throw new BLLException("Enchère déjà créée");
		}
		try {
			this.daoEnchere.insertNewEnchere(enchere);
		} catch (DALException e) {
			throw new BLLException("Echec création Enchère");

		}

	}

	/**
	 * 
	 * @param enchere
	 * @throws BLLException
	 */
	public void updateEnchere(Enchere enchere) throws BLLException {

		try {
			this.daoEnchere.updateEnchere(enchere);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des données " + enchere, e);
		}
	}

	/**
	 * 
	 * @param no_article
	 * @return
	 * @throws BLLException
	 */
	public Enchere selectByNoArticle(int no_article) throws BLLException {

		try {
			return this.daoEnchere.selectByNoArticle(no_article);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des données " + no_article, e);
		}
	}

}
