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
@WebServlet("/creationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurManager manager = new UtilisateurManager();
	private Utilisateur user = new Utilisateur();

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

		int no_utilisateur = Integer.parseInt(request.getParameter("id"));
		String pseudo = request.getParameter("Pseudo");
		String nom = request.getParameter("Nom");
		String prenom = request.getParameter("Prenom");
		String email = request.getParameter("Mail");
		String telephone = request.getParameter("Telephone");
		String rue = request.getParameter("Rue");
		String code_postal = request.getParameter("Cdp");
		String ville = request.getParameter("Ville");
		String mot_de_passe = request.getParameter("Mdp");
		String confirm = request.getParameter("ConfirmMdp");
		int credit = Integer.valueOf(request.getParameter("Credit"));
		byte administrateur = Byte.parseByte(request.getParameter("administrateur"));

		if (no_utilisateur == 0) {
			try {
				manager.addUser(user);

			} catch (BLLException e) {

				if (no_utilisateur != 0) {
					try {
						throw new BLLException("Utilisateur déjà créé");
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					request.getRequestDispatcher("/WEB-INF/pages/NewVente.jsp").forward(request, response);
				}
			}

		}
	}
}
