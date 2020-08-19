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
 * Servlet implementation class seConnecter
 */
@WebServlet("/Connection")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = "";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Erreur", msg);
		request.getRequestDispatcher("/WEB-INF/ConnexionUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Id_Saisie = request.getParameter("Identifiant");
		String Mdp_Saisie = request.getParameter("Mdp");

		// System.out.println(Id_Saisie);
		// System.out.println(Mdp_Saisie);

		// id est-il existant ?
		UtilisateurManager mgr = new UtilisateurManager();
		Utilisateur user = new Utilisateur();

		try {
			// Test des Identifiants utlilisateurs //
			Utilisateur userPseudo = mgr.selectByPseudo(Id_Saisie);

			String mdp_Compare = userPseudo.getMot_de_passe();
			System.out.println(mdp_Compare);
			System.out.println(Mdp_Saisie);

			if (Mdp_Saisie.equals(mdp_Compare)) {
				Servlet.setConnected(true);
			} else {
				msg = "Ceci est un message d'erreur";
				response.getWriter().append("/Connection");
			}

		} catch (BLLException e) {
			try {
				Utilisateur userMail = mgr.selectByMail(Id_Saisie);

			} catch (BLLException e1) {
				System.out.println("Aucun Identifiant trouvé");
			}
		}

		// si oui le mdp saisie est-il celui de l'utilisateur existant

	}

}
