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

/**
 * Servlet implementation class seConnecter
 */
@WebServlet("/Connection")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = "";
	Utilisateur user = new Utilisateur();
	HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/WEB-INF/ConnexionUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Id_Saisie = request.getParameter("Identifiant");
		String Mdp_Saisie = request.getParameter("Mdp");

		// id est-il existant ?
		UtilisateurManager mgr = new UtilisateurManager();
		String mdp_Compare;
		try {
			user = mgr.selectByPseudo(Id_Saisie);
			if (Id_Saisie.equals(user.getPseudo())) {

				mdp_Compare = user.getMot_de_passe();
				System.out.println("1er IF");

				if (Mdp_Saisie.equals(mdp_Compare)) {
					//session
					session=request.getSession();
					
			        session.setAttribute("user",user); 
					response.sendRedirect("Servlet");
				} else {
					msg = "Le mot de passe saisi n'est pas correct";
					doGet(request, response);
				}

			}
		} catch (BLLException e) {
			try {
				user = mgr.selectByMail(Id_Saisie);
				if (Id_Saisie.equals(user.getEmail())) {
					mdp_Compare = user.getMot_de_passe();
					if (Mdp_Saisie.equals(mdp_Compare)) {
						response.sendRedirect("Servlet");

					} else {
						msg = "Le mot de passe saisi n'est pas correct";
						doGet(request, response);
					}
				}
			} catch (BLLException k) {
				msg = "Identifiant Inconnu";
				doGet(request, response);
			}
		}
	}
}

