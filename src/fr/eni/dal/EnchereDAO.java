package fr.eni.dal;

import fr.eni.bo.Enchere;

public interface EnchereDAO {

	// Méthodes d'insertion d'une nouvelle enchere //

	public Enchere insertNewEnchere(Enchere enchere) throws DALException;
	public void updateEnchere(Enchere enchere) throws DALException;

	// Méthodes Selection par numéro d'enchere //

	public Enchere selectByNoArticle(int no_Enchere) throws DALException;

	// Méthodes en prévision //

	// public void updateEnchere(Enchere enchere) throws DALException;

	// public void deleteEnchere(int no_Enchere) throws DALException;
}
