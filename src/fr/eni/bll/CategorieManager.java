package fr.eni.bll;

import java.util.List;

import fr.eni.bo.Categorie;
import fr.eni.dal.CategorieDAO;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;

public class CategorieManager {
	private CategorieDAO daoCategorie;

	public CategorieManager() {
		this.daoCategorie = DAOFactory.getCategorieDAO();
	}

	/**
	 * @see
	 * @return articles
	 * @throws BLLException
	 */
	public List<Categorie> selectAll() throws BLLException {

		try {
			return this.daoCategorie.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la récupération des données " + e);
		}

	}

}
