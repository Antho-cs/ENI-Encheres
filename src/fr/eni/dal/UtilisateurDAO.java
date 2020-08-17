package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Utilisateur;

public interface UtilisateurDAO {

	public void insert(Utilisateur user) throws DALException;

	public Utilisateur selectById(int noUtilisateur) throws DALException;

	public List<String> selectAll() throws DALException;

	public void update(Utilisateur data) throws DALException;

	public void delete(int noUtilisateur) throws DALException;

}
