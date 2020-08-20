package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.BLLException;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class creationCompte
 */
@WebServlet("/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private UtilisateurManager manager = new UtilisateurManager();
	// private Utilisateur user = new Utilisateur();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/NewUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurManager manager = new UtilisateurManager();

		String pseudo = request.getParameter("Pseudo");
		String nom = request.getParameter("Nom");
		String prenom = request.getParameter("Prenom");
		String email = request.getParameter("Mail");
		String telephone = request.getParameter("Telephone");
		String rue = request.getParameter("Rue");
		String code_postal = request.getParameter("Cdp");
		String ville = request.getParameter("Ville");
		String mot_de_passe = request.getParameter("Mdp");

		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville,
				mot_de_passe);
		try {
			// try {
			// ConnectionProvider.getConnection();
			// } catch (SQLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			manager.addUser(user);

		} catch (BLLException e) {

			e.printStackTrace();
		}

		response.sendRedirect("Servlet");

	}
}