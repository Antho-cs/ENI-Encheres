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

	String msg = "";
	// String msgPseudo = "";
	// String msgEmail = "";
	// String msgMdp = "";

	/**
	 * @author Laure
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setAttribute("msg", msg);
		// request.setAttribute("msg", msgPseudo);
		// request.setAttribute("msg", msgEmail);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/WEB-INF/NewUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilisateurManager manager = new UtilisateurManager();

		// pour checker les données déjà présentes dans la base
		String idSaisie = request.getParameter("Pseudo");
		String mailSaisie = request.getParameter("Mail");

		// pour insérer le nouvel utilsateur dans la BDD
		String pseudo = request.getParameter("Pseudo");
		String nom = request.getParameter("Nom");
		String prenom = request.getParameter("Prenom");
		String email = request.getParameter("Mail");
		String telephone = request.getParameter("Telephone");
		String rue = request.getParameter("Rue");
		String code_postal = request.getParameter("Cdp");
		String ville = request.getParameter("Ville");
		String mot_de_passe = request.getParameter("Mdp");
		String confirmSaisie = request.getParameter("ConfirmMdp");

		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville,
				mot_de_passe);

		try {
			// pseudo déjà existant
			if (idSaisie.equals(manager.selectByPseudo(idSaisie).getPseudo())) {
				msg = "* Pseudo déjà utilisé, merci de le modifier";
				System.out.println("pb pseudo");
				request.setAttribute("msg", msg);
				doGet(request, response);

				// } // mail déjà existant
				// else if (mailSaisie.equals(manager.selectByMail(mailSaisie).getEmail())) {
				// System.out.println("pb mail");
				// msg = "* Adresse email déjà utilisée";
				// response.sendRedirect("ServletCreationCompte");
				// doGet(request, response);

				// } // correspondance entre mdp et confirmation du mot de passe
				// else if (!confirmSaisie.equals(mot_de_passe)) {
				// System.out.println("pb mdp");
				// msg = "* Le mot de passe et la confirmation ne correspondent pas";
				// response.sendRedirect("ServletCreationCompte");

			} // si tout va bien, création de l'utilisateur
			else {
				manager.addUser(user);
				response.sendRedirect("Servlet");
			}
		} catch (BLLException e) {
			doGet(request, response);
		}

	}
}
