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

	// public void insertNewCat(Categorie Categorie) throws BLLException {
	//
	// if (Categorie.getNoCategorie() != 0) {
	// throw new BLLException("Categorie déjà créer");
	// }
	// try {
	// this.daoCategorie.insertNewCat(Categorie);
	// System.out.println("Categorie insérer dans la BDD");
	// } catch (DALException e) {
	// System.out.println(e.getStackTrace());
	// throw new BLLException("Echec création Categorie");
	//
	// }
	//
	// }
	//
	// public void updateCat(Categorie categorie) throws BLLException {
	// try {
	// this.daoCategorie.updateCat(categorie);
	// } catch (DALException e) {
	// throw new BLLException("Echec dans la mise à jour des données de Catégorie "
	// + categorie, e);
	// }
	// }
	//
	// /**
	// * supprime la Categorie
	// *
	// * @throws BLLException
	// */
	// public void deleteCat(int no_Categorie) throws BLLException {
	//
	// try {
	// this.daoCategorie.deleteCat(no_Categorie);
	// } catch (DALException e) {
	// throw new BLLException("Echec dans la suppression de l'utilisateur " +
	// no_Categorie, e);
	// }
	// }

	public List<Categorie> selectAll() throws BLLException {

		try {
			return this.daoCategorie.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur dans la rÃ©cupÃ©ration des donnÃ©s " + e);
		}

	}

}
