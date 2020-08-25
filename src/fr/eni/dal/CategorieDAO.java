package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Categorie;

public interface CategorieDAO {

	public List<Categorie> selectAll() throws DALException;

	// public Categorie insertNewCat(Categorie categorie) throws DALException;
	//
	// public void updateCat(Categorie libelle) throws DALException;
	//
	// public void deleteCat(int no_categorie) throws DALException;
	//
	// public Categorie selectByIdCat(int no_categorie) throws DALException;

}
