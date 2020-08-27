package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
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
	Utilisateur user = new Utilisateur();
	HttpSession session;
	private Logger monLogger = (Logger) LoggerFactory.getLogger(ServletSeConnecter.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/WEB-INF/ConnexionUser.jsp").forward(request, response);
	}

	/**
	 * @see
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Id_Saisie = request.getParameter("Identifiant");
		String Mdp_Saisie = request.getParameter("Mdp");

		// id est-il existant ?
		UtilisateurManager mgr = new UtilisateurManager();

		// Test des Identifiants utlilisateurs //
		String mdp_Compare;

		try {
			user = mgr.selectByPseudo(Id_Saisie);
			monLogger.info(user.getPseudo() + " s'est connecté(e)");
			if (Id_Saisie.equals(user.getPseudo())) {

				mdp_Compare = user.getMot_de_passe();

				if (Mdp_Saisie.equals(mdp_Compare)) {
					// session

					session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("Servlet");
				} else {
					msg = "<div class=\"alert alert-danger\">"
							+ "  <strong>Erreur!</strong> Le mot de passe saisi n'est pas correct." + "</div>";
					doGet(request, response);
				}

			}
		} catch (BLLException e) {
			try {
				user = mgr.selectByMail(Id_Saisie);
				monLogger.info(user.getPseudo() + " s'est connecté(e)");
				if (Id_Saisie.equals(user.getEmail())) {
					mdp_Compare = user.getMot_de_passe();
					if (Mdp_Saisie.equals(mdp_Compare)) {
						session = request.getSession();
						session.setAttribute("user", user);
						response.sendRedirect("Servlet");

					} else {
						msg = "<div class=\"alert alert-danger\">"
								+ "  <strong>Erreur!</strong> Le mot de passe saisi n'est pas correct." + "</div>";
						doGet(request, response);
					}
				}
			} catch (BLLException k) {
				msg = "<div class=\"alert alert-danger\">" + " <strong>Erreur!</strong> Identifiant Inconnu."
						+ "</div>";
				doGet(request, response);
			}
		}
	}
}
