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
 * Servlet implementation class monProfil
 */
@WebServlet("/monProfil")
public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager mgr = new UtilisateurManager();
	Utilisateur user = null;
	HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			session = request.getSession(false);
			user = (Utilisateur) session.getAttribute("user");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/monProfil.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Servlet");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btn").equalsIgnoreCase("enregistrer")) {
			try {
				if (user.getMot_de_passe().equals(request.getParameter("motDePasse").trim())) {
					user.setPseudo(request.getParameter("pseudo"));
					user.setEmail(request.getParameter("email"));
					user.setNom(request.getParameter("nom"));
					user.setPrenom(request.getParameter("prenom"));
					user.setCode_postal(request.getParameter("codePostal"));
					user.setTelephone(request.getParameter("telephone"));
					user.setVille(request.getParameter("ville"));
					user.setRue(request.getParameter("rue"));
					user.setCredit(100);
					if (!request.getParameter("nouveauMotDePasse").equals("")) {
						user.setMot_de_passe(request.getParameter("nouveauMotDePasse"));
					}
					mgr.updateUser(user);
				}
			} catch (BLLException e) {
				e.printStackTrace();
			}
		} else if (request.getParameter("btn").equalsIgnoreCase("supprimer")) {
			try {
				mgr.deleteUser(user.getNo_utilisateur());
				HttpSession session = request.getSession(false);
				session.invalidate();
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}
