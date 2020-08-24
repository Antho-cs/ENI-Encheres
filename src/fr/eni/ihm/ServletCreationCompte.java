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

/***
 *  @author Laure
 */
@WebServlet("/SeervletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String msg = "";
	Utilisateur user ;
	
	/**
	 * @author Laure / Firas
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		request.setAttribute("user", user);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/WEB-INF/NewUser.jsp").forward(request, response);
	}

	/**
	 * @author Laure / Firas
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

			user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville,
							mot_de_passe);

		try {// pseudo déjà existant
			idSaisie.equals(manager.selectByPseudo(idSaisie).getPseudo())); 
			try { 	// mail déjà existant
				mailSaisie.equals(manager.selectByMail(mailSaisie).getEmail());
				try {  // mdp et confirmation identiques
					!confirmSaisie.equals(mot_de_passe);
					// si tout va bien, création de l'utilisateur	
					manager.addUser(user);
					HttpSession session = request.getSession();
					user = (Utilisateur)session.getAttribute("user");
					request.setAttribute("user", user);
					response.sendRedirect("Servlet");	
						} catch (BLLException e) {
							msg = "* Le mot de passe et la confirmation ne correspondent pas";
							doGet(request, response);			
					} catch (BLLException e) {
							msg = "* Adresse email déjà utilisée";
							doGet(request, response);				
				} catch (BLLException e) {
							msg = "* Pseudo déjà utilisé, merci de le modifier";
			 				doGet(request, response);
		}
			}
		}
	}
}