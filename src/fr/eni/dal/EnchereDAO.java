package fr.eni.dal;

import fr.eni.bo.Enchere;

public interface EnchereDAO {

	public Enchere insertNewEnchere(Enchere enchere) throws DALException;

	// public void updateEnchere(Enchere enchere) throws DALException;

	//
	// public void deleteEnchere(int no_Enchere) throws DALException;
	//
	public Enchere selectByIdEnchere(int no_Enchere) throws DALException;
	//
}
