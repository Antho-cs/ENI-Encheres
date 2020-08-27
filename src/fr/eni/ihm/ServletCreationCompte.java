package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.BLLException;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;

@WebServlet("/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String msg = "";
	Utilisateur user;
	HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("user", user);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/WEB-INF/NewUser.jsp").forward(request, response);
	}

	/**
	 * @see doPost
	 * 
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

		System.out.println(mot_de_passe);
		System.out.println(confirmSaisie);

		user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe);

		try {// pseudo déjà existant
			idSaisie.equals(manager.selectByPseudo(idSaisie).getPseudo());
			msg = "* Pseudo déjà utilisé, merci de le modifier";
			doGet(request, response);
		} catch (Exception c) {

			try { // mail déjà existant
				mailSaisie.equals(manager.selectByMail(mailSaisie).getEmail());
				msg = "* Adresse email déjà utilisé";
				doGet(request, response);
			} catch (BLLException e) {

				if (!confirmSaisie.equals(mot_de_passe)) {// mdp et confirmation identiques
					msg = "* Le mot de passe et la confirmation ne correspondent pas";
					doGet(request, response);

				} else {// si tout va bien, creation de l'utilisateur

					try {
						manager.addUser(user);
						session = request.getSession();
						session.setAttribute("user", user);
						response.sendRedirect("Servlet");

					} catch (BLLException e1) {
						e1.printStackTrace();
					}

				}
			}
		}
	}
}
