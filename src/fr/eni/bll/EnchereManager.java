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
	
	public void insertNewEnchere(Enchere enchere) throws BLLException {
		if (enchere.getNoEnchere() != 0) {
			throw new BLLException("Enchere dÈj‡ crÈÈe");
		}
		try {
			this.daoEnchere.insertNewEnchere(enchere);
			System.out.println("Enchere insÈrÈ dans la BDD");
		} catch (DALException e) {
			System.out.println(e.getStackTrace());
			throw new BLLException("Echec crÈation Enchere");

		}

	}
	
	public void updateEnchere( Enchere enchere) throws BLLException {

		try {
			  this.daoEnchere.updateEnchere(enchere);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la r√©cup√©ration des donn√©s " + enchere, e);
		}
	}

	public Enchere selectByNoArticle(int no_article) throws BLLException {

		try {
			return this.daoEnchere.selectByNoArticle(no_article);
		} catch (DALException e) {
			throw new BLLException("Erreur dans la r√©cup√©ration des donn√©s " + no_article, e);
		}
	}

}
