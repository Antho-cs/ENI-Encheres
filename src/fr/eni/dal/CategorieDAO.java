package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Categorie;

public interface CategorieDAO {

	/**
	 * // Selection de toutes les cat�gories //
	 * 
	 * @return
	 * @throws DALException
	 */

	public List<Categorie> selectAll() throws DALException;

}
